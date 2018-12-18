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
package net.havox.times.model.api.user;

import java.io.Serializable;
import java.util.Set;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.permissions.Permission;

/**
 * This interface represents an user group.
 *
 * @author Christian Otto
 */
public interface UserGroup extends ChangeAware, Serializable
{

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
   * Returns the users.
   *
   * @return the users.
   */
  Set<User> getUsers();

  /**
   * Adds users.
   *
   * @param users the users.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<User> addUsers( User... users );

  /**
   * Removes users.
   *
   * @param users the users.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<User> removeUsers( User... users );
  
  /**
   * Returns the user group permissions.
   * 
   * @return the user group permissions.
   */
  Set<Permission> getUserGroupPermissions();
}
