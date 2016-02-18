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

import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.City;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of an address.
 *
 * @author Christian Otto
 */
public class AddressImpl implements Address {

    /**
     * The serialVersionUID.
     */
    private static final long serialVersionUID = -3857698669332938089L;

    /**
     * The id.
     */
    private Long id;
    /**
     * The version.
     */
    private long version;
    /**
     * The street name.
     */
    private String street;
    /**
     * The house number.
     */
    private String houseNumber;
    /**
     * The City.
     */
    private City city;

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
    public String getStreet() {
        return this.street;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getHouseNumber() {
        return this.houseNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setHouseNumber(String houseNumber) {
        this.houseNumber = houseNumber;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public City getCity() {
        return this.city;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setCity(City city) {
        this.city = city;
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
        if (obj instanceof Address) {
            Address address = (Address) obj;

            if (this.getId() == null) {
                return (this == address);
            } else {
                EqualsBuilder builder = new EqualsBuilder();

                builder.append(this.getId(), address.getId());

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
        builder.append(this.getStreet());
        builder.append(this.getHouseNumber());
        builder.append(this.getCity());

        return builder.toString();
    }
}
