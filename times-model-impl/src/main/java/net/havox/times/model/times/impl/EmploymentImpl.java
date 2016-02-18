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
package net.havox.times.model.times.impl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;
import net.havox.times.model.times.api.Employment;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of an employment.
 * 
 * @author Christian Otto
 */
public class EmploymentImpl implements Employment {
    
    /**
     * The SerialVersionUID.
     */
    private static final long serialVersionUID = 544489079880583555L;

    /**
     * The id.
     */
    private Long id;

    /**
     * The version.
     */
    private long version;
    /**
     * The employment start.
     */
    private LocalDate start;
    /**
     * The employment end.
     */
    private LocalDate end;
    /**
     * The employee.
     */
    private Person employee;
    /**
     * The employer.
     */
    private Company employer;
    /**
     * The projects during the employment.
     */
    private Collection<Employment> projects = new ArrayList<>();

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getVersion() {
        return this.version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getStart() {
        return this.start;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStart(LocalDate start) {
        this.start = start;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getEnd() {
        return this.end;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnd(LocalDate end) {
        this.end = end;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Company getEmployer() {
        return this.employer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEmployer(Company employer) {
        this.employer = employer;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Person getEmployee() {
        return this.employee;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEmployee(Person employee) {
        this.employee = employee;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Employment> getProjects() {
        return this.projects;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hashCode;

        if (this.getId() == null) {
            hashCode = super.hashCode();
        } else {
            HashCodeBuilder builder = new HashCodeBuilder();

            builder.append(this.getId());

            hashCode = builder.toHashCode();
        }

        return hashCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Employment) {
            Employment employment = (Employment) obj;

            if (this.getId() == null) {
                return (this == employment);
            } else {
                EqualsBuilder builder = new EqualsBuilder();

                builder.append(this.getId(), employment.getId());

                return builder.isEquals();
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);

        builder.append(this.getId());
        builder.append(this.getEmployee());
        builder.append(this.getEmployer());
        builder.append(this.getDuration());
        builder.append(this.getStart());
        builder.append(this.getEnd());
        builder.append(this.isActive());
        builder.append(this.getProjects());

        return builder.toString();
    }
}
