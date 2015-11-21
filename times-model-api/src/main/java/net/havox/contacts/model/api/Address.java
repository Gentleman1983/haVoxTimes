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
package net.havox.contacts.model.api;

import java.io.Serializable;

/**
 * This interface represents an address.
 *
 * @author Christian Otto
 */
public interface Address extends Serializable {

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
     * Gets the street name.
     *
     * @return the street name
     */
    String getStreet();

    /**
     * Sets the street name.
     *
     * @param street the street name
     */
    void setStreet(String street);

    /**
     * Gets the house number.
     *
     * @return the house number
     */
    String getHouseNumber();

    /**
     * Sets the house number.
     *
     * @param houseNumber the house number
     */
    void setHouseNumber(String houseNumber);

    /**
     * Gets the city.
     *
     * @return the city
     */
    City getCity();

    /**
     * Sets the city.
     *
     * @param city the cityS
     */
    void setCity(City city);
}
