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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.booking.Booking;
import net.havox.times.model.api.booking.BookingReference;
import net.havox.times.model.api.booking.BookingReferenceType;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link BookingReference}.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = BOOKING_REFERENCE_DB_TABLE_NAME )
public class BookingReferenceImpl extends AbstractChangeAwareClass<BookingReferenceImpl> implements BookingReference
{

  private static final long serialVersionUID = 6832193014541142884L;

  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = BOOKING_REFERENCE_DB_COLUMN_BOOKING )
  private Booking booking;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = BOOKING_REFERENCE_DB_COLUMN_TYPE )
  private BookingReferenceType type;
  @Column( name = BOOKING_REFERENCE_DB_COLUMN_VALUE )
  private String value;

  @Override
  public Booking getBooking()
  {
    return booking;
  }

  @Override
  public void setBooking( Booking booking )
  {
    this.booking = booking;
  }

  @Override
  public BookingReferenceType getType()
  {
    return type;
  }

  @Override
  public void setType( BookingReferenceType type )
  {
    this.type = type;
  }

  @Override
  public String getValue()
  {
    return value;
  }

  @Override
  public void setValue( String value )
  {
    this.value = value;
  }
}
