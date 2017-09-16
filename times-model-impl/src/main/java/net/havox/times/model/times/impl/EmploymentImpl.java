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

import java.time.LocalDate;
import java.util.Collection;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;
import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.times.api.Employment;
import net.havox.times.model.times.api.Project;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of an employment.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = EmploymentImpl.DB_TABLE_NAME )
public class EmploymentImpl extends AbstractChangeAwareClass<EmploymentImpl> implements Employment
{

  /**
   * The db table name.
   */
  public static final String DB_TABLE_NAME = "HAVOX_TIMES_EMPLOYMENT";

  private static final long serialVersionUID = 544489079880583555L;

  @Column( name = "start_date" )
  private transient LocalDate start;
  @Column( name = "end_date" )
  private transient LocalDate end;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn( name = "employee_id" )
  private Person employee;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn( name = "employer_id" )
  private Company employer;
  @ManyToOne(fetch=FetchType.LAZY)
  @JoinColumn( name = "project_id" )
  private final Collection<Project> projects = new CopyOnWriteArrayList<>();

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
  public Collection<Project> getProjects()
  {
    return this.projects;
  }

  @Override
  public String toString()
  {
    ToStringBuilder builder = new ToStringBuilder( this, ToStringStyle.SHORT_PREFIX_STYLE );

    builder.append( this.getId() );
    builder.append( this.getEmployee() );
    builder.append( this.getEmployer() );
    builder.append( this.getEmploymentMonths() );
    builder.append( this.getStart() );
    builder.append( this.getEnd() );
    builder.append( this.isActive() );
    builder.append( this.getProjects() );

    return builder.toString();
  }
}
