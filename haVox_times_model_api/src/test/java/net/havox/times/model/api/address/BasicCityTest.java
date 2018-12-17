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
 * Basic implementation of {@link AbstractCityTest}.
 * 
 * @author Christian Otto
 */
public class BasicCityTest extends AbstractCityTest
{

  @Override
  public City newInstance() throws Exception
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

  @Override
  public Country newCountry() throws Exception
  {
    return new Country()
    {
      private static final long serialVersionUID = -1745768422907059718L;
      
      private String name;
      private long version;
      private Long id;
      
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
