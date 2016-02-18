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
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;
import java.time.Duration;
import java.time.LocalDate;
import java.time.Month;
import java.util.Collection;

/**
 * This interface represents an employment.
 *
 * @author Christian Otto
 */
public interface Project extends Serializable {

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
     * Gets the project name.
     *
     * @return the project name
     */
    String getName();

    /**
     * Sets the project name.
     *
     * @param name the project name
     */
    void setName(String name);

    /**
     * Calculates the duration of the employment.
     *
     * @return the duration
     */
    default Duration getDuration() {
        LocalDate start = this.getStart();
        LocalDate end = this.getEnd();

        if (end == null) {
            end = LocalDate.now();
        }

        return Duration.between(start, end);
    }

    default Duration getDuraration(Month month, int year, WorkUnitType type) throws NullPointerException, IllegalArgumentException {
        if (month == null) {
            throw new NullPointerException("The month has to be set.");
        } else if (type == null) {
            throw new NullPointerException("The work unit type has to be set.");
        }

        LocalDate monthStart = LocalDate.of(year, month, 1);
        LocalDate nextMonthStart = LocalDate.of(year, month.getValue() + 1, 1);

        if ((monthStart.compareTo(this.getEnd()) > 0)
                && // project end date before regarded month
                (nextMonthStart.compareTo(this.getStart()) <= 0)) { // project start adter regarded month
            throw new IllegalArgumentException("The seleceted month '" + month.toString() + " " + year + "' has to be within project range (" + this.getStart() + " till " + this.getEnd() + ").");
        }

        return null;
    }

    /**
     * Returns the employment start.
     *
     * @return the start
     */
    LocalDate getStart();

    /**
     * Sets the employment start.
     *
     * @param start the start
     */
    void setStart(LocalDate start);

    /**
     * Checks if the employment is active. This means either the end is in the
     * future or the end has not been defined.
     *
     * @return true, if the employment is active
     */
    default boolean isActive() {
        if (this.getStart() == null) {
            return false;
        }
        boolean isInTheFuture = this.getEnd().isAfter(LocalDate.now());
        return (this.getEnd() == null) || isInTheFuture;
    }

    /**
     * Checks if the employment has started. This means either the start is in
     * the past.
     *
     * @return true, if the employment has started
     */
    default boolean hasStarted() {
        return this.getStart().isBefore(LocalDate.now());
    }

    /**
     * Returns the employment end.
     *
     * @return the end
     */
    LocalDate getEnd();

    /**
     * Sets the employment end.
     *
     * @param end the end
     */
    void setEnd(LocalDate end);

    /**
     * Returns the employer.
     *
     * @return the employer
     */
    Company getEmployer();

    /**
     * Sets the employer.
     *
     * @param employer the employer
     */
    void setEmployer(Company employer);

    /**
     * Returns the employee.
     *
     * @return the employee
     */
    Person getEmployee();

    /**
     * Sets the employee.
     *
     * @param employee the employee
     */
    void setEmployee(Person employee);

    /**
     * Checks if this employment contains sub projects.
     *
     * @return true, if the employment contains sub projects
     * @throws IllegalStateException if the projects propery is not initialized
     */
    default boolean hasProjects() throws IllegalStateException {
        if (this.getProjects() == null) {
            throw new IllegalStateException("Projects property not yet initialized.");
        }

        return !this.getProjects().isEmpty();
    }

    /**
     * Returns the projects.
     *
     * @return the projects
     */
    Collection<Project> getProjects();
}
