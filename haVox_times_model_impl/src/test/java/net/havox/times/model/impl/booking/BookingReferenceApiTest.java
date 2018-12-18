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
package net.havox.times.model.impl.booking;

import net.havox.times.model.api.booking.AbstractBookingReferenceTest;
import net.havox.times.model.api.booking.Booking;
import net.havox.times.model.api.booking.BookingReference;
import net.havox.times.model.api.booking.BookingReferenceType;
import net.havox.times.model.factory.BookingModelFactory;
import org.junit.BeforeClass;

/**
 * API specific tests for {@link BookingReference}.
 * 
 * @author Christian Otto
 */
public class BookingReferenceApiTest extends AbstractBookingReferenceTest
{
  private static BookingModelFactory bookingFactory;

  @BeforeClass
  public static void setupClass()
  {
    bookingFactory = BookingModelFactory.getInstance();
  }

  @Override
  public BookingReference newInstance() throws Exception
  {
    return bookingFactory.getNewBookingReference();
  }

  @Override
  public Booking newBooking() throws Exception
  {
    return bookingFactory.getNewBooking();
  }

  @Override
  public BookingReferenceType newBookingReferenceType() throws Exception
  {
    return bookingFactory.getNewBookingReferenceType();
  }
}
