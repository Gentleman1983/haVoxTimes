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
package net.havox.times.model.api.address;

/**
 * Basic implementation od {@link AbstractAddressTest}.
 * 
 * @author Christian Otto
 */
public class BasicAdressTest extends AbstractAddressTest
{

  @Override
  public Address newInstance() throws Exception
  {
    return new Address()
    {
      private static final long serialVersionUID = 2020880992885345176L;
      
      private String street;
      private String houseNumber;
      private City city;
      private long version;
      private Long id;
      
      @Override
      public String getStreet()
      {
        return street;
      }

      @Override
      public void setStreet( String street )
      {
        this.street = street;
      }

      @Override
      public String getHouseNumber()
      {
        return houseNumber;
      }

      @Override
      public void setHouseNumber( String houseNumber )
      {
        this.houseNumber = houseNumber;
      }

      @Override
      public City getCity()
      {
        return this.city;
      }

      @Override
      public void setCity( City city )
      {
        this.city = city;
      }

      @Override
      public long getVersion()
      {
        return version;
      }

      @Override
      public long incrementVersion()
      {
        return ++version;
      }

      @Override
      public Long getId()
      {
        return id;
      }
    };
  }

  @Override
  public City newCity() throws Exception
  {
    return new City()
    {
      private static final long serialVersionUID = 6150184775108706277L;
      
      private String name;
      private String zip;
      private Country country;
      private long version;
      private Long id;
      
      @Override
      public String getZipCode()
      {
        return zip;
      }

      @Override
      public void setZipCode( String zipCode )
      {
        zip = zipCode;
      }

      @Override
      public String getName()
      {
        return name;
      }

      @Override
      public void setName( String name )
      {
        this.name = name;
      }

      @Override
      public Country getCountry()
      {
        return country;
      }

      @Override
      public void setCountry( Country country )
      {
        this.country = country;
      }

      @Override
      public long getVersion()
      {
        return version;
      }

      @Override
      public long incrementVersion()
      {
        return ++version;
      }

      @Override
      public Long getId()
      {
        return id;
      }
    };
  }
}
