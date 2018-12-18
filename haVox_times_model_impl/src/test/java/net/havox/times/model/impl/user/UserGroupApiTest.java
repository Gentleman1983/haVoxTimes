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
package net.havox.times.model.impl.user;

import org.junit.BeforeClass;

import net.havox.times.model.api.user.AbstractUserGroupTest;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;
import net.havox.times.model.factory.UserModelFactory;

/**
 * API specific tests for {@link UserGroup}.
 *
 * @author Christian Otto
 */
public class UserGroupApiTest extends AbstractUserGroupTest
{

  private static UserModelFactory userFactory;

  @BeforeClass
  public static void setupClass()
  {
    userFactory = UserModelFactory.getInstance();
  }

  @Override
  public UserGroup newInstance() throws Exception
  {
    return userFactory.getNewUserGroup();
  }

  @Override
  public User newUser() throws Exception
  {
    return userFactory.getNewUser();
  }
}
