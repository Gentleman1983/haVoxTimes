/*
 * Copyright (C) 2018 [haVox] Design
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
package net.havox.times.model.api.company;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.booking.Project;

/**
 * This interface represents an employment.
 *
 * @author Christian Otto
 */
public interface Employment extends ChangeAware, Serializable
{

  /**
   * Returns the employer.
   *
   * @return the employer.
   */
  Employer getEmployer();

  /**
   * Sets the employer.
   *
   * @param employer the employer.
   */
  void setEmployer( Employer employer );

  /**
   * Returns the employee.
   *
   * @return the employee.
   */
  Worker getEmployee();

  /**
   * Sets the employee.
   *
   * @param employee the employee.
   */
  void setEmployee( Worker employee );

  /**
   * Returns the employment start date.
   *
   * @return the start.
   */
  LocalDate getStartDate();

  /**
   * Sets the employment start date.
   *
   * @param start the start.
   */
  void setStartDate( LocalDate start );

  /**
   * Returns the employment end date.
   *
   * @return the end.
   */
  LocalDate getEndDate();

  /**
   * Sets the employment end date.
   *
   * @param end the end.
   */
  void setEndDate( LocalDate end );

  /**
   * Returns the projects corresponding to the employment.
   *
   * @return the projects.
   */
  Set<Project> getProjects();

  /**
   * Adds projects.
   *
   * @param projects the projects.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<Project> addProjects( Project... projects );

  /**
   * Removes projects.
   *
   * @param projects the projects.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<Project> removeProjects( Project... projects );
}
