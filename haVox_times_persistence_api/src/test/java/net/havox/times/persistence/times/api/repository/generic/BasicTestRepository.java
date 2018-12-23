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
package net.havox.times.persistence.times.api.repository.generic;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import net.havox.times.persistence.times.api.repository.AbstractGenericRepositoryTest;
import net.havox.times.persistence.times.api.repository.GenericRepository;

/**
 * Basic implementation of a repository simulating the functionality of a database for usage in basic implementation of
 * {@link AbstractGenericRepositoryTest}.
 *
 * @author Christian Otto
 */
public class BasicTestRepository implements GenericRepository<BasicTestClass>
{

  private long currentId = 1l;
  private Map<Long, BasicTestClass> data;

  public BasicTestRepository()
  {
    super();

    data = new HashMap<>();
  }

  @Override
  public Optional<BasicTestClass> get( Long id )
  {
    Optional<BasicTestClass> result = data.containsKey( id ) ? Optional.of( data.get( id ) ) : Optional.empty();
    return result;
  }

  @Override
  public Set<BasicTestClass> get()
  {
    Set<BasicTestClass> result = new HashSet<>();
    data.values().forEach( date -> result.add( date ) );
    return Collections.unmodifiableSet( result );
  }

  @Override
  public BasicTestClass persist( BasicTestClass entity )
  {
    if ( entity.getId() == null )
    {
      entity.setId( getAndIncrementAutoId() );
    }

    data.put( entity.getId(), entity );

    return entity;
  }

  @Override
  public Optional<BasicTestClass> remove( BasicTestClass entity )
  {
    Optional<BasicTestClass> result;

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
