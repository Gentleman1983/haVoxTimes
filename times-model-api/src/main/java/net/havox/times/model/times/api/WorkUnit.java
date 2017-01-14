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
import java.util.Set;

import net.havox.times.model.api.ChangeAware;

/**
 * Defines a work unit (work day).
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
  WorkUnitDuration getDuration();

  /**
   * Gets a set of the tasks worked on.
   *
   * @return the tasks
   */
  Set<Task> getTasks();
}
