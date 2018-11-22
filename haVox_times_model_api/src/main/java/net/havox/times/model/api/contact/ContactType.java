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
 * Represents the different types of contact options.
 *
 * @author Christian Otto
 */
public enum ContactType
{ // TODO: Additional contact types
  BLOG("Blog", ""), //TODO: Validation pattern
  EMAIL("Email", ""), //TODO: Validation pattern
  FAX("Fax", ""), //TODO: Validation pattern
  FACEBOOK("Facebook", ""), //TODO: Validation pattern
  HOMEPAGE("Homepage", ""), //TODO: Validation pattern
  ICQ("ICQ", ""), //TODO: Validation pattern
  INSTAGRAM("Instagram", ""), //TODO: Validation pattern
  PHONE("Phone", ""), //TODO: Validation pattern
  PHONE_WORK("Phone (Work)", ""), //TODO: Validation pattern
  SKYPE("Skype", ""), //TODO: Validation pattern
  TWITTER("Twitter", ""), //TODO: Validation pattern
  XING("XING", ""); //TODO: Validation pattern

  /** The alias. */
  private final String alias;
  /** The regular expression used for content validation. */
  private final String validationRegEx;

  /**
   * The constructor.
   * 
   * @param alias the alias.
   * @param regEx the validation regular expression.
   */
  private ContactType( String alias, String regEx )
  {
    this.alias = alias;
    this.validationRegEx = regEx;
  }

  /**
   * Returns the alias.
   * 
   * @return the alias.
   */
  public String getAlias()
  {
    return this.alias;
  }

  /**
   * Returns the validation reg ex.
   * @return the regular expression used for content validation.
   */
  public String getValidationRegEx()
  {
    return this.validationRegEx;
  }
  
  @Override
  public String toString() {
    return this.getAlias();
  }
}
