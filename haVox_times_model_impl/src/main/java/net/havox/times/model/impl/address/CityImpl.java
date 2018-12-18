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
import net.havox.times.model.api.address.City;
import net.havox.times.model.api.address.Country;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Imlementation of {@link City}.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = CITY_DB_TABLE_NAME )
public class CityImpl extends AbstractChangeAwareClass<CityImpl> implements City
{

  private static final long serialVersionUID = 6353902360183285609L;

  @Column( name = CITY_DB_COLUMN_ZIP_CODE )
  private String zip;
  @Column( name = CITY_DB_COLUMN_NAME )
  private String name;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = CITY_DB_COLUMN_COUNTRY )
  private Country country;

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
}
