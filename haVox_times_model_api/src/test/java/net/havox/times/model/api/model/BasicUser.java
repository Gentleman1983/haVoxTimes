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
package net.havox.times.model.api.model;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.api.user.Credential;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;

/**
 * Basic implementation of {@link User].
 *
 * @author Christian Otto
 */
public class BasicUser extends AbstractChangeAwareAndIdentifiableClass implements User
{

  private static final long serialVersionUID = 7844031746824163564L;

  private String email;
  private final Credential credential;
  private Worker worker;
  private final Set<UserGroup> userGroupMemberships;

  public BasicUser()
  {
    super();

    credential = new BasicCredential();
    userGroupMemberships = new HashSet<>();
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

  @Override
  public Set<UserGroup> getMemberOfUserGroup()
  {
    return Collections.unmodifiableSet( userGroupMemberships );
  }
}
