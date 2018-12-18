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
package net.havox.times.model.impl.address;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.address.City;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link Address}.
 * 
 * @author Christian Otto
 */
@Entity
@Table( name = ADDRESS_DB_TABLE_NAME )
public class AddressImpl extends AbstractChangeAwareClass<AddressImpl> implements Address
{

  private static final long serialVersionUID = 8376031385090004308L;
  
  @Column( name = ADDRESS_DB_COLUMN_STREET )
  private String street;
  @Column( name = ADDRESS_DB_COLUMN_HOUSE_NUMBER )
  private String houseNumber;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn( name = ADDRESS_DB_COLUMN_CITY )
  private City city;

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
    return city;
  }

  @Override
  public void setCity( City city )
  {
    this.city = city;
  }
}
