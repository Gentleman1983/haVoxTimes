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
package net.havox.times.model.contacts.impl;

import java.lang.reflect.Field;

import net.havox.times.model.impl.AbstractChangeAwareClass;
import net.havox.times.model.impl.AbstractChangeAwareClassTest;

public class CompanyImplTest extends AbstractChangeAwareClassTest
{
  
  @Override
  public AbstractChangeAwareClass createNewInstance( Long id, long version ) throws Exception
  {
    Class<?> clazz = CompanyImpl.class;
    Object instance = clazz.newInstance();

    Field idField = instance.getClass().getSuperclass().getDeclaredField( "id" );
    idField.setAccessible( true );
    idField.set( instance, id );

    Field versionField = instance.getClass().getSuperclass().getDeclaredField( "version" );
    versionField.setAccessible( true );
    versionField.set( instance, version );

    return ( CompanyImpl ) instance;
  }
}
