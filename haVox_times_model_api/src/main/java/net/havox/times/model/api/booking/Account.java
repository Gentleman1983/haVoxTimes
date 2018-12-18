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
package net.havox.times.model.api.booking;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Set;

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.CollectionMassModificationStatus;

/**
 * This interface represents an account.
 *
 * @author Christian Otto
 */
public interface Account extends ChangeAware, Serializable
{

  /**
   * Returns the project.
   *
   * @return the project.
   */
  Project getProject();

  /**
   * Sets the project.
   *
   * @param project the project.
   */
  void setProject( Project project );

  /**
   * Returns the account name.
   *
   * @return the name.
   */
  String getName();

  /**
   * Sets the account name.
   *
   * @param name the name.
   */
  void setName( String name );

  /**
   * Returns the start date.
   *
   * @return the start.
   */
  LocalDate getStartDate();

  /**
   * Sets the start date.
   *
   * @param start the start.
   */
  void setStartDate( LocalDate start );

  /**
   * Returns the end date.
   *
   * @return the end.
   */
  LocalDate getEndDate();

  /**
   * Sets the end date.
   *
   * @param end the end.
   */
  void setEndDate( LocalDate end );

  /**
   * Returns the account budget.
   *
   * @return the budget.
   */
  Long getBudget();

  /**
   * Sets the account budget.
   *
   * @param budget the budget.
   */
  void setBudget( Long budget );

  /**
   * Returns the account bookings.
   *
   * @return the bookings.
   */
  Set<Booking> getBookings();

  /**
   * Adds bookings to the account.
   *
   * @param bookings the bookings.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<Booking> addBookings( Booking... bookings );

  /**
   * Removes bookings to the account.
   *
   * @param bookings the bookings.
   *
   * @return the status.
   */
  CollectionMassModificationStatus<Booking> removeBookings( Booking... bookings );
}
