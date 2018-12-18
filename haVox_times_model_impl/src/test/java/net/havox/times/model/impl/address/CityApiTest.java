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
package net.havox.times.model.impl.address;

import org.junit.BeforeClass;

import net.havox.times.model.api.address.AbstractCityTest;
import net.havox.times.model.api.address.City;
import net.havox.times.model.api.address.Country;
import net.havox.times.model.factory.AddressModelFactory;

/**
 * API specific tests for {@link City}.
 *
 * @author Christian Otto
 */
public class CityApiTest extends AbstractCityTest
{

  private static AddressModelFactory addressFactory;

  @BeforeClass
  public static void setupClass()
  {
    addressFactory = AddressModelFactory.getInstance();
  }

  @Override
  public City newInstance() throws Exception
  {
    return addressFactory.getNewCity();
  }

  @Override
  public Country newCountry() throws Exception
  {
    return addressFactory.getNewCountry();
  }
}
