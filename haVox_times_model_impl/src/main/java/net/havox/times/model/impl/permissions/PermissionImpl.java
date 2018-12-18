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
package net.havox.times.model.impl.permissions;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.CollectionMassModificationStatus;
import net.havox.times.model.api.permissions.Permission;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link Permission}.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = PERMISSION_DB_TABLE_NAME )
public class PermissionImpl extends AbstractChangeAwareClass<PermissionImpl> implements Permission
{

  private static final long serialVersionUID = -1704787538392376312L;

  @Column( name = PERMISSION_DB_COLUMN_NAME )
  private String name;
  @ManyToMany(
           cascade =
          {
            CascadeType.PERSIST,
            CascadeType.MERGE
          } )
  @JoinTable(
           name = USER_PERMISSION_MAPPING_DB_TABLE_NAME,
           joinColumns = @JoinColumn( name = USER_PERMISSION_MAPPING_DB_COLUMN_PERMISSION ),
           inverseJoinColumns = @JoinColumn( name = USER_PERMISSION_MAPPING_DB_COLUMN_USER )
  )
  private final Set<User> usersWithPermission;
  @ManyToMany(
           cascade =
          {
            CascadeType.PERSIST,
            CascadeType.MERGE
          } )
  @JoinTable(
           name = USER_GROUP_PERMISSION_MAPPING_DB_TABLE_NAME,
           joinColumns = @JoinColumn( name = USER_GROUP_PERMISSION_MAPPING_DB_COLUMN_PERMISSION ),
           inverseJoinColumns = @JoinColumn( name = USER_GROUP_PERMISSION_MAPPING_DB_COLUMN_USER_GROUP )
  )
  private final Set<UserGroup> userGroupsWithPermission;

  public PermissionImpl()
  {
    super();

    usersWithPermission = new CopyOnWriteArraySet<>();
    userGroupsWithPermission = new CopyOnWriteArraySet<>();
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
    return Collections.unmodifiableSet( usersWithPermission );
  }

  @Override
  public CollectionMassModificationStatus<User> addUsers( User... users )
  {
    CollectionMassModificationStatus<User> status = new CollectionMassModificationStatus<>();

    for ( User user : users )
    {
      if ( this.usersWithPermission.contains( user ) )
      {
        status.addUnsuccessfulElements( user );
      }
      else
      {
        this.usersWithPermission.add( user );
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
      if ( this.usersWithPermission.contains( user ) )
      {
        this.usersWithPermission.remove( user );
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
    return Collections.unmodifiableSet( userGroupsWithPermission );
  }

  @Override
  public CollectionMassModificationStatus<UserGroup> addUserGroups( UserGroup... userGroups )
  {
    CollectionMassModificationStatus<UserGroup> status = new CollectionMassModificationStatus<>();

    for ( UserGroup userGroup : userGroups )
    {
      if ( this.userGroupsWithPermission.contains( userGroup ) )
      {
        status.addUnsuccessfulElements( userGroup );
      }
      else
      {
        this.userGroupsWithPermission.add( userGroup );
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
      if ( this.userGroupsWithPermission.contains( userGroup ) )
      {
        this.userGroupsWithPermission.remove( userGroup );
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
