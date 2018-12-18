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

/**
 * The booking model factory.
 *
 * @author Christian Otto
 */
public class BookingModelFactory
{

  /**
   * The singleton model factory instance.
   */
  private static final BookingModelFactory INSTANCE = new BookingModelFactory();

  /**
   * The private default constructor.
   */
  private BookingModelFactory()
  {
    super();
  }

  /**
   * Returns the singleton model factory.
   *
   * @return the {@link BookingModelFactory} instance.
   */
  public static BookingModelFactory getInstance()
  {
    return BookingModelFactory.INSTANCE;
  }

  /**
   * Returns a new {@link Account}.
   *
   * @return a new account entity.
   */
  public Account getNewAccount()
  {
    return new AccountImpl();
  }

  /**
   * Returns a new {@link Booking}.
   *
   * @return a new booking entity.
   */
  public Booking getNewBooking()
  {
    return new BookingImpl();
  }

  /**
   * Returns a new {@link BookingReference}.
   *
   * @return a new booking reference entity.
   */
  public BookingReference getNewBookingReference()
  {
    return new BookingReferenceImpl();
  }

  /**
   * Returns a new {@link BookingReferenceType}.
   *
   * @return a new booking reference type entity.
   */
  public BookingReferenceType getNewBookingReferenceType()
  {
    return new BookingReferenceTypeImpl();
  }

  /**
   * Returns a new {@link BookingType}.
   *
   * @return a new booking type entity.
   */
  public BookingType getNewBookingType()
  {
    return new BookingTypeImpl();
  }

  /**
   * Returns a new {@link Project}.
   *
   * @return a new project entity.
   */
  public Project getNewProject()
  {
    return new ProjectImpl();
  }
}
