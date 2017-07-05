/*
 * Copyright (C) 2017 [haVox] Design
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
import net.havox.times.model.contacts.api.AbstractPersonTest;
import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.Person;

public class PersonApiTest extends AbstractPersonTest
{

  @Override
  public Person getNewInstance( LocalDate dateOfBirth )
  {
    Person person = new PersonImpl();
    person.setDateOfBirth( dateOfBirth );
    return person;
  }

  @Override
  public Person getNewInstanceWithNonInitializedDateOfBirth()
  {
    return getNewInstance( null );
  }

  @Override
  public Address getNewAddress() throws Exception
  {
    return new AddressImpl();
  }
}
