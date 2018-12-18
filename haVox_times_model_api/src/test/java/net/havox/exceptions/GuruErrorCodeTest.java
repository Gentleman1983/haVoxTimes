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
package net.havox.exceptions;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * Basic {@link GuruErrorCode} test.
 *
 * @author Christian Otto
 */
public class GuruErrorCodeTest
{

  @Test
  public void testNoDuplicateErrorCode()
  {
    List<Long> errorCodes = new ArrayList<>();

    for ( GuruErrorCode errorCode : GuruErrorCode.values() )
    {
      long code = errorCode.getErrorCodeAsLong();
      assertThat( errorCodes, not( contains( code ) ) );

      errorCodes.add( code );
    }
  }

  @Test
  public void testNoEmptyErrorCode()
  {
    for ( GuruErrorCode errorCode : GuruErrorCode.values() )
    {
      StringBuilder message = new StringBuilder();

      message.append( "Errorcode '" ).append( errorCode.toString() )
              .append( "' should contain an errorcode, but was '" ).append( errorCode.getErrorCode() ).append( "'." );
      assertNotNull( message.toString(), errorCode.getErrorCode() );
    }
  }

  @Test
  public void testNoEmptyDescription()
  {
    for ( GuruErrorCode errorCode : GuruErrorCode.values() )
    {
      StringBuilder message = new StringBuilder();

      message.append( "Errorcode '" ).append( errorCode.toString() )
              .append( "' should contain an description, but was '" ).append( errorCode.getDescription() )
              .append( "'." );
      assertNotNull( message.toString(), errorCode.getErrorCode() );
    }
  }

  @Test
  public void testCorrectHexErrorCodesLongToHex()
  {
    for ( GuruErrorCode errorCode : GuruErrorCode.values() )
    {
      long currentErrorCode = errorCode.getErrorCodeAsLong();

      assertEquals( "0x" + Long.toHexString( currentErrorCode ), errorCode.getErrorCodeAsHex() );
    }
  }

  @Test
  public void testCorrectHexErrorCodesHexToLong()
  {
    for ( GuruErrorCode errorCode : GuruErrorCode.values() )
    {
      String currentErrorCode = errorCode.getErrorCodeAsHex();
      String currentErrorCodePrefix = currentErrorCode.substring( 0, 2 );
      String currentErrorCodeNumber = currentErrorCode.substring( 2 );

      assertEquals( "0x", currentErrorCodePrefix );
      assertEquals( Long.parseUnsignedLong( currentErrorCodeNumber, 16 ), errorCode.getErrorCodeAsLong() );
    }
  }
}
