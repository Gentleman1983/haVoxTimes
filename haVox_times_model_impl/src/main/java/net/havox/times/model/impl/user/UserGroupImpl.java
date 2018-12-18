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
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link UserGroup}.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = USER_GROUP_DB_TABLE_NAME )
public class UserGroupImpl extends AbstractChangeAwareClass<UserGroupImpl> implements UserGroup
{

  private static final long serialVersionUID = -3262046127418876587L;

  @Column( name = USER_GROUP_DB_COLUMN_NAME, unique = true )
  private String name;
  @ManyToMany(
           cascade =
          {
            CascadeType.PERSIST,
            CascadeType.MERGE
          } )
  @JoinTable(
           name = USER_USER_GROUP_MAPPING_DB_TABLE_NAME,
           joinColumns = @JoinColumn( name = USER_USER_GROUP_MAPPING_DB_COLUMN_USER_GROUP ),
           inverseJoinColumns = @JoinColumn( name = USER_USER_GROUP_MAPPING_DB_COLUMN_USER )
  )
  private final Set<User> usersInUserGroup;

  public UserGroupImpl()
  {
    super();

    usersInUserGroup = new CopyOnWriteArraySet<>();
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
    return Collections.unmodifiableSet( usersInUserGroup );
  }

  @Override
  public CollectionMassModificationStatus<User> addUsers( User... users )
  {
    CollectionMassModificationStatus<User> status = new CollectionMassModificationStatus<>();

    for ( User user : users )
    {
      if ( this.usersInUserGroup.contains( user ) )
      {
        status.addUnsuccessfulElements( user );
      }
      else
      {
        this.usersInUserGroup.add( user );
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
      if ( this.usersInUserGroup.contains( user ) )
      {
        this.usersInUserGroup.remove( user );
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
