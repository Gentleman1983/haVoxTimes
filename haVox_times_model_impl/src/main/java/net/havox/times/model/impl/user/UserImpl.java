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
package net.havox.times.model.impl.user;

import net.havox.times.model.api.company.Worker;
import net.havox.times.model.api.user.Credential;
import net.havox.times.model.api.user.User;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link User}.
 * 
 * @author Christian Otto
 */
public class UserImpl extends AbstractChangeAwareClass<UserImpl> implements User
{

  private static final long serialVersionUID = -5909687147118246286L;

  private String email;
  private final Credential credential;
  private Worker worker;
  
  public UserImpl()
  {
    super();
    
    credential = new CredentialImpl();
  }

  @Override
  public String getEmailAddress()
  {
    return email;
  }

  @Override
  public void setEmailAddress( String emailAddress )
  {
    email = emailAddress;
  }

  @Override
  public Credential getCredentials()
  {
    return credential;
  }

  @Override
  public Worker getWorker()
  {
    return worker;
  }

  @Override
  public void setWorker( Worker worker )
  {
    this.worker = worker;
  }
}
