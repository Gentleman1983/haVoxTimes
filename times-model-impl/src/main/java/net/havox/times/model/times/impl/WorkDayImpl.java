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

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Set;
import java.util.concurrent.ConcurrentSkipListSet;
import javax.persistence.Entity;
import javax.persistence.Table;

import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.times.api.WorkDay;
import net.havox.times.model.times.api.WorkUnit;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Represents a work day.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = WorkDayImpl.DB_TABLE_NAME )
public class WorkDayImpl extends AbstractChangeAwareClass<WorkDayImpl> implements WorkDay
{

  /**
   * The db table name.
   */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_WORK_DAY";

  private static final long serialVersionUID = -1468588140684922531L;

  private transient LocalDate date;
  private transient LocalDateTime start;
  private transient LocalDateTime end;
  private final Set<WorkUnit> workUnits = new ConcurrentSkipListSet<>();

  @Override
  public LocalDate getDate()
  {
    return this.date;
  }

  @Override
  public void setDate( LocalDate date )
  {
    this.date = date;
  }

  @Override
  public Set<WorkUnit> getWorkUnits()
  {
    return this.workUnits;
  }

  @Override
  public LocalDateTime getStart()
  {
    return this.start;
  }

  @Override
  public void setStart( LocalDateTime start )
  {
    this.start = start;
  }

  @Override
  public LocalDateTime getEnd()
  {
    return this.end;
  }

  @Override
  public void setEnd( LocalDateTime end )
  {
    this.end = end;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE );

    builder.append( this.getId() );
    builder.append( this.getDate() );
    builder.append( this.getStart() );
    builder.append( this.getEnd() );
    builder.append( this.getWorkUnits() );

    return builder.toString();
  }
}
