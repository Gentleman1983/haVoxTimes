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
package net.havox.times.persistence.times.api.repository;

import java.util.Arrays;
import java.util.Optional;
import java.util.Set;
import static org.junit.Assert.*;
import org.junit.Test;

import net.havox.times.model.api.ChangeAware;
import static org.hamcrest.Matchers.*;
import org.junit.Before;

/**
 * This is a abstract generic test for a DB repository.
 *
 * @param <T> the data type.
 * @param <R> the repository type for <code>T</code> data type.
 *
 * @author Christian Otto
 */
public abstract class AbstractGenericRepositoryTest<T extends ChangeAware, R extends GenericRepository<T>>
{
  private R repository;

  public abstract T newEntity() throws Exception;

  public abstract R getRepository() throws Exception;
  
  @Before
  public void setUp() throws Exception {
    repository = getRepository();
  }

  @Test
  public void testGenericRepositoryGetEntityById() throws Exception
  {
    T persistedEntity1 = repository.persist( newEntity() );
    Long entityId1 = persistedEntity1.getId();
    T persistedEntity2 = repository.persist( newEntity() );
    Long entityId2 = persistedEntity2.getId();
    T persistedEntity3 = repository.persist( newEntity() );
    Long entityId3 = persistedEntity3.getId();

    Optional<T> searchResult1 = repository.get( entityId1 );
    Optional<T> searchResult2 = repository.get( entityId2 );
    Optional<T> searchResult3 = repository.get( entityId3 );
    Optional<T> searchResult4 = repository.get( Long.MIN_VALUE );

    // Search results 1 - 3 should have a valid result, 4 should not.
    assertTrue( searchResult1.isPresent() );
    assertTrue( searchResult2.isPresent() );
    assertTrue( searchResult3.isPresent() );
    assertFalse( searchResult4.isPresent() );

    // The search results should be correct.
    assertThat( searchResult1.get(), is( equalTo( persistedEntity1 ) ) );
    assertThat( searchResult1.get(), is( not( equalTo( persistedEntity2 ) ) ) );
    assertThat( searchResult1.get(), is( not( equalTo( persistedEntity3 ) ) ) );

    assertThat( searchResult2.get(), is( not( equalTo( persistedEntity1 ) ) ) );
    assertThat( searchResult2.get(), is( equalTo( persistedEntity2 ) ) );
    assertThat( searchResult2.get(), is( not( equalTo( persistedEntity3 ) ) ) );

    assertThat( searchResult3.get(), is( not( equalTo( persistedEntity1 ) ) ) );
    assertThat( searchResult3.get(), is( not( equalTo( persistedEntity2 ) ) ) );
    assertThat( searchResult3.get(), is( equalTo( persistedEntity3 ) ) );
  }

  @Test
  public void testGenericRepositoryGetEntitiesByPredicate() throws Exception
  {
    T persistedEntity1 = repository.persist( newEntity() );
    T persistedEntity2 = repository.persist( newEntity() );
    T persistedEntity3 = repository.persist( newEntity() );

    Set<T> resultSearchPredicate1 = repository.get( entity -> entity.equals( persistedEntity1 ) );
    Set<T> resultSearchPredicate2 = repository.get( entity -> entity.equals( persistedEntity2 ) );
    Set<T> resultSearchPredicate3 = repository.get( entity -> entity.equals( persistedEntity3 ) );

    Set<T> entities = repository.get();

    // All results should not be empty.
    assertThat( persistedEntity1, is( not( nullValue() ) ) );
    assertThat( persistedEntity2, is( not( nullValue() ) ) );
    assertThat( persistedEntity3, is( not( nullValue() ) ) );
    assertThat( resultSearchPredicate1, is( not( nullValue() ) ) );
    assertThat( resultSearchPredicate2, is( not( nullValue() ) ) );
    assertThat( resultSearchPredicate3, is( not( nullValue() ) ) );
    assertThat( entities, is( not( nullValue() ) ) );

    // It should contain the persisted entity.
    assertThat( resultSearchPredicate1, is( not( empty() ) ) );
    assertThat( resultSearchPredicate2, is( not( empty() ) ) );
    assertThat( resultSearchPredicate3, is( not( empty() ) ) );
    assertThat( entities, is( not( empty() ) ) );

    // Only the correct entity should be in the search sets.
    assertThat( resultSearchPredicate1, hasItem( persistedEntity1 ) );
    assertThat( resultSearchPredicate1, not( hasItem( persistedEntity2 ) ) );
    assertThat( resultSearchPredicate1, not( hasItem( persistedEntity3 ) ) );

    assertThat( resultSearchPredicate2, not( hasItem( persistedEntity1 ) ) );
    assertThat( resultSearchPredicate2, hasItem( persistedEntity2 ) );
    assertThat( resultSearchPredicate2, not( hasItem( persistedEntity3 ) ) );

    assertThat( resultSearchPredicate3, not( hasItem( persistedEntity1 ) ) );
    assertThat( resultSearchPredicate3, not( hasItem( persistedEntity2 ) ) );
    assertThat( resultSearchPredicate3, hasItem( persistedEntity3 ) );

    // All should be contained in the complete list.
    assertThat( entities, hasItem( persistedEntity1 ) );
    assertThat( entities, hasItem( persistedEntity2 ) );
    assertThat( entities, hasItem( persistedEntity3 ) );
  }

  @Test
  public void testGenericRepositoryGetAllEntities() throws Exception
  {
    Set<T> entities = repository.get();

    T persistedEntity = repository.persist( newEntity() );

    Set<T> entitiesAfterPersist = repository.get();

    // All results should not be empty.
    assertThat( entities, is( not( nullValue() ) ) );
    assertThat( persistedEntity, is( not( nullValue() ) ) );
    assertThat( entitiesAfterPersist, is( not( nullValue() ) ) );

    // It should contain the persisted entity.
    assertThat( entitiesAfterPersist, is( not( empty() ) ) );

    // Only after persisting the entity we should have the entity contained.
    assertThat( entities, not( hasItem( persistedEntity ) ) );
    assertThat( entitiesAfterPersist, hasItem( persistedEntity ) );
  }

  @Test
  public void testGenericRepositoryPersistEntity() throws Exception
  {
    // Before persisting the element, it should not be found.
    Set<T> entities = repository.get();
    T entityToPersist = newEntity();
    assertThat( entities, not( hasItem( entityToPersist ) ) );

    // After persisting the element, it should be found.
    repository.persist( entityToPersist );
    entities = repository.get();
    assertThat( entities, hasItem( entityToPersist ) );
  }

  @Test
  public void testGenericRepositoryPersistEntityArray() throws Exception
  {
    // Before persisting the elements, they should not be found.
    Set<T> entities = repository.get();
    T entityToPersist1 = newEntity();
    T entityToPersist2 = newEntity();
    T entityToPersist3 = newEntity();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) ) );
    
    // After persisting the elements, all should be found.
    repository.persist( entityToPersist1, entityToPersist2, entityToPersist3 );
    entities = repository.get();
    assertThat( entities, hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) );
  }

  @Test
  public void testGenericRepositoryPersistEntityCollection() throws Exception
  {
    // Before persisting the elements, they should not be found.
    Set<T> entities = repository.get();
    T entityToPersist1 = newEntity();
    T entityToPersist2 = newEntity();
    T entityToPersist3 = newEntity();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) ) );
    
    // After persisting the elements, all should be found.
    repository.persist( Arrays.asList( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    entities = repository.get();
    assertThat( entities, hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) );
  }

  @Test
  public void testGenericRepositoryRemoveEntityById() throws Exception
  {
    T entityToPersist1 = newEntity();
    T entityToPersist2 = newEntity();
    T entityToPersist3 = newEntity();
    repository.persist( Arrays.asList( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    
    // Before deleting any entity all should be present.
    Set<T> entities = repository.get();
    assertThat( entities, hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    
    // The deleted item should not be found.
    repository.remove( entityToPersist1.getId() );
    entities = repository.get();
    assertThat( entities, not( hasItem( entityToPersist1 ) ) );
    assertThat( entities, hasItems( entityToPersist2, entityToPersist3 ) );
    
    // The deleted item should not be found.
    repository.remove( entityToPersist2.getId() );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2 ) ) );
    assertThat( entities, hasItem( entityToPersist3 ) );
    
    // The deleted item should not be found.
    repository.remove( entityToPersist3.getId() );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) ) );
  }

  @Test
  public void testGenericRepositoryRemoveEntitiesByIds() throws Exception
  {
    T entityToPersist1 = newEntity();
    T entityToPersist2 = newEntity();
    T entityToPersist3 = newEntity();
    T entityToPersist4 = newEntity();
    T entityToPersist5 = newEntity();
    repository.persist( Arrays.asList( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) );
    
    // Before deleting any entity all should be present.
    Set<T> entities = repository.get();
    assertThat( entities, hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    
    // The deleted items should not be found.
    repository.remove( entityToPersist1.getId(), entityToPersist2.getId() );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2 ) ) );
    assertThat( entities, hasItems( entityToPersist3, entityToPersist4, entityToPersist5 ) );
    
    // The deleted items should not be found.
    repository.remove( entityToPersist3.getId(), entityToPersist4.getId(), entityToPersist5.getId() );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) ) );
  }

  @Test
  public void testGenericRepositoryRemoveEntity() throws Exception
  {
    T entityToPersist1 = newEntity();
    T entityToPersist2 = newEntity();
    T entityToPersist3 = newEntity();
    repository.persist( Arrays.asList( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    
    // Before deleting any entity all should be present.
    Set<T> entities = repository.get();
    assertThat( entities, hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    
    // The deleted item should not be found.
    repository.remove( entityToPersist1 );
    entities = repository.get();
    assertThat( entities, not( hasItem( entityToPersist1 ) ) );
    assertThat( entities, hasItems( entityToPersist2, entityToPersist3 ) );
    
    // The deleted item should not be found.
    repository.remove( entityToPersist2 );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2 ) ) );
    assertThat( entities, hasItem( entityToPersist3 ) );
    
    // The deleted item should not be found.
    repository.remove( entityToPersist3 );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) ) );
  }

  @Test
  public void testGenericRepositoryRemoveEntityArray() throws Exception
  {
    T entityToPersist1 = newEntity();
    T entityToPersist2 = newEntity();
    T entityToPersist3 = newEntity();
    T entityToPersist4 = newEntity();
    T entityToPersist5 = newEntity();
    repository.persist( Arrays.asList( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) );
    
    // Before deleting any entity all should be present.
    Set<T> entities = repository.get();
    assertThat( entities, hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    
    // The deleted items should not be found.
    repository.remove( entityToPersist1, entityToPersist2 );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2 ) ) );
    assertThat( entities, hasItems( entityToPersist3, entityToPersist4, entityToPersist5 ) );
    
    // The deleted items should not be found.
    repository.remove( entityToPersist3, entityToPersist4, entityToPersist5 );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) ) );
  }

  @Test
  public void testGenericRepositoryRemoveEntityCollection() throws Exception
  {
    T entityToPersist1 = newEntity();
    T entityToPersist2 = newEntity();
    T entityToPersist3 = newEntity();
    T entityToPersist4 = newEntity();
    T entityToPersist5 = newEntity();
    repository.persist( Arrays.asList( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) );
    
    // Before deleting any entity all should be present.
    Set<T> entities = repository.get();
    assertThat( entities, hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    
    // The deleted items should not be found.
    repository.remove( Arrays.asList( entityToPersist1, entityToPersist2 ) );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2 ) ) );
    assertThat( entities, hasItems( entityToPersist3, entityToPersist4, entityToPersist5 ) );
    
    // The deleted items should not be found.
    repository.remove( Arrays.asList( entityToPersist3, entityToPersist4, entityToPersist5 ) );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) ) );
  }

  @Test
  public void testGenericRepositoryRemoveEntitiesByPredicate() throws Exception
  {
    T entityToPersist1 = newEntity();
    T entityToPersist2 = newEntity();
    T entityToPersist3 = newEntity();
    T entityToPersist4 = newEntity();
    T entityToPersist5 = newEntity();
    repository.persist( Arrays.asList( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) );
    
    // Before deleting any entity all should be present.
    Set<T> entities = repository.get();
    assertThat( entities, hasItems( entityToPersist1, entityToPersist2, entityToPersist3 ) );
    
    // The deleted items should not be found.
    repository.remove( entity -> entity.equals( entityToPersist1 ) );
    entities = repository.get();
    assertThat( entities, not( hasItem( entityToPersist1 ) ) );
    assertThat( entities, hasItems( entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) );
    
    // The deleted items should not be found.
    repository.remove( entity -> Arrays.asList( entityToPersist2, entityToPersist3, entityToPersist5 ).contains( entity ) );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist5 ) ) );
    assertThat( entities, hasItem( entityToPersist4 ) );
    
    // The deleted items should not be found.
    repository.remove( entity -> entity.equals( entityToPersist4 ) );
    entities = repository.get();
    assertThat( entities, not( hasItems( entityToPersist1, entityToPersist2, entityToPersist3, entityToPersist4, entityToPersist5 ) ) );
  }
}
