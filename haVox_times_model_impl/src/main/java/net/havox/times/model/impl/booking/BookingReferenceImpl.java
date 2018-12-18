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

import net.havox.times.model.api.booking.BookingReference;
import net.havox.times.model.api.booking.BookingReferenceType;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link BookingReference}.
 * 
 * @author Christian Otto
 */
public class BookingReferenceImpl extends AbstractChangeAwareClass<BookingReferenceImpl> implements BookingReference
{

  private static final long serialVersionUID = 6832193014541142884L;
  
  private BookingReferenceType type;
  private String value;

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
