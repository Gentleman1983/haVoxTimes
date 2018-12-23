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
package net.havox.times.persistence.api.repository;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
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
   *
   * @return the persisted entity.
   */
  T persist( T entity );

  /**
   * Persists several entities.
   *
   * @param entities the entities.
   *
   * @return the persisted entities.
   */
  default Set<T> persist( T... entities )
  {
    return persist( Arrays.asList( entities ) );
  }

  /**
   * Persists several entities.
   *
   * @param entities the entities.
   *
   * @return the persisted entities.
   */
  default Set<T> persist( Collection<T> entities )
  {
    Set<T> result = new CopyOnWriteArraySet<>();
    entities.forEach( entity -> result.add( persist( entity ) ) );
    return result;
  }

  // ******************************************************************************************************************
  // Remove entities from database. ***********************************************************************************
  // ******************************************************************************************************************
  /**
   * Removes an entity by id.
   *
   * @param id the id.
   * 
   * @return the removed entity.
   */
  default Optional<T> remove( Long id )
  {
    Optional<T> element = get( id );

    if ( element.isPresent() )
    {
      remove( element.get() );
    }

    return element;
  }

  /**
   * Removes several entities by id.
   *
   * @param ids the ids.
   * 
   * @return the removed entities.
   */
  default Set<T> remove( Long... ids )
  {
    return remove(
            entity -> Arrays.asList( ids ).contains( entity.getId() ) // Predicate to match the given ids.
    );
  }

  /**
   * Removes an entity.
   *
   * @param entity the entity.
   * 
   * @return the removed entity.
   */
  Optional<T> remove( T entity );

  /**
   * Removes several entites.
   *
   * @param entities the entities.
   * 
   * @return the removed entities.
   */
  default Set<T> remove( T... entities )
  {
    return remove( Arrays.asList( entities ) );
  }

  /**
   * Removes several entities.
   *
   * @param entities the entities.
   * 
   * @return the removed entities.
   */
  default Set<T> remove( Collection<T> entities )
  {
    return remove(
            entity -> entities.contains( entity ) // Predicate to select any entity in entities.
    );
  }

  /**
   * Removes entities using a predicate.
   *
   * @param predicate the predicate.
   * 
   * @return the removed entities.
   */
  default Set<T> remove( Predicate<T> predicate )
  {
    Set<T> result = new CopyOnWriteArraySet<>();
    get( predicate ).forEach( entity ->
    {
      result.add( entity );
      remove( entity );
    } );
    return result;
  }
}
