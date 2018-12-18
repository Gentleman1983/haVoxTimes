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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.permissions.Permission;
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
}
