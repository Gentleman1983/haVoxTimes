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

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.contact.ContactOption;

/**
 * Basic implementation of {@link Employer}.
 *
 * @author Christian Otto
 */
public class BasicEmployer extends AbstractChangeAwareAndIdentifiableClass implements Employer
{

  private static final long serialVersionUID = -1379172374607001341L;

  private String name;
  private Address address;
  private Employer group;
  private final Set<ContactOption> contactOptions;

  public BasicEmployer()
  {
    super();

    contactOptions = new HashSet<>();
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
  public Employer getEmploymentGroup()
  {
    return group;
  }

  @Override
  public void setEmploymentGroup( Employer group )
  {
    this.group = group;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( "id", getId() );
    builder.append( "name", getName() );
    builder.append( "address", getAddress() );
    builder.append( "employmentGroup", getEmploymentGroup() );
    builder.append( "contactOptions", getContactOptions() );
    builder.append( "version", getVersion() );

    return builder.build();
  }
}
