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

import java.util.HashSet;
import java.util.Set;
import net.havox.times.model.times.api.Task;
import net.havox.times.model.times.api.WorkUnit;
import net.havox.times.model.times.api.WorkUnitDuration;
import net.havox.times.model.times.api.WorkUnitType;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Christian Otto
 */
public class WorkUnitImpl implements WorkUnit
{

  /**
   * The SerialVersionUID.
   */
  private static final long serialVersionUID = 944542180473045373L;

  /**
   * The id.
   */
  private Long id;

  /**
   * The version.
   */
  private long version;

  /**
   * The type of work unit.
   */
  private WorkUnitType type;

  /**
   * The work duration.
   */
  private WorkUnitDuration duration;

  /**
   * The accomplished tasks during this work unit.
   */
  private Set<Task> tasks = new HashSet<>();

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
  public WorkUnitType getType()
  {
    return this.type;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setType( WorkUnitType type )
  {
    this.type = type;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public WorkUnitDuration getDuration()
  {
    return this.duration;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Set<Task> getTasks()
  {
    return this.tasks;
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
    if ( obj instanceof WorkUnit )
    {
      WorkUnit workUnit = ( WorkUnit ) obj;

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

  /**
   * {@inheritDoc}
   */
  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE );

    builder.append( this.id );
    builder.append( this.type );
    builder.append( this.duration );
    builder.append( this.tasks );

    return builder.toString();
  }
}
