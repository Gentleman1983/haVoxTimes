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
package net.havox.times.model.factory;

import net.havox.times.model.api.user.Credential;
import net.havox.times.model.api.user.User;
import net.havox.times.model.impl.user.CredentialImpl;
import net.havox.times.model.impl.user.UserImpl;

/**
 * The user model factory.
 *
 * @author Christian Otto
 */
public class UserModelFactory
{
  /**
   * The singleton model factory instance.
   */
  private static final UserModelFactory INSTANCE = new UserModelFactory();

  /**
   * The private default constructor.
   */
  private UserModelFactory()
  {
    super();
  }

  /**
   * Returns the singleton model factory.
   *
   * @return the {@link UserModelFactory} instance.
   */
  public static UserModelFactory getInstance()
  {
    return UserModelFactory.INSTANCE;
  }
  
  /**
   * Returns a new {@link Credential}.
   *
   * @return a new credential entity.
   */
  public Credential getNewCredential() {
    return new CredentialImpl();
  }
  
  /**
   * Returns a new {@link User}.
   *
   * @return a new user entity.
   */
  public User getNewUser() {
    return new UserImpl();
  }
}
