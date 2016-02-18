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

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author Christian Otto
 */
public interface WorkDay {

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
     * Gets the date of the work day, e.g. 4th of March, 2013.
     *
     * @return the date
     */
    LocalDate getDate();

    /**
     * Sets the date of the work day date.
     *
     * @param date the date
     */
    void setDate(LocalDate date);

    /**
     * Returns a set of the work units of this day.
     *
     * @return the work units
     */
    Set<WorkUnit> getWorkUnits();

    /**
     * Adds a work unit to the work units.
     *
     * @param workUnit the work unit to add
     */
    default void addWorkUnit(WorkUnit workUnit) {
        this.getWorkUnits().add(workUnit);
    }

    /**
     * adds multiple work units to the work units.
     *
     * @param workUnits the work units to add
     */
    default void addWorkUnits(WorkUnit... workUnits) {
        this.getWorkUnits().addAll(Arrays.asList(workUnits));
    }

    /**
     * Removes a work unit from the work units.
     *
     * @param workUnit the work unit to be removed
     * @return the removed element or <code>null</code> if not contained in the
     * work units
     */
    default WorkUnit removeWorkUnit(WorkUnit workUnit) {
        boolean elementWasContained = this.getWorkUnits().remove(workUnit);

        return elementWasContained ? workUnit : null;
    }

    /**
     * Removes multiple work units from the work units.
     *
     * @param workUnits the work units to be removed
     * @return the removed elements or an empty set if no element was removed
     */
    default Set<WorkUnit> removeWorkUnits(WorkUnit... workUnits) {
        Set<WorkUnit> deletedElementSet = new HashSet<>();

        for (WorkUnit workUnit : workUnits) {
            WorkUnit deletedElement = this.removeWorkUnit(workUnit);

            if (deletedElement != null) {
                deletedElementSet.add(deletedElement);
            }
        }

        return deletedElementSet;
    }

    /**
     * Returns the duration of a given WorkUnitType (work, pause, vacation,
     * ...).
     *
     * @param type the WorkUnitType to calculate
     * @return the duration
     *
     * @throws NullPointerException , if the type parameter is not set
     */
    default Duration getDuration(WorkUnitType type) throws NullPointerException {
        if (type == null) {
            String message = "The WorkUnitType parameter type has to be set.";
            throw new NullPointerException(message);
        }
        Duration duration = Duration.ZERO;

        for (WorkUnit workUnit : this.getWorkUnits()) {
            if (type == workUnit.getType()) {
                duration = duration.plus(workUnit.getDuration().getWorkDuration());
            }
        }

        return duration;
    }

    /**
     * Returns the start of the work unit.
     *
     * @return the start
     */
    LocalDateTime getStart();

    /**
     * Sets the start of the work unit.
     *
     * @param start the start
     */
    void setStart(LocalDateTime start);

    /**
     * Returns the end of the work unit.
     *
     * @return the end
     */
    LocalDateTime getEnd();

    /**
     * Sets the end of the work unit.
     *
     * @param end the end
     */
    void setEnd(LocalDateTime end);
}
