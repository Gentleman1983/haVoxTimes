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
import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.contact.ContactOption;

/**
 * This interface represents a worker.
 *
 * @author Christian Otto
 */
public interface Worker extends ChangeAware, Serializable
{

  /**
   * Gets the first name.
   *
   * @return the first name.
   */
  String getFirstName();

  /**
   * Sets the fist name.
   *
   * @param firstName the first name.
   */
  void setFirstName( String firstName );

  /**
   * Gets the middle initials.
   *
   * @return the middle initials.
   */
  String getMiddleInitials();

  /**
   * Sets the middle initials.
   *
   * @param initials the middle initials.
   */
  void setMiddleInitials( String initials );

  /**
   * Gets the last name.
   *
   * @return the last name.
   */
  String getLastName();

  /**
   * Sets the last name.
   *
   * @param lastName the last name.
   */
  void setLastName( String lastName );

  /**
   * Gets the address.
   *
   * @return the address.
   */
  Address getAddress();

  /**
   * Sets the address.
   *
   * @param address the address.
   */
  void setAddress( Address address );

  /**
   * Gets the birth date.
   *
   * @return the birth date.
   */
  LocalDate getBirthDate();

  /**
   * Sets the birth date.
   *
   * @param birthDate the birth date.
   */
  void setBirthDate( LocalDate birthDate );

  /**
   * Gets the contact options.
   *
   * @return the contact options.
   */
  Set<ContactOption> getContactOptions();

  /**
   * Adds contact options.
   *
   * @param contactOptions contact options
   *
   * @return true, if all could be added.
   */
  CollectionMassModificationStatus<ContactOption> addContactOptions( ContactOption... contactOptions );

  /**
   * Removes contact options.
   *
   * @param contactOptions contact options
   *
   * @return true, if all could be removed.
   */
  CollectionMassModificationStatus<ContactOption> removeContactOptions( ContactOption... contactOptions );
}
