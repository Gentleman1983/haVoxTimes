/*
 * Copyright (C) 2018 [haVox] Design
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
package net.havox.times.model.api.address;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;

@RunWith( ExtendedRunner.class )
public abstract class AbstractAddressTest
{

  public abstract Address newInstance() throws Exception;

  public abstract City newCity() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM003 acceptance criteria 01 ("It consists of a street, house number and city.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyStreet() throws Exception
  {
    String alphabet = " -" + ModelRandomGenerator.ALPHABETIC_STRING;
    String streetName = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Address objectUnderTest = newInstance();
    objectUnderTest.setStreet( streetName );
    assertEquals( streetName, objectUnderTest.getStreet() );
  }

  /**
   * User Story BM003 acceptance criteria 01 ("It consists of a street, house number and city.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyHouseNumber() throws Exception
  {
    int number = ModelRandomGenerator.randomIntInRange( 1, 9999 );
    String letter = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 0, 1 ), ModelRandomGenerator.ALPHABETIC_STRING );
    String houseNumber = "" + number + letter;

    Address objectUnderTest = newInstance();
    objectUnderTest.setHouseNumber( houseNumber );
    assertEquals( houseNumber, objectUnderTest.getHouseNumber() );
  }

  /**
   * User Story BM003 acceptance criteria 01 ("It consists of a street, house number and city.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyCity() throws Exception
  {
    City city = newCity();

    Address objectUnderTest = newInstance();
    objectUnderTest.setCity( city );
    assertEquals( city, objectUnderTest.getCity() );
  }
}
