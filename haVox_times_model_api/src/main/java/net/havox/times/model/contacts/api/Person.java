/*
 * Copyright (C) 2015 [haVox] Design
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
package net.havox.times.model.contacts.api;

import static net.havox.exceptions.GuruErrorCode.ILLEGAL_STATE;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.Period;

import net.havox.exceptions.GuruMeditationWarning;
import net.havox.times.model.api.ChangeAware;

/**
 * This interface represents a person.
 *
 * @author Christian Otto
 */
public interface Person extends ChangeAware, Serializable
{

  /**
   * Gets the last name.
   *
   * @return the last name
   */
  String getLastName();

  /**
   * Sets the last name.
   *
   * @param lastName the last name
   */
  void setLastName( String lastName );

  /**
   * Gets the middle innitials.
   *
   * @return the middle innitials
   */
  String getMiddleInnitials();

  /**
   * Sets the middle innitials.
   *
   * @param middleInnitials the middle innitials
   */
  void setMiddleInnitials( String middleInnitials );

  /**
   * Gets the first name.
   *
   * @return the first name
   */
  String getFirstName();

  /**
   * Sets the first name.
   *
   * @param firstName the first name
   */
  void setFirstName( String firstName );

  /**
   * Gets the age.
   *
   * @return the age
   *
   * @throws GuruMeditationWarning In case the birth date is not set.
   */
  default Period getAge()
  {
    if ( this.getDateOfBirth() == null )
    {
      throw new GuruMeditationWarning( ILLEGAL_STATE, "Unable to calculate age. No birth date set." );
    }

    return Period.between( this.getDateOfBirth(), LocalDate.now() );
  }

  /**
   * Gets the date of birth.
   *
   * @return the date of birth
   */
  LocalDate getDateOfBirth();

  /**
   * Sets the date of birth.
   *
   * @param dateOfBirth the date of birth
   */
  void setDateOfBirth( LocalDate dateOfBirth );

  /**
   * Gets the address.
   *
   * @return the address
   */
  Address getAddress();

  /**
   * Sets the address.
   *
   * @param address the address
   */
  void setAddress( Address address );
}