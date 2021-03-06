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
import net.havox.times.model.api.address.Country;
import net.havox.times.model.api.booking.Account;
import net.havox.times.model.api.booking.Booking;
import net.havox.times.model.api.booking.Project;

/**
 * Basic implementation of {@link Country}.
 *
 * @author Christian Otto
 */
public class BasicAccount extends AbstractChangeAwareAndIdentifiableClass implements Account
{

  private static final long serialVersionUID = -7293617991333044884L;

  private Project project;
  private String name;
  private LocalDate start;
  private LocalDate end;
  private Long budget;
  private final Set<Booking> bookings;

  public BasicAccount()
  {
    super();

    bookings = new HashSet<>();
  }

  @Override
  public Project getProject()
  {
    return project;
  }

  @Override
  public void setProject( Project project )
  {
    this.project = project;
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

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( "id", getId() );
    builder.append( "project", getProject() );
    builder.append( "name", getName() );
    builder.append( "start", getStartDate() );
    builder.append( "end", getEndDate() );
    builder.append( "budget", getBudget() );
    builder.append( "bookings", getBookings() );
    builder.append( "version", getVersion() );

    return builder.build();
  }
}
