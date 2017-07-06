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
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import net.havox.times.model.api.ExtendedRunner;
import net.havox.times.model.api.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractWorkUnitTest
{

  public abstract WorkUnit newInstance() throws Exception;

  public abstract WorkUnit newInstance( LocalDateTime start, LocalDateTime end ) throws Exception;

  public abstract Task newTask( Duration duration ) throws Exception;

  @Test
  @Repeat( 25 )
  public void testModifyType() throws Exception
  {
    WorkUnitType type = WorkUnitType.VACATION;

    WorkUnit objectUnderTest = newInstance();
    objectUnderTest.setType( type );
    assertEquals( type, objectUnderTest.getType() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyWorkUnitDurationStartEnd() throws Exception
  {
    WorkUnit objectUnderTest = newInstance();
    objectUnderTest.setWorkUnitDuration( LocalDateTime.MIN, LocalDateTime.MAX );

    assertEquals( LocalDateTime.MIN, objectUnderTest.getWorkUnitStart() );
    assertEquals( LocalDateTime.MAX, objectUnderTest.getWorkUnitEnd() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyWorkUnitDurationStartDuration() throws Exception
  {
    WorkUnit objectUnderTest = newInstance();
    objectUnderTest.setWorkUnitDuration( LocalDateTime.MIN, Duration.ofDays( 30 ) );

    assertEquals( LocalDateTime.MIN, objectUnderTest.getWorkUnitStart() );
    assertEquals( Duration.of( 30, ChronoUnit.DAYS ), objectUnderTest.getWorkUnitDuration() );
  }

  @Test( expected = IllegalStateException.class )
  public void testGetWorkUnitDurationStartNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance( null, LocalDateTime.MAX );

    objectUnderTest.getWorkUnitDuration();

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalStateException.class )
  public void testGetWorkUnitDurationEndNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance( LocalDateTime.MIN, null );

    objectUnderTest.getWorkUnitDuration();

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalStateException.class )
  public void testGetWorkUnitDurationStartAndEndNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance( null, null );

    objectUnderTest.getWorkUnitDuration();

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeLocalDateTimeStartNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance();

    objectUnderTest.setWorkUnitDuration( null, LocalDateTime.MAX );

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeLocalDateTimeEndNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance();

    objectUnderTest.setWorkUnitDuration( LocalDateTime.MIN, ( LocalDateTime ) null );

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeLocalDateTimeStartAndEndNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance();

    objectUnderTest.setWorkUnitDuration( null, ( LocalDateTime ) null );

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeDurationStartNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance();

    objectUnderTest.setWorkUnitDuration( null, Duration.ofDays( 1 ) );

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeDurationEndNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance();

    objectUnderTest.setWorkUnitDuration( LocalDateTime.MIN, ( Duration ) null );

    fail( "This should never be reached!" );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeDurationStartAndEndNotSet() throws Exception
  {
    WorkUnit objectUnderTest = newInstance();

    objectUnderTest.setWorkUnitDuration( null, ( Duration ) null );

    fail( "This should never be reached!" );
  }

  @Test
  public void testGetDuration() throws Exception
  {
    WorkUnit noTasks = newInstance();
    assertEquals( Duration.ZERO, noTasks.getDuration() );

    WorkUnit zeroDurationTask = newInstance();
    Task zeroTask = newTask( Duration.ZERO );
    zeroDurationTask.getTasks().add( zeroTask );
    assertEquals( Duration.ZERO, zeroDurationTask.getDuration() );

    WorkUnit twoHourTask = newInstance();
    Task twoHour = newTask( Duration.ofHours( 2 ) );
    twoHourTask.getTasks().add( twoHour );
    assertEquals( Duration.of( 2, ChronoUnit.HOURS ), twoHourTask.getDuration() );

    WorkUnit sixHourTasks = newInstance();
    Task fourHour = newTask( Duration.ofHours( 4 ) );
    sixHourTasks.getTasks().add( twoHour );
    sixHourTasks.getTasks().add( fourHour );
    assertEquals( Duration.of( 6, ChronoUnit.HOURS ), sixHourTasks.getDuration() );
  }
}
