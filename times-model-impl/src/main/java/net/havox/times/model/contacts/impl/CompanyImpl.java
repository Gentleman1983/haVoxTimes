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

import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.impl.AbstractChangeAwareClass;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of the company.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = CompanyImpl.DB_TABLE_NAME )
public class CompanyImpl extends AbstractChangeAwareClass implements Company
{
  /** The db table name. */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_COMPANY";

  private static final long serialVersionUID = 7315535092868289098L;

  private String name;
  private Address address;
  private final Collection<Company> subCompanies = new CopyOnWriteArrayList<>();

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
  public Address getAddress()
  {
    return this.address;
  }

  @Override
  public void setAddress( Address address )
  {
    this.address = address;
  }

  @Override
  public Collection<Company> getSubCompanies()
  {
    return this.subCompanies;
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
      Company company = ( CompanyImpl ) obj;

      if ( this.getId() == null )
      {
        return ( this == company );
      }
      else
      {
        EqualsBuilder builder = new EqualsBuilder();

        builder.append( this.getId(), company.getId() );

        return builder.isEquals();
      }
    }

    return false;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( this.getId() );
    builder.append( this.getName() );
    builder.append( this.getAddress() );
    builder.append( this.getSubCompanies() );

    return builder.toString();
  }
}
