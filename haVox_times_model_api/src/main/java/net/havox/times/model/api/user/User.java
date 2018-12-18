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
import net.havox.times.model.api.company.Worker;

/**
 * This class defines an application user.
 *
 * @author Christian Otto
 */
public interface User extends ChangeAware, Serializable
{

  /**
   * Returns the mail address.
   *
   * @return the mail address.
   */
  String getEmailAddress();

  /**
   * Sets a new mail address.
   *
   * @param emailAddress the new email address.
   *
   * @throws GuruMeditationWarning if the password is empty.
   * @throws GuruMeditationWarning if email address is not valid.
   */
  void setEmailAddress( String emailAddress );

  /**
   * Returns the user credentials.
   *
   * @return the user credentials.
   */
  Credential getCredentials();

  /**
   * Returns the corresponding worker.
   *
   * @return the worker.
   */
  Worker getWorker();

  /**
   * Sets the corresponding worker.
   *
   * @param worker the worker.
   */
  void setWorker( Worker worker );
}
