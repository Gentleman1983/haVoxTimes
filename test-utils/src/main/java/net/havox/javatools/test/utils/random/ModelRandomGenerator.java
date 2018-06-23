/*
 * Copyright (C) 2017 [haVox] Design
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
package net.havox.javatools.test.utils.random;

import java.security.SecureRandom;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.ZoneOffset;
import java.util.concurrent.ThreadLocalRandom;

public class ModelRandomGenerator
{

  private static final SecureRandom RANDOM = new SecureRandom();

  public static final String ALPHANUMERIC_STRING = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
  public static final String ALPHABETIC_STRING = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";

  private ModelRandomGenerator()
  {
  }

  public static String randomString( int length )
  {
    return randomString( length, ALPHANUMERIC_STRING );
  }

  public static String randomString( int length, String alphabet )
  {
    StringBuilder builder = new StringBuilder( length );
    for ( int i = 0; i < length; i++ )
    {
      builder.append( alphabet.charAt( RANDOM.nextInt( alphabet.length() ) ) );
    }
    return builder.toString();
  }

  public static int randomInt()
  {
    return RANDOM.nextInt();
  }

  public static int randomInt( int bound )
  {
    return RANDOM.nextInt( bound );
  }

  public static int randomIntInRange( int min, int max )
  {
    int result;
    int bound = ( max - min + 1 );
    if ( bound > 0 )
    {
      result = randomInt( bound ) + min;
    }
    else
    { // Bound calculation caused int overflow.
      do
      {
        result = randomInt();
      }
      while ( result < min || result > max );
    }

    return result;
  }

  public static long randomLong()
  {
    return RANDOM.nextLong();
  }

  public static boolean randomBoolean()
  {
    return RANDOM.nextBoolean();
  }

  public static double randomDouble()
  {
    return RANDOM.nextDouble();
  }

  public static float randomFloat()
  {
    return RANDOM.nextFloat();
  }

  public static LocalDate randomLocalDate()
  {
    return randomLocalDate( LocalDate.of( 1970, Month.JANUARY, 1 ), LocalDate.now() );
  }

  public static LocalDate randomLocalDate( LocalDate min, LocalDate max )
  {
    long minDay = min.toEpochDay();
    long maxDay = max.toEpochDay();
    long randomDay = ThreadLocalRandom.current().nextLong( minDay, maxDay );

    return LocalDate.ofEpochDay( randomDay );
  }

  public static LocalDateTime randomLocalDateTime()
  {
    return randomLocalDateTime( LocalDateTime.of( 1970, Month.JANUARY, 1, 0, 0 ), LocalDateTime.now() );
  }

  public static LocalDateTime randomLocalDateTime( LocalDateTime min, LocalDateTime max )
  {
    long minSecond = min.toEpochSecond( ZoneOffset.UTC );
    long maxSecond = max.toEpochSecond( ZoneOffset.UTC );
    long randomSecond = ThreadLocalRandom.current().nextLong( minSecond, maxSecond );

    return LocalDateTime.ofEpochSecond( randomSecond, 0, ZoneOffset.UTC );
  }
}
