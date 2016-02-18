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
package net.havox.times.model.contacts.impl;

import java.time.LocalDate;
import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.Person;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of a person.
 * 
 * @author Christian Otto
 */
public class PersonImpl implements Person {
    /**
     * The SerialVersionUID.
     */
    private static final long serialVersionUID = 5520806245947083462L;

    /**
     * The id.
     */
    private Long id;
    /**
     * The version.
     */
    private long version;
    /**
     * The first name.
     */
    private String firstName;
    /**
     * The middle initials.
     */
    private String middleInitials;
    /**
     * The last name.
     */
    private String lastName;
    /**
     * The address.
     */
    private Address address;
    /**
     * The date of birth.
     */
    private LocalDate dateOfBirth;

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
    public String getLastName() {
        return this.lastName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getMiddleInnitials() {
        return this.middleInitials;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setMiddleInnitials(String middleInnitials) {
        this.middleInitials = middleInnitials;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getFirstName() {
        return this.firstName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDate getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Address getAddress() {
        return this.address;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setAddress(Address address) {
        this.address = address;
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
        if (obj instanceof Person) {
            Person person = (Person) obj;

            if (this.getId() == null) {
                return (this == person);
            } else {
                EqualsBuilder builder = new EqualsBuilder();

                builder.append(this.getId(), person.getId());

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
        builder.append(this.getFirstName());
        builder.append(this.getMiddleInnitials());
        builder.append(this.getLastName());
        builder.append(this.getAddress());
        builder.append(this.getDateOfBirth());

        return builder.toString();
    }

}
