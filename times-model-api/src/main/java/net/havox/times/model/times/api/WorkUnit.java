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
import java.time.LocalDateTime;
import java.util.Set;

import net.havox.exceptions.GuruMeditationWarning;
import net.havox.times.model.api.ChangeAware;

/**
 * Defines a work unit (e.g. WORK slice, BREAK slice and another WORK slice).
 *
 * @author Christian Otto
 */
public interface WorkUnit extends ChangeAware, Serializable
{

  /**
   * Gets the type of the work unit.
   *
   * @return the {@link WorkUnitType}
   */
  WorkUnitType getType();

  /**
   * Sets the type of the work unit.
   *
   * @param type the {@link WorkUnitType}
   */
  void setType( WorkUnitType type );

  /**
   * Returns the work duration.
   *
   * @return the duration
   */
  default Duration getDuration()
  {
    Duration duration = Duration.ZERO;

    for ( Task task : this.getTasks() )
    {
      duration = duration.plus( task.getDuration() );
    }

    return duration;
  }

  /**
   * Gets a set of the tasks worked on.
   *
   * @return the tasks
   */
  Set<Task> getTasks();

  /**
   * Returns the duration of the work, defined either by the duration or the start and end time.
   *
   * @return the work duration
   *
   * @throws GuruMeditationWarning , if the workUnitStart of workUnitEnd is <code>null</code>.
   */
  Duration getWorkUnitDuration();

  /**
   * Sets the work duration using a start and end time.
   *
   * @param start the start time
   * @param end the end time
   *
   * @throws GuruMeditationWarning , if any of the parameters is <code>null</code>.
   */
  void setWorkUnitDuration( LocalDateTime start, LocalDateTime end );

  /**
   * Sets the work duration using a duration value.
   *
   * @param start the start time
   * @param duration the duration
   *
   * @throws GuruMeditationWarning , if any of the parameters is <code>null</code>.
   */
  void setWorkUnitDuration( LocalDateTime start, Duration duration );

  /**
   * Returns the start date.
   *
   * @return the start date
   */
  LocalDateTime getWorkUnitStart();

  /**
   * Returns the end date.
   *
   * @return the end date
   */
  LocalDateTime getWorkUnitEnd();
}
