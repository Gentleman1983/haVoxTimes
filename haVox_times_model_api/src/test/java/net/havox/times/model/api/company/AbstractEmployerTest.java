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

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.contact.ContactOption;

@RunWith( ExtendedRunner.class )
public abstract class AbstractEmployerTest
{

  public abstract Employer newInstance() throws Exception;
  public abstract Address newAddress() throws Exception;
  public abstract ContactOption newContactOption() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM015 acceptance criteria 01 ("An employer has a name, address and contact options.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Employer objectUnderTest = newInstance();
    objectUnderTest.setName( name );
    assertEquals( name, objectUnderTest.getName() );
  }

  /**
   * User Story BM015 acceptance criteria 01 ("An employer has a name, address and contact options.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyAddress() throws Exception
  {
    Address address = newAddress();

    Employer objectUnderTest = newInstance();
    objectUnderTest.setAddress( address );
    assertEquals( address, objectUnderTest.getAddress() );
  }

  /**
   * User Story BM015 acceptance criteria 01 ("An employer has a name, address and contact options.").
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

    Employer objectUnderTest = newInstance();
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
   * User Story BM015 acceptance criteria 01 ("An employer has a name, address and contact options.").
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

    Employer objectUnderTest = newInstance();
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
  
  /**
   * User Story BM015 acceptance criteria 02 ("May be part of a employer group.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyEmployerGroup() throws Exception
  {
    Employer group = newInstance();

    Employer objectUnderTest = newInstance();
    objectUnderTest.setEmploymentGroup( group );
    assertEquals( group, objectUnderTest.getEmploymentGroup() );
  }
}
