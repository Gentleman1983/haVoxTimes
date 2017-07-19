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
package net.havox.times.persistence.times.api.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenericDAO<TYPE, ID extends Serializable>
{

  TYPE persist( TYPE entity );

  List<TYPE> persistAll( List<TYPE> entities );

  void delete( ID id );

  void delete( TYPE entity );

  void deleteAll( List<TYPE> entities );

  TYPE findByID( ID id );

  List<TYPE> findAll();

  void flush();

  void clear();

  void rollbackTransaction();

  boolean isOpenTransaction();

  void makeTransient( TYPE o );

  int makeTransientAll();

  void openTransaction();

  void closeTransaction();

  Collection<TYPE> getListOfQuery( String query );
}
