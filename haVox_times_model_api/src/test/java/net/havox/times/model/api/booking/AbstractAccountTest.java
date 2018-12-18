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

import java.time.LocalDate;
import java.time.Month;
import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractAccountTest
{

  public abstract Account newInstance() throws Exception;

  public abstract Booking newBooking() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM009 acceptance criteria 01 ("An account has a name.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Account objectUnderTest = newInstance();
    objectUnderTest.setName( name );
    assertEquals( name, objectUnderTest.getName() );
  }

  /**
   * User Story BM009 acceptance criteria 02 ("A start and end date can be set.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyStartDate() throws Exception
  {
    LocalDate periodStart = LocalDate.of( 2000, Month.JANUARY, 1 );
    LocalDate periodEnd = LocalDate.of( 2999, Month.DECEMBER, 31 );
    LocalDate start = ModelRandomGenerator.randomLocalDate( periodStart, periodEnd );

    Account objectUnderTest = newInstance();
    objectUnderTest.setStartDate( start );
    assertEquals( start, objectUnderTest.getStartDate() );
  }

  /**
   * User Story BM009 acceptance criteria 02 ("A start and end date can be set.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyEndDate() throws Exception
  {
    LocalDate periodStart = LocalDate.of( 2000, Month.JANUARY, 1 );
    LocalDate periodEnd = LocalDate.of( 2999, Month.DECEMBER, 31 );
    LocalDate end = ModelRandomGenerator.randomLocalDate( periodStart, periodEnd );

    Account objectUnderTest = newInstance();
    objectUnderTest.setEndDate( end );
    assertEquals( end, objectUnderTest.getEndDate() );
  }

  /**
   * User Story BM009 acceptance criteria 03 ("No start date is det if start is the unlimited past.").
   *
   * @throws Exception
   */
  @Test
  public void testModifyStartDateUnlimitedPast() throws Exception
  {
    LocalDate start = null;
    LocalDate unlimitedPast = LocalDate.MIN;

    Account objectUnderTest = newInstance();
    objectUnderTest.setStartDate( start );
    assertEquals( unlimitedPast, objectUnderTest.getStartDate() );
  }

  /**
   * User Story BM009 acceptance criteria 04 ("No end date is det if start is the unlimited future.").
   *
   * @throws Exception
   */
  @Test
  public void testModifyEndDateUnlimitedFuture() throws Exception
  {
    LocalDate end = null;
    LocalDate unlimitedFuture = LocalDate.MAX;

    Account objectUnderTest = newInstance();
    objectUnderTest.setEndDate( end );
    assertEquals( unlimitedFuture, objectUnderTest.getEndDate() );
  }

  /**
   * User Story BM009 acceptance criteria 05 ("The account may have a budget.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyBudget() throws Exception
  {
    Long budget = ModelRandomGenerator.randomBoolean() ? null
            : Long.valueOf( ModelRandomGenerator.randomIntInRange( 0, Integer.MAX_VALUE ) );

    Account objectUnderTest = newInstance();
    objectUnderTest.setBudget( budget );
    assertEquals( budget, objectUnderTest.getBudget() );
  }

  /**
   * User Story BM009 acceptance criteria 04 ("They hold a set of bookings.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyAddBookings() throws Exception
  {
    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    Booking[] bookingsToBeAdded = new Booking[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      bookingsToBeAdded[ i ] = newBooking();
    }

    Account objectUnderTest = newInstance();
    objectUnderTest.addBookings( bookingsToBeAdded );
    for ( Booking addedElement : bookingsToBeAdded )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of bookings '" ).append( objectUnderTest.getBookings() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getBookings().contains( addedElement ) );
    }
  }

  /**
   * User Story BM009 acceptance criteria 04 ("They hold a set of bookings.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyRemoveBookings() throws Exception
  {
    Booking[] bookingsToBeAdded = new Booking[ 100 ];
    for ( int i = 0; i < 100; i++ )
    {
      bookingsToBeAdded[ i ] = newBooking();
    }

    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    Booking[] bookingsToBeDeleted = new Booking[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      bookingsToBeAdded[ i ] = newBooking();
    }

    Account objectUnderTest = newInstance();
    objectUnderTest.addBookings( bookingsToBeAdded );
    objectUnderTest.addBookings( bookingsToBeDeleted );
    for ( Booking addedElement : bookingsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of booking '" ).append( objectUnderTest.getBookings() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getBookings().contains( addedElement ) );
    }
    objectUnderTest.removeBookings( bookingsToBeDeleted );
    for ( Booking checkedElement : bookingsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of booking '" ).append( objectUnderTest.getBookings() )
              .append( "' to contain none of the deleted elements. The value '" ).append( checkedElement )
              .append( "' was found." );
      assertFalse( msg.toString(), objectUnderTest.getBookings().contains( checkedElement ) );
    }
  }
}
