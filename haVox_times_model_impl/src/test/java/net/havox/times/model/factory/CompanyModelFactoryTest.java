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
package net.havox.times.model.factory;

import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Employment;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.impl.company.EmployerImpl;
import net.havox.times.model.impl.company.EmploymentImpl;
import net.havox.times.model.impl.company.WorkerImpl;
import static org.hamcrest.Matchers.instanceOf;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;
import static org.junit.Assert.assertThat;
import org.junit.BeforeClass;
import org.junit.Test;

/**
 * Factory test of {@link CompanyModelFactory}.
 * 
 * @author Christian Otto
 */
public class CompanyModelFactoryTest
{
  private static CompanyModelFactory factory;

  @BeforeClass
  public static void setupClass()
  {
    factory = CompanyModelFactory.getInstance();
  }

  @Test
  public void testGetInstance()
  {
    Object instanceUnderTest = CompanyModelFactory.getInstance();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( CompanyModelFactory.class ) ) );
  }

  @Test
  public void testGetNewEmployer()
  {
    Employer instanceUnderTest = factory.getNewEmployer();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( EmployerImpl.class ) ) );
  }

  @Test
  public void testGetNewEmployment()
  {
    Employment instanceUnderTest = factory.getNewEmployment();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( EmploymentImpl.class ) ) );
  }

  @Test
  public void testGetNewWorker()
  {
    Worker instanceUnderTest = factory.getNewWorker();

    // Is the instance initialized?
    assertThat( instanceUnderTest, is( notNullValue() ) );

    // Is the instance of the correct type?
    assertThat( instanceUnderTest, is( instanceOf( WorkerImpl.class ) ) );
  }
}
