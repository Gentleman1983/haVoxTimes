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

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.Collection;
import java.util.concurrent.TimeUnit;
import net.havox.test.utils.junit.ExtendedRunner;
import net.havox.test.utils.random.ModelRandomGenerator;
import net.havox.test.utils.junit.Repeat;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Person;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractProjectTest
{

  public abstract Project newInstance() throws Exception;

  public abstract Project newInstanceWithoutInitializedSubprojects() throws Exception;

  public abstract Company newCompany() throws Exception;

  public abstract Person newPerson() throws Exception;

  public abstract WorkDay newWorkday( LocalDate workDate ) throws Exception;

  public abstract WorkDay newWorkday( LocalDate workDate, WorkUnitType type, Duration duration ) throws Exception;

  @Test
  @Repeat( 25 )
  public void testModifyName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Project objectUnderTest = newInstance();
    objectUnderTest.setName( name );
    assertEquals( name, objectUnderTest.getName() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyStart() throws Exception
  {
    LocalDate start = ModelRandomGenerator.randomLocalDate();

    Project objectUnderTest = newInstance();
    objectUnderTest.setStart( start );
    assertEquals( start, objectUnderTest.getStart() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyEnd() throws Exception
  {
    LocalDate end = ModelRandomGenerator.randomLocalDate();

    Project objectUnderTest = newInstance();
    objectUnderTest.setEnd( end );
    assertEquals( end, objectUnderTest.getEnd() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyEmployer() throws Exception
  {
    Company employer = newCompany();

    Project objectUnderTest = newInstance();
    objectUnderTest.setEmployer( employer );
    assertEquals( employer, objectUnderTest.getEmployer() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyEmployee() throws Exception
  {
    Person employee = newPerson();

    Project objectUnderTest = newInstance();
    objectUnderTest.setEmployee( employee );
    assertEquals( employee, objectUnderTest.getEmployee() );
  }

  @Test( expected = IllegalStateException.class )
  public void testHasSubprojectsUninitializedSubprojects() throws Exception
  {
    Project objectUnderTest = newInstanceWithoutInitializedSubprojects();
    objectUnderTest.hasSubprojects();
    fail( "This should never be able to reach." );
  }

  @Test
  public void testHasSubprojectsNoSubprojects() throws Exception
  {
    Project objectUnderTest = newInstance();

    assertTrue( objectUnderTest.getSubprojects().isEmpty() );
    assertFalse( objectUnderTest.hasSubprojects() );
  }

  @Test
  public void testHasSubprojectsWithSubprojects() throws Exception
  {
    Project objectUnderTestOneSubproject = newInstance();
    objectUnderTestOneSubproject.getSubprojects().add( newInstance() );

    assertFalse( objectUnderTestOneSubproject.getSubprojects().isEmpty() );
    assertTrue( objectUnderTestOneSubproject.hasSubprojects() );

    Project objectUnderTestMultipleSubproject = newInstance();
    objectUnderTestMultipleSubproject.getSubprojects().add( newInstance() );
    objectUnderTestMultipleSubproject.getSubprojects().add( newInstance() );

    assertFalse( objectUnderTestMultipleSubproject.getSubprojects().isEmpty() );
    assertTrue( objectUnderTestMultipleSubproject.hasSubprojects() );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testGetWorkDaysLocalDateLocalDateNoStartDate() throws Exception
  {
    Project objectUnderTest = newInstance();
    objectUnderTest.getWorkDays( null, LocalDate.now() );
    fail( "This should never be able to reach." );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testGetWorkDaysLocalDateLocalDateNoEndDate() throws Exception
  {
    Project objectUnderTest = newInstance();
    objectUnderTest.getWorkDays( LocalDate.now(), null );
    fail( "This should never be able to reach." );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testGetWorkDaysLocalDateLocalDateNoDates() throws Exception
  {
    Project objectUnderTest = newInstance();
    objectUnderTest.getWorkDays( null, null );
    fail( "This should never be able to reach." );
  }

  @Test
  public void testGetWorkDaysLocalDateLocalDateNoWorkDays() throws Exception
  {
    Project objectUnderTest = newInstance();
    assertTrue( objectUnderTest.getWorkDays( LocalDate.MIN, LocalDate.MAX ).isEmpty() );
  }

  @Test
  public void testGetWorkDaysLocalDateLocalDateWorkDayBeforePeriod() throws Exception
  {
    Project objectUnderTest = newInstance();

    LocalDate yesterday = LocalDate.now().minus( 1, ChronoUnit.DAYS );
    WorkDay yesterdayWorkDay = newWorkday( yesterday );
    objectUnderTest.getWorkDays().add( yesterdayWorkDay );

    assertTrue( objectUnderTest.getWorkDays( LocalDate.now(), LocalDate.MAX ).isEmpty() );
  }

  @Test
  public void testGetWorkDaysLocalDateLocalDateWorkDayAfterPeriod() throws Exception
  {
    Project objectUnderTest = newInstance();

    LocalDate tomorrow = LocalDate.now().plus( 1, ChronoUnit.DAYS );
    WorkDay tomorrowWorkDay = newWorkday( tomorrow );
    objectUnderTest.getWorkDays().add( tomorrowWorkDay );

    assertTrue( objectUnderTest.getWorkDays( LocalDate.MIN, LocalDate.now() ).isEmpty() );
  }

  @Test
  public void testGetWorkDaysLocalDateLocalDateWorkDaysMatchingPeriod() throws Exception
  {
    Project objectUnderTest = newInstance();

    LocalDate tooEarly = LocalDate.now().minus( 2, ChronoUnit.DAYS );
    WorkDay tooEarlyWorkDay = newWorkday( tooEarly );
    objectUnderTest.getWorkDays().add( tooEarlyWorkDay );

    LocalDate yesterday = LocalDate.now().minus( 1, ChronoUnit.DAYS );
    WorkDay yesterdayWorkDay = newWorkday( yesterday );
    objectUnderTest.getWorkDays().add( yesterdayWorkDay );

    LocalDate today = LocalDate.now().plus( 1, ChronoUnit.DAYS );
    WorkDay todayWorkDay = newWorkday( today );
    objectUnderTest.getWorkDays().add( todayWorkDay );

    LocalDate tomorrow = LocalDate.now().plus( 1, ChronoUnit.DAYS );
    WorkDay tomorrowWorkDay = newWorkday( tomorrow );
    objectUnderTest.getWorkDays().add( tomorrowWorkDay );

    LocalDate tooLate = LocalDate.now().plus( 2, ChronoUnit.DAYS );
    WorkDay tooLateWorkDay = newWorkday( tooLate );
    objectUnderTest.getWorkDays().add( tooLateWorkDay );

    Collection<WorkDay> selection = objectUnderTest.getWorkDays( yesterday, tomorrow );

    assertFalse( selection.isEmpty() );

    assertFalse( selection.contains( tooEarlyWorkDay ) );
    assertTrue( selection.contains( yesterdayWorkDay ) );
    assertTrue( selection.contains( todayWorkDay ) );
    assertTrue( selection.contains( tomorrowWorkDay ) );
    assertFalse( selection.contains( tooLateWorkDay ) );
  }

  @Test
  public void testHasStartedTrue() throws Exception
  {
    LocalDate yesterday = LocalDate.now().minus( 1, ChronoUnit.DAYS );
    Project startedYesterday = newInstance();
    startedYesterday.setStart( yesterday );
    assertTrue( startedYesterday.hasStarted() );

    LocalDate now = LocalDate.now();
    Project startsAlmostNow = newInstance();
    startsAlmostNow.setStart( now );
    TimeUnit.SECONDS.sleep( 1 );
    assertTrue( startsAlmostNow.hasStarted() );
  }

  @Test
  public void testHasStartedFalse() throws Exception
  {
    LocalDate tomorrow = LocalDate.now().plus( 1, ChronoUnit.DAYS );
    Project startsTomorrow = newInstance();
    startsTomorrow.setStart( tomorrow );
    assertFalse( startsTomorrow.hasStarted() );

    Project noStartDate = newInstance();
    noStartDate.setStart( null );
    assertFalse( noStartDate.hasStarted() );
  }

  @Test
  public void testIsActiveNotStarted() throws Exception
  {
    Project instanceUnderTest = newInstance();
    instanceUnderTest.setStart( null );
    instanceUnderTest.setEnd( null );

    assertFalse( instanceUnderTest.hasStarted() );
    assertFalse( instanceUnderTest.isActive() );
  }

  @Test
  public void testIsActiveNoEndDate() throws Exception
  {
    Project instanceUnderTest = newInstance();
    instanceUnderTest.setStart( LocalDate.MIN );
    instanceUnderTest.setEnd( null );

    assertTrue( instanceUnderTest.hasStarted() );
    assertTrue( instanceUnderTest.isActive() );
  }

  @Test
  public void testIsActiveEndDateInFuture() throws Exception
  {
    Project instanceUnderTest = newInstance();
    instanceUnderTest.setStart( LocalDate.MIN );
    instanceUnderTest.setEnd( LocalDate.MAX );

    assertTrue( instanceUnderTest.hasStarted() );
    assertTrue( instanceUnderTest.isActive() );
  }

  @Test
  public void testIsActiveEndDateInPast() throws Exception
  {
    Project instanceUnderTest = newInstance();
    LocalDate yesterday = LocalDate.now().minus( 1, ChronoUnit.DAYS );

    instanceUnderTest.setStart( LocalDate.MIN );
    instanceUnderTest.setEnd( yesterday );

    assertTrue( instanceUnderTest.hasStarted() );
    assertFalse( instanceUnderTest.isActive() );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testGetDurationMonthIntWorkUnitTypeBooleanNoMonth() throws Exception
  {
    Project instanceUnderTest = newInstance();
    try
    {
      instanceUnderTest.getDuraration( null, 2017, WorkUnitType.WORK, true );
    }
    catch ( IllegalArgumentException iae )
    {
      assertEquals( "The month has to be set.", iae.getMessage() );
      throw iae;
    }

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testGetDurationMonthIntWorkUnitTypeBooleanNoType() throws Exception
  {
    Project instanceUnderTest = newInstance();
    try
    {
      instanceUnderTest.getDuraration( Month.JANUARY, 2017, null, true );
    }
    catch ( IllegalArgumentException iae )
    {
      assertEquals( "The work unit type has to be set.", iae.getMessage() );
      throw iae;
    }

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testGetDurationMonthIntWorkUnitTypeBooleanOutOfRangeBefore() throws Exception
  {
    Project instanceUnderTest = newInstance();
    instanceUnderTest.setStart( LocalDate.now() );
    instanceUnderTest.setEnd( LocalDate.MAX );

    try
    {
      instanceUnderTest.getDuraration( Month.JANUARY, LocalDate.now().getYear() - 1, WorkUnitType.BREAK, true );
    }
    catch ( IllegalArgumentException iae )
    {
      assertTrue( iae.getMessage().contains( "has to be within project range" ) );
      throw iae;
    }

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testGetDurationMonthIntWorkUnitTypeBooleanOutOfRangeAfter() throws Exception
  {
    Project instanceUnderTest = newInstance();
    instanceUnderTest.setStart( LocalDate.MIN );
    instanceUnderTest.setEnd( LocalDate.now() );

    try
    {
      instanceUnderTest.getDuraration( Month.JANUARY, LocalDate.now().getYear() + 1, WorkUnitType.BREAK, true );
    }
    catch ( IllegalArgumentException iae )
    {
      assertTrue( iae.getMessage().contains( "has to be within project range" ) );
      throw iae;
    }

    fail( "This should never be reached!" );
  }

  @Test
  public void testGetDurationMonthIntWorkUnitTypeBooleanOnlyWorkInMainProject() throws Exception
  {
    Project subProject = newInstance();
    subProject.setStart( LocalDate.MIN );
    subProject.setEnd( LocalDate.MAX );

    Project instanceUnderTest = newInstance();
    instanceUnderTest.setStart( LocalDate.MIN );
    instanceUnderTest.setEnd( LocalDate.MAX );
    instanceUnderTest.getSubprojects().add( subProject );

    LocalDate today = LocalDate.now();
    WorkDay eightHourDay = newWorkday( today, WorkUnitType.WORK, Duration.of( 8, ChronoUnit.HOURS ) );
    instanceUnderTest.getWorkDays().add( eightHourDay );

    assertEquals( Duration.ZERO, subProject.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, true ) );
    assertEquals( Duration.ZERO, subProject.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, false ) );

    assertEquals( Duration.of( 8, ChronoUnit.HOURS ), instanceUnderTest.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, true ) );
    assertEquals( Duration.of( 8, ChronoUnit.HOURS ), instanceUnderTest.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, false ) );
  }

  @Test
  public void testGetDurationMonthIntWorkUnitTypeBooleanOnlyWorkInSubProject() throws Exception
  {
    Project subProject = newInstance();
    subProject.setStart( LocalDate.MIN );
    subProject.setEnd( LocalDate.MAX );

    Project instanceUnderTest = newInstance();
    instanceUnderTest.setStart( LocalDate.MIN );
    instanceUnderTest.setEnd( LocalDate.MAX );
    instanceUnderTest.getSubprojects().add( subProject );

    LocalDate today = LocalDate.now();
    WorkDay eightHourDay = newWorkday( today, WorkUnitType.WORK, Duration.of( 8, ChronoUnit.HOURS ) );
    subProject.getWorkDays().add( eightHourDay );

    assertEquals( Duration.of( 8, ChronoUnit.HOURS ), subProject.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, true ) );
    assertEquals( Duration.of( 8, ChronoUnit.HOURS ), subProject.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, false ) );

    assertEquals( Duration.of( 8, ChronoUnit.HOURS ), instanceUnderTest.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, true ) );
    assertEquals( Duration.ZERO, instanceUnderTest.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, false ) );
  }

  @Test
  public void testGetDurationMonthIntWorkUnitTypeBooleanWorkInMainAndSubProject() throws Exception
  {
    Project subProject = newInstance();
    subProject.setStart( LocalDate.MIN );
    subProject.setEnd( LocalDate.MAX );

    Project instanceUnderTest = newInstance();
    instanceUnderTest.setStart( LocalDate.MIN );
    instanceUnderTest.setEnd( LocalDate.MAX );
    instanceUnderTest.getSubprojects().add( subProject );

    LocalDate today = LocalDate.now();
    WorkDay twoHourDay = newWorkday( today, WorkUnitType.WORK, Duration.of( 2, ChronoUnit.HOURS ) );
    instanceUnderTest.getWorkDays().add( twoHourDay );
    WorkDay sixHourDay = newWorkday( today, WorkUnitType.WORK, Duration.of( 6, ChronoUnit.HOURS ) );
    subProject.getWorkDays().add( sixHourDay );

    assertEquals( Duration.of( 6, ChronoUnit.HOURS ), subProject.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, true ) );
    assertEquals( Duration.of( 6, ChronoUnit.HOURS ), subProject.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, false ) );

    assertEquals( Duration.of( 8, ChronoUnit.HOURS ), instanceUnderTest.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, true ) );
    assertEquals( Duration.of( 2, ChronoUnit.HOURS ), instanceUnderTest.getDuraration( today.getMonth(), today.getYear(), WorkUnitType.WORK, false ) );
  }
}
