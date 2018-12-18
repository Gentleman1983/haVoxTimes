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
package net.havox.times.model.api.booking;

import static org.junit.Assert.*;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.math.BigDecimal;

import net.havox.javatools.test.utils.junit.ExtendedRunner;
import net.havox.javatools.test.utils.random.ModelRandomGenerator;
import net.havox.javatools.test.utils.junit.Repeat;

@RunWith( ExtendedRunner.class )
public abstract class AbstractBookingTypeTest
{

  public abstract BookingType newInstance() throws Exception;

  // *******************************************************************************************************************
  // Getter / Setter Tests
  // *******************************************************************************************************************
  /**
   * User Story BM011 acceptance criteria 01 ("Booking types have a unique name (e.g. Illness, Spare Time, Vacation,
   * Work, Break).").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyType() throws Exception
  {
    String alphabet = ModelRandomGenerator.ALPHABETIC_STRING + " -";
    String name = ModelRandomGenerator.randomString( ModelRandomGenerator.randomIntInRange( 1, 50 ), alphabet );

    BookingType objectUnderTest = newInstance();
    objectUnderTest.setType( name );
    assertEquals( name, objectUnderTest.getType() );
  }

  /**
   * User Story BM011 acceptance criteria 02 ("Booking types have a multiplicator.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyMultiplicator() throws Exception
  {
    BigDecimal multiplier = BigDecimal.valueOf( ModelRandomGenerator.randomDouble() );

    BookingType objectUnderTest = newInstance();
    objectUnderTest.setMultiplier( multiplier );
    assertEquals( multiplier, objectUnderTest.getMultiplier() );
  }

  /**
   * User Story BM011 acceptance criteria 03 ("Booking types have an information if that type of booking may be
   * invoiced.").
   *
   * @throws Exception
   */
  @Test
  @Repeat( 25 )
  public void testModifyCanBeInvoiced() throws Exception
  {
    boolean canBeInvoiced = ModelRandomGenerator.randomBoolean();

    BookingType objectUnderTest = newInstance();
    objectUnderTest.setCanBeInvoiced( canBeInvoiced );
    assertEquals( canBeInvoiced, objectUnderTest.canBeInvoiced() );
  }
}
