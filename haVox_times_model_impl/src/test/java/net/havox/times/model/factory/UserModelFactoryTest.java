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

import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

import net.havox.times.model.api.user.Credential;
import net.havox.times.model.api.user.User;
import net.havox.times.model.impl.user.CredentialImpl;
import net.havox.times.model.impl.user.UserImpl;

/**
 * Factory test of {@link UserModelFactory}.
 *
 * @author Christian Otto
 */
public class UserModelFactoryTest
{

  private static UserModelFactory factory;

  @BeforeClass
  public static void setupClass()
  {
    factory = UserModelFactory.getInstance();
  }

  @Test
  public void testGetInstance()
  {
    Object instanceUnderTest = UserModelFactory.getInstance();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( UserModelFactory.class ) ) );
  }

  @Test
  public void testGetNewCredential()
  {
    Credential instanceUnderTest = factory.getNewCredential();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( CredentialImpl.class ) ) );
  }

  @Test
  public void testGetNewUser()
  {
    User instanceUnderTest = factory.getNewUser();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( UserImpl.class ) ) );
  }
}
