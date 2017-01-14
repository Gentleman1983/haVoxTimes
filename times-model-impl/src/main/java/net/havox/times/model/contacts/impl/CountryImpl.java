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

import javax.persistence.Entity;
import javax.persistence.Table;
import net.havox.times.model.contacts.api.Country;
import net.havox.times.model.impl.AbstractChangeAwareClass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of the country.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = CountryImpl.DB_TABLE_NAME )
public class CountryImpl extends AbstractChangeAwareClass implements Country
{
  /** The db table name. */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_COUNTRY";

  private static final long serialVersionUID = -632142391869704255L;

  private String name;

  @Override
  public String getName()
  {
    return this.name;
  }

  @Override
  public void setName( String name )
  {
    this.name = name;
  }

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

  @Override
  public boolean equals( Object obj )
  {
    if ( this == obj )
    {
      return true;
    }
    else if ( obj == null )
    {
      return false;
    }
    else if ( this.getClass() == obj.getClass() )
    {
      Country country = ( CountryImpl ) obj;

      if ( this.getId() == null )
      {
        return ( this == country );
      }
      else
      {
        EqualsBuilder builder = new EqualsBuilder();

        builder.append( this.getId(), country.getId() );

        return builder.isEquals();
      }
    }

    return false;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    return builder.toString();
  }
}
