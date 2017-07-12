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
package net.havox.times.model.times.impl;

import java.lang.reflect.Field;
import java.time.Duration;
import java.time.LocalDateTime;

import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.impl.AbstractChangeAwareClassTest;
import net.havox.times.model.times.api.WorkUnit;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.fail;
import org.junit.Test;

public class WorkUnitImplTest extends AbstractChangeAwareClassTest
{

  @Override
  public AbstractChangeAwareClass createNewInstance( Long id, long version ) throws Exception
  {
    Class<?> clazz = WorkUnitImpl.class;
    Object instance = clazz.newInstance();

    Field idField = instance.getClass().getSuperclass().getDeclaredField( "id" );
    idField.setAccessible( true );
    idField.set( instance, id );

    Field versionField = instance.getClass().getSuperclass().getDeclaredField( "version" );
    versionField.setAccessible( true );
    versionField.set( instance, version );
    
    (( WorkUnitImpl ) instance).setWorkUnitDuration( LocalDateTime.MIN, LocalDateTime.MAX );

    return ( WorkUnitImpl ) instance;
  }

  private void processTestSetWorkUnitDuration( LocalDateTime startTime, LocalDateTime endTime, Duration expectedDuration )
  {
    WorkUnit objectUnderTest = new WorkUnitImpl();

    assertNotNull( objectUnderTest );

    objectUnderTest.setWorkUnitDuration( startTime, endTime );

    assertEquals( expectedDuration, objectUnderTest.getWorkUnitDuration() );
  }

  private void processTestSetWorkUnitDuration( LocalDateTime startTime, Duration duration, Duration expectedDuration )
  {
    WorkUnit objectUnderTest = new WorkUnitImpl();

    assertNotNull( objectUnderTest );

    objectUnderTest.setWorkUnitDuration( startTime, duration );

    assertEquals( expectedDuration, objectUnderTest.getWorkUnitDuration() );
  }

  @Test
  public void testSetWorkUnitDurationLocalDateTimeLocalDateTimeNoException()
  {
    LocalDateTime startTime = LocalDateTime.now();
    Duration expectedDuration = Duration.ofMinutes( 23 * 60 + 59 );
    LocalDateTime endTime = startTime.plus( expectedDuration );

    assertNotNull( startTime );
    assertNotNull( endTime );

    processTestSetWorkUnitDuration( startTime, endTime, expectedDuration );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeLocalDateTimeFirstParameterNull()
  {
    LocalDateTime startTime = LocalDateTime.now();
    Duration expectedDuration = Duration.ofMinutes( 23 * 60 + 59 );
    LocalDateTime endTime = startTime.plus( expectedDuration );
    startTime = null;

    assertNull( startTime );
    assertNotNull( endTime );

    processTestSetWorkUnitDuration( startTime, endTime, expectedDuration );

    fail( "This should never be reached..." );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeLocalDateTimeSecondParameterNull()
  {
    LocalDateTime startTime = LocalDateTime.now();
    Duration expectedDuration = Duration.ofMinutes( 23 * 60 + 59 );
    LocalDateTime endTime = null;

    assertNotNull( startTime );
    assertNull( endTime );

    processTestSetWorkUnitDuration( startTime, endTime, expectedDuration );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeLocalDateTimeBothParametersNull()
  {
    LocalDateTime startTime = null;
    Duration expectedDuration = Duration.ofMinutes( 23 * 60 + 59 );
    LocalDateTime endTime = null;

    assertNull( startTime );
    assertNull( endTime );

    processTestSetWorkUnitDuration( startTime, endTime, expectedDuration );

    fail( "This should never be reached..." );
  }

  @Test
  public void testSetWorkUnitDurationLocalDateTimeDurationNoException()
  {
    LocalDateTime startTime = LocalDateTime.now();
    Duration duration = Duration.ofMinutes( 23 * 60 + 59 );
    Duration expectedDuration = duration;

    assertNotNull( startTime );
    assertNotNull( duration );

    processTestSetWorkUnitDuration( startTime, duration, expectedDuration );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeDurationFirstParameterNull()
  {
    LocalDateTime startTime = null;
    Duration duration = Duration.ofMinutes( 23 * 60 + 59 );
    Duration expectedDuration = Duration.ZERO;

    assertNull( startTime );
    assertNotNull( duration );

    processTestSetWorkUnitDuration( startTime, duration, expectedDuration );

    fail( "This should never be reached..." );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeDurationSecondParameterNull()
  {
    LocalDateTime startTime = LocalDateTime.now();
    Duration duration = null;
    Duration expectedDuration = Duration.ZERO;

    assertNotNull( startTime );
    assertNull( duration );

    processTestSetWorkUnitDuration( startTime, duration, expectedDuration );

    fail( "This should never be reached..." );
  }

  @Test( expected = IllegalArgumentException.class )
  public void testSetWorkUnitDurationLocalDateTimeDurationBothParametersNull()
  {
    LocalDateTime startTime = null;
    Duration duration = null;
    Duration expectedDuration = Duration.ZERO;

    assertNull( startTime );
    assertNull( duration );

    processTestSetWorkUnitDuration( startTime, duration, expectedDuration );

    fail( "This should never be reached..." );
  }
}
