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
package net.havox.times.model.api.permissions;

import java.io.Serializable;
import java.util.Set;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;

/**
 * This interface represents a permission.
 *
 * @author Christian Otto
 */
public interface Permission extends ChangeAware, Serializable
{

  /**
   * Gets the permission name.
   *
   * @return the permission name
   */
  String getName();

  /**
   * Sets the permission name.
   *
   * @param name the permission name
   */
  void setName( String name );

  /**
   * Returns the users having this permission.
   *
   * @return the users.
   */
  Set<User> getUsers();

  /**
   * Adds users having this permission.
   *
   * @param users the users.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<User> addUsers( User... users );

  /**
   * Removes users having this permission.
   *
   * @param users the users.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<User> removeUsers( User... users );

  /**
   * Returns the user groups having this permission.
   *
   * @return the user groups.
   */
  Set<UserGroup> getUserGroups();

  /**
   * Adds user groups having this permission.
   *
   * @param userGroups the user groups.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<UserGroup> addUserGroups( UserGroup... userGroups );

  /**
   * Removes user groups having this permission.
   *
   * @param userGroups the user groups.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<UserGroup> removeUserGroups( UserGroup... userGroups );
}
