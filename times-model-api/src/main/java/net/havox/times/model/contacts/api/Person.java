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

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.LocalDate;

/**
 * This interface represents a person.
 *
 * @author Christian Otto
 */
public interface Person extends Serializable
{

  /**
   * Gets the id.
   *
   * @return the id
   */
  Long getId();

  /**
   * Gets the version.
   *
   * @return the version
   */
  long getVersion();

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
   * @throws IllegalStateException In case the birth date is not set.
   */
  default Duration getAge()
  {
    if ( this.getDateOfBirth() == null )
    {
      throw new IllegalStateException( "Unable to calculate age. No birth date set." );
    }

    return Duration.between( Instant.now(), this.getDateOfBirth() );
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
