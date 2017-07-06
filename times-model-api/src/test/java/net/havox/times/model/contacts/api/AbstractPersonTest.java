/*
 * Copyright (C) 2017 [haVox] Design
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
package net.havox.times.model.contacts.api;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import net.havox.times.model.api.ExtendedRunner;
import net.havox.times.model.api.ModelRandomGenerator;
import net.havox.times.model.api.Repeat;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractPersonTest
{

  public abstract Person getNewInstance( LocalDate dateOfBirth ) throws Exception;

  public abstract Person getNewInstanceWithNonInitializedDateOfBirth() throws Exception;

  public abstract Address getNewAddress() throws Exception;

  @Test
  public void testGetAge() throws Exception
  {
    Person personBornToday = getNewInstance( LocalDate.now() );
    Person personBornOneHundredYearsAgo = getNewInstance( LocalDate.now().minus( 100, ChronoUnit.YEARS ) );

    assertNotNull( personBornToday );
    assertNotNull( personBornOneHundredYearsAgo );

    assertEquals( Period.ZERO, personBornToday.getAge() );
    assertEquals( Period.of( 100, 0, 0 ), personBornOneHundredYearsAgo.getAge() );
  }

  @Test( expected = IllegalStateException.class )
  public void testGetAgeNotInitialized() throws Exception
  {
    Person person = getNewInstanceWithNonInitializedDateOfBirth();

    person.getAge();

    fail( "This should never be reached..." );
  }

  @Test
  @Repeat( 25 )
  public void testModifyLastName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Person objectUnderTest = getNewInstanceWithNonInitializedDateOfBirth();
    objectUnderTest.setLastName( name );
    assertEquals( name, objectUnderTest.getLastName() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyMiddleInitials() throws Exception
  {
    int numberOfMiddleInitials = ModelRandomGenerator.randomIntInRange( 0, 10 );
    StringBuilder builder = new StringBuilder();
    for ( int i = 0; i < numberOfMiddleInitials; i++ )
    {
      if ( i > 0 )
      {
        builder.append( " " );
      }
      builder.append( ModelRandomGenerator.randomString( 1, ModelRandomGenerator.ALPHABETIC_STRING ) );
      builder.append( "." );
    }
    String middleInitials = builder.toString();

    Person objectUnderTest = getNewInstanceWithNonInitializedDateOfBirth();
    objectUnderTest.setMiddleInnitials( middleInitials );
    assertEquals( middleInitials, objectUnderTest.getMiddleInnitials() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyFirstName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Person objectUnderTest = getNewInstanceWithNonInitializedDateOfBirth();
    objectUnderTest.setFirstName( name );
    assertEquals( name, objectUnderTest.getFirstName() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyDateOfBirth() throws Exception
  {
    LocalDate date = ModelRandomGenerator.randomLocalDate();

    Person objectUnderTest = getNewInstanceWithNonInitializedDateOfBirth();
    objectUnderTest.setDateOfBirth( date );
    assertEquals( date, objectUnderTest.getDateOfBirth() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyAddress() throws Exception
  {
    Address address = getNewAddress();

    Person objectUnderTest = getNewInstanceWithNonInitializedDateOfBirth();
    objectUnderTest.setAddress( address );
    assertEquals( address, objectUnderTest.getAddress() );
  }
}
