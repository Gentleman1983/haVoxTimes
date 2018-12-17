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
import java.math.BigDecimal;

import net.havox.times.model.api.ChangeAware;

/**
 * This interface represents a booking type.
 *
 * @author Christian Otto
 */
public interface BookingType extends ChangeAware, Serializable
{
  /**
   * Returns the unique name of the booking type.
   * 
   * @return the unique name.
   */
  String getType();
  
  /**
   * Sets the unique name of the booking type.
   * 
   * @param name the unique name.
   */
  void setType( String name );
  
  /**
   * Returns the multiplier. A multiplier of 1.5 means that every booked hour is worth 1.5 hours.
   * 
   * @return the multiplier.
   */
  BigDecimal getMultiplier();
  
  /**
   * Sets the multiplier.
   * 
   * @param multiplier the multiplier.
   */
  void setMultiplier( BigDecimal multiplier );
  
  /**
   * Is this type of booking invoicable?
   * 
   * @return can this booking be invoiced.
   */
  boolean canBeInvoiced();
  
  /**
   * Sets if this booking can be invoiced.
   * 
   * @param canBeInvoiced can this booking be invoiced.
   */
  void setCanBeInvoiced( boolean canBeInvoiced );
}
