/*
 * Copyright (C) 2019 [haVox] Design
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
package net.havox.javatools.test.utils.junit;

import java.text.MessageFormat;
import static org.junit.Assert.*;

import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import org.junit.Test;
import org.junit.runners.BlockJUnit4ClassRunner;
import org.junit.runners.model.InitializationError;
import org.reflections.Configuration;
import org.reflections.Reflections;
import org.reflections.scanners.SubTypesScanner;
import org.reflections.util.ClasspathHelper;
import org.reflections.util.ConfigurationBuilder;

/**
 *
 * @author The_G
 */
public abstract class AbstractInvalidJUnitTestDetector
{

  private static final Logger LOGGER = Logger.getLogger( AbstractInvalidJUnitTestDetector.class.getName() );

  public abstract Set<String> getPackages();

  @Test
  public void testInvalidTests()
  {
    Configuration config = getConfiguration();
    Reflections reflections = new Reflections( config );

    Set<Class<?>> tests = reflections.getSubTypesOf( Object.class );
    Set<Class<?>> brokenTests = tests.stream().filter( clazz -> canRunTestWithClass( clazz ) ).collect( Collectors.toSet() );

    assertTrue( brokenTests.isEmpty() );
  }

  private Configuration getConfiguration()
  {
    Set<String> packageSet = getPackages();
    if ( packageSet == null || packageSet.isEmpty() )
    {
      throw new IllegalStateException( MessageFormat.format( "You have to provide a set of packages to scan but given set was: '{0}'.", packageSet ) );
    }

    ConfigurationBuilder builder = new ConfigurationBuilder();
    for ( String currentPackage : packageSet )
    {
      builder = builder.addUrls( ClasspathHelper.forPackage( currentPackage ) );
    }
    return builder.setScanners( new SubTypesScanner( false ) ).filterInputsBy( this::filterClass );
  }

  private boolean canRunTestWithClass( Class<?> clazz )
  {
    try
    {
      BlockJUnit4ClassRunner blockJUnit4ClassRunner = new BlockJUnit4ClassRunner( clazz );
      LOGGER.log( Level.FINE, "Test class ''{0}'' analyzed and could be initialized.", clazz.getName() );
      return false;
    }
    catch ( InitializationError ie )
    {
      LOGGER.log( Level.SEVERE, "Could not initialize test for class ''{0}''. Cause: {1}", new Object[]
      {
        clazz.getName(), ie.getCauses().get( 0 ).getMessage()
      } );
      return true;
    }
  }

  private boolean filterClass( String className )
  {
    String lowerCaseClassName = className.toLowerCase();
    return lowerCaseClassName.endsWith( "test.class" );
  }
}
