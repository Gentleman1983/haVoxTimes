/*
 * Copyright (C) 2015 [haVox] Design
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.havox.times.model.times.api;

import java.io.Serializable;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListSet;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;

/**
 * This interface represents an employment.
 *
 * @author Christian Otto
 */
public interface Project extends ChangeAware, Serializable
{

  /**
   * Gets the project name.
   *
   * @return the project name
   */
  String getName();

  /**
   * Sets the project name.
   *
   * @param name the project name
   */
  void setName( String name );

  /**
   * Calculates the months of the employment.
   *
   * @return the completed months
   */
  default long getEmploymentMonths()
  {
    LocalDate start = this.getStart();
    LocalDate end = this.getEnd();

    if ( end == null )
    {
      end = LocalDate.now();
    }

    return Period.between( start, end ).getMonths();
  }

  /**
   * Calculates the work duration for a given month, year and work unit type.
   *
   * @param month the month
   * @param year the year
   * @param type the {@link WorkUnitType}
   * @return the calculated work duration for this month
   *
   * @throws IllegalArgumentException if the month is not set.
   * @throws IllegalArgumentException if the work unit type is not set.
   * @throws IllegalArgumentException if the month does not fit the Employment duration.
   */
  default Duration getDuraration( Month month, int year, WorkUnitType type )
  {
    return getDuraration( month, year, type, true );
  }

  /**
   * Calculates the work duration for a given month, year and work unit type.
   *
   * @param month the month
   * @param year the year
   * @param type the {@link WorkUnitType}
   * @param includeSubProjects Shall we include subProjects (default: true).
   * @return the calculated work duration for this month
   *
   * @throws IllegalArgumentException if the month is not set.
   * @throws IllegalArgumentException if the work unit type is not set.
   * @throws IllegalArgumentException if the month does not fit the Employment duration.
   */
  default Duration getDuraration( Month month, int year, WorkUnitType type, boolean includeSubProjects )
  {
    if ( month == null )
    {
      throw new IllegalArgumentException( "The month has to be set." );
    }
    else if ( type == null )
    {
      throw new IllegalArgumentException( "The work unit type has to be set." );
    }

    LocalDate monthStart = LocalDate.of( year, month, 1 );
    LocalDate monthEnd = LocalDate.of( year, month.getValue() + 1, 1 ).minus( 1, ChronoUnit.DAYS );

    if ( ( monthStart.compareTo( this.getEnd() ) > 0 )
            || // project end date before regarded month
            ( monthEnd.compareTo( this.getStart() ) < 0 ) )
    { // project start after regarded month
      StringBuilder builder = new StringBuilder();

      builder.append( "The seleceted month '" ).append( month.toString() ).append( " " ).append( year ).append( "'" );
      builder.append( " has to be within project range (" ).append( this.getStart() ).append( " till " );
      builder.append( this.getEnd() ).append( ")." );

      throw new IllegalArgumentException( builder.toString() );
    }

    Duration duration = Duration.ZERO;

    // Calculate the duration of this project.
    for ( WorkDay workDay : getWorkDays( monthStart, monthEnd ) )
    {
      duration = duration.plus( workDay.getDuration( type ) );
    }

    // Calculate the duration of subprojects.
    if ( includeSubProjects )
    {
      for ( Project subProject : getSubprojects() )
      {
        duration = duration.plus( subProject.getDuraration( month, year, type, includeSubProjects ) );
      }
    }

    return duration;
  }

  /**
   * Returns the employment start.
   *
   * @return the start
   */
  LocalDate getStart();

  /**
   * Sets the employment start.
   *
   * @param start the start
   */
  void setStart( LocalDate start );

  /**
   * Checks if the employment is active. This means the project has started and either the end is in the future or the
   * end has not been defined.
   *
   * @return true, if the employment is active
   */
  default boolean isActive()
  {
    if ( !this.hasStarted() )
    {
      return false;
    }
    return ( this.getEnd() == null ) || this.getEnd().isAfter( LocalDate.now() );
  }

  /**
   * Checks if the employment has started. This means either the start is in the past or today.
   *
   * @return true, if the employment has started
   */
  default boolean hasStarted()
  {
    if ( this.getStart() == null )
    {
      return false;
    }
    return this.getStart().isBefore( LocalDate.now() ) || this.getStart().isEqual( LocalDate.now() );
  }

  /**
   * Returns the employment end.
   *
   * @return the end
   */
  LocalDate getEnd();

  /**
   * Sets the employment end.
   *
   * @param end the end
   */
  void setEnd( LocalDate end );

  /**
   * Returns the employer.
   *
   * @return the employer
   */
  Company getEmployer();

  /**
   * Sets the employer.
   *
   * @param employer the employer
   */
  void setEmployer( Company employer );

  /**
   * Returns the employee.
   *
   * @return the employee
   */
  Person getEmployee();

  /**
   * Sets the employee.
   *
   * @param employee the employee
   */
  void setEmployee( Person employee );

  /**
   * Checks if this employment contains sub projects.
   *
   * @return true, if the employment contains sub projects
   * @throws IllegalStateException if the projects propery is not initialized
   */
  default boolean hasSubprojects()
  {
    if ( this.getSubprojects() == null )
    {
      throw new IllegalStateException( "Projects property not yet initialized." );
    }

    return !this.getSubprojects().isEmpty();
  }

  /**
   * Returns the sub projects.
   *
   * @return the sub projects
   */
  Collection<Project> getSubprojects();

  /**
   * Returns the work days for this project.
   *
   * @return the work days
   */
  Collection<WorkDay> getWorkDays();

  /**
   * Returns the work days in a given time period. The start and end date are included.
   *
   * @param start the starting day of this period
   * @param end the ending day of this period
   * @return the work days in this time period
   *
   * @throws IllegalArgumentException if the start parameter is null.
   * @throws IllegalArgumentException if the end parameter is null.
   */
  default Collection<WorkDay> getWorkDays( LocalDate start, LocalDate end )
  {
    if ( start == null || end == null )
    {
      throw new IllegalArgumentException( "The start and end parameter have to be set." );
    }

    Collection<WorkDay> selectedWorkDays = new ConcurrentSkipListSet<>();

    for ( WorkDay workDay : getWorkDays() )
    {                                               // The work day matches the
      if ( ( workDay.getDate().isAfter( start ) || workDay.getDate().isEqual( start ) )
              && // given period, is on start
              ( workDay.getDate().isBefore( end ) || workDay.getDate().isEqual( end ) ) )
      {  // or end date or between.
        selectedWorkDays.add( workDay );
      }
    }

    return selectedWorkDays;
  }
}
