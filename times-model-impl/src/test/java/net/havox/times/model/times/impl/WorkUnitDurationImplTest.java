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
import net.havox.times.model.times.api.WorkUnitDuration;

import org.junit.Test;

 import static  org.junit.Assert.*;

public class WorkUnitDurationImplTest extends AbstractChangeAwareClassTest
{
  
  @Override
  public AbstractChangeAwareClass createNewInstance( Long id, long version ) throws Exception
  {
    Class<?> clazz = WorkUnitDurationImpl.class;
    Object instance = clazz.newInstance();

    Field idField = instance.getClass().getSuperclass().getDeclaredField( "id" );
    idField.setAccessible( true );
    idField.set( instance, id );

    Field versionField = instance.getClass().getSuperclass().getDeclaredField( "version" );
    versionField.setAccessible( true );
    versionField.set( instance, version );

    return ( WorkUnitDurationImpl ) instance;
  }
  
  private void processTestSetDuration( LocalDateTime startTime, LocalDateTime endTime, Duration expectedDuration ) {
    WorkUnitDuration objectUnderTest = new WorkUnitDurationImpl();
    
    assertNotNull( objectUnderTest );
    
    objectUnderTest.setDuration( startTime, endTime );
    
    assertEquals( expectedDuration, objectUnderTest.getDuration() );
  }
  
  private void processTestSetDuration( LocalDateTime startTime, Duration duration, Duration expectedDuration ) {
    WorkUnitDuration objectUnderTest = new WorkUnitDurationImpl();
    
    assertNotNull( objectUnderTest );
    
    objectUnderTest.setDuration( startTime, duration );
    
    assertEquals( expectedDuration, objectUnderTest.getDuration() );
  }
  
  @Test
  public void testSetDurationLocalDateTimeLocalDateTimeNoException() {
    LocalDateTime startTime = LocalDateTime.now();
    Duration expectedDuration = Duration.ofMinutes( 23 * 60 + 59 );
    LocalDateTime endTime = startTime.plus(expectedDuration );
    
    assertNotNull( startTime );
    assertNotNull( endTime );
    
    processTestSetDuration( startTime, endTime, expectedDuration );
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testSetDurationLocalDateTimeLocalDateTimeFirstParameterNull() {
    LocalDateTime startTime = LocalDateTime.now();
    Duration expectedDuration = Duration.ofMinutes( 23 * 60 + 59 );
    LocalDateTime endTime = startTime.plus(expectedDuration );
    startTime = null;
    
    assertNull( startTime );
    assertNotNull( endTime );
    
    processTestSetDuration( startTime, endTime, expectedDuration );
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testSetDurationLocalDateTimeLocalDateTimeSecondParameterNull() {
    LocalDateTime startTime = LocalDateTime.now();
    Duration expectedDuration = Duration.ofMinutes( 23 * 60 + 59 );
    LocalDateTime endTime = null;
    
    assertNotNull( startTime );
    assertNull( endTime );
    
    processTestSetDuration( startTime, endTime, expectedDuration );
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testSetDurationLocalDateTimeLocalDateTimeBothParametersNull() {
    LocalDateTime startTime = null;
    Duration expectedDuration = Duration.ofMinutes( 23 * 60 + 59 );
    LocalDateTime endTime = null;
    
    assertNull( startTime );
    assertNull( endTime );
    
    processTestSetDuration( startTime, endTime, expectedDuration );
  }
  
  @Test
  public void testSetDurationLocalDateTimeDurationNoException() {
    LocalDateTime startTime = LocalDateTime.now();
    Duration duration = Duration.ofMinutes( 23 * 60 + 59 );
    Duration expectedDuration = duration;
    
    assertNotNull( startTime );
    assertNotNull( duration );
    
    processTestSetDuration( startTime, duration, expectedDuration );
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testSetDurationLocalDateTimeDurationFirstParameterNull() {
    LocalDateTime startTime = null;
    Duration duration = Duration.ofMinutes( 23 * 60 + 59 );
    Duration expectedDuration = Duration.ZERO;
    
    assertNull( startTime );
    assertNotNull( duration );
    
    processTestSetDuration( startTime, duration, expectedDuration );
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testSetDurationLocalDateTimeDurationSecondParameterNull() {
    LocalDateTime startTime = LocalDateTime.now();
    Duration duration = null;
    Duration expectedDuration = Duration.ZERO;
    
    assertNotNull( startTime );
    assertNull( duration );
    
    processTestSetDuration( startTime, duration, expectedDuration );
  }
  
  @Test(expected = IllegalArgumentException.class)
  public void testSetDurationLocalDateTimeDurationBothParametersNull() {
    LocalDateTime startTime = null;
    Duration duration = null;
    Duration expectedDuration = Duration.ZERO;
    
    assertNull( startTime );
    assertNull( duration );
    
    processTestSetDuration( startTime, duration, expectedDuration );
  }
}
