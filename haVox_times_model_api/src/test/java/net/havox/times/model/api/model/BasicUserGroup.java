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
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;

/**
 * Basic implementation of {@link UserGroup].
 *
 * @author Christian Otto
 */
public class BasicUserGroup extends AbstractChangeAwareAndIdentifiableClass implements UserGroup
{

  private static final long serialVersionUID = -1159919733750410543L;

  private String name;
  private final Set<User> users;

  public BasicUserGroup()
  {
    super();

    users = new HashSet<>();
  }

  @Override
  public String getName()
  {
    return name;
  }

  @Override
  public void setName( String name )
  {
    this.name = name;
  }

  @Override
  public Set<User> getUsers()
  {
    return Collections.unmodifiableSet( users );
  }

  @Override
  public CollectionMassModificationStatus<User> addUsers( User... users )
  {
    CollectionMassModificationStatus<User> status = new CollectionMassModificationStatus<>();

    for ( User user : users )
    {
      if ( this.users.contains( user ) )
      {
        status.addUnsuccessfulElements( user );
      }
      else
      {
        this.users.add( user );
        status.addSuccessfulElements( user );
      }
    }

    return status;
  }

  @Override
  public CollectionMassModificationStatus<User> removeUsers( User... users )
  {
    CollectionMassModificationStatus<User> status = new CollectionMassModificationStatus<>();

    for ( User user : users )
    {
      if ( this.users.contains( user ) )
      {
        this.users.remove( user );
        status.addSuccessfulElements( user );
      }
      else
      {
        status.addUnsuccessfulElements( user );
      }
    }

    return status;
  }
}
