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

import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.Test;

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;

@RunWith( ExtendedRunner.class )
public abstract class AbstractPermissionTest
{

  public abstract Permission newInstance() throws Exception;

  public abstract User newUser() throws Exception;

  public abstract UserGroup newUserGroup() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM018 acceptance criteria 01 ("It has a name.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Permission objectUnderTest = newInstance();
    objectUnderTest.setName( name );
    assertEquals( name, objectUnderTest.getName() );
  }

  /**
   * User Story BM019 (User Permission) acceptance criteria 01 ("It is the unique mapping between an user and a
   * permission.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyAddUsers() throws Exception
  {
    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    User[] usersToBeAdded = new User[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      usersToBeAdded[ i ] = newUser();
    }

    Permission objectUnderTest = newInstance();
    objectUnderTest.addUsers( usersToBeAdded );
    for ( User addedElement : usersToBeAdded )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of users '" ).append( objectUnderTest.getUsers() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getUsers().contains( addedElement ) );
    }
  }

  /**
   * User Story BM019 (User Permission) acceptance criteria 01 ("It is the unique mapping between an user and a
   * permission.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyRemoveUsers() throws Exception
  {
    User[] usersToBeAdded = new User[ 100 ];
    for ( int i = 0; i < 100; i++ )
    {
      usersToBeAdded[ i ] = newUser();
    }

    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    User[] usersToBeDeleted = new User[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      usersToBeAdded[ i ] = newUser();
    }

    Permission objectUnderTest = newInstance();
    objectUnderTest.addUsers( usersToBeAdded );
    objectUnderTest.addUsers( usersToBeDeleted );
    for ( User addedElement : usersToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of users '" ).append( objectUnderTest.getUsers() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getUsers().contains( addedElement ) );
    }
    objectUnderTest.removeUsers( usersToBeDeleted );
    for ( User checkedElement : usersToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of users '" ).append( objectUnderTest.getUsers() )
              .append( "' to contain none of the deleted elements. The value '" ).append( checkedElement )
              .append( "' was found." );
      assertFalse( msg.toString(), objectUnderTest.getUsers().contains( checkedElement ) );
    }
  }

  /**
   * User Story BM019 (User Permission) acceptance criteria 01 ("It is the unique mapping between an user and a
   * permission.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyAddUserGroups() throws Exception
  {
    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    UserGroup[] userGroupsToBeAdded = new UserGroup[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      userGroupsToBeAdded[ i ] = newUserGroup();
    }

    Permission objectUnderTest = newInstance();
    objectUnderTest.addUserGroups( userGroupsToBeAdded );
    for ( UserGroup addedElement : userGroupsToBeAdded )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of user groups '" ).append( objectUnderTest.getUserGroups() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getUserGroups().contains( addedElement ) );
    }
  }

  /**
   * User Story BM019 (User Permission) acceptance criteria 01 ("It is the unique mapping between an user and a
   * permission.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyRemoveUserGroups() throws Exception
  {
    UserGroup[] userGroupsToBeAdded = new UserGroup[ 100 ];
    for ( int i = 0; i < 100; i++ )
    {
      userGroupsToBeAdded[ i ] = newUserGroup();
    }

    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    UserGroup[] userGroupsToBeDeleted = new UserGroup[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      userGroupsToBeAdded[ i ] = newUserGroup();
    }

    Permission objectUnderTest = newInstance();
    objectUnderTest.addUserGroups( userGroupsToBeAdded );
    objectUnderTest.addUserGroups( userGroupsToBeDeleted );
    for ( UserGroup addedElement : userGroupsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of user groups '" ).append( objectUnderTest.getUserGroups() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getUserGroups().contains( addedElement ) );
    }
    objectUnderTest.removeUserGroups( userGroupsToBeDeleted );
    for ( UserGroup checkedElement : userGroupsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of user groups '" ).append( objectUnderTest.getUserGroups() )
              .append( "' to contain none of the deleted elements. The value '" ).append( checkedElement )
              .append( "' was found." );
      assertFalse( msg.toString(), objectUnderTest.getUserGroups().contains( checkedElement ) );
    }
  }
}
