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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.user.Credential;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link Credential}.
 * 
 * @author Christian Otto
 */
@Entity
@Table( name = CREDENTIAL_DB_TABLE_NAME )
public class CredentialImpl extends AbstractChangeAwareClass<CredentialImpl> implements Credential
{

  private static final long serialVersionUID = 1079647780224317739L;

  @Column( name = CREDENTIAL_DB_COLUMN_USERNAME, unique = true )
  private String username;
  @Column( name = CREDENTIAL_DB_COLUMN_PASSWORD )
  private String pass;

  @Override
  public String getUsername()
  {
    return username;
  }

  @Override
  public void setUsername( String username )
  {
    this.username = username;
  }

  @Override
  public String getPasswordHash()
  {
    return pass;
  }

  @Override
  public void setPassword( String password )
  {
    this.pass = "foo_" + password + "_bar";
  }
}
