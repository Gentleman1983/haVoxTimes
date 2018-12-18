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
package net.havox.times.model.impl;

/**
 * Entity to manage Database table and column names at a central place.
 *
 * @author Christian otto
 */
public class DefaultDatabaseMapping
{

  private DefaultDatabaseMapping()
  {
    super();
  }

  private static final String DB_TABLE_PREFIX = "havox_times_";

  // Address.
  public static final String ADDRESS_DB_TABLE_NAME = DB_TABLE_PREFIX + "address";
  public static final String ADDRESS_DB_COLUMN_STREET = "street";
  public static final String ADDRESS_DB_COLUMN_HOUSE_NUMBER = "house_number";
  public static final String ADDRESS_DB_COLUMN_CITY = "city_id";

  // City.
  public static final String CITY_DB_TABLE_NAME = DB_TABLE_PREFIX + "city";
  public static final String CITY_DB_COLUMN_ZIP_CODE = "zip_code";
  public static final String CITY_DB_COLUMN_NAME = "name";
  public static final String CITY_DB_COLUMN_COUNTRY = "country_id";

  // Country.
  public static final String COUNTRY_DB_TABLE_NAME = DB_TABLE_PREFIX + "country";
  public static final String COUNTRY_DB_COLUMN_NAME = "";

  // Account.
  public static final String ACCOUNT_DB_TABLE_NAME = DB_TABLE_PREFIX + "account";
  public static final String ACCOUNT_DB_COLUMN_PROJECT = "project_id";
  public static final String ACCOUNT_DB_COLUMN_NAME = "name";
  public static final String ACCOUNT_DB_COLUMN_START_DATE = "start_date";
  public static final String ACCOUNT_DB_COLUMN_END_DATE = "end_date";
  public static final String ACCOUNT_DB_COLUMN_BUDGET = "budget";

  // Booking.
  public static final String BOOKING_DB_TABLE_NAME = DB_TABLE_PREFIX + "booking";
  public static final String BOOKING_DB_COLUMN_ACCOUNT = "account_id";
  public static final String BOOKING_DB_COLUMN_TYPE = "type_id";
  public static final String BOOKING_DB_COLUMN_TEXT = "text";
  public static final String BOOKING_DB_COLUMN_IS_INVOICED = "is_invoiced";

  // Booking Reference.
  public static final String BOOKING_REFERENCE_DB_TABLE_NAME = DB_TABLE_PREFIX + "booking_reference";
  public static final String BOOKING_REFERENCE_DB_COLUMN_BOOKING = "booking_id";
  public static final String BOOKING_REFERENCE_DB_COLUMN_TYPE = "type_id";
  public static final String BOOKING_REFERENCE_DB_COLUMN_VALUE = "value";

  // Booking Reference Type.
  public static final String BOOKING_REFERENCE_TYPE_DB_TABLE_NAME = DB_TABLE_PREFIX + "booking_reference_type";
  public static final String BOOKING_REFERENCE_TYPE_DB_COLUMN_NAME = "name";
  public static final String BOOKING_REFERENCE_TYPE_DB_COLUMN_PROJECT = "project_id";
  public static final String BOOKING_REFERENCE_TYPE_DB_COLUMN_PREFIX = "prefix";
  public static final String BOOKING_REFERENCE_TYPE_DB_COLUMN_SUFFIX = "suffix";
  public static final String BOOKING_REFERENCE_TYPE_DB_COLUMN_VALIDATION_PATTERN = "validation_pattern";
  public static final String BOOKING_REFERENCE_TYPE_DB_COLUMN_EXTERNAL_REFERENCE = "ext_reference";

  // Booking Type.
  public static final String BOOKING_TYPE_DB_TABLE_NAME = DB_TABLE_PREFIX + "booking_type";
  public static final String BOOKING_TYPE_DB_COLUMN_NAME = "name";
  public static final String BOOKING_TYPE_DB_COLUMN_MULTIPLIER = "multiplier";
  public static final String BOOKING_TYPE_DB_COLUMN_CAN_BE_INVOICED = "can_be_invoiced";

  // Project.
  public static final String PROJECT_DB_TABLE_NAME = DB_TABLE_PREFIX + "project";
  public static final String PROJECT_DB_COLUMN_EMPLOYMENT = "employment_id";
  public static final String PROJECT_DB_COLUMN_NAME = "name";
  public static final String PROJECT_DB_COLUMN_START_DATE = "start_date";
  public static final String PROJECT_DB_COLUMN_END_DATE = "end_date";

  // Employer.
  public static final String EMPLOYER_DB_TABLE_NAME = DB_TABLE_PREFIX + "employer";
  public static final String EMPLOYER_DB_COLUMN_NAME = "name";
  public static final String EMPLOYER_DB_COLUMN_ADDRESS = "address_id";
  public static final String EMPLOYER_DB_COLUMN_EMPLOYER_GROUP = "employer_group_id";

  // Employment.
  public static final String EMPLOYMENT_DB_TABLE_NAME = DB_TABLE_PREFIX + "employment";
  public static final String EMPLOYMENT_DB_COLUMN_EMPLOYER = "employer_id";
  public static final String EMPLOYMENT_DB_COLUMN_EMPLOYEE = "employee_id";
  public static final String EMPLOYMENT_DB_COLUMN_START_DATE = "start_date";
  public static final String EMPLOYMENT_DB_COLUMN_END_DATE = "end_date";

  // Worker.
  public static final String WORKER_DB_TABLE_NAME = DB_TABLE_PREFIX + "worker";
  public static final String WORKER_DB_COLUMN_FIRST_NAME = "first_name";
  public static final String WORKER_DB_COLUMN_MIDDLE_INITIALS = "initials";
  public static final String WORKER_DB_COLUMN_LAST_NAME = "last_name";
  public static final String WORKER_DB_COLUMN_ADDRESS = "address_id";
  public static final String WORKER_DB_COLUMN_BIRTHDAY = "birthday";

  // Contact Option.
  public static final String CONTACT_OPTION_DB_TABLE_NAME = DB_TABLE_PREFIX + "contact_option";
  public static final String CONTACT_OPTION_DB_COLUMN_EMPLOYER = "employer_id";
  public static final String CONTACT_OPTION_DB_COLUMN_EMPLOYEE = "employee_id";
  public static final String CONTACT_OPTION_DB_COLUMN_TYPE = "type";
  public static final String CONTACT_OPTION_DB_COLUMN_VALUE = "value";

  // Credential.
  public static final String CREDENTIAL_DB_TABLE_NAME = DB_TABLE_PREFIX + "credential";
  public static final String CREDENTIAL_DB_COLUMN_USERNAME = "username";
  public static final String CREDENTIAL_DB_COLUMN_PASSWORD = "password";

  // User.
  public static final String USER_DB_TABLE_NAME = DB_TABLE_PREFIX + "user";
  public static final String USER_DB_COLUMN_EMAIL = "email";
  public static final String USER_DB_COLUMN_CREDENTIAL = "credential_id";
  public static final String USER_DB_COLUMN_WORKER = "worker_id";
  
  // User Group.
  public static final String USER_GROUP_DB_TABLE_NAME = DB_TABLE_PREFIX + "user_group";
  public static final String USER_GROUP_DB_COLUMN_NAME = "name";
  
  // User - User Group Mapping.
  public static final String USER_USER_GROUP_MAPPING_DB_TABLE_NAME = DB_TABLE_PREFIX + "users_in_user_group";
  public static final String USER_USER_GROUP_MAPPING_DB_COLUMN_USER_GROUP = "user_group_id";
  public static final String USER_USER_GROUP_MAPPING_DB_COLUMN_USER = "user_id";
}
