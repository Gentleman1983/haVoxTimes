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

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static net.havox.times.model.api.contact.ContactType.*;

public class ContactTypeTest
{

  /**
   * User Story BM007 acceptance criteria 01 ("It has an unique type.").
   */
  @Test
  public void testUniqueAlias()
  {
    Map<String, ContactType> discoveredAliases = new HashMap<>();
    List<String> findings = new ArrayList<>();

    for ( ContactType type : ContactType.values() )
    {
      if ( discoveredAliases.keySet().contains( type.getAlias() ) )
      {
        ContactType discoveredType = discoveredAliases.get( type.getAlias() );

        StringBuilder msg = new StringBuilder();
        msg.append( "Found duplicate alias '" ).append( type.getAlias() ).append( "'. The ContactTypes '" )
                .append( discoveredType ).append( "' and '" ).append( type ).append( "' define this alias. " )
                .append( "By definition the alias has to be unique." );
        findings.add( msg.toString() );
        continue;
      }

      discoveredAliases.put( type.getAlias(), type );
    }

    if ( !findings.isEmpty() )
    {
      boolean firstFinding = true;
      StringBuilder msg = new StringBuilder();
      for ( String finding : findings )
      {
        if ( !firstFinding )
        {
          msg.append( "\n" );
        }
        msg.append( finding );
      }
      fail( msg.toString() );
    }
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testDoesEveryContactTypeHaveAValidationPattern()
  {
    String emptyValidationPattern = "";

    for ( ContactType type : ContactType.values() )
    {
      StringBuilder msgNullPattern = new StringBuilder();
      msgNullPattern.append( "[" ).append( type.getAlias() ).append( "]: " )
              .append( "There should be a validation pattern." );
      assertNotNull( msgNullPattern.toString(), type.getValidationRegEx() );

      StringBuilder msgEmptyPattern = new StringBuilder();
      msgEmptyPattern.append( "[" ).append( type.getAlias() ).append( "]: " )
              .append( "The validation pattern should not be empty." );
      assertNotEquals( msgEmptyPattern.toString(), emptyValidationPattern, type.getValidationRegEx() );
    }
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidBlogValues()
  {
    List<String> validValues = Arrays.asList(
            "http://foo.com/blah_blah",
            "http://foo.com/blah_blah/",
            "http://foo.com/blah_blah_(wikipedia)",
            "http://foo.com/blah_blah_(wikipedia)_(again)",
            "http://www.example.com/wpstyle/?p=364",
            "https://www.example.com/foo/?bar=baz&inga=42&quux",
            "http://userid:password@example.com:8080",
            "http://userid:password@example.com:8080/",
            "http://userid@example.com",
            "http://userid@example.com/",
            "http://userid@example.com:8080",
            "http://userid@example.com:8080/",
            "http://userid:password@example.com",
            "http://userid:password@example.com/",
            "http://142.42.1.1/",
            "http://142.42.1.1:8080/",
            "http://foo.com/blah_(wikipedia)#cite-1",
            "http://foo.com/blah_(wikipedia)_blah#cite-1",
            "http://foo.com/(something)?after=parens",
            "http://code.google.com/events/#&product=browser",
            "http://j.mp",
            "ftp://foo.bar/baz",
            "http://foo.bar/?q=Test%20URL-encoded%20stuff",
            "http://-.~_!$&'()*+,;=:%40:80%2f::::::@example.com",
            "http://1337.net",
            "http://a.b-c.de",
            "http://223.255.255.254",
            "https://foo_bar.example.com/",
            "http://1.1.1.0",
            "http://01.02.03.04",
            "http://001.002.003.004" );

    testValidValues( validValues, BLOG );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidBlogValues()
  {
    List<String> invalidValues = Arrays.asList(
            "http://",
            "http://.",
            "http://.",
            "http://../",
            "http://?",
            "http://??",
            "http://??/",
            "http://#",
            "http://##",
            "http://##/",
            "http://foo.bar?q=Spaces should be encoded",
            "//",
            "//a",
            "///a",
            "///",
            "http:///a",
            "foo.com",
            "rdar://1234",
            "h://test",
            "http:// shouldfail.com",
            ":// should fail",
            "http://foo.bar/foo(bar)baz quux",
            "ftps://foo.bar/",
            "http://-error-.invalid/",
            "http://-a.b.co",
            "http://.www.foo.bar/",
            "http://www.foo.bar./",
            "http://.www.foo.bar./" );

    testInvalidValues( invalidValues, BLOG );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidEmailValues()
  {
    List<String> validValues = Arrays.asList(
            "email@domain.com",
            "firstname.lastname@domain.com",
            "email@subdomain.domain.com",
            "firstname+lastname@domain.com",
            "email@123.123.123.123",
            "email@[123.123.123.123]",
            "\"email\"@domain.com",
            "1234567890@domain.com",
            "email@domain-one.com",
            "_______@domain.com",
            "email@domain.name",
            "email@domain.co.jp",
            "firstname-lastname@domain.com" );

    testValidValues( validValues, EMAIL );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidEmailValues()
  {
    List<String> invalidValues = Arrays.asList(
            "plainaddress",
            "#@%^%#$@#$@#.com",
            "@domain.com",
            "Joe Smith <email@domain.com>",
            "email.domain.com",
            "email@domain@domain.com",
            ".email@domain.com",
            "email.@domain.com",
            "email..email@domain.com",
            "あいうえお@domain.com",
            "email@domain.com (Joe Smith)",
            "email@domain",
            "email@-domain.com",
            "email@domain..com" );

    testInvalidValues( invalidValues, EMAIL );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidFaxValues()
  {
    List<String> validValues = Arrays.asList(
            "112",
            "110",
            "4711",
            "47-11",
            "08154711",
            "0815/4711",
            "(0815) 4711",
            "+42 (815) 4711",
            "0042 815 4711" );

    testValidValues( validValues, FAX );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidFaxValues()
  {
    List<String> invalidValues = Arrays.asList(
            "17+4",
            " 110",
            "-110",
            "(110",
            ")110",
            "/110",
            "110+",
            "110-",
            "110(",
            "110)",
            "110/",
            "110 ",
            "a" );

    testInvalidValues( invalidValues, FAX );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidFacebookValues()
  {
    List<String> validValues = Arrays.asList(
            "a",
            "1",
            "a1",
            "a.1",
            "a_1",
            "foo-bar" );

    testValidValues( validValues, FACEBOOK );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidFacebookValues()
  {
    List<String> invalidValues = Arrays.asList(
            "",
            "man|eater",
            "x,men",
            "be;ready",
            "michael:jackson",
            "österreich",
            "<tag>" );

    testInvalidValues( invalidValues, FACEBOOK );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidHomepageValues()
  {
    List<String> validValues = Arrays.asList(
            "http://foo.com/blah_blah",
            "http://foo.com/blah_blah/",
            "http://foo.com/blah_blah_(wikipedia)",
            "http://foo.com/blah_blah_(wikipedia)_(again)",
            "http://www.example.com/wpstyle/?p=364",
            "https://www.example.com/foo/?bar=baz&inga=42&quux",
            "http://userid:password@example.com:8080",
            "http://userid:password@example.com:8080/",
            "http://userid@example.com",
            "http://userid@example.com/",
            "http://userid@example.com:8080",
            "http://userid@example.com:8080/",
            "http://userid:password@example.com",
            "http://userid:password@example.com/",
            "http://142.42.1.1/",
            "http://142.42.1.1:8080/",
            "http://foo.com/blah_(wikipedia)#cite-1",
            "http://foo.com/blah_(wikipedia)_blah#cite-1",
            "http://foo.com/(something)?after=parens",
            "http://code.google.com/events/#&product=browser",
            "http://j.mp",
            "ftp://foo.bar/baz",
            "http://foo.bar/?q=Test%20URL-encoded%20stuff",
            "http://-.~_!$&'()*+,;=:%40:80%2f::::::@example.com",
            "http://1337.net",
            "http://a.b-c.de",
            "http://223.255.255.254",
            "https://foo_bar.example.com/",
            "http://1.1.1.0",
            "http://01.02.03.04",
            "http://001.002.003.004" );

    testValidValues( validValues, HOMEPAGE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidHomepageValues()
  {
    List<String> invalidValues = Arrays.asList(
            "http://",
            "http://.",
            "http://.",
            "http://../",
            "http://?",
            "http://??",
            "http://??/",
            "http://#",
            "http://##",
            "http://##/",
            "http://foo.bar?q=Spaces should be encoded",
            "//",
            "//a",
            "///a",
            "///",
            "http:///a",
            "foo.com",
            "rdar://1234",
            "h://test",
            "http:// shouldfail.com",
            ":// should fail",
            "http://foo.bar/foo(bar)baz quux",
            "ftps://foo.bar/",
            "http://-error-.invalid/",
            "http://-a.b.co",
            "http://.www.foo.bar/",
            "http://www.foo.bar./",
            "http://.www.foo.bar./" );

    testInvalidValues( invalidValues, HOMEPAGE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidIcqValues()
  {
    List<String> validValues = Arrays.asList(
            "1",
            "42",
            "4711",
            "0815",
            "47110815" );

    testValidValues( validValues, ICQ );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidIcqValues()
  {
    List<String> invalidValues = Arrays.asList(
            "",
            "a",
            "1a",
            "a1",
            " ",
            "1 ",
            " 1",
            "!",
            "!1",
            "1!" );

    testInvalidValues( invalidValues, ICQ );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidInstagramValues()
  {
    List<String> validValues = Arrays.asList(
            "a",
            "1",
            "a1",
            "a.1",
            "a_1" );

    testValidValues( validValues, INSTAGRAM );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidInstagramValues()
  {
    List<String> invalidValues = Arrays.asList(
            "",
            "foo-bar",
            "man|eater",
            "x,men",
            "be;ready",
            "michael:jackson",
            "österreich",
            "<tag>" );

    testInvalidValues( invalidValues, INSTAGRAM );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidPhoneValues()
  {
    List<String> validValues = Arrays.asList(
            "112",
            "110",
            "4711",
            "47-11",
            "08154711",
            "0815/4711",
            "(0815) 4711",
            "+42 (815) 4711",
            "0042 815 4711" );

    testValidValues( validValues, PHONE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidPhoneValues()
  {
    List<String> invalidValues = Arrays.asList(
            "17+4",
            " 110",
            "-110",
            "(110",
            ")110",
            "/110",
            "110+",
            "110-",
            "110(",
            "110)",
            "110/",
            "110 ",
            "a" );

    testInvalidValues( invalidValues, PHONE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidPhoneWorkValues()
  {
    List<String> validValues = Arrays.asList(
            "112",
            "110",
            "4711",
            "47-11",
            "08154711",
            "0815/4711",
            "(0815) 4711",
            "+42 (815) 4711",
            "0042 815 4711" );

    testValidValues( validValues, PHONE_WORK );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidPhoneWorkValues()
  {
    List<String> invalidValues = Arrays.asList(
            "17+4",
            " 110",
            "-110",
            "(110",
            ")110",
            "/110",
            "110+",
            "110-",
            "110(",
            "110)",
            "110/",
            "110 ",
            "a" );

    testInvalidValues( invalidValues, PHONE_WORK );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidSkypeValues()
  {
    List<String> validValues = Arrays.asList(
            "abcdef",
            "abcde1",
            "abcd12",
            "abc123",
            "ab1234",
            "a12345",
            "abcdefghijklmnopqrstuvwxyzABCDEF",
            "abcdefghijklmnopqrstuvwxyz123456" );

    testValidValues( validValues, SKYPE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidSkypeValues()
  {
    List<String> invalidValues = Arrays.asList(
            "abcde",
            "a1234",
            "123456",
            "1abcde",
            "abcdefghijklmnopqrstuvwxyzABCDEFG",
            "abcdefghijklmnopqrstuvwxyzABCDEF1",
            "abcdefgö" );

    testInvalidValues( invalidValues, SKYPE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidTwitterValues()
  {
    List<String> validValues = Arrays.asList(
            "a",
            "1",
            "_",
            "abcdefghijklmno",
            "ABCDEFGHIJKLMNO",
            "123456789012345",
            "_______________" );

    testValidValues( validValues, TWITTER );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidTwitterValues()
  {
    List<String> invalidValues = Arrays.asList(
            "",
            "ä",
            "+",
            "-",
            "abcdefghijklmnop",
            "ABCDEFGHIJKLMNOP",
            "1234567890123456",
            "________________" );

    testInvalidValues( invalidValues, TWITTER );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidXingValues()
  {
    List<String> validValues = Arrays.asList(
            "a",
            "1" );

    testValidValues( validValues, XING );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidXingValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, XING );
  }

  // ###################################################################################################################
  // # UTILITY METHODS...                                                                                              #
  // ###################################################################################################################
  /**
   * A standard test for valid values.
   *
   * @param validValues the valid values.
   * @param type the contact type.
   */
  private void testValidValues( List<String> validValues, ContactType type )
  {
    String messages = "";
    for ( String value : validValues )
    {
      ValidationResult result = validateContactValue( type, value );
      if ( !result.isValid )
      {
        if ( messages.length() > 0 )
        {
          messages += "\n";
        }
        messages += result.getMessage();
      }
    }
    assertEquals( messages, "", messages );
  }

  /**
   * A standard test for invalid values.
   *
   * @param invalidValues the invalid values.
   * @param type the contact type.
   */
  private void testInvalidValues( List<String> invalidValues, ContactType type )
  {
    String messages = "";
    for ( String value : invalidValues )
    {
      ValidationResult result = validateContactValue( type, value );
      if ( result.isValid )
      {
        if ( messages.length() > 0 )
        {
          messages += "\n";
        }
        messages += "The value '" + value + "' should be invalid, but it was classified valid by the "
                + type.getAlias() + " RegEx '" + type.getValidationRegEx() + "'.";
      }
    }
    assertEquals( messages, "", messages );
  }

  /**
   * Validates a value depending of the {@link ContactType}.
   *
   * @param type the contact type.
   * @param validationTarget the value under validation.
   *
   * @return the validation result.
   */
  private ValidationResult validateContactValue( ContactType type, String validationTarget )
  {
    String regEx = type.getValidationRegEx();

    ValidationResult result = new ValidationResult();

    if ( !validationTarget.matches( regEx ) )
    {
      StringBuilder msg = new StringBuilder();

      msg.append( "Validation failed for value '" ).append( validationTarget ).append( "' and contact type '" )
              .append( type.getAlias() ).append( "'. The value does not match the validation RegEx '" ).append( regEx )
              .append( "'." );

      result.setValid( false );
      result.setMessage( msg.toString() );
    }
    return result;
  }

  /**
   * Utility class for representing a validation result.
   */
  private static class ValidationResult
  {

    /**
     * Is the validation target valid?
     */
    private boolean isValid = true;
    /**
     * The validation message.
     */
    private String message;

    /**
     * Sets the valid flag.
     *
     * @param valid true, if the validation target is valid.
     */
    public void setValid( boolean valid )
    {
      this.isValid = valid;
    }

    /**
     * Checks if the validation target is valid.
     *
     * @return true, if it's valid
     */
    public boolean isValid()
    {
      return this.isValid;
    }

    /**
     * Sets the message.
     *
     * @param message the validation message.
     */
    public void setMessage( String message )
    {
      this.message = message;
    }

    /**
     * Returns the validation message.
     *
     * @return the message.
     */
    public String getMessage()
    {
      return this.message;
    }
  }
}
