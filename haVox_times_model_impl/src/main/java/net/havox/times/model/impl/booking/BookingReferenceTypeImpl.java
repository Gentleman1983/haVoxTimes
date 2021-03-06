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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.booking.BookingReferenceType;
import net.havox.times.model.api.booking.Project;
import net.havox.times.model.impl.AbstractChangeAwareClass;
import org.apache.commons.lang3.StringUtils;

/**
 * Implementation of {@link BookingReferenceType}.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = BOOKING_REFERENCE_TYPE_DB_TABLE_NAME )
public class BookingReferenceTypeImpl extends AbstractChangeAwareClass<BookingReferenceTypeImpl> implements BookingReferenceType
{

  private static final long serialVersionUID = -4838958141132600137L;

  @Column( name = BOOKING_REFERENCE_TYPE_DB_COLUMN_NAME )
  private String name;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = BOOKING_REFERENCE_TYPE_DB_COLUMN_PROJECT )
  private Project project;
  @Column( name = BOOKING_REFERENCE_TYPE_DB_COLUMN_PREFIX )
  private String prefix;
  @Column( name = BOOKING_REFERENCE_TYPE_DB_COLUMN_SUFFIX )
  private String suffix;
  @Column( name = BOOKING_REFERENCE_TYPE_DB_COLUMN_VALIDATION_PATTERN )
  private String validationPattern;
  @Column( name = BOOKING_REFERENCE_TYPE_DB_COLUMN_EXTERNAL_REFERENCE )
  private String externalReference;

  @Override
  public String getType()
  {
    return name;
  }

  @Override
  public void setType( String name )
  {
    this.name = name;
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
  public boolean hasPrefix()
  {
    return StringUtils.isNotBlank( prefix );
  }

  @Override
  public String getPrefix()
  {
    return prefix;
  }

  @Override
  public void setPrefix( String prefix )
  {
    this.prefix = prefix;
  }

  @Override
  public boolean hasSuffix()
  {
    return StringUtils.isNotBlank( suffix );
  }

  @Override
  public String getSuffix()
  {
    return suffix;
  }

  @Override
  public void setSuffix( String suffix )
  {
    this.suffix = suffix;
  }

  @Override
  public String getValidationPattern()
  {
    return validationPattern;
  }

  @Override
  public void setValidationPattern( String pattern )
  {
    validationPattern = pattern;
  }

  @Override
  public String getExternalReference()
  {
    return externalReference;
  }

  @Override
  public void setExternalReference( String reference )
  {
    externalReference = reference;
  }
}
