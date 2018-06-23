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
package net.havox.times.persistence.times.api.repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import net.havox.times.model.api.ChangeAware;

public interface GenericRepository<T extends ChangeAware>
{

  // ******************************************************************************************************************
  // Get entities from database. **************************************************************************************
  // ******************************************************************************************************************
  Optional<T> get( Long id );

  default Set<T> get( Predicate<T> predicate )
  {
    return get()
            .stream()
            .filter( predicate )
            .collect( Collectors.toSet() );
  }

  Set<T> get();

  // ******************************************************************************************************************
  // Update entities on database. *************************************************************************************
  // ******************************************************************************************************************
  void persist( T entity );

  default void persist( T... entities )
  {
    persist( Arrays.asList( entities ) );
  }

  default void persist( Collection<T> entities )
  {
    entities.forEach( this::persist );
  }

  // ******************************************************************************************************************
  // Remove entities from database. ***********************************************************************************
  // ******************************************************************************************************************
  
  // Remove objects by IDs.
  default void remove( Long id )
  {
    remove( entity -> entity.getId().equals( id ) ); // predicate to match the id
  }

  default void remove( Long... ids )
  {
    Arrays.asList( ids ).forEach( this::remove );
  }

  // Remove using the entities.
  void remove( T entity );

  default void remove( T... entities )
  {
    remove( Arrays.asList( entities ) );
  }

  default void remove( Collection<T> entities )
  {
    entities.forEach( this::remove );
  }
  
  // Remove using predicate.
  default void remove( Predicate<T> predicate )
  {
    get( predicate ).forEach( this::remove );
  }
}
