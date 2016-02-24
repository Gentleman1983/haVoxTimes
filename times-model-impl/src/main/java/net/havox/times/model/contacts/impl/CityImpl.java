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
package net.havox.times.model.contacts.impl;

import net.havox.times.model.contacts.api.City;
import net.havox.times.model.contacts.api.Country;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of a city.
 *
 * @author Christian Otto
 */
public class CityImpl implements City
{

  /**
   * The SerialVersionUID.
   */
  private static final long serialVersionUID = -416723199770693783L;

  /**
   * The id.
   */
  private Long id;
  /**
   * The version.
   */
  private long version;
  /**
   * The zip code.
   */
  private String zipCode;
  /**
   * The city name.
   */
  private String name;
  /**
   * The country.
   */
  private Country country;

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getId()
  {
    return this.id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public long getVersion()
  {
    return this.version;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getZipCode()
  {
    return this.zipCode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setZipCode( String zipCode )
  {
    this.zipCode = zipCode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String getName()
  {
    return this.name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName( String name )
  {
    this.name = name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Country getCountry()
  {
    return this.country;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setCountry( Country country )
  {
    this.country = country;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode()
  {
    int hashCode;

    if ( this.getId() == null )
    {
      hashCode = super.hashCode();
    }
    else
    {
      HashCodeBuilder builder = new HashCodeBuilder();

      builder.append( this.getId() );

      hashCode = builder.toHashCode();
    }

    return hashCode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals( Object obj )
  {
    if ( this == obj ) {
      return true;
    }
    else if ( obj == null ) {
      return false;
    }
    else if ( this.getClass() == obj.getClass() )
    {
      City city = ( CityImpl ) obj;

      if ( this.getId() == null )
      {
        return ( this == city );
      }
      else
      {
        EqualsBuilder builder = new EqualsBuilder();

        builder.append( this.getId(), city.getId() );

        return builder.isEquals();
      }
    }

    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( this.getId() );
    builder.append( this.getZipCode() );
    builder.append( this.getName() );
    builder.append( this.getCountry() );

    return builder.toString();
  }
}
