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
package net.havox.times.model.api.company;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.time.LocalDate;
import java.time.Month;

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;
import net.havox.times.model.api.booking.Project;

@RunWith( ExtendedRunner.class )
public abstract class AbstractEmploymentTest
{

  public abstract Employment newInstance() throws Exception;

  public abstract Employer newEmployer() throws Exception;

  public abstract Worker newEmployee() throws Exception;

  public abstract Project newProject() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM014 acceptance criteria 01 ("It has an employer.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyEmployer() throws Exception
  {
    Employer employer = newEmployer();

    Employment objectUnderTest = newInstance();
    objectUnderTest.setEmployer( employer );
    assertEquals( employer, objectUnderTest.getEmployer() );
  }

  /**
   * User Story BM014 acceptance criteria 02 ("It has an employee, a start and end date and a set of projects.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyEmployee() throws Exception
  {
    Worker employee = newEmployee();

    Employment objectUnderTest = newInstance();
    objectUnderTest.setEmployee( employee );
    assertEquals( employee, objectUnderTest.getEmployee() );
  }

  /**
   * User Story BM014 acceptance criteria 02 ("It has an employee, a start and end date and a set of projects.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testAddProjects() throws Exception
  {
    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    Project[] projectsToBeAdded = new Project[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      projectsToBeAdded[ i ] = newProject();
    }

    Employment objectUnderTest = newInstance();
    objectUnderTest.addProjects( projectsToBeAdded );
    for ( Project addedElement : projectsToBeAdded )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of projects '" ).append( objectUnderTest.getProjects() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getProjects().contains( addedElement ) );
    }
  }

  /**
   * User Story BM014 acceptance criteria 02 ("It has an employee, a start and end date and a set of projects.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testRemoveProjects() throws Exception
  {
    Project[] projectsToBeAdded = new Project[ 100 ];
    for ( int i = 0; i < 100; i++ )
    {
      projectsToBeAdded[ i ] = newProject();
    }

    int elements = ModelRandomGenerator.randomIntInRange( 1, 25 );
    Project[] projectsToBeDeleted = new Project[ elements ];
    for ( int i = 0; i < elements; i++ )
    {
      projectsToBeAdded[ i ] = newProject();
    }

    Employment objectUnderTest = newInstance();
    objectUnderTest.addProjects( projectsToBeAdded );
    objectUnderTest.addProjects( projectsToBeDeleted );
    for ( Project addedElement : projectsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of projects '" ).append( objectUnderTest.getProjects() )
              .append( "' to contain all added elements. The value '" ).append( addedElement )
              .append( "' was not found." );
      assertTrue( msg.toString(), objectUnderTest.getProjects().contains( addedElement ) );
    }
    objectUnderTest.removeProjects( projectsToBeDeleted );
    for ( Project checkedElement : projectsToBeDeleted )
    {
      StringBuilder msg = new StringBuilder();
      msg.append( "Expected List of projects '" ).append( objectUnderTest.getProjects() )
              .append( "' to contain none of the deleted elements. The value '" ).append( checkedElement )
              .append( "' was found." );
      assertFalse( msg.toString(), objectUnderTest.getProjects().contains( checkedElement ) );
    }
  }

  /**
   * User Story BM014 acceptance criteria 02 ("It has an employee, a start and end date and a set of projects.").
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

    Employment objectUnderTest = newInstance();
    objectUnderTest.setStartDate( start );
    assertEquals( start, objectUnderTest.getStartDate() );
  }

  /**
   * User Story BM014 acceptance criteria 02 ("It has an employee, a start and end date and a set of projects.").
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

    Employment objectUnderTest = newInstance();
    objectUnderTest.setEndDate( end );
    assertEquals( end, objectUnderTest.getEndDate() );
  }

  /**
   * User Story BM014 acceptance criteria 03 ("No start date is det if start is the unlimited past.").
   *
   * @throws Exception
   */
  @Test
  public void testModifyStartDateUnlimitedPast() throws Exception
  {
    LocalDate start = null;
    LocalDate unlimitedPast = LocalDate.MIN;

    Employment objectUnderTest = newInstance();
    objectUnderTest.setStartDate( start );
    assertEquals( unlimitedPast, objectUnderTest.getStartDate() );
  }

  /**
   * User Story BM014 acceptance criteria 04 ("No end date is det if start is the unlimited future.").
   *
   * @throws Exception
   */
  @Test
  public void testModifyEndDateUnlimitedFuture() throws Exception
  {
    LocalDate end = null;
    LocalDate unlimitedFuture = LocalDate.MAX;

    Employment objectUnderTest = newInstance();
    objectUnderTest.setEndDate( end );
    assertEquals( unlimitedFuture, objectUnderTest.getEndDate() );
  }
}
