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

/**
 * This interface represents a country.
 *
 * @author Christian Otto
 */
public interface Country extends Serializable
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
   * Gets the country name.
   *
   * @return the country name
   */
  String getName();

  /**
   * Sets the country name.
   *
   * @param name the country name
   */
  void setName( String name );
}
