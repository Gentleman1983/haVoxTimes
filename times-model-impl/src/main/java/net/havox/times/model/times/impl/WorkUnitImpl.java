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

import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.times.api.Task;
import net.havox.times.model.times.api.WorkUnit;
import net.havox.times.model.times.api.WorkUnitDuration;
import net.havox.times.model.times.api.WorkUnitType;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * This is the implementation of a work unit.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = WorkUnitImpl.DB_TABLE_NAME )
public class WorkUnitImpl extends AbstractChangeAwareClass implements WorkUnit
{
  /**
   * The db table name.
   */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_WORK_UNIT";
          
  private static final long serialVersionUID = 944542180473045373L;

  private WorkUnitType type;
  private WorkUnitDuration duration;
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
  public WorkUnitDuration getDuration()
  {
    return this.duration;
  }

  @Override
  public Set<Task> getTasks()
  {
    return this.tasks;
  }

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

  @Override
  public boolean equals( Object obj )
  {
    if ( this == obj )
    {
      return true;
    }
    else if ( obj == null )
    {
      return false;
    }
    else if ( this.getClass() == obj.getClass() )
    {
      WorkUnit workUnit = ( WorkUnitImpl ) obj;

      if ( this.getId() == null )
      {
        return ( this == workUnit );
      }
      else
      {
        EqualsBuilder builder = new EqualsBuilder();

        builder.append( this.getId(), workUnit.getId() );

        return builder.isEquals();
      }
    }

    return false;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE );

    builder.append( this.getId() );
    builder.append( this.getType() );
    builder.append( this.getDuration() );
    builder.append( this.getTasks() );

    return builder.toString();
  }
}
