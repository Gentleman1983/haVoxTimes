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

import net.havox.times.model.api.model.BasicPermission;
import net.havox.times.model.api.model.BasicUser;
import net.havox.times.model.api.model.BasicUserGroup;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;

/**
 * Simplest implementation for {@link AbstractPermissionTest}.
 *
 * @author Christian Otto
 */
public class BasicPermissionTest extends AbstractPermissionTest
{

  @Override
  public Permission newInstance() throws Exception
  {
    return new BasicPermission();
  }

  @Override
  public User newUser() throws Exception
  {
    return new BasicUser();
  }

  @Override
  public UserGroup newUserGroup() throws Exception
  {
    return new BasicUserGroup();
  }
}
