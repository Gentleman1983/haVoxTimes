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
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.booking.Account;
import net.havox.times.model.api.booking.Project;

/**
 * Basic implementation of {@link Project}.
 * 
 * @author Christian Otto
 */
public class BasicProject extends AbstractChangeAwareAndIdentifiableClass implements Project
{

  private static final long serialVersionUID = -7935715108821345744L;
  
  private String name;
  private LocalDate start;
  private LocalDate end;
  private final Set<Account> accounts;
  
  public BasicProject()
  {
    super();
    
    accounts = new HashSet<>();
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
