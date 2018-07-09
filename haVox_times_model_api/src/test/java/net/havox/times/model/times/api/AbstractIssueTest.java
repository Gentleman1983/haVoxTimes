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
import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractIssueTest
{

  public abstract Issue newInstance() throws Exception;

  @Test
  @Repeat( 25 )
  public void testModifyDescription() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHANUMERIC_STRING + " -,;.!?ß";
    String description = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 0, 500 ), alphabet );

    Issue objectUnderTest = newInstance();
    objectUnderTest.setDescription( description );
    assertEquals( description, objectUnderTest.getDescription() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyStart() throws Exception
  {
    LocalDateTime start = ModelRandomGenerator.randomLocalDateTime();

    Issue objectUnderTest = newInstance();
    objectUnderTest.setStart( start );
    assertEquals( start, objectUnderTest.getStart() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyEnd() throws Exception
  {
    LocalDateTime end = ModelRandomGenerator.randomLocalDateTime();

    Issue objectUnderTest = newInstance();
    objectUnderTest.setEnd( end );
    assertEquals( end, objectUnderTest.getEnd() );
  }

  @Test
  public void testDuration() throws Exception
  {
    Task zeroSecondsTask = mock( Task.class );
    when( zeroSecondsTask.getDuration() ).thenReturn( Duration.ZERO );

    Task twentyMinuteTask = mock( Task.class );
    when( twentyMinuteTask.getDuration() ).thenReturn( Duration.of( 20, ChronoUnit.MINUTES ) );

    Task fourHourTask = mock( Task.class );
    when( fourHourTask.getDuration() ).thenReturn( Duration.of( 4, ChronoUnit.HOURS ) );

    Issue issueNoIssue = newInstance();

    Issue issueNoDuration = newInstance();
    issueNoDuration.getTasks().add( zeroSecondsTask );

    Issue issuetwentyMinutes = newInstance();
    issuetwentyMinutes.getTasks().add( twentyMinuteTask );

    Issue issueFourHours = newInstance();
    issueFourHours.getTasks().add( fourHourTask );

    Issue issueFourHoursAndTwentyMinutes = newInstance();
    issueFourHoursAndTwentyMinutes.getTasks().add( twentyMinuteTask );
    issueFourHoursAndTwentyMinutes.getTasks().add( fourHourTask );

    assertEquals( Duration.ZERO, issueNoIssue.getDuration() );
    assertEquals( Duration.ZERO, issueNoDuration.getDuration() );
    assertEquals( Duration.of( 20, ChronoUnit.MINUTES ), issuetwentyMinutes.getDuration() );
    assertEquals( Duration.of( 4, ChronoUnit.HOURS ), issueFourHours.getDuration() );
    assertEquals( Duration.of( 4, ChronoUnit.HOURS ).plus( Duration.of( 20, ChronoUnit.MINUTES ) ), issueFourHoursAndTwentyMinutes.getDuration() );
  }
}
