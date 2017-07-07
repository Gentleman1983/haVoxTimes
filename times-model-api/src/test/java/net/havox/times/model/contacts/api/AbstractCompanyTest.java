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

import net.havox.test.utils.ExtendedRunner;
import net.havox.test.utils.ModelRandomGenerator;
import net.havox.test.utils.Repeat;
import org.junit.Test;

import static org.junit.Assert.*;
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

  @Test( expected = IllegalStateException.class )
  public void testHasSubcompaniesNotInitialized() throws Exception
  {
    Company company = getNewInstanceWithUninitializedSubCompanyValue();

    company.hasSubCompanies();

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
