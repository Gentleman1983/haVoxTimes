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
import java.time.temporal.ChronoUnit;
import net.havox.test.utils.ExtendedRunner;
import net.havox.test.utils.ModelRandomGenerator;
import net.havox.test.utils.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractTaskTest
{

  public abstract Task newInstance() throws Exception;

  @Test
  @Repeat( 25 )
  public void testModifyName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHANUMERIC_STRING + " -_";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Task objectUnderTest = newInstance();
    objectUnderTest.setName( name );
    assertEquals( name, objectUnderTest.getName() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyDuration() throws Exception
  {
    int hours = ModelRandomGenerator.randomIntInRange( 0, 48 );
    Duration duration = Duration.of( hours, ChronoUnit.HOURS );

    Task objectUnderTest = newInstance();
    objectUnderTest.setDuration( duration );
    assertEquals( duration, objectUnderTest.getDuration() );
  }

  @Test
  public void testHasSubTasks() throws Exception
  {
    Task objectUnderTest = newInstance();

    assertTrue( objectUnderTest.getSubTasks().isEmpty() );
    assertFalse( objectUnderTest.hasSubTasks() );

    Task subTask = newInstance();
    objectUnderTest.getSubTasks().add( subTask );

    assertTrue( subTask.getSubTasks().isEmpty() );
    assertFalse( subTask.hasSubTasks() );

    assertFalse( objectUnderTest.getSubTasks().isEmpty() );
    assertTrue( objectUnderTest.hasSubTasks() );
  }
}
