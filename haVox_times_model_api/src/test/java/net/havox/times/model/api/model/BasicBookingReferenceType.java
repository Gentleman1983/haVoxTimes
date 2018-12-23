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

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import net.havox.times.model.api.booking.BookingReferenceType;
import net.havox.times.model.api.booking.Project;

/**
 * Basic implementation of {@link BookingReferenceType}.
 *
 * @author Christian Otto
 */
public class BasicBookingReferenceType extends AbstractChangeAwareAndIdentifiableClass implements BookingReferenceType
{

  private static final long serialVersionUID = 3472093861977283065L;

  private String name;
  private Project project;
  private String prefix;
  private String suffix;
  private String validationPattern;
  private String externalReference;

  public BasicBookingReferenceType()
  {
    super();

    this.prefix = "";
    this.suffix = "";
  }

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
    return !"".equals( prefix );
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
    return !"".equals( suffix );
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

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( "id", getId() );
    builder.append( "type", getType() );
    builder.append( "project", getProject() );
    builder.append( "prefix", getPrefix() );
    builder.append( "suffix", getSuffix() );
    builder.append( "validationPattern", getValidationPattern() );
    builder.append( "externalReference", getExternalReference() );
    builder.append( "version", getVersion() );

    return builder.build();
  }
}
