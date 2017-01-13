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
package net.havox.times.model.factory;

import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.City;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Country;
import net.havox.times.model.contacts.api.Person;
import net.havox.times.model.contacts.impl.AddressImpl;
import net.havox.times.model.contacts.impl.CityImpl;
import net.havox.times.model.contacts.impl.CompanyImpl;
import net.havox.times.model.contacts.impl.CountryImpl;
import net.havox.times.model.contacts.impl.PersonImpl;

/**
 * The contacts model factory.
 *
 * @author Christian Otto
 */
public class ContactsModelFactory
{

  /**
   * The singleton model factory instance.
   */
  private static final ContactsModelFactory INSTANCE = new ContactsModelFactory();

  /**
   * The private default constructor.
   */
  private ContactsModelFactory()
  {
    super();
  }

  /**
   * Returns the singleton model factory.
   *
   * @return the {@link ContactsModelFactory} instance.
   */
  public static ContactsModelFactory getInstance()
  {
    return ContactsModelFactory.INSTANCE;
  }

  /**
   * Returns a new {@link Address}.
   *
   * @return a new address entity
   */
  public Address getNewAddress()
  {
    return new AddressImpl();
  }

  /**
   * Returns a new {@link City}.
   *
   * @return a new city entity
   */
  public City getNewCity()
  {
    return new CityImpl();
  }

  /**
   * Returns a new {@link Company}.
   *
   * @return a new company entity
   */
  public Company getNewCompany()
  {
    return new CompanyImpl();
  }

  /**
   * Returns a new {@link Country}.
   *
   * @return a new country entity
   */
  public Country getNewCountry()
  {
    return new CountryImpl();
  }

  /**
   * Returns a new {@link Person}.
   *
   * @return a new person entity
   */
  public Person getNewPerson()
  {
    return new PersonImpl();
  }
}
