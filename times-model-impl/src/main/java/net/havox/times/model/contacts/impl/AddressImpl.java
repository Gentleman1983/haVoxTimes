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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.City;
import net.havox.times.model.impl.AbstractChangeAwareClass;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of an address.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = AddressImpl.DB_TABLE_NAME )
public class AddressImpl extends AbstractChangeAwareClass<AddressImpl> implements Address
{

  /**
   * The db table name.
   */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_ADDRESS";

  private static final long serialVersionUID = -3857698669332938089L;
  
  @Column( name = "street" )
  private String street;
  @Column( name = "house_number" )
  private String houseNumber;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn( name = "city_id" )
  private City city;

  @Override
  public String getStreet()
  {
    return this.street;
  }

  @Override
  public void setStreet( String street )
  {
    this.street = street;
  }

  @Override
  public String getHouseNumber()
  {
    return this.houseNumber;
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
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( this.getId() );
    builder.append( this.getStreet() );
    builder.append( this.getHouseNumber() );
    builder.append( this.getCity() );

    return builder.toString();
  }
}
