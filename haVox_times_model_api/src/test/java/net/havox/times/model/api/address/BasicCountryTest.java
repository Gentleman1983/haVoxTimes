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
 * Basic implementation of {@link AbstractCountryTest}.
 * 
 * @author Christian Otto
 */
public class BasicCountryTest extends AbstractCountryTest
{

  @Override
  public Country newInstance() throws Exception
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
