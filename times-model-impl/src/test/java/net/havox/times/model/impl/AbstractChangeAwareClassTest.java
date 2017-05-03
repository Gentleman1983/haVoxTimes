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
package net.havox.times.model.impl;

import java.util.Random;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractChangeAwareClassTest
{
  private static Random randomGenerator;

  @BeforeClass
  public static void setUpClass()
  {
    randomGenerator = new Random( System.nanoTime() );
  }

  public abstract AbstractChangeAwareClass createNewInstance( Long id, long version ) throws Exception;

  @Test
  public void testEqualsReflexive() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( 2L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance3 = createNewInstance( 3L, randomGenerator.nextLong() );

    assertNotNull( instance1 );
    assertNotNull( instance2 );
    assertNotNull( instance3 );

    assertEquals( instance1, instance1 );
    assertEquals( instance2, instance2 );
    assertEquals( instance3, instance3 );
  }

  @Test
  public void testEqualsSymmetric() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( 1L, randomGenerator.nextLong() );

    assertNotNull( instance1 );
    assertNotNull( instance2 );

    assertEquals( instance1, instance2 );
    assertEquals( instance2, instance1 );
  }

  @Test
  public void testEqualsTransitive() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance3 = createNewInstance( 1L, randomGenerator.nextLong() );

    assertNotNull( instance1 );
    assertNotNull( instance2 );
    assertNotNull( instance3 );

    assertEquals( instance1, instance2 );
    assertEquals( instance2, instance3 );
    assertEquals( instance1, instance3 );
  }

  @Test
  public void testEqualsConsitence() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( 2L, randomGenerator.nextLong() );

    assertNotNull( instance1 );
    assertNotNull( instance2 );

    for ( int i = 0; i < 100; i++ )
    {
      assertEquals( instance1, instance1 );
    }
    for ( int j = 0; j < 100; j++ )
    {
      assertEquals( instance2, instance2 );
    }
    for ( int k = 0; k < 100; k++ )
    {
      assertEquals( instance1, instance1 );
      assertEquals( instance2, instance2 );
    }
  }

  @Test
  public void testEqualsNotEqualsNull() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( 2L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance3 = createNewInstance( 3L, randomGenerator.nextLong() );
    AbstractChangeAwareClass nullInstance = null;

    assertNotNull( instance1 );
    assertNotNull( instance2 );
    assertNotNull( instance3 );
    assertNull( nullInstance );

    assertNotEquals( instance1, nullInstance );
    assertNotEquals( instance2, nullInstance );
    assertNotEquals( instance3, nullInstance );
  }

  @Test
  public void testHashCode() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( 2L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance3 = createNewInstance( 3L, randomGenerator.nextLong() );

    assertNotNull( instance1 );
    assertNotNull( instance2 );
    assertNotNull( instance3 );

    int hashCode1 = instance1.hashCode();
    int hashCode2 = instance2.hashCode();
    int hashCode3 = instance3.hashCode();

    assertNotNull( hashCode1 );
    assertNotNull( hashCode2 );
    assertNotNull( hashCode3 );
  }

  @Test
  public void testHashCodeConsistency() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( 2L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance3 = createNewInstance( 3L, randomGenerator.nextLong() );

    assertNotNull( instance1 );
    assertNotNull( instance2 );
    assertNotNull( instance3 );

    int hashCode1 = instance1.hashCode();
    int hashCode2 = instance2.hashCode();
    int hashCode3 = instance3.hashCode();

    assertNotNull( hashCode1 );
    assertNotNull( hashCode2 );
    assertNotNull( hashCode3 );

    for ( int i = 0; i < 100; i++ )
    {
      assertEquals( hashCode1, instance1.hashCode() );
      assertEquals( hashCode2, instance2.hashCode() );
      assertEquals( hashCode3, instance3.hashCode() );
    }
  }

  @Test
  public void testHashCodeEqualObjects() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( 1L, randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( 1L, randomGenerator.nextLong() );

    assertNotNull( instance1 );
    assertNotNull( instance2 );

    assertEquals( instance1, instance2 );

    int hashCode1 = instance1.hashCode();
    int hashCode2 = instance2.hashCode();

    assertNotNull( hashCode1 );
    assertNotNull( hashCode2 );

    assertEquals( hashCode1, hashCode2 );
  }

  @Test
  public void testIncrementVersion() throws Exception
  {
    AbstractChangeAwareClass instance1 = createNewInstance( randomGenerator.nextLong(), randomGenerator.nextLong() );
    AbstractChangeAwareClass instance2 = createNewInstance( randomGenerator.nextLong(), randomGenerator.nextLong() );

    assertNotNull( instance1 );
    assertNotNull( instance2 );

    long versionInstance1 = instance1.getVersion();
    long versionInstance2 = instance2.getVersion();

    for ( int i = 1; i < 100; i++ )
    {
      instance1.incrementVersion();
      instance2.incrementVersion();

      assertTrue( instance1.getVersion() == versionInstance1 + i );
      assertTrue( instance2.getVersion() == versionInstance2 + i );
    }
  }
}
