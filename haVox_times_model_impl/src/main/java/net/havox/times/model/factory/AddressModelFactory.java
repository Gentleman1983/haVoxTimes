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
package net.havox.times.model.factory;

import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.address.City;
import net.havox.times.model.api.address.Country;
import net.havox.times.model.impl.address.AddressImpl;
import net.havox.times.model.impl.address.CityImpl;
import net.havox.times.model.impl.address.CountryImpl;

/**
 * The address model factory.
 *
 * @author Christian Otto
 */
public class AddressModelFactory
{

  /**
   * The singleton model factory instance.
   */
  private static final AddressModelFactory INSTANCE = new AddressModelFactory();

  /**
   * The private default constructor.
   */
  private AddressModelFactory()
  {
    super();
  }

  /**
   * Returns the singleton model factory.
   *
   * @return the {@link AddressModelFactory} instance.
   */
  public static AddressModelFactory getInstance()
  {
    return AddressModelFactory.INSTANCE;
  }

  /**
   * Returns a new {@link Address}.
   * 
   * @return a new address entity.
   */
  public Address getNewAddress()
  {
    return new AddressImpl();
  }

  /**
   * Returns a new {@link City}.
   * 
   * @return a new city entity.
   */
  public City getNewCity()
  {
    return new CityImpl();
  }

  /**
   * Returns a new {@link Country}.
   * 
   * @return a new country entity.
   */
  public Country getNewCountry()
  {
    return new CountryImpl();
  }
}
