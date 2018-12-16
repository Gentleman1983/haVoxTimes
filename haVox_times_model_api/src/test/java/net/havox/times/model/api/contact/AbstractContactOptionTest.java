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
package net.havox.times.model.api.contact;

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractContactOptionTest
{

  public abstract ContactOption newInstance() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
    
  /**
   * User Story BM006 acceptance criteria 01 ("It consists of a contact type and a value.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyType() throws Exception
  {
    ContactType type = ContactType.values()[ ModelRandomGenerator.randomIntInRange( 0, ContactType.values().length ) ];
    
    ContactOption objectUnderTest = newInstance();
    String value = objectUnderTest.getContactValue();
    objectUnderTest.setValue( type, value);
    assertEquals( value, objectUnderTest.getContactValue() );
    assertEquals( type, objectUnderTest.getType() );
  }
  
  /**
   * User Story BM006 acceptance criteria 01 ("It consists of a contact type and a value.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyValue() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING;
    String value = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    ContactOption objectUnderTest = newInstance();
    ContactType type = objectUnderTest.getType();
    objectUnderTest.setValue( type, value);
    assertEquals( value, objectUnderTest.getContactValue() );
    assertEquals( type, objectUnderTest.getType() );
  }
  
  /**
   * User Story BM006 acceptance criteria 01 ("It consists of a contact type and a value.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyValueAndType() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING;
    String value = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );
    ContactType type = ContactType.values()[ ModelRandomGenerator.randomIntInRange( 0, ContactType.values().length ) ];

    ContactOption objectUnderTest = newInstance();
    objectUnderTest.setValue( type, value);
    assertEquals( value, objectUnderTest.getContactValue() );
    assertEquals( type, objectUnderTest.getType() );
  }
}
