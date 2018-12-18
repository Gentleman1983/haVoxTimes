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
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.api.permissions.Permission;
import net.havox.times.model.api.user.Credential;
import net.havox.times.model.api.user.User;
import net.havox.times.model.api.user.UserGroup;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link User}.
 *
 * @author Christian Otto
 */
@Entity
@Table( name = USER_DB_TABLE_NAME )
public class UserImpl extends AbstractChangeAwareClass<UserImpl> implements User
{

  private static final long serialVersionUID = -5909687147118246286L;

  @Column( name = USER_DB_COLUMN_EMAIL, unique = true )
  private String email;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = USER_DB_COLUMN_CREDENTIAL )
  private final Credential credential;
  @ManyToOne( fetch = FetchType.LAZY )
  @JoinColumn( name = USER_DB_COLUMN_WORKER )
  private Worker worker;
  @ManyToMany( mappedBy = "usersInUserGroup" )
  private final Set<UserGroup> userGroupMemberships;
  @ManyToMany( mappedBy = "usersWithPermission" )
  private final Set<Permission> userPermissions;

  public UserImpl()
  {
    super();

    credential = new CredentialImpl();
    userGroupMemberships = new CopyOnWriteArraySet<>();
    userPermissions = new CopyOnWriteArraySet<>();
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

  @Override
  public Set<Permission> getUserPermissions()
  {
    return Collections.unmodifiableSet( userPermissions );
  }
}
