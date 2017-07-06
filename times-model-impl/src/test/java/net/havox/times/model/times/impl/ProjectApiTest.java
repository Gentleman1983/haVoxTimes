/*
 * Copyright (C) 2017 [haVox] Design
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

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;
import net.havox.times.model.contacts.impl.CompanyImpl;
import net.havox.times.model.contacts.impl.PersonImpl;
import net.havox.times.model.times.api.AbstractProjectTest;
import net.havox.times.model.times.api.Project;
import net.havox.times.model.times.api.Task;
import net.havox.times.model.times.api.WorkDay;
import net.havox.times.model.times.api.WorkUnit;
import net.havox.times.model.times.api.WorkUnitType;

public class ProjectApiTest extends AbstractProjectTest
{

  @Override
  public Project newInstance() throws Exception
  {
    return new ProjectImpl();
  }

  @Override
  public Project newInstanceWithoutInitializedSubprojects() throws Exception
  {
    Project instance = new ProjectImpl();

    Field subprojectsField = instance.getClass().getDeclaredField( "subprojects" );
    subprojectsField.setAccessible( true );
    subprojectsField.set( instance, null );

    return instance;
  }

  @Override
  public Company newCompany() throws Exception
  {
    return new CompanyImpl();
  }

  @Override
  public Person newPerson() throws Exception
  {
    return new PersonImpl();
  }

  @Override
  public WorkDay newWorkday( LocalDate workDate ) throws Exception
  {
    WorkDay instance = new WorkDayImpl();
    instance.setDate( workDate );

    return instance;
  }

  @Override
  public WorkDay newWorkday( LocalDate workDate, WorkUnitType type, Duration duration ) throws Exception
  {
    Task task = new TaskImpl();
    task.setDuration( duration );

    WorkUnit workUnit = new WorkUnitImpl();
    workUnit.getTasks().add( task );
    workUnit.setType( type );
    workUnit.setWorkUnitDuration( LocalDateTime.of( workDate, LocalTime.MIN ), duration );

    WorkDay instance = newWorkday( workDate );
    instance.addWorkUnit( workUnit );
    instance.setStart( LocalDateTime.of( workDate, LocalTime.MIN ) );
    instance.setEnd( LocalDateTime.of( workDate, LocalTime.MAX ) );

    return instance;
  }

}
