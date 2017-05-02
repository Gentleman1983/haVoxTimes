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
 * Master wrapper class for any haVox {@link RuntimeException}.
 * 
 * @author Christian Otto
 */
public class GuruMeditationWarning extends RuntimeException
{
  private static final long serialVersionUID = 381815545100816135L;

  private final GuruErrorCode errorCode;
  
  public GuruMeditationWarning(GuruErrorCode code, String message, Throwable cause) {
    super(message, cause);
    
    this.errorCode = code;
  }
  
  public GuruMeditationWarning(GuruErrorCode code, String message) {
    this(code, message, null);
  }
  
  public GuruErrorCode getErrorCode() {
    return this.errorCode;
  }
}
