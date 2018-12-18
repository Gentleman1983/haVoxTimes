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

import net.havox.times.model.api.model.BasicAccount;
import net.havox.times.model.api.model.BasicBooking;
import net.havox.times.model.api.model.BasicProject;

/**
 * Basic implementation of {@link AbstractAccountTest}.
 *
 * @author Christian Otto
 */
public class BasicAccountTest extends AbstractAccountTest
{

  @Override
  public Account newInstance() throws Exception
  {
    return new BasicAccount();
  }

  @Override
  public Project newProject() throws Exception
  {
    return new BasicProject();
  }

  @Override
  public Booking newBooking() throws Exception
  {
    return new BasicBooking();
  }
}
