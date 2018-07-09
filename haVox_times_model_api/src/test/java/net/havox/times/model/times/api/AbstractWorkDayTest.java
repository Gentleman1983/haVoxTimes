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

import static net.havox.exceptions.GuruErrorCode.ILLEGAL_ARGUMENT;

import static org.junit.Assert.*;

import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import net.havox.exceptions.GuruMeditationWarning;
import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractWorkDayTest
{

  public abstract WorkDay newInstance() throws Exception;

  public abstract WorkUnit newWorkUnit() throws Exception;

  public abstract WorkUnit newWorkUnit( WorkUnitType type, Duration duration ) throws Exception;

  @Test
  @Repeat( 25 )
  public void testModifyDate() throws Exception
  {
    LocalDate date = ModelRandomGenerator.randomLocalDate();

    WorkDay objectUnderTest = newInstance();
    objectUnderTest.setDate( date );
    assertEquals( date, objectUnderTest.getDate() );
  }

  @Test
  @Repeat( 25 )
  public void testAddAndRemoveWorkUnit() throws Exception
  {
    WorkDay objectUnderTest = newInstance();

    assertTrue( objectUnderTest.getWorkUnits().isEmpty() );

    WorkUnit addedWorkUnit = newWorkUnit();
    WorkUnit addedAndRemovedWorkUnit = newWorkUnit();

    objectUnderTest.addWorkUnit( addedWorkUnit );
    objectUnderTest.addWorkUnit( addedAndRemovedWorkUnit );

    assertFalse( objectUnderTest.getWorkUnits().isEmpty() );
    assertEquals( 2, objectUnderTest.getWorkUnits().size() );
    assertTrue( objectUnderTest.getWorkUnits().contains( addedWorkUnit ) );
    assertTrue( objectUnderTest.getWorkUnits().contains( addedAndRemovedWorkUnit ) );

    WorkUnit removedUnit = objectUnderTest.removeWorkUnit( addedAndRemovedWorkUnit );

    assertFalse( objectUnderTest.getWorkUnits().isEmpty() );
    assertEquals( 1, objectUnderTest.getWorkUnits().size() );
    assertTrue( objectUnderTest.getWorkUnits().contains( addedWorkUnit ) );
    assertFalse( objectUnderTest.getWorkUnits().contains( addedAndRemovedWorkUnit ) );
    assertEquals( addedAndRemovedWorkUnit, removedUnit );
  }

  @Test
  @Repeat( 25 )
  public void testAddAndRemoveWorkUnits() throws Exception
  {
    int numberOfAddedWorkUnits = ModelRandomGenerator.randomIntInRange( 0, 50 );
    int numberOfRemovedWorkUnits = ModelRandomGenerator.randomIntInRange( 0, numberOfAddedWorkUnits );

    List<WorkUnit> addedWorkUnits = new ArrayList<>();
    List<WorkUnit> removedWorkUnits = new ArrayList<>();

    for ( int i = 0; i < numberOfAddedWorkUnits; i++ )
    {
      WorkUnit instance = newWorkUnit();
      addedWorkUnits.add( instance );
      if ( i < numberOfRemovedWorkUnits )
      {
        removedWorkUnits.add( instance );
      }
    }

    WorkDay objectUnderTest = newInstance();

    assertTrue( objectUnderTest.getWorkUnits().isEmpty() );

    objectUnderTest.addWorkUnits( addedWorkUnits.toArray( new WorkUnit[ numberOfAddedWorkUnits ] ) );

    assertEquals( numberOfAddedWorkUnits, objectUnderTest.getWorkUnits().size() );
    for ( WorkUnit addedWorkUnit : addedWorkUnits )
    {
      assertTrue( objectUnderTest.getWorkUnits().contains( addedWorkUnit ) );
    }
    for ( WorkUnit addedAndRemovedWorkUnit : removedWorkUnits )
    {
      assertTrue( objectUnderTest.getWorkUnits().contains( addedAndRemovedWorkUnit ) );
    }

    Set<WorkUnit> removedUnits = objectUnderTest.removeWorkUnits( removedWorkUnits.toArray( new WorkUnit[ numberOfRemovedWorkUnits ] ) );

    assertEquals( numberOfAddedWorkUnits - numberOfRemovedWorkUnits, objectUnderTest.getWorkUnits().size() );
    for ( WorkUnit workUnit : addedWorkUnits )
    {
      if ( removedWorkUnits.contains( workUnit ) )
      {
        assertFalse( objectUnderTest.getWorkUnits().contains( workUnit ) );
        assertTrue( removedUnits.contains( workUnit ) );
      }
      else
      {
        assertTrue( objectUnderTest.getWorkUnits().contains( workUnit ) );
        assertFalse( removedUnits.contains( workUnit ) );
      }
    }
    assertEquals( numberOfRemovedWorkUnits, removedUnits.size() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyStart() throws Exception
  {
    LocalDateTime start = ModelRandomGenerator.randomLocalDateTime();

    WorkDay objectUnderTest = newInstance();
    objectUnderTest.setStart( start );
    assertEquals( start, objectUnderTest.getStart() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyEnd() throws Exception
  {
    LocalDateTime end = ModelRandomGenerator.randomLocalDateTime();

    WorkDay objectUnderTest = newInstance();
    objectUnderTest.setEnd( end );
    assertEquals( end, objectUnderTest.getEnd() );
  }

  @Test
  public void testGetDurationWorkUnitTypeNoWorkUnit() throws Exception
  {
    WorkDay objectUnderTest = newInstance();

    for ( WorkUnitType type : WorkUnitType.values() )
    {
      String message = "WorkUnitType " + type.name() + ": There should be no duration, but duration was: " + objectUnderTest.getDuration( type ) + ".";
      assertEquals( message, Duration.ZERO, objectUnderTest.getDuration( type ) );
    }
  }

  @Test
  public void testGetDurationWorkUnitTypeNoDuration() throws Exception
  {
    WorkDay objectUnderTest = newInstance();

    for ( WorkUnitType type : WorkUnitType.values() )
    {
      WorkUnit workUnit = newWorkUnit( type, Duration.ZERO );
      objectUnderTest.addWorkUnit( workUnit );
    }

    for ( WorkUnitType type : WorkUnitType.values() )
    {
      String message = "WorkUnitType " + type.name() + ": There should be no duration, but duration was: " + objectUnderTest.getDuration( type ) + ".";
      assertEquals( message, Duration.ZERO, objectUnderTest.getDuration( type ) );
    }
  }

  @Test
  public void testGetDurationWorkUnitTypeDurationOfGivenAndUngivenType() throws Exception
  {
    WorkDay objectUnderTest = newInstance();

    WorkUnit workUnit = newWorkUnit( WorkUnitType.WORK, Duration.ofHours( 8 ) );
    objectUnderTest.addWorkUnit( workUnit );

    for ( WorkUnitType type : WorkUnitType.values() )
    {
      if ( WorkUnitType.WORK.equals( type ) )
      {
        String message = "WorkUnitType " + type.name() + ": The duration should be 8h, but duration was: " + objectUnderTest.getDuration( type ) + ".";
        assertEquals( message, Duration.of( 8, ChronoUnit.HOURS ), objectUnderTest.getDuration( type ) );
      }
      else
      {
        String message = "WorkUnitType " + type.name() + ": There should be no duration, but duration was: " + objectUnderTest.getDuration( type ) + ".";
        assertEquals( message, Duration.ZERO, objectUnderTest.getDuration( type ) );
      }
    }
  }

  @Test
  public void testGetDurationWorkUnitTypeDurationOfMixedType() throws Exception
  {
    WorkDay objectUnderTest = newInstance();

    WorkUnit workUnit = newWorkUnit( WorkUnitType.WORK, Duration.ofHours( 8 ) );
    WorkUnit breakWorkUnit = newWorkUnit( WorkUnitType.BREAK, Duration.ofMinutes( 30 ) );
    objectUnderTest.addWorkUnit( workUnit );
    objectUnderTest.addWorkUnit( breakWorkUnit );

    for ( WorkUnitType type : WorkUnitType.values() )
    {
      if ( WorkUnitType.WORK.equals( type ) )
      {
        String message = "WorkUnitType " + type.name() + ": The duration should be 8h, but duration was: " + objectUnderTest.getDuration( type ) + ".";
        assertEquals( message, Duration.of( 8, ChronoUnit.HOURS ), objectUnderTest.getDuration( type ) );
      }
      else if ( WorkUnitType.BREAK.equals( type ) )
      {
        String message = "WorkUnitType " + type.name() + ": The duration should be 30m, but duration was: " + objectUnderTest.getDuration( type ) + ".";
        assertEquals( message, Duration.of( 30, ChronoUnit.MINUTES ), objectUnderTest.getDuration( type ) );
      }
      else
      {
        String message = "WorkUnitType " + type.name() + ": There should be no duration, but duration was: " + objectUnderTest.getDuration( type ) + ".";
        assertEquals( message, Duration.ZERO, objectUnderTest.getDuration( type ) );
      }
    }
  }

  @Test( expected = GuruMeditationWarning.class )
  public void testGetDurationWorkUnitTypeNoType() throws Exception
  {
    WorkDay objectUnderTest = newInstance();

    try
    {
      objectUnderTest.getDuration( null );
    }
    catch ( GuruMeditationWarning gmw )
    {
      assertEquals( ILLEGAL_ARGUMENT, gmw.getErrorCode() );
      throw gmw;
    }

    fail( "This should never be reached!" );
  }
}
