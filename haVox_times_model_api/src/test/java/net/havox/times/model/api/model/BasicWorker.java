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
package net.havox.times.model.api.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.address.Country;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.api.contact.ContactOption;

/**
 * Basic implementation of {@link Country}.
 *
 * @author Christian Otto
 */
public class BasicWorker extends AbstractChangeAwareAndIdentifiableClass implements Worker
{

  private static final long serialVersionUID = 5859878211562504134L;

  private String firstName;
  private String middleInitials;
  private String lastName;
  private Address address;
  private LocalDate birthDate;
  private final Set<ContactOption> contactOptions;

  public BasicWorker()
  {
    super();

    contactOptions = new HashSet<>();
  }

  @Override
  public String getFirstName()
  {
    return firstName;
  }

  @Override
  public void setFirstName( String firstName )
  {
    this.firstName = firstName;
  }

  @Override
  public String getMiddleInitials()
  {
    return middleInitials;
  }

  @Override
  public void setMiddleInitials( String initials )
  {
    middleInitials = initials;
  }

  @Override
  public String getLastName()
  {
    return lastName;
  }

  @Override
  public void setLastName( String lastName )
  {
    this.lastName = lastName;
  }

  @Override
  public Address getAddress()
  {
    return address;
  }

  @Override
  public void setAddress( Address address )
  {
    this.address = address;
  }

  @Override
  public LocalDate getBirthDate()
  {
    return birthDate;
  }

  @Override
  public void setBirthDate( LocalDate birthDate )
  {
    this.birthDate = birthDate;
  }

  @Override
  public Set<ContactOption> getContactOptions()
  {
    return Collections.unmodifiableSet( contactOptions );
  }

  @Override
  public CollectionMassModificationStatus<ContactOption> addContactOptions( ContactOption... contactOptions )
  {
    CollectionMassModificationStatus<ContactOption> status = new CollectionMassModificationStatus<>();

    for ( ContactOption option : contactOptions )
    {
      if ( this.contactOptions.contains( option ) )
      {
        status.addUnsuccessfulElements( option );
      }
      else
      {
        this.contactOptions.add( option );
        status.addSuccessfulElements( option );
      }
    }

    return status;
  }

  @Override
  public CollectionMassModificationStatus<ContactOption> removeContactOptions( ContactOption... contactOptions )
  {
    CollectionMassModificationStatus<ContactOption> status = new CollectionMassModificationStatus<>();

    for ( ContactOption option : contactOptions )
    {
      if ( this.contactOptions.contains( option ) )
      {
        this.contactOptions.remove( option );
        status.addSuccessfulElements( option );
      }
      else
      {
        status.addUnsuccessfulElements( option );
      }
    }

    return status;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( "id", getId() );
    builder.append( "firstName", getFirstName() );
    builder.append( "middleInitials", getMiddleInitials() );
    builder.append( "lastName", getLastName() );
    builder.append( "address", getAddress() );
    builder.append( "birthDate", getBirthDate() );
    builder.append( "contactOptions", getContactOptions() );
    builder.append( "version", getVersion() );

    return builder.build();
  }
}
