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

import static net.havox.exceptions.GuruErrorCode.ILLEGAL_STATE;

import static org.junit.Assert.*;

import net.havox.exceptions.GuruMeditationWarning;
import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;

import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractCompanyTest
{

  public abstract Company getNewInstance( Company... subCompanies ) throws Exception;

  public abstract Company getNewInstanceWithUninitializedSubCompanyValue() throws Exception;

  public abstract Address getNewAddress() throws Exception;

  @Test
  public void testHasSubcompanies() throws Exception
  {
    Company companyWithoutSubCompanies = getNewInstance();
    Company subCompanies1 = getNewInstance();
    Company subCompanies2 = getNewInstance();
    Company subCompanies3 = getNewInstance( subCompanies2 );
    Company companyWithSubCompanies = getNewInstance( subCompanies1, subCompanies2, subCompanies3 );

    assertNotNull( companyWithoutSubCompanies );
    assertNotNull( companyWithSubCompanies );

    assertFalse( companyWithoutSubCompanies.hasSubCompanies() );
    assertTrue( companyWithSubCompanies.hasSubCompanies() );
  }

  @Test( expected = GuruMeditationWarning.class )
  public void testHasSubcompaniesNotInitialized() throws Exception
  {
    Company company = getNewInstanceWithUninitializedSubCompanyValue();

    try
    {
      company.hasSubCompanies();
    }
    catch ( GuruMeditationWarning gmw )
    {
      assertEquals( ILLEGAL_STATE, gmw.getErrorCode() );
      throw gmw;
    }

    fail( "This should never be reached..." );
  }

  @Test
  @Repeat( 25 )
  public void testModifyName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Company objectUnderTest = getNewInstance();
    objectUnderTest.setName( name );
    assertEquals( name, objectUnderTest.getName() );
  }

  @Test
  @Repeat( 25 )
  public void testModifyAddress() throws Exception
  {
    Address address = getNewAddress();

    Company objectUnderTest = getNewInstance();
    objectUnderTest.setAddress( address );
    assertEquals( address, objectUnderTest.getAddress() );
  }
}
