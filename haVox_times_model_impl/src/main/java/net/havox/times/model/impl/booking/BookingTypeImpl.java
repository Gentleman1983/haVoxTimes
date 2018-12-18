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

import java.math.BigDecimal;
import net.havox.times.model.api.booking.BookingType;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link BookingType}.
 * 
 * @author Christian Otto
 */
public class BookingTypeImpl extends AbstractChangeAwareClass<BookingTypeImpl> implements BookingType
{

  private static final long serialVersionUID = 5106400945569949499L;
  
  private String name;
  private BigDecimal multiplier;
  private boolean canBeInvoiced;

  @Override
  public String getType()
  {
    return name;
  }

  @Override
  public void setType( String name )
  {
    this.name = name;
  }

  @Override
  public BigDecimal getMultiplier()
  {
    return multiplier;
  }

  @Override
  public void setMultiplier( BigDecimal multiplier )
  {
    this.multiplier = multiplier;
  }

  @Override
  public boolean canBeInvoiced()
  {
    return canBeInvoiced;
  }

  @Override
  public void setCanBeInvoiced( boolean canBeInvoiced )
  {
    this.canBeInvoiced = canBeInvoiced;
  }
}
