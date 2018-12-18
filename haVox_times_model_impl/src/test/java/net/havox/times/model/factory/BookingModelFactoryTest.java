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

import net.havox.times.model.api.booking.Account;
import net.havox.times.model.api.booking.Booking;
import net.havox.times.model.api.booking.BookingReference;
import net.havox.times.model.api.booking.BookingReferenceType;
import net.havox.times.model.api.booking.BookingType;
import net.havox.times.model.api.booking.Project;
import net.havox.times.model.impl.booking.AccountImpl;
import net.havox.times.model.impl.booking.BookingImpl;
import net.havox.times.model.impl.booking.BookingReferenceImpl;
import net.havox.times.model.impl.booking.BookingReferenceTypeImpl;
import net.havox.times.model.impl.booking.BookingTypeImpl;
import net.havox.times.model.impl.booking.ProjectImpl;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Factory test of {@link BookingModelFactory}.
 * 
 * @author Christian Otto
 */
public class BookingModelFactoryTest
{
  private static BookingModelFactory factory;

  @BeforeClass
  public static void setupClass()
  {
    factory = BookingModelFactory.getInstance();
  }

  @Test
  public void testGetInstance()
  {
    Object instanceUnderTest = BookingModelFactory.getInstance();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( BookingModelFactory.class ) ) );
  }

  @Test
  public void testGetNewAccount()
  {
    Account instanceUnderTest = factory.getNewAccount();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( AccountImpl.class ) ) );
  }

  @Test
  public void testGetNewBooking()
  {
    Booking instanceUnderTest = factory.getNewBooking();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( BookingImpl.class ) ) );
  }

  @Test
  public void testGetNewBookingReference()
  {
    BookingReference instanceUnderTest = factory.getNewBookingReference();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( BookingReferenceImpl.class ) ) );
  }

  @Test
  public void testGetNewBookingReferenceType()
  {
    BookingReferenceType instanceUnderTest = factory.getNewBookingReferenceType();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( BookingReferenceTypeImpl.class ) ) );
  }

  @Test
  public void testGetNewBookingType()
  {
    BookingType instanceUnderTest = factory.getNewBookingType();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( BookingTypeImpl.class ) ) );
  }

  @Test
  public void testGetNewProject()
  {
    Project instanceUnderTest = factory.getNewProject();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( ProjectImpl.class ) ) );
  }
}
