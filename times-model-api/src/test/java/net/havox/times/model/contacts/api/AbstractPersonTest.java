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
package net.havox.times.model.contacts.api;

import java.time.LocalDate;
import java.time.Period;
import java.time.temporal.ChronoUnit;

import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractPersonTest
{
  public abstract Person getNewInstance( LocalDate dateOfBirth ) throws Exception;
  public abstract Person getNewInstanceWithNonInitializedDateOfBirth() throws Exception;
  
  @Test
  public void testGetAge() throws Exception {
    Person personBornToday = getNewInstance( LocalDate.now() );
    Person personBornOneHundredYearsAgo = getNewInstance( LocalDate.now().minus( 100, ChronoUnit.YEARS ) );
    
    assertNotNull( personBornToday );
    assertNotNull( personBornOneHundredYearsAgo );
    
    assertEquals( Period.ZERO, personBornToday.getAge() );
    assertEquals( Period.of(100, 0, 0), personBornOneHundredYearsAgo.getAge() );
  }
  
  @Test( expected = IllegalStateException.class )
  public void testGetAgeNotInitialized() throws Exception {
    Person person = getNewInstanceWithNonInitializedDateOfBirth();
    
    person.getAge();
    
    fail( "This should never be reached..." );
  }
  
}
