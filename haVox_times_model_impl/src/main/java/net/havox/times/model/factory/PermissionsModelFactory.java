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
package net.havox.times.model.factory;

import net.havox.times.model.api.permissions.Permission;
import net.havox.times.model.impl.permissions.PermissionImpl;

/**
 * The permissions model factory.
 *
 * @author Christian Otto
 */
public class PermissionsModelFactory
{

  /**
   * The singleton model factory instance.
   */
  private static final PermissionsModelFactory INSTANCE = new PermissionsModelFactory();

  /**
   * The private default constructor.
   */
  private PermissionsModelFactory()
  {
    super();
  }

  /**
   * Returns the singleton model factory.
   *
   * @return the {@link PermissionsModelFactory} instance.
   */
  public static PermissionsModelFactory getInstance()
  {
    return PermissionsModelFactory.INSTANCE;
  }

  /**
   * Returns a new {@link Permission}.
   *
   * @return a new contact option entity.
   */
  public Permission getNewPermission()
  {
    return new PermissionImpl();
  }
}
