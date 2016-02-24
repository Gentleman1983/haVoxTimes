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

/**
 * This represents the duration type, needed especially for managing the input.
 * 
 * @author Christian Otto
 */
public enum WorkUnitDurationType
{
  /**
   * The Duration Type. This means the work unit is defined by its beginning and duration.
   */
  DURATION,
  /**
   * The Start/End Type. This means the work unit is defined by its start end end time.
   */
  STARTEND;
}
