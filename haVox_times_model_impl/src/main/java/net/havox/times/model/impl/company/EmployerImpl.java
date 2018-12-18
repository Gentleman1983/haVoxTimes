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

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.contact.ContactOption;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link Employer}.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = EMPLOYER_DB_TABLE_NAME )
public class EmployerImpl extends AbstractChangeAwareClass<EmployerImpl> implements Employer
{

  private static final long serialVersionUID = -6794382971390618252L;

  @Column( name = EMPLOYER_DB_COLUMN_NAME )
  private String name;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = EMPLOYER_DB_COLUMN_ADDRESS )
  private Address address;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = EMPLOYER_DB_COLUMN_EMPLOYER_GROUP )
  private Employer group;
  @OneToMany( mappedBy = EMPLOYER_DB_TABLE_NAME, cascade = CascadeType.ALL )
  private final Set<ContactOption> contactOptions;

  public EmployerImpl()
  {
    super();

    contactOptions = new CopyOnWriteArraySet<>();
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
}
