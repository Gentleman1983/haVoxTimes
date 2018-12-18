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
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Factory test of {@link AddressModelFactory}.
 * 
 * @author Christian Otto
 */
public class AddressModelFactoryTest
{
  public static AddressModelFactory factory;

  @BeforeClass
  public static void setupClass()
  {
    factory = AddressModelFactory.getInstance();
  }

  @Test
  public void testGetInstance()
  {
    Object instanceUnderTest = AddressModelFactory.getInstance();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( AddressModelFactory.class ) ) );
  }

  @Test
  public void testGetNewAddress()
  {
    Address instanceUnderTest = factory.getNewAddress();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( AddressImpl.class ) ) );
  }

  @Test
  public void testGetNewCity()
  {
    City instanceUnderTest = factory.getNewCity();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( CityImpl.class ) ) );
  }

  @Test
  public void testGetNewCountry()
  {
    Country instanceUnderTest = factory.getNewCountry();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( CountryImpl.class ) ) );
  }
}
