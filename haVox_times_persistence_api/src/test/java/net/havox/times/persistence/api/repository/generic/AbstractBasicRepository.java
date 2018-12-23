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
package net.havox.times.persistence.api.repository.generic;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.persistence.api.repository.GenericRepository;

/**
 * Basic implementation of a repository simulating the functionality of a database.
 *
 * @param <T> the entity type.
 *
 * @author Christian Otto
 */
public abstract class AbstractBasicRepository<T extends ChangeAware> implements GenericRepository<T>
{

  private long currentId = 1l;
  private Map<Long, T> data = new HashMap<>();

  @Override
  public Optional<T> get( Long id )
  {
    Optional<T> result = data.containsKey( id ) ? Optional.of( data.get( id ) ) : Optional.empty();
    return result;
  }

  @Override
  public Set<T> get()
  {
    Set<T> result = new HashSet<>();
    data.values().forEach( date -> result.add( date ) );
    return Collections.unmodifiableSet( result );
  }

  @Override
  public T persist( T entity )
  {
    if ( entity.getId() == null )
    {
      entity.setId( getAndIncrementAutoId() );
    }

    data.put( entity.getId(), entity );

    return entity;
  }

  @Override
  public Optional<T> remove( T entity )
  {
    Optional<T> result;

    if ( data.containsKey( entity.getId() ) )
    {
      data.remove( entity.getId() );
      result = Optional.of( entity );
    }
    else
    {
      result = Optional.empty();
    }
    return result;
  }

  private long getAndIncrementAutoId()
  {
    if ( !data.isEmpty() && dataMaxIdGreaterThanOrEqualCurrentId() )
    {
      currentId = getMaxDataId() + 1;
    }

    return currentId++;
  }

  private long getMaxDataId()
  {
    return Collections.max( data.keySet() );
  }

  private boolean dataMaxIdGreaterThanOrEqualCurrentId()
  {
    return getMaxDataId() >= currentId;
  }
}
