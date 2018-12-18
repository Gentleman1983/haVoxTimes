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
package net.havox.times.model.impl.permissions;

import org.junit.BeforeClass;

import net.havox.times.model.api.permissions.AbstractPermissionTest;
import net.havox.times.model.api.permissions.Permission;
import net.havox.times.model.factory.PermissionsModelFactory;

/**
 * API specific tests for {@link Permission}.
 *
 * @author Christian Otto
 */
public class PermissionApiTest extends AbstractPermissionTest
{

  private static PermissionsModelFactory permissionsFactory;

  @BeforeClass
  public static void setupClass()
  {
    permissionsFactory = PermissionsModelFactory.getInstance();
  }

  @Override
  public Permission newInstance() throws Exception
  {
    return permissionsFactory.getNewPermission();
  }
}
