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
package net.havox.times.model.factory;

import net.havox.times.model.contacts.api.Address;
import net.havox.times.model.contacts.api.City;
import net.havox.times.model.contacts.api.Company;
import net.havox.times.model.contacts.api.Country;
import net.havox.times.model.contacts.api.Person;
import net.havox.times.model.contacts.impl.AddressImpl;
import net.havox.times.model.contacts.impl.CityImpl;
import net.havox.times.model.contacts.impl.CompanyImpl;
import net.havox.times.model.contacts.impl.CountryImpl;
import net.havox.times.model.contacts.impl.PersonImpl;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Christian Otto
 */
public class ContactsModelFactoryTest
{
  public static ContactsModelFactory factory;
  
  @BeforeClass
  public static void setupClass() {
    factory = ContactsModelFactory.getInstance();
  }
    
  @Test
  public void testGetInstance() {
    Object instanceUnderTest = ContactsModelFactory.getInstance();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( ContactsModelFactory.class ) ) );
  }
  
  @Test
  public void testGetNewAddress() {
    Address instanceUnderTest = factory.getNewAddress();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( AddressImpl.class ) ) );
  }
  
  @Test
  public void testGetNewCity() {
    City instanceUnderTest = factory.getNewCity();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( CityImpl.class ) ) );
  }
  
  @Test
  public void testGetNewCompany() {
    Company instanceUnderTest = factory.getNewCompany();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( CompanyImpl.class ) ) );
  }
  
  @Test
  public void testGetNewCountry() {
    Country instanceUnderTest = factory.getNewCountry();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( CountryImpl.class ) ) );
  }
  
  @Test
  public void testGetNewPerson() {
    Person instanceUnderTest = factory.getNewPerson();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( PersonImpl.class ) ) );
  }
}
