
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
import java.time.LocalDate;
import java.util.Arrays;

import net.havox.times.model.times.api.AbstractEmploymentTest;
import net.havox.times.model.times.api.Employment;
import net.havox.times.model.times.api.Project;

public class EmploymentApiTest extends AbstractEmploymentTest
{

  @Override
  public Project getNewProject()
  {
    return new ProjectImpl();
  }

  @Override
  public Employment getNewInstanceWithUninitializedProjects() throws Exception
  {
    EmploymentImpl instance = new EmploymentImpl();

    Field idField = instance.getClass().getDeclaredField( "projects" );
    idField.setAccessible( true );
    idField.set( instance, null );

    return instance;
  }

  @Override
  public Employment getNewInstance( Project... projects )
  {
    Employment instance = new EmploymentImpl();
    instance.getProjects().addAll( Arrays.asList( projects ) );
    return instance;
  }

  @Override
  public Employment getNewInstance( LocalDate start, LocalDate end )
  {
    Employment instance = new EmploymentImpl();
    instance.setStart( start );
    instance.setEnd( end );
    return instance;
  }
}
