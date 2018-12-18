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
package net.havox.times.model.impl.contact;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.Field;

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.junit.Repeat;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.times.model.api.contact.ContactOption;
import net.havox.times.model.api.contact.ContactType;
import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.impl.AbstractChangeAwareClassTest;

/**
 * Implementation specific tests for {@link ContactOption}.
 *
 * @author Christian Otto
 */
@RunWith( ExtendedRunner.class )
public class ContactOptionImplTest extends AbstractChangeAwareClassTest
{

  @Override
  public AbstractChangeAwareClass createNewInstance( Long id, long version ) throws Exception
  {
    Class<?> clazz = ContactOptionImpl.class;
    Object instance = clazz.newInstance();

    Field idField = instance.getClass().getSuperclass().getDeclaredField( "id" );
    idField.setAccessible( true );
    idField.set( instance, id );

    Field versionField = instance.getClass().getSuperclass().getDeclaredField( "version" );
    versionField.setAccessible( true );
    versionField.set( instance, version );

    return ( ContactOptionImpl ) instance;
  }

  /**
   * This test tests the constructor without parameters.
   *
   * @throws Exception
   */
  @Test
  public void testConstructor() throws Exception
  {
    ContactType expectedType = null;
    String expectedValue = "";

    ContactOption objectUnderTest = null;

    assertNull( objectUnderTest );

    objectUnderTest = new ContactOptionImpl();

    assertNotNull( objectUnderTest );
    assertEquals( expectedType, objectUnderTest.getType() );
    assertEquals( expectedValue, objectUnderTest.getContactValue() );
  }

  /**
   * This test tests the constructor with type parameter.
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testConstructorType() throws Exception
  {
    ContactType type = ContactType.values()[ ModelRandomGenerator.randomIntInRange( 0, ContactType.values().length - 1 ) ];
    String expectedValue = "";

    ContactOption objectUnderTest = null;

    assertNull( objectUnderTest );

    objectUnderTest = new ContactOptionImpl( type );

    assertNotNull( objectUnderTest );
    assertEquals( type, objectUnderTest.getType() );
    assertEquals( expectedValue, objectUnderTest.getContactValue() );
  }

  /**
   * This test tests the constructor with type and value parameters.
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testConstructorValueAndType() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING;
    String value = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );
    ContactType type = ContactType.values()[ ModelRandomGenerator.randomIntInRange( 0, ContactType.values().length - 1 ) ];

    ContactOption objectUnderTest = null;

    assertNull( objectUnderTest );

    objectUnderTest = new ContactOptionImpl( type, value );

    assertNotNull( objectUnderTest );
    assertEquals( type, objectUnderTest.getType() );
    assertEquals( value, objectUnderTest.getContactValue() );
  }
}
