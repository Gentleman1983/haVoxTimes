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
 * This interface represents a booking reference type.
 *
 * @author Christian Otto
 */
public interface BookingReferenceType extends ChangeAware, Serializable
{
  /**
   * Returns the name of the booking reference type.
   * 
   * @return the name.
   */
  String getType();
  
  /**
   * Sets the name of the booking reference type.
   * 
   * @param name the name.
   */
  void setType( String name );
  
  /**
   * Returns the project.
   * 
   * @return the project.
   */
  Project getProject();
  
  /**
   * Sets the project.
   * 
   * @param project the project.
   */
  void setProject( Project project );
  
  /**
   * Checks if a prefix is set.
   * 
   * @return is a prefix set?
   */
  boolean hasPrefix();
  
  /**
   * Returns the prefix.
   * 
   * @return the prefix.
   */
  String getPrefix();
  
  /**
   * Sets the prefix.
   * 
   * @param prefix the prefix.
   */
  void setPrefix( String prefix );
  
  /**
   * Checks if a suffix is set.
   * 
   * @return is a suffix set?
   */
  boolean hasSuffix();
  
  /**
   * Returns the suffix.
   * 
   * @return the suffix.
   */
  String getSuffix();
  
  /**
   * Sets the suffix.
   * 
   * @param suffix the suffix.
   */
  void setSuffix( String suffix );
  
  /**
   * Returns the validation pattern.
   * 
   * @return the validation pattern.
   */
  String getValidationPattern();
  
  /**
   * Sets the validation pattern.
   * 
   * @param pattern the validation pattern.
   */
  void setValidationPattern( String pattern );
  
  /**
   * Returns the external reference.
   * 
   * @return the external reference.
   */
  String getExternalReference();
  
  /**
   * Sets the external reference.
   * 
   * @param reference the external reference.
   */
  void setExternalReference( String reference );
}
