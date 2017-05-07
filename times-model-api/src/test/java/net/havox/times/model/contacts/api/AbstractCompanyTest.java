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

import org.junit.Test;

import static org.junit.Assert.*;

public abstract class AbstractCompanyTest
{
  public abstract Company getNewInstance(Company... subCompanies) throws Exception;
  public abstract Company getNewInstanceWithUninitializedSubCompanyValue() throws Exception;
  
  @Test
  public void testHasSubcompanies() throws Exception {
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
  
  @Test(expected = IllegalStateException.class)
  public void testHasSubcompaniesNotInitialized() throws Exception {
    Company company = getNewInstanceWithUninitializedSubCompanyValue();
    
    company.hasSubCompanies();
    
    fail( "This should never be reached..." );
  }
}
