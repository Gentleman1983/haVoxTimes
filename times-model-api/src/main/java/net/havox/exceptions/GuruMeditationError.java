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
 * Master wrapper class for any haVox Design {@link Error}.
 * 
 * @author Christian Otto
 */
public class GuruMeditationError extends Error
{
  private static final long serialVersionUID = -1479564798304421989L;

  private final GuruErrorCode errorCode;
  
  /**
   * Constructs a new error with the specified detail message and cause.
   * 
   * @param code the error code.
   * @param message the detail message (which is saved for later retrieval by the {@link Error.getMessage()} method).
   * @param cause the cause (which is saved for later retrieval by the {@link Error.getCause()} method). (A null value 
   *              is permitted, and indicates that the cause is nonexistent or unknown.)
   */
  public GuruMeditationError(GuruErrorCode code, String message, Throwable cause) {
    super(message, cause);
    
    this.errorCode = code;
  }
  
  /**
   * Constructs a new error with the specified detail message.
   * 
   * @param code the error code.
   * @param message the detail message (which is saved for later retrieval by the {@link Error.getMessage()} method).
   */
  public GuruMeditationError(GuruErrorCode code, String message) {
    this(code, message, null);
  }
  
  /**
   * Grands access to the {@link GuruErrorCode} of this error.
   * 
   * @return the error code.
   */
  public GuruErrorCode getErrorCode() {
    return this.errorCode;
  }
}
