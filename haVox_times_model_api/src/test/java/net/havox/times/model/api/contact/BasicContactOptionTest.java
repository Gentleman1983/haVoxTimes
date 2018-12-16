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
package net.havox.times.model.api.contact;

/**
 * Simplest implementation for {@link  AbstractContactOptionTest}.
 *
 * @author Christian Otto
 */
public class BasicContactOptionTest extends AbstractContactOptionTest
{

  @Override
  public ContactOption newInstance() throws Exception
  {
    return new ContactOption()
    {
      private static final long serialVersionUID = -6805985062034526838L;

      private ContactType type = null;
      private String value = "leer";
      private long version;
      private Long id;

      @Override
      public ContactType getType()
      {
        return type;
      }

      @Override
      public String getContactValue()
      {
        return value;
      }

      @Override
      public void setValue( ContactType type, String value )
      {
        this.type = type;
        this.value = value;
      }

      @Override
      public long getVersion()
      {
        return version;
      }

      @Override
      public long incrementVersion()
      {
        return ++version;
      }

      @Override
      public Long getId()
      {
        return id;
      }
    };
  }

}