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
package net.havox.times.model.api.booking;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.company.Employment;

/**
 * This interface represents a project.
 *
 * @author Christian Otto
 */
public interface Project extends ChangeAware, Serializable
{

  /**
   * Returns the employment.
   *
   * @return the employment.
   */
  Employment getEmployment();

  /**
   * Sets the employment.
   *
   * @param employment the employment.
   */
  void setEmployment( Employment employment );

  /**
   * Returns the name.
   *
   * @return the name.
   */
  String getName();

  /**
   * Sets the name.
   *
   * @param name the name.
   */
  void setName( String name );

  /**
   * Returns the start date.
   *
   * @return the start date.
   */
  LocalDate getStartDate();

  /**
   * Sets the start date.
   *
   * @param start the start date.
   */
  void setStartDate( LocalDate start );

  /**
   * Returns the end date.
   *
   * @return the end date.
   */
  LocalDate getEndDate();

  /**
   * Sets the end date.
   *
   * @param end the end date.
   */
  void setEndDate( LocalDate end );

  /**
   * Returns the project accounts.
   *
   * @return the accounts.
   */
  Set<Account> getAccounts();

  /**
   * Adds accounts to the account set.
   *
   * @param accounts the accounts.
   *
   * @return the result.
   */
  CollectionMassModificationStatus<Account> addAccounts( Account... accounts );

  /**
   * Removes accounts from the accounts set.
   *
   * @param accounts the accounts.
   *
   * @return the result.
   */
  CollectionMassModificationStatus<Account> removeAccounts( Account... accounts );
}
