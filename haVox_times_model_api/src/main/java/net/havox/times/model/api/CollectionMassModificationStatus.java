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
package net.havox.times.model.api;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * This class is used to display the status of a mass modification of a {@link Collection}.
 *
 * @param <T> the type of collection.
 *
 * @author Christian Otto
 */
public class CollectionMassModificationStatus<T>
{

  private List<T> successfulElements;
  private List<T> unsuccessfulElements;

  /**
   * Creates an instance with empty result set.
   */
  public CollectionMassModificationStatus()
  {
    super();

    this.successfulElements = new ArrayList<>();
    this.unsuccessfulElements = new ArrayList<>();
  }

  /**
   * Creates an instance with lists of successful and unsuccessful elements.
   *
   * @param successful the successful elements.
   * @param unsuccessful the unsuccessful elements.
   */
  public CollectionMassModificationStatus( Collection<T> successful, Collection<T> unsuccessful )
  {
    this();

    successfulElements.addAll( successful );
    unsuccessfulElements.addAll( unsuccessful );
  }

  /**
   * Was the modification successful on all elements?
   *
   * @return true, if no elements were unsuccessful.
   */
  public boolean wasSuccessful()
  {
    return unsuccessfulElements.isEmpty();
  }

  /**
   * Adds successful elements.
   *
   * @param elements the elements.
   */
  public void addSuccessfulElements( T... elements )
  {
    Arrays.asList( elements );
  }

  /**
   * Adds successful elements.
   *
   * @param elements the elements.
   */
  public void addSuccessfulElements( Collection<T> elements )
  {
    elements.forEach( successfulElements::add );
  }

  /**
   * Adds unsuccessful elements.
   *
   * @param elements the elements.
   */
  public void addUnsuccessfulElements( T... elements )
  {
    Arrays.asList( elements );
  }

  /**
   * Adds unsuccessful elements.
   *
   * @param elements the elements.
   */
  public void addUnsuccessfulElements( Collection<T> elements )
  {
    elements.forEach( unsuccessfulElements::add );
  }

  /**
   * Returns the successful elements.
   *
   * @return the elements.
   */
  public List<T> getSuccessfulElements()
  {
    return Collections.unmodifiableList( successfulElements );
  }

  /**
   * Returns the unsuccessful elements.
   *
   * @return the elements.
   */
  public List<T> getUnsuccessfulElements()
  {
    return Collections.unmodifiableList( unsuccessfulElements );
  }
}
