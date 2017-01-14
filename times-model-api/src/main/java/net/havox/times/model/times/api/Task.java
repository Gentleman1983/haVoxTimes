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
package net.havox.times.model.times.api;

import java.io.Serializable;
import java.time.Duration;
import java.util.Collection;

import net.havox.times.model.api.ChangeAware;

/**
 * Defines a task. A task may contain subtasks, has a name and duration. The subtasks' sum of durations is not allowed
 * to exceed the duration of the main task.
 *
 * @author Christian Otto
 */
public interface Task extends ChangeAware, Serializable
{

  /**
   * Returns the task name.
   *
   * @return the name
   */
  String getName();

  /**
   * Sets the task name.
   *
   * @param name the name
   */
  void setName( String name );

  /**
   * Returns the task's duration.
   *
   * @return the duration
   */
  Duration getDuration();

  /**
   * Sets the task's duration.
   *
   * @param duration the duration
   */
  void setDuration( Duration duration );

  /**
   * Checks if the task has subtasks.
   *
   * @return true, if the task has subtasks
   */
  default boolean hasSubTasks()
  {
    return !this.getSubTasks().isEmpty();
  }

  /**
   * Returns the subtasks.
   *
   * @return the subtasks
   */
  Collection<Task> getSubTasks();
}
