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
package net.havox.times.model.api.booking;

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractBookingTest
{

  public abstract Booking newInstance() throws Exception;
  public abstract BookingType newBookingType() throws Exception;
  public abstract BookingReference newBookingReference() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
    
  /**
   * User Story BM010 acceptance criteria 01 ("They have a booking type.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyType() throws Exception
  {
    BookingType type = newBookingType();

    Booking objectUnderTest = newInstance();
    objectUnderTest.setType( type );
    assertEquals( type, objectUnderTest.getType() );
  }
    
  /**
   * User Story BM010 acceptance criteria 02 ("They have a text.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyText() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " ";
    String text = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Booking objectUnderTest = newInstance();
    objectUnderTest.setText( text );
    assertEquals( text, objectUnderTest.getText() );
  }
    
  /**
   * User Story BM010 acceptance criteria 03 ("They have a marker to be invoiced.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyInvoiced() throws Exception
  {
    boolean isInvoiced = ModelRandomGenerator.randomBoolean();

    Booking objectUnderTest = newInstance();
    objectUnderTest.setIsInvoiced( isInvoiced );
    assertEquals( isInvoiced, objectUnderTest.isInvoiced() );
  }

  /**
   * User Story BM010 acceptance criteria 04 ("They have a set of booking references.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyAddBookingReferences() throws Exception
  {
    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    BookingReference[] accountsToBeAdded = new BookingReference[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      accountsToBeAdded[ i ] = newBookingReference();
    }

    Booking objectUnderTest = newInstance();
    objectUnderTest.addReferences( accountsToBeAdded );
    for ( BookingReference addedElement : accountsToBeAdded )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of booking references '" ).append( objectUnderTest.getReferences() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getReferences().contains( addedElement ) );
    }
  }

  /**
   * User Story BM010 acceptance criteria 04 ("They have a set of booking references.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyRemoveBookingReferences() throws Exception
  {
    BookingReference[] accountsToBeAdded = new BookingReference[ 100 ];
    for ( int i = 0; i < 100; i++ )
    {
      accountsToBeAdded[ i ] = newBookingReference();
    }

    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    BookingReference[] accountsToBeDeleted = new BookingReference[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      accountsToBeAdded[ i ] = newBookingReference();
    }

    Booking objectUnderTest = newInstance();
    objectUnderTest.addReferences(accountsToBeAdded );
    objectUnderTest.addReferences(accountsToBeDeleted );
    for ( BookingReference addedElement : accountsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of booking references '" ).append( objectUnderTest.getReferences() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getReferences().contains( addedElement ) );
    }
    objectUnderTest.removeReferences(accountsToBeDeleted );
    for ( BookingReference checkedElement : accountsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of booking references '" ).append( objectUnderTest.getReferences() )
              .append( "' to contain none of the deleted elements. The value '" ).append( checkedElement )
              .append( "' was found." );
      assertFalse( msg.toString(), objectUnderTest.getReferences().contains( checkedElement ) );
    }
  }
}
