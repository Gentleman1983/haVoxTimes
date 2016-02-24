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
import java.util.ArrayList;
import java.util.Collection;
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
public class TaskImpl implements Task
{

  /**
   * The SerialVersionUID.
   */
  private static final long serialVersionUID = 8471130167805360250L;

  /**
   * The id.
   */
  private Long id;
  /**
   * The version.
   */
  private long version;
  /**
   * The task name.
   */
  private String name;
  /**
   * The task duration.
   */
  private Duration duration;
  /**
   * The sub tasks.
   */
  Collection<Task> subTasks = new ArrayList<>();

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
  public String getName()
  {
    return this.name;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setName( String name )
  {
    this.name = name;
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
  public void setDuration( Duration duration )
  {
    this.duration = duration;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Task> getSubTasks()
  {
    return this.subTasks;
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

  /**
   * {@inheritDoc}
   */
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
