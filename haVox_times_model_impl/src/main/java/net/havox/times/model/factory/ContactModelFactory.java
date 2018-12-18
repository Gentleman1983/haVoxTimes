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
package net.havox.times.model.factory;

import net.havox.times.model.api.contact.ContactOption;
import net.havox.times.model.impl.contact.ContactOptionImpl;

/**
 * The contact model factory.
 *
 * @author Christian Otto
 */
public class ContactModelFactory
{

  /**
   * The singleton model factory instance.
   */
  private static final ContactModelFactory INSTANCE = new ContactModelFactory();

  /**
   * The private default constructor.
   */
  private ContactModelFactory()
  {
    super();
  }

  /**
   * Returns the singleton model factory.
   *
   * @return the {@link ContactModelFactory} instance.
   */
  public static ContactModelFactory getInstance()
  {
    return ContactModelFactory.INSTANCE;
  }

  /**
   * Returns a new {@link ContactOption}.
   *
   * @return a new contact option entity.
   */
  public ContactOption getNewContactOption()
  {
    return new ContactOptionImpl();
  }
}
