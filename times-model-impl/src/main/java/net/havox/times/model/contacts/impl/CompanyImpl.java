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

import java.util.ArrayList;
import java.util.Collection;
import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.Company;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of the company.
 *
 * @author Christian Otto
 */
public class CompanyImpl implements Company
{

  /**
   * The SerialVersionUID.
   */
  private static final long serialVersionUID = 7315535092868289098L;

  /**
   * The id.
   */
  private Long id;
  /**
   * The version.
   */
  private long version;
  /**
   * The company name.
   */
  private String name;
  /**
   * The company address.
   */
  private Address address;
  /**
   * The sub companies.
   */
  private Collection<Company> subCompanies = new ArrayList<>();

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
  public Address getAddress()
  {
    return this.address;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setAddress( Address address )
  {
    this.address = address;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Company> getSubCompanies()
  {
    return this.subCompanies;
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
    if ( this.getClass() == obj.getClass() )
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

  /**
   * {@inheritDoc}
   */
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
