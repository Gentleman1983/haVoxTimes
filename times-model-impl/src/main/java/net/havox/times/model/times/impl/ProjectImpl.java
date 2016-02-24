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
import java.util.HashSet;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;
import net.havox.times.model.times.api.Project;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Christian Otto
 */
public class ProjectImpl implements Project
{
  /**
   * The SerialVersionUID.
   */
  private static final long serialVersionUID = -537340800679521572L;

  /**
   * The id.
   */
  private Long id;
  /**
   * The version.
   */
  private long version;
  /**
   * The name of the project.
   */
  private String name;
  /**
   * The start date of the project.
   */
  private LocalDate start;
  /**
   * The end date of the project.
   */
  private LocalDate end;
  /**
   * The employing company.
   */
  private Company employer;
  /**
   * The employee.
   */
  private Person employee;
  /**
   * The sub projects.
   */
  private Collection<Project> subprojects = new HashSet<>();

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
  public LocalDate getStart()
  {
    return this.start;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setStart( LocalDate start )
  {
    this.start = start;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public LocalDate getEnd()
  {
    return this.end;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEnd( LocalDate end )
  {
    this.end = end;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Company getEmployer()
  {
    return this.employer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEmployer( Company employer )
  {
    this.employer = employer;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Person getEmployee()
  {
    return this.employee;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public void setEmployee( Person employee )
  {
    this.employee = employee;
  }

  /**
   * {@inheritDoc}
   */
  @Override
  public Collection<Project> getSubprojects()
  {
    return this.subprojects;
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
    if ( this == obj ) {
      return true;
    }
    else if ( obj == null ) {
      return false;
    }
    else if ( this.getClass() == obj.getClass() )
    {
      Project project = ( ProjectImpl ) obj;

      if ( this.getId() == null )
      {
        return ( this == project );
      }
      else
      {
        EqualsBuilder builder = new EqualsBuilder();

        builder.append(this.getId(), project.getId() );

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

    builder.append( this.getId() );

    return builder.toString();
  }
}
