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

/**
 *
 * @author Christian Otto
 */
public enum GuruErrorCode
{
  // *******************************************************************************************************************
  // * Warning codes starting by 0x0 to 0x3! ***************************************************************************
  // *******************************************************************************************************************
  @Deprecated
  DEFAULT_WARNING( 0x0000000000000000L, "This should not be used." ),
  /**
   * The application let to an illegal state.
   */
  ILLEGAL_STATE( 0x0000000000000001L, "The application let to an illegal state." ),
  /**
   * One or more arguments have invalid values.
   */
  ILLEGAL_ARGUMENT( 0x0000000000000002L, "One or more arguments have invalid values." ),
  // *******************************************************************************************************************
  // * Exception codes starting by 0x4 to 0xC! *************************************************************************
  // *******************************************************************************************************************
  @Deprecated
  DEFAULT_EXCEPTION( 0x4000000000000000L, "This should not be used." ),
  // *******************************************************************************************************************
  // * Error codes starting by 0xD to 0xF! *****************************************************************************
  // *******************************************************************************************************************
  @Deprecated
  DEFAULT_ERROR( 0xD000000000000000L, "This should not be used" );

  private final long errorCode;
  private final String description;

  private GuruErrorCode( long code, String desc )
  {
    this.errorCode = code;
    this.description = desc;
  }

  public String getErrorCode()
  {
    return this.getErrorCodeAsHex();
  }

  public String getErrorCodeAsHex()
  {
    return "0x" + Long.toHexString( this.errorCode );
  }

  public long getErrorCodeAsLong()
  {
    return this.errorCode;
  }

  public String getDescription()
  {
    return this.description;
  }
}
