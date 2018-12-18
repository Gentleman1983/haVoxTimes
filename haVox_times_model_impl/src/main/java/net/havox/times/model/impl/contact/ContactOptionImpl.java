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

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Worker;
import static net.havox.times.model.impl.DefaultDatabaseMapping.*;
import net.havox.times.model.api.contact.ContactOption;
import net.havox.times.model.api.contact.ContactType;
import net.havox.times.model.impl.AbstractChangeAwareClass;

/**
 * Implementation of {@link ContactOption}.
 * 
 * @author Christian Otto
 */
@Entity
@Table( name = CONTACT_OPTION_DB_TABLE_NAME )
public class ContactOptionImpl extends AbstractChangeAwareClass<ContactOptionImpl> implements ContactOption
{

  private static final long serialVersionUID = 8791837873292915594L;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = CONTACT_OPTION_DB_COLUMN_EMPLOYER)
  private Employer employer;
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = CONTACT_OPTION_DB_COLUMN_EMPLOYEE)
  private Worker employee;
  @Column( name = CONTACT_OPTION_DB_COLUMN_TYPE )
  private ContactType type;
  @Column( name = CONTACT_OPTION_DB_COLUMN_VALUE )
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
