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

import net.havox.times.model.api.model.BasicAccount;
import net.havox.times.model.api.model.BasicBooking;
import net.havox.times.model.api.model.BasicBookingReference;
import net.havox.times.model.api.model.BasicBookingType;

/**
 * Basic implementation of {@link AbstractBookingTest}.
 *
 * @author Christian Otto
 */
public class BasicBookingTest extends AbstractBookingTest
{

  @Override
  public Booking newInstance() throws Exception
  {
    return new BasicBooking();
  }

  @Override
  public Account newAccount() throws Exception
  {
    return new BasicAccount();
  }

  @Override
  public BookingType newBookingType() throws Exception
  {
    return new BasicBookingType();
  }

  @Override
  public BookingReference newBookingReference() throws Exception
  {
    return new BasicBookingReference();
  }
}
