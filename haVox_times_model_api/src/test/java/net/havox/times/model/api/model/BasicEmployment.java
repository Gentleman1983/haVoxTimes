/*
 * Copyright (C) 2018 [haVox] Design
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
package net.havox.times.model.api.model;

import java.time.LocalDate;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.booking.Project;
import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Employment;
import net.havox.times.model.api.company.Worker;

/**
 * Basic implementation of {@link Employment}.
 *
 * @author Christian Otto
 */
public class BasicEmployment extends AbstractChangeAwareAndIdentifiableClass implements Employment
{

  private static final long serialVersionUID = 6735202581677222968L;

  private Employer employer;
  private Worker employee;
  private LocalDate start;
  private LocalDate end;
  private final Set<Project> projects;

  public BasicEmployment()
  {
    super();

    projects = new HashSet<>();
  }

  @Override
  public Employer getEmployer()
  {
    return employer;
  }

  @Override
  public void setEmployer( Employer employer )
  {
    this.employer = employer;
  }

  @Override
  public Worker getEmployee()
  {
    return employee;
  }

  @Override
  public void setEmployee( Worker employee )
  {
    this.employee = employee;
  }

  @Override
  public LocalDate getStartDate()
  {
    return start;
  }

  @Override
  public void setStartDate( LocalDate start )
  {
    this.start = start == null ? LocalDate.MIN : start;
  }

  @Override
  public LocalDate getEndDate()
  {
    return end;
  }

  @Override
  public void setEndDate( LocalDate end )
  {
    this.end = end == null ? LocalDate.MAX : end;
  }

  @Override
  public Set<Project> getProjects()
  {
    return Collections.unmodifiableSet( projects );
  }

  @Override
  public CollectionMassModificationStatus<Project> addProjects( Project... projects )
  {
    CollectionMassModificationStatus<Project> status = new CollectionMassModificationStatus<>();

    for ( Project project : projects )
    {
      if ( this.projects.contains( project ) )
      {
        status.addUnsuccessfulElements( project );
      }
      else
      {
        this.projects.add( project );
        status.addSuccessfulElements( project );
      }
    }

    return status;
  }

  @Override
  public CollectionMassModificationStatus<Project> removeProjects( Project... projects )
  {
    CollectionMassModificationStatus<Project> status = new CollectionMassModificationStatus<>();

    for ( Project project : projects )
    {
      if ( this.projects.contains( project ) )
      {
        this.projects.remove( project );
        status.addSuccessfulElements( project );
      }
      else
      {
        status.addUnsuccessfulElements( project );
      }
    }

    return status;
  }
}
