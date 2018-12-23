/*
 * Copyright (C) 2017 [haVox] Design
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
package net.havox.times.model.impl;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

import net.havox.times.model.api.ChangeAware;

/**
 * This class provides the basic functionality to provide change awareness.
 *
 * @param <T> the type of change aware class.
 *
 * @author Christian Otto
 */
@MappedSuperclass
public abstract class AbstractChangeAwareClass<T extends AbstractChangeAwareClass> implements ChangeAware, Comparable<T>
{

  @Id
  @GeneratedValue
  @Column( name = "id" )
  private Long id;
  @Column( name = "version", nullable = false )
  private long version = 1l;

  @Override
  public Long getId()
  {
    return this.id;
  }
  
  @Override
  public void setId( Long id )
  {
    this.id = id;
  }

  @Override
  public long getVersion()
  {
    return this.version;
  }

  @Override
  public long incrementVersion()
  {
    return ++this.version;
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
  public boolean equals( Object object )
  {
    if ( this == object )
    {
      return true;
    }
    else if ( object == null )
    {
      return false;
    }
    else if ( this.getClass() == object.getClass() )
    {
      T typedObject = ( T ) object;

      if ( this.getId() == null )
      {
        return ( this == typedObject );
      }
      else
      {
        EqualsBuilder builder = new EqualsBuilder();

        builder.append( this.getId(), typedObject.getId() );

        return builder.isEquals();
      }
    }

    return false;
  }

  @Override
  public int compareTo( T other )
  {
    if ( null == this.getId() || null == other.getId() )
    {
      return super.hashCode() - ( ( Object ) other ).hashCode();
    }
    return ( int ) ( this.getId() - other.getId() );
  }
}
