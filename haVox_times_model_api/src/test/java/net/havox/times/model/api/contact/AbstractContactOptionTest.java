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
import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Worker;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractContactOptionTest
{

  public abstract ContactOption newInstance() throws Exception;
  public abstract Employer newEmployer() throws Exception;
  public abstract Worker newEmployee() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  
  /**
   * User Story BM015 ({@link Employer}) acceptance criteria 01 ("An employer has a name, address and contact options.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyEmployer() throws Exception
  {
    Employer employer = newEmployer();

    ContactOption objectUnderTest = newInstance();
    objectUnderTest.setEmployer( employer );
    assertEquals( employer, objectUnderTest.getEmployer() );
  }
  
  /**
   * User Story BM002 ({@link Worker}) acceptance criteria 04 ("A worker has got a set of contact options.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyEmployee() throws Exception
  {
    Worker employee = newEmployee();

    ContactOption objectUnderTest = newInstance();
    objectUnderTest.setEmployee( employee );
    assertEquals( employee, objectUnderTest.getEmployee() );
  }
    
  /**
   * User Story BM006 acceptance criteria 01 ("It consists of a contact type and a value.").
   * 
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyType() throws Exception
  {
    ContactType type = ContactType.values()[ ModelRandomGenerator.randomIntInRange( 0, ContactType.values().length - 1 ) ];
    
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
    ContactType type = ContactType.values()[ ModelRandomGenerator.randomIntInRange( 0, ContactType.values().length - 1 ) ];

    ContactOption objectUnderTest = newInstance();
    objectUnderTest.setValue( type, value);
    assertEquals( value, objectUnderTest.getContactValue() );
    assertEquals( type, objectUnderTest.getType() );
  }
}
