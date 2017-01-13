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
package net.havox.times.model.factory;

import net.havox.times.model.times.api.Employment;
import net.havox.times.model.times.api.Issue;
import net.havox.times.model.times.api.Project;
import net.havox.times.model.times.api.Task;
import net.havox.times.model.times.api.WorkUnit;
import net.havox.times.model.times.api.WorkUnitDuration;
import net.havox.times.model.times.impl.EmploymentImpl;
import net.havox.times.model.times.impl.IssueImpl;
import net.havox.times.model.times.impl.ProjectImpl;
import net.havox.times.model.times.impl.TaskImpl;
import net.havox.times.model.times.impl.WorkUnitDurationImpl;
import net.havox.times.model.times.impl.WorkUnitImpl;

/**
 * The times model factory.
 *
 * @author Christian Otto
 */
public class TimesModelFactory
{

  /**
   * The singleton model factory instance.
   */
  private static final TimesModelFactory INSTANCE = new TimesModelFactory();

  /**
   * The private default constructor.
   */
  private TimesModelFactory()
  {
    super();
  }

  /**
   * Returns the singleton model factory.
   *
   * @return the {@link TimesModelFactory} instance.
   */
  public static TimesModelFactory getInstance()
  {
    return TimesModelFactory.INSTANCE;
  }

  /**
   * Returns a new {@link Employment}.
   *
   * @return a new employment entity
   */
  public Employment getNewEmployment()
  {
    return new EmploymentImpl();
  }

  /**
   * Returns a new {@link Issue}.
   *
   * @return a new issue entity
   */
  public Issue getNewIssue()
  {
    return new IssueImpl();
  }

  /**
   * Returns a new {@link Project}.
   *
   * @return a new project entity
   */
  public Project getNewProject()
  {
    return new ProjectImpl();
  }

  /**
   * Returns a new {@link Task}.
   *
   * @return a new task entity
   */
  public Task getNewTask()
  {
    return new TaskImpl();
  }

  /**
   * Returns a new {@link WorkUnitDuration}.
   *
   * @return a new work unit duration entity
   */
  public WorkUnitDuration getNewWorkUnitDuration()
  {
    return new WorkUnitDurationImpl();
  }

  /**
   * Returns a new {@link WorkUnit}.
   *
   * @return a new work unit entity
   */
  public WorkUnit getNewWorkUnit()
  {
    return new WorkUnitImpl();
  }
}
