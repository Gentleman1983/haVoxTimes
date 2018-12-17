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

import java.time.LocalDate;
import java.time.Month;
import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import net.havox.times.model.api.model.BasicAccount;
import org.junit.Test;

import static org.junit.Assert.*;
import org.junit.runner.RunWith;

@RunWith( ExtendedRunner.class )
public abstract class AbstractProjectTest
{

  public abstract Project newInstance() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM008 acceptance criteria 01 ("A project has a name.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyName() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    Project objectUnderTest = newInstance();
    objectUnderTest.setName( name );
    assertEquals( name, objectUnderTest.getName() );
  }

  /**
   * User Story BM008 acceptance criteria 02 ("A project has a start and end date.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyStartDate() throws Exception
  {
    LocalDate periodStart = LocalDate.of( 2000, Month.JANUARY, 1 );
    LocalDate periodEnd = LocalDate.of( 2999, Month.DECEMBER, 31 );
    LocalDate start = ModelRandomGenerator.randomLocalDate( periodStart, periodEnd );

    Project objectUnderTest = newInstance();
    objectUnderTest.setStartDate( start );
    assertEquals( start, objectUnderTest.getStartDate() );
  }

  /**
   * User Story BM008 acceptance criteria 02 ("A project has a start and end date.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyEndDate() throws Exception
  {
    LocalDate periodStart = LocalDate.of( 2000, Month.JANUARY, 1 );
    LocalDate periodEnd = LocalDate.of( 2999, Month.DECEMBER, 31 );
    LocalDate end = ModelRandomGenerator.randomLocalDate( periodStart, periodEnd );

    Project objectUnderTest = newInstance();
    objectUnderTest.setEndDate( end );
    assertEquals( end, objectUnderTest.getEndDate() );
  }

  /**
   * User Story BM008 acceptance criteria 03 ("No start date is set to unlimited past.").
   *
   * @throws Exception
   */
  @Test
  public void testModifyStartDateUnlimitedPast() throws Exception
  {
    LocalDate start = null;
    LocalDate unlimitedPast = LocalDate.MIN;

    Project objectUnderTest = newInstance();
    objectUnderTest.setStartDate( start );
    assertEquals( unlimitedPast, objectUnderTest.getStartDate() );
  }

  /**
   * User Story BM008 acceptance criteria 04 ("No end date is set to unlimited future.").
   *
   * @throws Exception
   */
  @Test
  public void testModifyEndDateUnlimitedFuture() throws Exception
  {
    LocalDate end = null;
    LocalDate unlimitedFuture = LocalDate.MAX;

    Project objectUnderTest = newInstance();
    objectUnderTest.setEndDate( end );
    assertEquals( unlimitedFuture, objectUnderTest.getEndDate() );
  }

  /**
   * User Story BM008 acceptance criteria 05 ("Contains a set of accounts.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyAddAccounts() throws Exception
  {
    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    Account[] accountsToBeAdded = new Account[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      accountsToBeAdded[ i ] = new BasicAccount();
    }

    Project objectUnderTest = newInstance();
    objectUnderTest.addAccounts( accountsToBeAdded );
    for ( Account addedElement : accountsToBeAdded )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of accounts '" ).append( objectUnderTest.getAccounts() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getAccounts().contains( addedElement ) );
    }
  }

  /**
   * User Story BM008 acceptance criteria 05 ("Contains a set of accounts.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyRemoveAccounts() throws Exception
  {
    Account[] accountsToBeAdded = new Account[ 100 ];
    for ( int i = 0; i < 100; i++ )
    {
      accountsToBeAdded[ i ] = new BasicAccount();
    }

    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    Account[] accountsToBeDeleted = new Account[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      accountsToBeAdded[ i ] = new BasicAccount();
    }

    Project objectUnderTest = newInstance();
    objectUnderTest.addAccounts(accountsToBeAdded );
    objectUnderTest.addAccounts(accountsToBeDeleted );
    for ( Account addedElement : accountsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of accounts '" ).append( objectUnderTest.getAccounts() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getAccounts().contains( addedElement ) );
    }
    objectUnderTest.removeAccounts(accountsToBeDeleted );
    for ( Account checkedElement : accountsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of accounts '" ).append( objectUnderTest.getAccounts() )
              .append( "' to contain none of the deleted elements. The value '" ).append( checkedElement )
              .append( "' was found." );
      assertFalse( msg.toString(), objectUnderTest.getAccounts().contains( checkedElement ) );
    }
  }
}
