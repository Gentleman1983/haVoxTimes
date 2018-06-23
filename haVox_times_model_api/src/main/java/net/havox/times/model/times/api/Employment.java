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

import static net.havox.exceptions.GuruErrorCode.ILLEGAL_ARGUMENT;
import static net.havox.exceptions.GuruErrorCode.ILLEGAL_STATE;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.util.Collection;

import net.havox.exceptions.GuruMeditationWarning;
import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;

/**
 * This interface represents an employment.
 *
 * @author Christian Otto
 */
public interface Employment extends ChangeAware, Serializable
{

  /**
   * Calculates the number of months of the employment.
   *
   * @return the number of months
   * @throws GuruMeditationWarning if the start parameter is null.
   */
  default long getEmploymentMonths()
  {
    /* 
     * For correct legth calculation we cannot use the default between function of Period.between( x, y ). E.g. when
     * calculating 1 year ending in december the Period.between( x, y ) returns a Period of 11 months and 31 days
     * instead of 1 year.
     * * So we have to look for a way to calculate the correct Period. First in the case of an employment, if I work 
     *   only today, it is needed that the result is 1 day. So we have to either increase the end date by one day or
     *   decrease the starting date.
     * * If we have got an open end, today is the current ending date and has to be added in the calculation.
     */
    LocalDate start = this.getStart();

    if ( null == start )
    {
      throw new GuruMeditationWarning( ILLEGAL_ARGUMENT, "The start date of the employment has to be set." );
    }

    LocalDate end = ( this.getEnd() == null )
            ? LocalDate.now().plus( 1, ChronoUnit.DAYS ) : this.getEnd().plus( 1, ChronoUnit.DAYS );
    int years = ( int ) ChronoUnit.YEARS.between( start, end );
    end = end.minus( years, ChronoUnit.YEARS ); // For not to count the duration of years multiple times, we have to
    // decrease the end date by the number of years.
    int months = ( int ) ChronoUnit.MONTHS.between( start, end );
    end = end.minus( months, ChronoUnit.MONTHS ); // For not to count the duration of months multiple times, we have to
    // decrease the end date by the number of months.
    int days = ( int ) ChronoUnit.DAYS.between( start, end );

    // After calculation of the correct number of years, months and days we can wrap it up in a Period object.
    return Period.of( years, months, days ).toTotalMonths();
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
   * Checks if the employment is active. This means either the end is in the future or the end has not been defined.
   *
   * @return true, if the employment is active
   */
  default boolean isActive()
  {
    return ( this.getEnd() == null )
            || // No end defined.
            this.getEnd().isAfter( LocalDate.now() )
            || // End in the future.
            this.getEnd().equals( LocalDate.now() );     // End today.
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
   *
   * @throws GuruMeditationWarning if the projects propery is not initialized
   */
  default boolean hasProjects()
  {
    if ( this.getProjects() == null )
    {
      throw new GuruMeditationWarning( ILLEGAL_STATE, "Projects property not yet initialized." );
    }

    return !this.getProjects().isEmpty();
  }

  /**
   * Returns the projects.
   *
   * @return the projects
   */
  Collection<Project> getProjects();
}
