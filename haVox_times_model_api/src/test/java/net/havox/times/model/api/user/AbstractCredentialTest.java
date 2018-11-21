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

import net.havox.times.model.contacts.api.*;
import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractCredentialTest
{

  public abstract Credential newInstance() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
    
  /**
   * User Story BM001 acceptance criteria 01 ("A user has credentials to log in.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyUsername() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING;
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Credential objectUnderTest = newInstance();
    objectUnderTest.setUsername( name );
    assertEquals( name, objectUnderTest.getUsername() );
  }

  /**
   * User Story BM001 acceptance criteria 01 ("A user has credentials to log in.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyPassword() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING ;
    String password = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Credential objectUnderTest = newInstance();
    String oldHashedPassword = objectUnderTest.getPasswordHash();
    objectUnderTest.setPassword( password );
    assertNotEquals( oldHashedPassword, objectUnderTest.getPasswordHash() );
  }

  /**
   * User Story BM001 acceptance criteria 02 ("The credential password is hashed and salted.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testPasswordDoesNotMatchHashedPassword() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING ;
    String password = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Credential objectUnderTest = newInstance();
    objectUnderTest.setPassword(password );
    assertNotEquals(password, objectUnderTest.getPasswordHash() );
  }
}
