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

import java.io.Serializable;
import net.havox.exceptions.GuruMeditationWarning;
import net.havox.times.model.api.ChangeAware;
import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Worker;

/**
 * This class defines a contact option.
 *
 * @author Christian Otto
 */
public interface ContactOption extends ChangeAware, Serializable
{
  /**
   * Returns the employer.
   * 
   * @return the employer.
   */
  Employer getEmployer();
  
  /**
   * Sets the employer.
   * 
   * @param employer the employer.
   */
  void setEmployer( Employer employer );
  
  /**
   * Returns the employee.
   * 
   * @return the employee.
   */
  Worker getEmployee();
  
  /**
   * Sets the employee.
   * 
   * @param employee the employee.
   */
  void setEmployee( Worker employee );
  
  /**
   * Returns the contact type.
   * 
   * @return the contact type.
   */
  ContactType getType();

  /**
   * Sets the
   * @return 
   */
  String getContactValue();
  
  /**
   * Sets the contact.
   * 
   * @param type the contact type.
   * @param value the contact value.
   * 
   * @throws GuruMeditationWarning if type or value is <code>null</code>.
   * @throws GuruMeditationWarning if value does not match to the validation rules.
   */
  void setValue( ContactType type, String value );
}
