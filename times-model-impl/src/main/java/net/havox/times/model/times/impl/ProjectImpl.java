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
import java.util.Collection;
import java.util.concurrent.ConcurrentSkipListSet;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;
import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.times.api.Project;
import net.havox.times.model.times.api.WorkDay;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Christian Otto
 */
@Entity
@Table( name = ProjectImpl.DB_TABLE_NAME )
public class ProjectImpl extends AbstractChangeAwareClass<ProjectImpl> implements Project
{

  /**
   * The db table name.
   */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_PROJECT";

  private static final long serialVersionUID = -537340800679521572L;

  @Column( name = "name" )
  private String name;
  @Column( name = "start_date" )
  private transient LocalDate start;
  @Column( name = "end_date" )
  private transient LocalDate end;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn( name = "employer_id" )
  private Company employer;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn( name = "employee_id" )
  private Person employee;
  @OneToMany
  @JoinColumn( name = "head_project_id", referencedColumnName = "id" )
  private final Collection<Project> subprojects = new ConcurrentSkipListSet<>();
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn( name = "work_day_id" )
  private final Collection<WorkDay> workDays = new ConcurrentSkipListSet<>();

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
  public LocalDate getStart()
  {
    return this.start;
  }

  @Override
  public void setStart( LocalDate start )
  {
    this.start = start;
  }

  @Override
  public LocalDate getEnd()
  {
    return this.end;
  }

  @Override
  public void setEnd( LocalDate end )
  {
    this.end = end;
  }

  @Override
  public Company getEmployer()
  {
    return this.employer;
  }

  @Override
  public void setEmployer( Company employer )
  {
    this.employer = employer;
  }

  @Override
  public Person getEmployee()
  {
    return this.employee;
  }

  @Override
  public void setEmployee( Person employee )
  {
    this.employee = employee;
  }

  @Override
  public Collection<Project> getSubprojects()
  {
    return this.subprojects;
  }

  @Override
  public Collection<WorkDay> getWorkDays()
  {
    return this.workDays;
  }

  @Override
  public int hashCode()
  {
    return super.hashCode();
  }

  @Override
  public boolean equals( Object object )
  {
    return super.equals( object );
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.MULTI_LINE_STYLE );

    builder.append( this.getId() );

    return builder.toString();
  }
}
