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

import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.Identifiable;

/**
 * Abstract basic class for change aware classes.
 *
 * @author Christian Otto
 */
public abstract class AbstractChangeAwareAndIdentifiableClass implements ChangeAware, Identifiable
{

  private Long id;
  private long version = 1l;

  @Override
  public Long getId()
  {
    return id;
  }

  @Override
  public void setId( Long id )
  {
    this.id = id;
  }

  @Override
  public long getVersion()
  {
    return this.version;
  }

  @Override
  public long incrementVersion()
  {
    return ++version;
  }

  public void setVersion( long version )
  {
    this.version = version;
  }
}
