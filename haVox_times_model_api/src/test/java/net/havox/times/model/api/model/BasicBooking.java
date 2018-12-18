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

import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.booking.Account;
import net.havox.times.model.api.booking.Booking;
import net.havox.times.model.api.booking.BookingReference;
import net.havox.times.model.api.booking.BookingType;

/**
 * Basic implementation of {@link Booking}.
 *
 * @author Christian Otto
 */
public class BasicBooking extends AbstractChangeAwareAndIdentifiableClass implements Booking
{

  private static final long serialVersionUID = 6088845829981604482L;

  private Account account;
  private BookingType type;
  private String text;
  private boolean invoiced;
  private final Set<BookingReference> references;

  public BasicBooking()
  {
    super();

    this.references = new HashSet<>();
  }

  @Override
  public Account getAccount()
  {
    return account;
  }

  @Override
  public void setAccount( Account account )
  {
    this.account = account;
  }

  @Override
  public BookingType getType()
  {
    return type;
  }

  @Override
  public void setType( BookingType type )
  {
    this.type = type;
  }

  @Override
  public String getText()
  {
    return text;
  }

  @Override
  public void setText( String text )
  {
    this.text = text;
  }

  @Override
  public boolean isInvoiced()
  {
    return invoiced;
  }

  @Override
  public void setIsInvoiced( boolean isInvoiced )
  {
    invoiced = isInvoiced;
  }

  @Override
  public Set<BookingReference> getReferences()
  {
    return Collections.unmodifiableSet( references );
  }

  @Override
  public CollectionMassModificationStatus<BookingReference> addReferences( BookingReference... references )
  {
    CollectionMassModificationStatus<BookingReference> status = new CollectionMassModificationStatus<>();

    for ( BookingReference reference : references )
    {
      if ( this.references.contains( reference ) )
      {
        status.addUnsuccessfulElements( reference );
      }
      else
      {
        this.references.add( reference );
        status.addSuccessfulElements( reference );
      }
    }

    return status;
  }

  @Override
  public CollectionMassModificationStatus<BookingReference> removeReferences( BookingReference... references )
  {
    CollectionMassModificationStatus<BookingReference> status = new CollectionMassModificationStatus<>();

    for ( BookingReference reference : references )
    {
      if ( this.references.contains( reference ) )
      {
        this.references.remove( reference );
        status.addSuccessfulElements( reference );
      }
      else
      {
        status.addUnsuccessfulElements( reference );
      }
    }

    return status;
  }
}
