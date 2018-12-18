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
import net.havox.times.model.api.booking.Booking;
import net.havox.times.model.api.booking.BookingReference;
import net.havox.times.model.api.booking.BookingType;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link Booking}.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = BOOKING_DB_TABLE_NAME )
public class BookingImpl extends AbstractChangeAwareClass<BookingImpl> implements Booking
{

  private static final long serialVersionUID = -3221948978182231002L;

  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = BOOKING_DB_COLUMN_ACCOUNT )
  private Account account;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = BOOKING_DB_COLUMN_TYPE )
  private BookingType type;
  @Column( name = BOOKING_DB_COLUMN_TEXT )
  private String text;
  @Column( name = BOOKING_DB_COLUMN_IS_INVOICED )
  private boolean invoiced;
  @OneToMany( mappedBy = BOOKING_DB_TABLE_NAME, cascade = CascadeType.ALL )
  private final Set<BookingReference> references;

  public BookingImpl()
  {
    super();

    this.references = new CopyOnWriteArraySet<>();
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
