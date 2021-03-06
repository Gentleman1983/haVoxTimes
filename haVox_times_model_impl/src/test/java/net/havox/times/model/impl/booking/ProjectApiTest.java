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
package net.havox.times.model.impl.booking;

import org.junit.BeforeClass;

import net.havox.times.model.api.booking.AbstractProjectTest;
import net.havox.times.model.api.booking.Account;
import net.havox.times.model.api.booking.Project;
import net.havox.times.model.api.company.Employment;
import net.havox.times.model.factory.BookingModelFactory;
import net.havox.times.model.factory.CompanyModelFactory;

/**
 * API specific tests for {@link Project}.
 *
 * @author Christian Otto
 */
public class ProjectApiTest extends AbstractProjectTest
{

  private static BookingModelFactory bookingFactory;
  private static CompanyModelFactory companyFactory;

  @BeforeClass
  public static void setupClass()
  {
    bookingFactory = BookingModelFactory.getInstance();
    companyFactory = CompanyModelFactory.getInstance();
  }

  @Override
  public Project newInstance() throws Exception
  {
    return bookingFactory.getNewProject();
  }

  @Override
  public Employment newEmployment() throws Exception
  {
    return companyFactory.getNewEmployment();
  }

  @Override
  public Account newAccount() throws Exception
  {
    return bookingFactory.getNewAccount();
  }
}
