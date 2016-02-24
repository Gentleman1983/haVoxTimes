/*
 * Copyright (C) 2016 [haVox] Design
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
package net.havox.times.model.times.impl;

import java.time.Duration;
import java.time.LocalDateTime;
import net.havox.times.model.times.api.WorkUnitDuration;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The implemantation of the work unit duration.
 *
 * @author Christian Otto
 */
public class WorkUnitDurationImpl implements WorkUnitDuration
{

  /**
   * The SerialVersionUID.
   */
  private static final long serialVersionUID = 2700239318546499492L;

  /**
   * The id.
   */
  private Long id;

  /**
   * The version.
   */
  private long version;

  /**
   * The duration.
   */
  private Duration duration;

  /**
   * The start time.
   */
  private LocalDateTime start;

  /**
   * The end time.
   */
  private LocalDateTime end;

  /**
   * {@inheritDoc}
   */
  @Override
  public Long getId()
  {
    return this.id;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public long getVersion()
  {
    return this.version;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Duration getDuration()
  {
    return this.duration;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDuration( LocalDateTime start, LocalDateTime end ) throws NullPointerException
  {
    if ( ( start == null ) || ( end == null ) )
    {
      String message = "Neigther the parameter 'start'=" + start + " nor the parameter 'end'=" + end + "is allowed to be NULL.";
      throw new NullPointerException( message );
    }

    this.start = start;
    this.end = end;
    this.duration = Duration.between( start, end );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setDuration( LocalDateTime start, Duration duration ) throws NullPointerException
  {
    if ( ( start == null ) || ( duration == null ) )
    {
      String message = "Neigther the parameter 'start'=" + start + " nor the parameter 'duration'=" + duration + "is allowed to be NULL.";
      throw new NullPointerException( message );
    }

    this.start = start;
    this.duration = duration;
    this.end = LocalDateTime.from( start ).plus( duration );
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getStart()
  {
    return this.start;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDateTime getEnd()
  {
    return this.end;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public int hashCode()
  {
    int hashCode;

    if ( this.getId() == null )
    {
      hashCode = super.hashCode();
    }
    else
    {
      HashCodeBuilder builder = new HashCodeBuilder();

      builder.append( this.getId() );

      hashCode = builder.toHashCode();
    }

    return hashCode;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public boolean equals( Object obj )
  {
    if ( this.getClass() == obj.getClass() )
    {
      WorkUnitDuration workUnitDuration = ( WorkUnitDurationImpl ) obj;

      if ( this.getId() == null )
      {
        return ( this == workUnitDuration );
      }
      else
      {
        EqualsBuilder builder = new EqualsBuilder();

        builder.append( this.getId(), workUnitDuration.getId() );

        return builder.isEquals();
      }
    }

    return false;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE );

    builder.append( this.id );
    builder.append( this.start );
    builder.append( this.end );
    builder.append( this.duration );

    return builder.toString();
  }
}
