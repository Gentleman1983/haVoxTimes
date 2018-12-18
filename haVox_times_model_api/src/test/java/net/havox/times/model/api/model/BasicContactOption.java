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

import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.api.contact.ContactOption;
import net.havox.times.model.api.contact.ContactType;

/**
 * Basic implementation of {@link ContactOption}.
 * 
 * @author Christian Otto
 */
public class BasicContactOption extends AbstractChangeAwareAndIdentifiableClass implements ContactOption
{
  private static final long serialVersionUID = -8059472798279522275L;

  private Employer employer;
  private Worker employee;
  private ContactType type = null;
  private String value = "leer";
  
  @Override
  public Employer getEmployer() {
    return employer;
  }
  
  @Override
  public void setEmployer( Employer employer ) {
    this.employer = employer;
  }
  
  @Override
  public Worker getEmployee() {
    return employee;
  }
  
  @Override
  public void setEmployee( Worker employee ) {
    this.employee = employee;
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
