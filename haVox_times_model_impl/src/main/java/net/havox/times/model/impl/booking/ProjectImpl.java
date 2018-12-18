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
package net.havox.times.model.impl.booking;

import java.time.LocalDate;
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
import net.havox.times.model.api.booking.Account;
import net.havox.times.model.api.booking.Project;
import net.havox.times.model.api.company.Employment;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link Project}.
 * 
 * @author Christian Otto
 */
@Entity
@Table( name = PROJECT_DB_TABLE_NAME )
public class ProjectImpl extends AbstractChangeAwareClass<ProjectImpl> implements Project
{

  private static final long serialVersionUID = 6402688587696621775L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = PROJECT_DB_COLUMN_EMPLOYMENT )
  private Employment employment;
  @Column( name = PROJECT_DB_COLUMN_NAME )
  private String name;
  @Column( name = PROJECT_DB_COLUMN_START_DATE )
  private LocalDate start;
  @Column( name = PROJECT_DB_COLUMN_END_DATE )
  private LocalDate end;
  @OneToMany( mappedBy = PROJECT_DB_TABLE_NAME, cascade = CascadeType.ALL )
  private final Set<Account> accounts;
  
  public ProjectImpl()
  {
    super();
    
    accounts = new CopyOnWriteArraySet<>();
  }

  @Override
  public Employment getEmployment()
  {
    return employment;
  }

  @Override
  public void setEmployment( Employment employment )
  {
    this.employment = employment;
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
  public LocalDate getStartDate()
  {
    return start;
  }

  @Override
  public void setStartDate( LocalDate start )
  {
    this.start = start == null ? LocalDate.MIN : start;
  }

  @Override
  public LocalDate getEndDate()
  {
    return end;
  }

  @Override
  public void setEndDate( LocalDate end )
  {
    this.end = end == null ? LocalDate.MAX : end;
  }

  @Override
  public Set<Account> getAccounts()
  {
    return Collections.unmodifiableSet( accounts );
  }

  @Override
  public CollectionMassModificationStatus<Account> addAccounts( Account... accounts )
  {
    CollectionMassModificationStatus<Account> status = new CollectionMassModificationStatus<>();

    for ( Account account : accounts )
    {
      if ( this.accounts.contains(account ) )
      {
        status.addUnsuccessfulElements(account );
      }
      else
      {
        this.accounts.add(account );
        status.addSuccessfulElements(account );
      }
    }

    return status;
  }

  @Override
  public CollectionMassModificationStatus<Account> removeAccounts( Account... accounts )
  {
    CollectionMassModificationStatus<Account> status = new CollectionMassModificationStatus<>();

    for ( Account account : accounts )
    {
      if ( this.accounts.contains(account ) )
      {
        this.accounts.remove(account );
        status.addSuccessfulElements(account );
      }
      else
      {
        status.addUnsuccessfulElements(account );
      }
    }

    return status;
  }
}
