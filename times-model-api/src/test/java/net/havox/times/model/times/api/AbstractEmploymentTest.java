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
package net.havox.times.model.times.api;

import java.time.LocalDate;
import java.time.Month;
import java.time.Period;
import net.havox.test.utils.junit.ExtendedRunner;
import net.havox.test.utils.random.ModelRandomGenerator;
import net.havox.test.utils.junit.Repeat;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;

import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractEmploymentTest
{

  public abstract Project getNewProject() throws Exception;

  public abstract Employment getNewInstanceWithUninitializedProjects() throws Exception;

  public abstract Employment getNewInstance( Project... projects ) throws Exception;

  public abstract Employment getNewInstance( LocalDate start, LocalDate end ) throws Exception;

  public abstract Company getNewCompany() throws Exception;

  public abstract Person getNewPerson() throws Exception;
  
  @Test( expected = IllegalStateException.class )
  public void testGetEmploymentMonthsStartNotSet() throws Exception
  {
    Employment instanceUnderTest = getNewInstance( null, LocalDate.MAX );
    
    try {
      instanceUnderTest.getEmploymentMonths();
      
      fail( "This should never be reached!" );
    }
    catch( IllegalStateException ise ) {
      assertEquals( "The start date of the employment has to be set.", ise.getMessage() );
      throw ise;
    }
  }

  @Test
  public void testGetEmploymentMonthsStartEnd() throws Exception
  {
    Employment employmentOneYear = getNewInstance( LocalDate.of( 2017, Month.JANUARY, 1 ), LocalDate.of( 2017, Month.DECEMBER, 31 ) );
    Employment employmentTwoYears = getNewInstance( LocalDate.of( 2017, Month.JANUARY, 1 ), LocalDate.of( 2018, Month.DECEMBER, 31 ) );
    Employment employmentSingleDay = getNewInstance( LocalDate.of( 2017, Month.JANUARY, 1 ), LocalDate.of( 2017, Month.JANUARY, 1 ) );

    assertEquals( 12l, employmentOneYear.getEmploymentMonths() );
    assertEquals( 24l, employmentTwoYears.getEmploymentMonths() );
    assertEquals( 0l, employmentSingleDay.getEmploymentMonths() );
  }

  @Test
  public void testGetEmploymentMonthsStartNow() throws Exception
  {
    Employment employmentToday = getNewInstance( LocalDate.now(), null );
    LocalDate startDateEmploymentOneMonth = LocalDate.now().minus( Period.ofMonths( 1 ) );
    Employment employmentOneMonth = getNewInstance( startDateEmploymentOneMonth, null );

    assertEquals( 0l, employmentToday.getEmploymentMonths() );
    assertEquals( 1l, employmentOneMonth.getEmploymentMonths() );
  }

  @Test
  public void testIsActive() throws Exception
  {
    Employment employmentUntillToday = getNewInstance( LocalDate.now().minus( Period.ofYears( 1 ) ), LocalDate.now() );
    Employment employmentUntillTomorrow = getNewInstance( LocalDate.now().minus( Period.ofYears( 1 ) ), LocalDate.now().plus( Period.ofDays( 1 ) ) );
    Employment employmentUntillYeaterday = getNewInstance( LocalDate.now().minus( Period.ofYears( 1 ) ), LocalDate.now().minus( Period.ofDays( 1 ) ) );
    Employment employmentOpenEnd = getNewInstance( LocalDate.now().minus( Period.ofYears( 1 ) ), null );

    assertFalse( employmentUntillYeaterday.isActive() );
    assertTrue( employmentUntillToday.isActive() );
    assertTrue( employmentUntillTomorrow.isActive() );
    assertTrue( employmentOpenEnd.isActive() );
  }

  @Test
  public void testHasProjects() throws Exception
  {
    Employment employmentWithOutProjects = getNewInstance();
    Project project = getNewProject();
    Employment employmentWithProject = getNewInstance( project );

    assertFalse( employmentWithOutProjects.hasProjects() );
    assertTrue( employmentWithProject.hasProjects() );
  }

  @Test( expected = IllegalStateException.class )
  public void testHasProjectsNotInitialized() throws Exception
  {
    Employment employment = getNewInstanceWithUninitializedProjects();
    employment.hasProjects();

    fail( "This should never be reached..." );
  }

  @Test
  @Repeat( 25 )
  public void testModifyStart() throws Exception
  {
    LocalDate start = ModelRandomGenerator.randomLocalDate();

    Employment objectUnderTest = getNewInstance();
    objectUnderTest.setStart( start );
    assertEquals( start, objectUnderTest.getStart() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyEnd() throws Exception
  {
    LocalDate end = ModelRandomGenerator.randomLocalDate();

    Employment objectUnderTest = getNewInstance();
    objectUnderTest.setEnd( end );
    assertEquals( end, objectUnderTest.getEnd() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyEmployer() throws Exception
  {
    Company employer = getNewCompany();

    Employment objectUnderTest = getNewInstance();
    objectUnderTest.setEmployer( employer );
    assertEquals( employer, objectUnderTest.getEmployer() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyEmployee() throws Exception
  {
    Person employee = getNewPerson();

    Employment objectUnderTest = getNewInstance();
    objectUnderTest.setEmployee( employee );
    assertEquals( employee, objectUnderTest.getEmployee() );
  }
}
