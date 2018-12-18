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
package net.havox.times.model.api.company;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;

import net.havox.times.model.api.address.*;
import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import net.havox.times.model.api.contact.ContactOption;

@RunWith( ExtendedRunner.class )
public abstract class AbstractWorkerTest
{

  public abstract Worker newInstance() throws Exception;

  public abstract Address newAddress() throws Exception;

  public abstract ContactOption newContactOption() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM002 acceptance criteria 01 ("It has a first name, middle initials and a last name.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyFirstName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Worker objectUnderTest = newInstance();
    objectUnderTest.setFirstName( name );
    assertEquals( name, objectUnderTest.getFirstName() );
  }

  /**
   * User Story BM002 acceptance criteria 01 ("It has a first name, middle initials and a last name.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyInitials() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Worker objectUnderTest = newInstance();
    objectUnderTest.setMiddleInitials( name );
    assertEquals( name, objectUnderTest.getMiddleInitials() );
  }

  /**
   * User Story BM002 acceptance criteria 01 ("It has a first name, middle initials and a last name.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyLastName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Worker objectUnderTest = newInstance();
    objectUnderTest.setLastName( name );
    assertEquals( name, objectUnderTest.getLastName() );
  }

  /**
   * User Story BM002 acceptance criteria 02 ("A worker has got an address.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyAddress() throws Exception
  {
    Address address = newAddress();

    Worker objectUnderTest = newInstance();
    objectUnderTest.setAddress( address );
    assertEquals( address, objectUnderTest.getAddress() );
  }

  /**
   * User Story BM002 acceptance criteria 03 ("A worker has got a birth date.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyBirthDate() throws Exception
  {
    LocalDate date = ModelRandomGenerator.randomLocalDate();

    Worker objectUnderTest = newInstance();
    objectUnderTest.setBirthDate( date );
    assertEquals( date, objectUnderTest.getBirthDate() );
  }

  /**
   * User Story BM002 acceptance criteria 04 ("A worker has got a set of contact options.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyAddContactOptions() throws Exception
  {
    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    ContactOption[] contactOptionsToBeAdded = new ContactOption[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      contactOptionsToBeAdded[ i ] = newContactOption();
    }

    Worker objectUnderTest = newInstance();
    objectUnderTest.addContactOptions( contactOptionsToBeAdded );
    for ( ContactOption addedElement : contactOptionsToBeAdded )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of contact options '" ).append( objectUnderTest.getContactOptions() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getContactOptions().contains( addedElement ) );
    }
  }

  /**
   * User Story BM002 acceptance criteria 04 ("A worker has got a set of contact options.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyRemoveContactOptions() throws Exception
  {
    ContactOption[] contactOptionsToBeAdded = new ContactOption[ 100 ];
    for ( int i = 0; i < 100; i++ )
    {
      contactOptionsToBeAdded[ i ] = newContactOption();
    }

    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    ContactOption[] contactOptionsToBeDeleted = new ContactOption[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      contactOptionsToBeAdded[ i ] = newContactOption();
    }

    Worker objectUnderTest = newInstance();
    objectUnderTest.addContactOptions( contactOptionsToBeAdded );
    objectUnderTest.addContactOptions( contactOptionsToBeDeleted );
    for ( ContactOption addedElement : contactOptionsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of contact options '" ).append( objectUnderTest.getContactOptions() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getContactOptions().contains( addedElement ) );
    }
    objectUnderTest.removeContactOptions( contactOptionsToBeDeleted );
    for ( ContactOption checkedElement : contactOptionsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of contact options '" ).append( objectUnderTest.getContactOptions() )
              .append( "' to contain none of the deleted elements. The value '" ).append( checkedElement )
              .append( "' was found." );
      assertFalse( msg.toString(), objectUnderTest.getContactOptions().contains( checkedElement ) );
    }
  }
}
