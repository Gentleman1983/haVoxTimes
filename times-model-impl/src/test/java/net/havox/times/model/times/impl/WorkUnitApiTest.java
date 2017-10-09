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
import java.time.LocalDateTime;

import net.havox.times.model.times.api.AbstractWorkUnitTest;
import net.havox.times.model.times.api.Task;
import net.havox.times.model.times.api.WorkUnit;

public class WorkUnitApiTest extends AbstractWorkUnitTest
{

  @Override
  public WorkUnit newInstance() throws Exception
  {
    return new WorkUnitImpl();
  }

  @Override
  public WorkUnit newInstance( LocalDateTime start, LocalDateTime end ) throws Exception
  {
    WorkUnit instance = newInstance();

    Field startField = instance.getClass().getDeclaredField( "workUnitStart" );
    startField.setAccessible( true );
    startField.set( instance, start );

    Field endField = instance.getClass().getDeclaredField( "workUnitEnd" );
    endField.setAccessible( true );
    endField.set( instance, end );

    return instance;
  }

  @Override
  public Task newTask( Duration duration ) throws Exception
  {
    Task instance = new TaskImpl();

    instance.setDuration( duration );

    return instance;
  }

}
