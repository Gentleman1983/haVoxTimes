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
import java.util.Collection;

/**
 * This interface represents a company.
 *
 * @author Christian Otto
 */
public interface Company extends Serializable
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
   * Gets the company name.
   *
   * @return the company name
   */
  String getName();

  /**
   * Sets the company name.
   *
   * @param name the company name
   */
  void setName( String name );

  /**
   * Gets the company address.
   *
   * @return the company address
   */
  Address getAddress();

  /**
   * Sets the company address.
   *
   * @param address the company address
   */
  void setAddress( Address address );

  /**
   * Has this company subcompanies?
   *
   * @return true, if this company has sub companies
   *
   * @throws IllegalStateException In case that the sub companies property are not yet initialized
   */
  default boolean hasSubCompanies()
  {
    if ( this.getSubCompanies() == null )
    {
      throw new IllegalStateException( "Sub-companies property not yet initialized." );
    }

    return !this.getSubCompanies().isEmpty();
  }

  /**
   * Gets the sub companies.
   *
   * @return the sub companies
   */
  Collection<Company> getSubCompanies();
}
