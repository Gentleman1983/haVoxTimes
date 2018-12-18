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
package net.havox.times.model.api.booking;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;

@RunWith( ExtendedRunner.class )
public abstract class AbstractBookingReferenceTypeTest
{

  public abstract BookingReferenceType newInstance() throws Exception;

  public abstract Project newProject() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM011 acceptance criteria 01 ("They are project specific.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyType() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingReferenceType objectUnderTest = newInstance();
    objectUnderTest.setType( name );
    assertEquals( name, objectUnderTest.getType() );
  }

  /**
   * User Story BM011 acceptance criteria 01 ("They are project specific.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyProject() throws Exception
  {
    Project project = newProject();

    BookingReferenceType objectUnderTest = newInstance();
    objectUnderTest.setProject( project );
    assertEquals( project, objectUnderTest.getProject() );
  }

  /**
   * User Story BM011 acceptance criteria 02 ("They have a given prefix and suffix.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testHasPrefix() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String prefix = ModelRandomGenerator.randomBoolean() ? ""
            : ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingReferenceType objectUnderTest = newInstance();
    objectUnderTest.setPrefix( prefix );
    assertNotEquals( "".equals( prefix ), objectUnderTest.hasPrefix() );
  }

  /**
   * User Story BM011 acceptance criteria 02 ("They have a given prefix and suffix.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyPrefix() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String prefix = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingReferenceType objectUnderTest = newInstance();
    objectUnderTest.setPrefix( prefix );
    assertEquals( prefix, objectUnderTest.getPrefix() );
  }

  /**
   * User Story BM011 acceptance criteria 02 ("They have a given prefix and suffix.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testHasSuffix() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String suffix = ModelRandomGenerator.randomBoolean() ? ""
            : ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingReferenceType objectUnderTest = newInstance();
    objectUnderTest.setSuffix( suffix );
    assertNotEquals( "".equals( suffix ), objectUnderTest.hasSuffix() );
  }

  /**
   * User Story BM011 acceptance criteria 02 ("They have a given prefix and suffix.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifySuffix() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String suffix = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingReferenceType objectUnderTest = newInstance();
    objectUnderTest.setSuffix( suffix );
    assertEquals( suffix, objectUnderTest.getSuffix() );
  }

  /**
   * User Story BM011 acceptance criteria 03 ("They have a given validation pattern.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyValidationPattern() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String pattern = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingReferenceType objectUnderTest = newInstance();
    objectUnderTest.setValidationPattern( pattern );
    assertEquals( pattern, objectUnderTest.getValidationPattern() );
  }

  /**
   * User Story BM011 acceptance criteria 04 ("They have an optional external reference.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyExternalReference() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String reference = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingReferenceType objectUnderTest = newInstance();
    objectUnderTest.setExternalReference( reference );
    assertEquals( reference, objectUnderTest.getExternalReference() );
  }
}
