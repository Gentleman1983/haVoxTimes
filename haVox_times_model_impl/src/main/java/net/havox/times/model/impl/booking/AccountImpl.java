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
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.booking.Account;
import net.havox.times.model.api.booking.Booking;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link Account}.
 *
 * @author Christian Otto
 */
public class AccountImpl extends AbstractChangeAwareClass<AccountImpl> implements Account
{

  private static final long serialVersionUID = 8058132623183316967L;

  private String name;
  private LocalDate start;
  private LocalDate end;
  private Long budget;
  private final Set<Booking> bookings;

  public AccountImpl()
  {
    super();

    bookings = new CopyOnWriteArraySet<>();
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
  public Long getBudget()
  {
    return budget;
  }

  @Override
  public void setBudget( Long budget )
  {
    this.budget = budget;
  }

  @Override
  public Set<Booking> getBookings()
  {
    return Collections.unmodifiableSet( bookings );
  }

  @Override
  public CollectionMassModificationStatus<Booking> addBookings( Booking... bookings )
  {
    CollectionMassModificationStatus<Booking> status = new CollectionMassModificationStatus<>();

    for ( Booking booking : bookings )
    {
      if ( this.bookings.contains( booking ) )
      {
        status.addUnsuccessfulElements( booking );
      }
      else
      {
        this.bookings.add( booking );
        status.addSuccessfulElements( booking );
      }
    }

    return status;
  }

  @Override
  public CollectionMassModificationStatus<Booking> removeBookings( Booking... bookings )
  {
    CollectionMassModificationStatus<Booking> status = new CollectionMassModificationStatus<>();

    for ( Booking booking : bookings )
    {
      if ( this.bookings.contains( booking ) )
      {
        this.bookings.remove( booking );
        status.addSuccessfulElements( booking );
      }
      else
      {
        status.addUnsuccessfulElements( booking );
      }
    }

    return status;
  }
}
