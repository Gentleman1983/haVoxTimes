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
package net.havox.times.model.api.user;

import java.io.Serializable;

import net.havox.exceptions.GuruMeditationWarning;
import net.havox.times.model.api.ChangeAware;

/**
 * This class defines acredentials.
 *
 * @author Christian Otto
 */
public interface Credential extends ChangeAware, Serializable
{

  /**
   * Returns the username.
   *
   * @return the username.
   */
  String getUsername();

  /**
   * Sets the username.
   *
   * @param username the username.
   *
   * @throws GuruMeditationWarning if the password is empty.
   * @throws GuruMeditationWarning if the username is not valid.
   */
  void setUsername( String username );

  /**
   * Returns the password hash.
   *
   * @return the password hash.
   */
  String getPasswordHash();

  /**
   * Sets the password.
   *
   * @param password the password.
   *
   * @throws GuruMeditationWarning if the password is empty.
   */
  void setPassword( String password );
}
