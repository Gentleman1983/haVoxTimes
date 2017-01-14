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
import java.util.Collection;

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
   * Calculates the duration of the employment.
   *
   * @return the duration
   */
  default Duration getDuration()
  {
    LocalDate start = this.getStart();
    LocalDate end = this.getEnd();

    if ( end == null )
    {
      end = LocalDate.now();
    }

    return Duration.between( start, end );
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
    boolean isInTheFuture = this.getEnd().isAfter( LocalDate.now() );
    return ( this.getEnd() == null ) || isInTheFuture;
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
   * @throws IllegalStateException if the projects propery is not initialized
   */
  default boolean hasProjects()
  {
    if ( this.getProjects() == null )
    {
      throw new IllegalStateException( "Projects property not yet initialized." );
    }

    return !this.getProjects().isEmpty();
  }

  /**
   * Returns the projects.
   *
   * @return the projects
   */
  Collection<Employment> getProjects();
}
