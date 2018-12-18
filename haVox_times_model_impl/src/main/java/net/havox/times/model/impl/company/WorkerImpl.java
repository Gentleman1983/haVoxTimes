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
package net.havox.times.model.impl.company;

import java.time.LocalDate;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.api.contact.ContactOption;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link Worker}.
 * 
 * @author Christian Otto
 */
public class WorkerImpl extends AbstractChangeAwareClass<WorkerImpl> implements Worker
{

  private static final long serialVersionUID = -2803772130584844878L;

  private String firstName;
  private String middleInitials;
  private String lastName;
  private Address address;
  private LocalDate birthDate;
  private final Set<ContactOption> contactOptions;

  public WorkerImpl()
  {
    super();

    contactOptions = new ConcurrentSkipListSet<>();
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
}
