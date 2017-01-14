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
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.times.api.Task;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of a task.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = TaskImpl.DB_TABLE_NAME )
public class TaskImpl extends AbstractChangeAwareClass implements Task
{
  /** The db table name. */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_TASK";

  private static final long serialVersionUID = 8471130167805360250L;
  private Long id;
  private long version;
  private String name;
  private Duration duration;
  private final Collection<Task> subTasks = new CopyOnWriteArrayList<>();

  @Override
  public String getName()
  {
    return this.name;
  }

  @Override
  public void setName( String name )
  {
    this.name = name;
  }

  @Override
  public Duration getDuration()
  {
    return this.duration;
  }

  @Override
  public void setDuration( Duration duration )
  {
    this.duration = duration;
  }

  @Override
  public Collection<Task> getSubTasks()
  {
    return this.subTasks;
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
      Task task = ( TaskImpl ) obj;

      if ( this.getId() == null )
      {
        return ( this == task );
      }
      else
      {
        EqualsBuilder builder = new EqualsBuilder();

        builder.append( this.getId(), task.getId() );

        return builder.isEquals();
      }
    }

    return false;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( this.getId() );
    builder.append( this.getName() );
    builder.append( this.getDuration() );
    builder.append( this.getSubTasks() );

    return builder.toString();
  }
}
