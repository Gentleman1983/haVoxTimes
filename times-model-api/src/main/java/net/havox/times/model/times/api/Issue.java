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
import java.util.Collection;

/**
 * This describes an work issue. An issue consists of one or more
 * {@link Task tasks}.
 *
 * @author Christian Otto
 */
public interface Issue extends Serializable {

    /**
     * Gets the id.
     *
     * @return the id
     */
    Long getId();

    /**
     * Gets the version.
     *
     * @return the version
     */
    long getVersion();

    /**
     * Returns the description.
     *
     * @return the description
     */
    String getDescription();

    /**
     * Sets the description.
     *
     * @param description the description
     */
    void setDescription(String description);

    /**
     * Returns the tasks.
     *
     * @return the tasks
     */
    Collection<Task> getTasks();

    /**
     * Returns the issue start.
     *
     * @return the start
     */
    LocalDateTime getStart();

    /**
     * Sets the issue start.
     *
     * @param start the start
     */
    void setStart(LocalDateTime start);

    /**
     * Gets the issue end.
     *
     * @return the end
     */
    LocalDateTime getEnd();

    /**
     * Sets the issue end.
     *
     * @param end the end
     */
    void setEnd(LocalDateTime end);

    /**
     * Returns the duration of the issue (the sum of durations of the
     * {@link Task task's} durations.
     *
     * @return the duration
     */
    default Duration getDuration() {
        Duration duration = Duration.ZERO;

        for (Task task : this.getTasks()) {
            duration = duration.plus(task.getDuration());
        }

        return duration;
    }
}
