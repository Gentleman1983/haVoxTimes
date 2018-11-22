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

import static net.havox.times.model.api.contact.ContactType.*;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactTypeTest
{

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidBlogValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, BLOG );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidBlogValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, BLOG );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidEmailValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, EMAIL );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidEmailValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, EMAIL );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidFaxValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, FAX );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidFaxValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, FAX );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidFacebookValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, FACEBOOK );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidFacebookValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, FACEBOOK );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidHomepageValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, HOMEPAGE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidHomepageValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, HOMEPAGE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidIcqValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, ICQ );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidIcqValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, ICQ );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidInstagramValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, INSTAGRAM );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidInstagramValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, INSTAGRAM );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidPhoneValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, PHONE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidPhoneValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, PHONE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidPhoneWorkValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, PHONE_WORK );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidPhoneWorkValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, PHONE_WORK );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidSkypeValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, SKYPE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidSkypeValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, SKYPE );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidTwitterValues()
  {
    List<String> validValues = Arrays.asList( "" );

    testValidValues( validValues, TWITTER );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testInvalidTwitterValues()
  {
    List<String> invalidValues = Arrays.asList( "" );

    testInvalidValues( invalidValues, TWITTER );
  }

  /**
   * User Story BM007 acceptance criteria 02 ("It has a validation pattern depending on the contact type.").
   */
  @Test
  public void testValidXingValues()
  {
    List<String> validValues = Arrays.asList( "" );

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

  private static class ValidationResult
  {

    private boolean isValid = true;
    private String message;

    public void setValid( boolean valid )
    {
      this.isValid = valid;
    }

    public boolean isValid()
    {
      return this.isValid;
    }

    public void setMessage( String message )
    {
      this.message = message;
    }

    public String getMessage()
    {
      return this.message;
    }
  }
}
