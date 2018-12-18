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
import java.util.Set;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.CollectionMassModificationStatus;

/**
 * This interface represents a booking.
 *
 * @author Christian Otto
 */
public interface Booking extends ChangeAware, Serializable
{
  /**
   * Returns the booking type.
   * 
   * @return the type.
   */
  BookingType getType();
  
  /**
   * Sets the booking type.
   * 
   * @param type the type.
   */
  void setType( BookingType type );
  
  /**
   * Returns the booking text.
   * 
   * @return the text.
   */
  String getText();
  
  /**
   * Sets the booking text.
   * 
   * @param text the text.
   */
  void setText( String text );
  
  /**
   * Is this booking invoiced?
   * 
   * @return true, if it is invoiced.
   */
  boolean isInvoiced();
  
  /**
   * Sets the status if this booking is invoiced.
   * 
   * @param isInvoiced true, if invoiced.
   */
  void setIsInvoiced( boolean isInvoiced );
  
  /**
   * Returns the set of booking references.
   * 
   * @return the references.
   */
  Set<BookingReference> getReferences();
  
  /**
   * Adds booking references.
   * 
   * @param references references.
   * 
   * @return the status.
   */
  CollectionMassModificationStatus<BookingReference> addReferences( BookingReference... references );
  
  /**
   * Removes booking references.
   * 
   * @param references references.
   * 
   * @return the status.
   */
  CollectionMassModificationStatus<BookingReference> removeReferences( BookingReference... references );
}
