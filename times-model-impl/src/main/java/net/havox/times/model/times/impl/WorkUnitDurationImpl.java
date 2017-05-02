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
import javax.persistence.Entity;
import javax.persistence.Table;

import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.times.api.WorkUnitDuration;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The implemantation of the work unit duration.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = WorkUnitDurationImpl.DB_TABLE_NAME )
public class WorkUnitDurationImpl extends AbstractChangeAwareClass<WorkUnitDurationImpl> implements WorkUnitDuration
{
  /** The db table name. */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_WORK_UNIT_DUR";

  private static final long serialVersionUID = 2700239318546499492L;

  private Duration duration;
  private LocalDateTime start;
  private LocalDateTime end;

  @Override
  public Duration getDuration()
  {
    return this.duration;
  }

  @Override
  public void setDuration( LocalDateTime start, LocalDateTime end )
  {
    if ( ( start == null ) || ( end == null ) )
    {
      String message = "Neigther the parameter 'start'=" + start + " nor the parameter 'end'=" + end + "is allowed to be NULL.";
      throw new IllegalArgumentException( message );
    }

    this.start = start;
    this.end = end;
    this.duration = Duration.between( start, end );
  }

  @Override
  public void setDuration( LocalDateTime start, Duration duration )
  {
    if ( ( start == null ) || ( duration == null ) )
    {
      String message = "Neigther the parameter 'start'=" + start + " nor the parameter 'duration'=" + duration + "is allowed to be NULL.";
      throw new IllegalArgumentException( message );
    }

    this.start = start;
    this.duration = duration;
    this.end = LocalDateTime.from( start ).plus( duration );
  }

  @Override
  public LocalDateTime getStart()
  {
    return this.start;
  }

  @Override
  public LocalDateTime getEnd()
  {
    return this.end;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE );

    builder.append( this.getId() );
    builder.append( this.getStart() );
    builder.append( this.getEnd() );
    builder.append( this.getDuration() );

    return builder.toString();
  }
}
