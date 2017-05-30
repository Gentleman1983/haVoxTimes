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
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractEmploymentTest
{
  public abstract Project getNewProject() throws Exception;
  public abstract Employment getNewInstanceWithUninitializedProjects() throws Exception;
  public abstract Employment getNewInstance( Project... projects ) throws Exception;
  public abstract Employment getNewInstance( LocalDate start, LocalDate end ) throws Exception;
  
  @Test
  public void testGetEmploymentPeriodStartEnd() throws Exception {
    Employment employmentOneYear = getNewInstance( LocalDate.of( 2017, Month.JANUARY, 1 ), LocalDate.of( 2017, Month.DECEMBER, 31 ) );
    Employment employmentTwoYears = getNewInstance( LocalDate.of( 2017, Month.JANUARY, 1 ), LocalDate.of( 2018, Month.DECEMBER, 31 ) );
    Employment employmentSingleDay = getNewInstance( LocalDate.of( 2017, Month.JANUARY, 1 ), LocalDate.of( 2017, Month.JANUARY, 1 ) );
    
    assertEquals( Period.ofYears( 1 ), employmentOneYear.getEmploymentPeriod() );
    assertEquals( Period.ofYears( 2 ), employmentTwoYears.getEmploymentPeriod() );
    assertEquals( Period.ofDays( 1 ), employmentSingleDay.getEmploymentPeriod() );
  }
  
  @Test
  public void testGetEmploymentPeriodStartNow() throws Exception {
    Employment employmentToday = getNewInstance( LocalDate.now(), null );
    Employment employmentOneMonth = getNewInstance( LocalDate.now().minus( Period.ofMonths( 1 ) ), null );
    
    assertEquals( Period.ofDays( 1 ), employmentToday.getEmploymentPeriod() );
    assertEquals( Period.ofMonths( 1 ), employmentOneMonth.getEmploymentPeriod() );
  }
  
  @Test
  public void testIsActive() throws Exception {
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
  public void testHasProjects() throws Exception {
    Employment employmentWithOutProjects = getNewInstance();
    Project project = getNewProject();
    Employment employmentWithProject = getNewInstance( project );
    
    assertFalse( employmentWithOutProjects.hasProjects() );
    assertTrue( employmentWithProject.hasProjects() );
  }
  
  @Test( expected = IllegalStateException.class )
  public void testHasProjectsNotInitialized() throws Exception {
    Employment employment = getNewInstanceWithUninitializedProjects();
    employment.hasProjects();
    
    fail( "This should never be reached..." );
  }
}
