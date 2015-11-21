/*
 * Copyright (C) 2015 haVox Design
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
package net.havox.times.model.api;

import java.time.Duration;
import java.time.LocalDateTime;

/**
 *
 * @author Christian Otto
 */
public interface WorkUnitDuration {

    /**
     * Returns the duration of the work, defined either by the duration or the
     * start and end time.
     *
     * @return the work duration
     */
    Duration getWorkDuration();

    /**
     * Sets the work duration using a start and end time.
     *
     * @param start the start time
     * @param end the end time
     *
     * @throws NullPointerException , if any of the parameters is
     * <code>null</code>.
     */
    void setWorkDuration(LocalDateTime start, LocalDateTime end) throws NullPointerException;

    /**
     * Sets the work duration using a duration value.
     *
     * @param duration the duration
     *
     * @throws NullPointerException , if the duration is <code>null</code>.
     */
    void setWorkDuration(Duration duration) throws NullPointerException;

    /**
     * Returns the duration.
     *
     * @return the duration.
     */
    Duration getDuration();

    /**
     * Returns the start date.
     *
     * @return the start date
     */
    LocalDateTime getStart();

    /**
     * Returns the end date.
     *
     * @return the end date
     */
    LocalDateTime getEnd();
}
