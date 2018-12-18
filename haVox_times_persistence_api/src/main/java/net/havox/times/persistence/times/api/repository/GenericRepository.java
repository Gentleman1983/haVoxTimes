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

/**
 * This represents a generic entity repository.
 *
 * @param <T> the entity type.
 *
 * @author Christian Otto
 */
public interface GenericRepository<T extends ChangeAware>
{

  // ******************************************************************************************************************
  // Get entities from database. **************************************************************************************
  // ******************************************************************************************************************
  /**
   * Returns an entity by id.
   *
   * @param id the id.
   *
   * @return the entity.
   */
  Optional<T> get( Long id );

  /**
   * Returns a set of entities by predicate.
   *
   * @param predicate the predicate.
   *
   * @return the set of entities.
   */
  default Set<T> get( Predicate<T> predicate )
  {
    return get()
            .stream()
            .filter( predicate )
            .collect( Collectors.toSet() );
  }

  /**
   * Returns all entities.
   *
   * @return all entities.
   */
  Set<T> get();

  // ******************************************************************************************************************
  // Update entities on database. *************************************************************************************
  // ******************************************************************************************************************
  /**
   * Persists a given entity.
   *
   * @param entity the entity.
   */
  void persist( T entity );

  /**
   * Persists several entities.
   *
   * @param entities the entities.
   */
  default void persist( T... entities )
  {
    persist( Arrays.asList( entities ) );
  }

  /**
   * Persists several entities.
   *
   * @param entities the entities.
   */
  default void persist( Collection<T> entities )
  {
    entities.forEach( this::persist );
  }

  // ******************************************************************************************************************
  // Remove entities from database. ***********************************************************************************
  // ******************************************************************************************************************
  /**
   * Removes an entity by id.
   *
   * @param id the id.
   */
  default void remove( Long id )
  {
    remove( entity -> entity.getId().equals( id ) ); // predicate to match the id
  }

  /**
   * Removes several entities by id.
   *
   * @param ids the ids.
   */
  default void remove( Long... ids )
  {
    Arrays.asList( ids ).forEach( this::remove );
  }

  /**
   * Removes an entity.
   *
   * @param entity the entity.
   */
  void remove( T entity );

  /**
   * Removes several entites.
   *
   * @param entities the entities.
   */
  default void remove( T... entities )
  {
    remove( Arrays.asList( entities ) );
  }

  /**
   * Removes several entities.
   *
   * @param entities the entities.
   */
  default void remove( Collection<T> entities )
  {
    entities.forEach( this::remove );
  }

  /**
   * Removes entities using a predicate.
   *
   * @param predicate the predicate.
   */
  default void remove( Predicate<T> predicate )
  {
    get( predicate ).forEach( this::remove );
  }
}
