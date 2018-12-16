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

import static net.havox.times.model.api.contact.ContactType.ValidationRegularExpressions.*;

/**
 * Represents the different types of contact options.
 *
 * @author Christian Otto
 */
public enum ContactType
{ // TODO: Additional contact types  
  BLOG( "Blog", URL_REGEX ),
  EMAIL( "Email", EMAIL_REGEX ),
  FAX( "Fax", PHONE_REGEX ),
  FACEBOOK( "Facebook", FACEBOOK_REGEX ),
  HOMEPAGE( "Homepage", URL_REGEX ),
  ICQ( "ICQ", ICQ_REGEX ),
  INSTAGRAM( "Instagram", INSTAGRAM_REGEX ),
  PHONE( "Phone", PHONE_REGEX ),
  PHONE_WORK( "Phone (Work)", PHONE_REGEX ),
  SKYPE( "Skype", SKYPE_REGEX ),
  TWITTER( "Twitter", TWITTER_USER_REGEX ),
  XING( "XING", XING_REGEX );

  /**
   * The alias.
   */
  private final String alias;
  /**
   * The regular expression used for content validation.
   */
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
   *
   * @return the regular expression used for content validation.
   */
  public String getValidationRegEx()
  {
    return this.validationRegEx;
  }

  @Override
  public String toString()
  {
    return this.getAlias();
  }

  /**
   * Helper class for RegEx definitions.
   */
  protected static class ValidationRegularExpressions
  {
/**
 * The Constructor.
 */
    private ValidationRegularExpressions()
    {
      // Only contains regular expressions for better readability of the enum.
    }

    public final static String EMAIL_REGEX = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])";
    public final static String FACEBOOK_REGEX = "^[A-Za-z0-9\\.\\-_]+";
    public final static String ICQ_REGEX = "^\\d+";
    public final static String INSTAGRAM_REGEX = "^[A-Za-z0-9\\._]+";
    public final static String PHONE_REGEX = "^(\\+[0-9]{1,5}[ ]?)?(\\([0-9][0-9-/ ]*[0-9]\\)[ ]?)?[0-9][0-9-/ ]*[0-9]";
    public final static String SKYPE_REGEX = "[a-zA-Z][a-zA-Z0-9\\.,\\-_]{5,31}";
    public final static String TWITTER_USER_REGEX = "^[A-Za-z0-9_]{1,15}$";
    public final static String URL_REGEX = "^(ftp|http(s?))://((\\S+:)?\\S+@)?([a-zA-Z0-9][a-zA-Z0-9_\\-\\.]*[a-zA-Z0-9](:\\d{1,5})?)(/([a-zA-Z0-9_/\\&\\?\\=\\-\\.\\~\\%\\(\\)#]*))?";
    public final static String XING_REGEX = "^.+"; // Currently no specifications known.
  }
}
