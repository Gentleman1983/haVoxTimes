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
package net.havox.times.model.impl.contact;

import net.havox.times.model.api.contact.ContactOption;
import net.havox.times.model.api.contact.ContactType;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link ContactOption}.
 * 
 * @author Christian Otto
 */
public class ContactOptionImpl extends AbstractChangeAwareClass<ContactOptionImpl> implements ContactOption
{

  private static final long serialVersionUID = 8791837873292915594L;

  private ContactType type;
  private String value;
  
  public ContactOptionImpl( ContactType type, String value ) {
    super();
    
    this.type = type;
    this.value = value;
  }
  
  public ContactOptionImpl( ContactType type ) {
    this( type, "" );
  }
  
  public ContactOptionImpl() {
    this( null );
  }

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
}
