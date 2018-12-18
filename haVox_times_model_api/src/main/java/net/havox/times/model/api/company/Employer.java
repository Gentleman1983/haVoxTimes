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
import java.util.Set;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.contact.ContactOption;

/**
 * This interface represents a employing entity, e.g. a company.
 *
 * @author Christian Otto
 */
public interface Employer extends ChangeAware, Serializable
{

  /**
   * Gets the name.
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

  /**
   * Gets the group this employer belongs to.
   *
   * @return the group.
   */
  Employer getEmploymentGroup();

  /**
   * Sets the group this employer belongs to.
   *
   * @param group the group.
   */
  void setEmploymentGroup( Employer group );
}
