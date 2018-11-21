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
public abstract class AbstractUserTest
{

  public abstract User newInstance() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
    
  /**
   * User Story BM001 acceptance criteria 03 ("The user can store an email address.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyEmailAddress() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING;

    String emailPrefix = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );
    String emailSuffix = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );
    String emailTopLevelDomain = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 2, 3 ), alphabet );

    // Creates a email address in the format [a-zA-Z](1-50)@[a-zA-Z](1-50).[a-zA-Z](2-3)
    String email = new StringBuilder()
            .append( emailPrefix )
            .append( "@" )
            .append( emailSuffix )
            .append( "." )
            .append( emailTopLevelDomain )
            .toString();

    User objectUnderTest = newInstance();
    objectUnderTest.setEmailAddress( email );
    assertEquals( email, objectUnderTest.getEmailAddress() );
  }

  /**
   * User Story BM001 acceptance criteria 01 ("A user has credentials to log in.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testHasCredentials() throws Exception
  {
    User objectUnderTest = newInstance();
    assertNotNull( objectUnderTest.getCredentials() );
  }

  /**
   * User Story BM001 acceptance criteria 04 ("The user maps to a worker").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyWorker() throws Exception
  {
    fail( "Not yet implemented." );
  }
}
