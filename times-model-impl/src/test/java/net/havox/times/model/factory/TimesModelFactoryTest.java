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
package net.havox.times.model.factory;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import net.havox.times.model.times.api.Employment;
import net.havox.times.model.times.api.Issue;
import net.havox.times.model.times.api.Project;
import net.havox.times.model.times.api.Task;
import net.havox.times.model.times.api.WorkDay;
import net.havox.times.model.times.api.WorkUnit;
import net.havox.times.model.times.api.WorkUnitDuration;
import net.havox.times.model.times.impl.EmploymentImpl;
import net.havox.times.model.times.impl.IssueImpl;
import net.havox.times.model.times.impl.ProjectImpl;
import net.havox.times.model.times.impl.TaskImpl;
import net.havox.times.model.times.impl.WorkDayImpl;
import net.havox.times.model.times.impl.WorkUnitDurationImpl;
import net.havox.times.model.times.impl.WorkUnitImpl;

import org.junit.BeforeClass;
import org.junit.Test;

/**
 * @author Christian Otto
 */
public class TimesModelFactoryTest
{
  public static TimesModelFactory factory;
  
  @BeforeClass
  public static void setupClass() {
    factory = TimesModelFactory.getInstance();
  }
    
  @Test
  public void testGetInstance() {
    Object instanceUnderTest = TimesModelFactory.getInstance();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( TimesModelFactory.class ) ) );
  }
  
  @Test
  public void testGetNewEmployment() {
    Employment instanceUnderTest = factory.getNewEmployment();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( EmploymentImpl.class ) ) );
  }
  
  @Test
  public void testGetNewIssue() {
    Issue instanceUnderTest = factory.getNewIssue();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( IssueImpl.class ) ) );
  }
  
  @Test
  public void testGetNewProject() {
    Project instanceUnderTest = factory.getNewProject();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( ProjectImpl.class ) ) );
  }
  
  @Test
  public void testGetNewTask() {
    Task instanceUnderTest = factory.getNewTask();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( TaskImpl.class ) ) );
  }
  
  @Test
  public void testGetNewWorkDay() {
    WorkDay instanceUnderTest = factory.getNewWorkDay();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( WorkDayImpl.class ) ) );
  }
  
  @Test
  public void testGetNewWorkUnitDuration() {
    WorkUnitDuration instanceUnderTest = factory.getNewWorkUnitDuration();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( WorkUnitDurationImpl.class ) ) );
  }
  
  @Test
  public void testGetNewWorkUnit() {
    WorkUnit instanceUnderTest = factory.getNewWorkUnit();
    
    // Is the instance initialized?
    assertThat ( instanceUnderTest, is ( notNullValue () ) );
    
    // Is the instance of the correct type?
    assertThat ( instanceUnderTest, is ( instanceOf ( WorkUnitImpl.class ) ) );
  }
}
