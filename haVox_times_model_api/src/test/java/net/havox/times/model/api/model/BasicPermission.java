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
import net.havox.times.model.api.permissions.Permission;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;

/**
 * Basic implementation of {@link Permission].
 *
 * @author Christian Otto
 */
public class BasicPermission extends AbstractChangeAwareAndIdentifiableClass implements Permission
{

  private static final long serialVersionUID = 1424337745566683237L;

  private String name;
  private final Set<User> users;
  private final Set<UserGroup> userGroups;

  public BasicPermission()
  {
    super();

    users = new HashSet<>();
    userGroups = new HashSet<>();
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

  @Override
  public Set<UserGroup> getUserGroups()
  {
    return Collections.unmodifiableSet( userGroups );
  }

  @Override
  public CollectionMassModificationStatus<UserGroup> addUserGroups( UserGroup... userGroups )
  {
    CollectionMassModificationStatus<UserGroup> status = new CollectionMassModificationStatus<>();

    for ( UserGroup userGroup : userGroups )
    {
      if ( this.userGroups.contains( userGroup ) )
      {
        status.addUnsuccessfulElements( userGroup );
      }
      else
      {
        this.userGroups.add( userGroup );
        status.addSuccessfulElements( userGroup );
      }
    }

    return status;
  }

  @Override
  public CollectionMassModificationStatus<UserGroup> removeUserGroups( UserGroup... userGroups )
  {
    CollectionMassModificationStatus<UserGroup> status = new CollectionMassModificationStatus<>();

    for ( UserGroup userGroup : userGroups )
    {
      if ( this.userGroups.contains( userGroup ) )
      {
        this.userGroups.remove( userGroup );
        status.addSuccessfulElements( userGroup );
      }
      else
      {
        status.addUnsuccessfulElements( userGroup );
      }
    }

    return status;
  }
}
