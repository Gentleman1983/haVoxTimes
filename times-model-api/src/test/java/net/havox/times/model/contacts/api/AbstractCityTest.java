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

import net.havox.times.model.api.ExtendedRunner;
import net.havox.times.model.api.ModelRandomGenerator;
import net.havox.times.model.api.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractCityTest
{
  public abstract City newInstance() throws Exception;
  public abstract Country newCountry() throws Exception;
  
  @Test
  @Repeat( 25 )
  public void testModifyZipCode() throws Exception {
    String zipCode = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 4, 8 ), ModelRandomGenerator.ALPHANUMERIC_STRING );
    
    City objectUnderTest = newInstance();
    objectUnderTest.setZipCode( zipCode );
    assertEquals( zipCode, objectUnderTest.getZipCode() );
  }
  
  @Test
  @Repeat( 25 )
  public void testModifyName() throws Exception {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );
    
    City objectUnderTest = newInstance();
    objectUnderTest.setName( name );
    assertEquals( name, objectUnderTest.getName() );
  }
  
  @Test
  @Repeat( 25 )
  public void testModifyCounty() throws Exception {
    Country country = newCountry();
    
    City objectUnderTest = newInstance();
    objectUnderTest.setCountry( country );
    assertEquals( country, objectUnderTest.getCountry() );
  }
}
