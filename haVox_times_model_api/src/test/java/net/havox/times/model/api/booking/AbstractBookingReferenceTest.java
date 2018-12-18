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
public abstract class AbstractBookingReferenceTest
{

  public abstract BookingReference newInstance() throws Exception;
  
  public abstract Booking newBooking() throws Exception;

  public abstract BookingReferenceType newBookingReferenceType() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  
  /**
   * User Story BM010 ({@link Booking}) acceptance criteria 04 ("They have a set of booking references.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyBooking() throws Exception
  {
    Booking booking = newBooking();

    BookingReference objectUnderTest = newInstance();
    objectUnderTest.setBooking( booking );
    assertEquals( booking, objectUnderTest.getBooking() );
  }
  
  /**
   * User Story BM012 acceptance criteria 01 ("They have a project specific reference type and a value.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyType() throws Exception
  {
    BookingReferenceType type = newBookingReferenceType();

    BookingReference objectUnderTest = newInstance();
    objectUnderTest.setType( type );
    assertEquals( type, objectUnderTest.getType() );
  }

  /**
   * User Story BM012 acceptance criteria 01 ("They have a project specific reference type and a value.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyValue() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " ";
    String value = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingReference objectUnderTest = newInstance();
    objectUnderTest.setValue( value );
    assertEquals( value, objectUnderTest.getValue() );
  }
}
