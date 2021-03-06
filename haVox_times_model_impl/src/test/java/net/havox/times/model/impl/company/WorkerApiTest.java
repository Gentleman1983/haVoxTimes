/*
 * Copyright (C) 2018 [haVox] Design
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
package net.havox.times.model.impl.company;

import org.junit.BeforeClass;

import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.company.AbstractWorkerTest;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.api.contact.ContactOption;
import net.havox.times.model.factory.AddressModelFactory;
import net.havox.times.model.factory.CompanyModelFactory;
import net.havox.times.model.factory.ContactModelFactory;

/**
 * API specific tests for {@link Worker}.
 *
 * @author Christian Otto
 */
public class WorkerApiTest extends AbstractWorkerTest
{

  private static AddressModelFactory addressFactory;
  private static CompanyModelFactory companyFactory;
  private static ContactModelFactory contactFactory;

  @BeforeClass
  public static void setupClass()
  {
    addressFactory = AddressModelFactory.getInstance();
    companyFactory = CompanyModelFactory.getInstance();
    contactFactory = ContactModelFactory.getInstance();
  }

  @Override
  public Worker newInstance() throws Exception
  {
    return companyFactory.getNewWorker();
  }

  @Override
  public Address newAddress() throws Exception
  {
    return addressFactory.getNewAddress();
  }

  @Override
  public ContactOption newContactOption() throws Exception
  {
    return contactFactory.getNewContactOption();
  }
}
