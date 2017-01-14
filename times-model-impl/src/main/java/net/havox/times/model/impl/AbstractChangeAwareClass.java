/*
 * Copyright (C) 2017 [haVox] Design
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
package net.havox.times.model.impl;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

import net.havox.times.model.api.ChangeAware;

/**
 * This class provides the basic functionality to provide change awareness.
 *
 * @author Christian Otto
 */
@MappedSuperclass
public class AbstractChangeAwareClass implements ChangeAware
{

  @Id
  @GeneratedValue
  @Column( name = "id" )
  private Long id;
  @Column( name = "version", nullable = false )
  private long version = 1l;

  @Override
  public Long getId()
  {
    return this.id;
  }

  @Override
  public long getVersion()
  {
    return this.version;
  }

  @Override
  public long incrementVersion()
  {
    return ++this.version;
  }
}
