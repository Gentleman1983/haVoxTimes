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

import net.havox.times.model.api.booking.Project;
import net.havox.times.model.api.company.AbstractEmploymentTest;
import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Employment;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.factory.BookingModelFactory;
import net.havox.times.model.factory.CompanyModelFactory;
import org.junit.BeforeClass;

/**
 * API specific tests for {@link Employment}.
 * 
 * @author Christian Otto
 */
public class EmploymentApiTest extends AbstractEmploymentTest
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
  public Employment newInstance() throws Exception
  {
    return companyFactory.getNewEmployment();
  }

  @Override
  public Employer newEmployer() throws Exception
  {
    return companyFactory.getNewEmployer();
  }

  @Override
  public Worker newEmployee() throws Exception
  {
    return companyFactory.getNewWorker();
  }

  @Override
  public Project newProject() throws Exception
  {
    return bookingFactory.getNewProject();
  }
}
