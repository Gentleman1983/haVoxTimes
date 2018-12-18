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

import java.io.Serializable;

import net.havox.times.model.api.ChangeAware;

/**
 * This interface represents a booking reference.
 *
 * @author Christian Otto
 */
public interface BookingReference extends ChangeAware, Serializable
{

  /**
   * Returns the booking.
   *
   * @return the booking.
   */
  Booking getBooking();

  /**
   * Sets the booking.
   *
   * @param booking the booking.
   */
  void setBooking( Booking booking );

  /**
   * Returns the booking reference type.
   *
   * @return the type.
   */
  BookingReferenceType getType();

  /**
   * Sets the booking reference type.
   *
   * @param type the type.
   */
  void setType( BookingReferenceType type );

  /**
   * Returns the reference value.
   *
   * @return the value.
   */
  String getValue();

  /**
   * Sets the reference value.
   *
   * @param value the value.
   */
  void setValue( String value );
}
