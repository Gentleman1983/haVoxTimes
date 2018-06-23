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

import java.time.Duration;

import net.havox.times.model.times.api.AbstractWorkDayTest;
import net.havox.times.model.times.api.Task;
import net.havox.times.model.times.api.WorkDay;
import net.havox.times.model.times.api.WorkUnit;
import net.havox.times.model.times.api.WorkUnitType;

public class WorkDayApiTest extends AbstractWorkDayTest
{

  @Override
  public WorkDay newInstance() throws Exception
  {
    return new WorkDayImpl();
  }

  @Override
  public WorkUnit newWorkUnit() throws Exception
  {
    return new WorkUnitImpl();
  }

  @Override
  public WorkUnit newWorkUnit( WorkUnitType type, Duration duration ) throws Exception
  {
    Task task = new TaskImpl();
    task.setDuration( duration );

    WorkUnit instance = newWorkUnit();
    instance.setType( type );
    instance.getTasks().add( task );

    return instance;
  }

}
