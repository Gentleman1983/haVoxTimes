/*
 * Copyright (C) 2015 [haVox] Design
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
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.times.api.Task;
import net.havox.times.model.times.api.WorkUnit;
import net.havox.times.model.times.api.WorkUnitType;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * This is the implementation of a work unit.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = WorkUnitImpl.DB_TABLE_NAME )
public class WorkUnitImpl extends AbstractChangeAwareClass<WorkUnitImpl> implements WorkUnit
{
  /**
   * The db table name.
   */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_WORK_UNIT";
          
  private static final long serialVersionUID = 944542180473045373L;

  private LocalDateTime workUnitStart;
  private LocalDateTime workUnitEnd;
  private WorkUnitType type;
  private final Set<Task> tasks = new ConcurrentSkipListSet<>();

  @Override
  public WorkUnitType getType()
  {
    return this.type;
  }

  @Override
  public void setType( WorkUnitType type )
  {
    this.type = type;
  }
  
  @Override
  public Duration getWorkUnitDuration()
  {
    if ( ( this.workUnitStart == null ) || ( this.workUnitEnd == null ) )
    {
      String message = "Neigther the 'start'=" + this.workUnitStart + " nor the 'end'=" + this.workUnitEnd + " parameter is allowed to be NULL.";
      throw new IllegalStateException( message );
    }
    
    return Duration.between(this.workUnitStart, this.workUnitEnd );
  }

  @Override
  public void setWorkUnitDuration( LocalDateTime start, LocalDateTime end )
  {
    if ( ( start == null ) || ( end == null ) )
    {
      String message = "Neigther the parameter 'start'=" + start + " nor the parameter 'end'=" + end + "is allowed to be NULL.";
      throw new IllegalArgumentException( message );
    }

    this.workUnitStart = start;
    this.workUnitEnd = end;
  }

  @Override
  public void setWorkUnitDuration( LocalDateTime start, Duration duration )
  {
    if ( ( start == null ) || ( duration == null ) )
    {
      String message = "Neigther the parameter 'start'=" + start + " nor the parameter 'duration'=" + duration + "is allowed to be NULL.";
      throw new IllegalArgumentException( message );
    }

    this.workUnitStart = start;
    this.workUnitEnd = LocalDateTime.from( start ).plus( duration );
  }

  @Override
  public LocalDateTime getWorkUnitStart()
  {
    return this.workUnitStart;
  }

  @Override
  public LocalDateTime getWorkUnitEnd()
  {
    return this.workUnitEnd;
  }

  @Override
  public Set<Task> getTasks()
  {
    return this.tasks;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE );

    builder.append( this.getId() );
    builder.append( this.getType() );
    builder.append( this.getDuration() );
    builder.append( this.getWorkUnitDuration() );
    builder.append( this.getWorkUnitStart() );
    builder.append( this.getWorkUnitEnd() );
    builder.append( this.getTasks() );

    return builder.toString();
  }
}
