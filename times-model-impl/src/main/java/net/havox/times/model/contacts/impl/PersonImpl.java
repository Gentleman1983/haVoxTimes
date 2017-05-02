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

import java.time.LocalDate;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.Person;
import net.havox.times.model.impl.AbstractChangeAwareClass;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of a person.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = PersonImpl.DB_TABLE_NAME )
public class PersonImpl extends AbstractChangeAwareClass<PersonImpl> implements Person
{
  /** The db table name. */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_PERSON";

  private static final long serialVersionUID = 5520806245947083462L;

  private String firstName;
  private String middleInitials;
  private String lastName;
  private Address address;
  private LocalDate dateOfBirth;

  @Override
  public String getLastName()
  {
    return this.lastName;
  }

  @Override
  public void setLastName( String lastName )
  {
    this.lastName = lastName;
  }

  @Override
  public String getMiddleInnitials()
  {
    return this.middleInitials;
  }

  @Override
  public void setMiddleInnitials( String middleInnitials )
  {
    this.middleInitials = middleInnitials;
  }

  @Override
  public String getFirstName()
  {
    return this.firstName;
  }

  @Override
  public void setFirstName( String firstName )
  {
    this.firstName = firstName;
  }

  @Override
  public LocalDate getDateOfBirth()
  {
    return this.dateOfBirth;
  }

  @Override
  public void setDateOfBirth( LocalDate dateOfBirth )
  {
    this.dateOfBirth = dateOfBirth;
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
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( this.getId() );
    builder.append( this.getFirstName() );
    builder.append( this.getMiddleInnitials() );
    builder.append( this.getLastName() );
    builder.append( this.getAddress() );
    builder.append( this.getDateOfBirth() );

    return builder.toString();
  }
}
