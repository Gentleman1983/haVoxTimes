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

import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.api.model.BasicContactOption;
import net.havox.times.model.api.model.BasicEmployer;
import net.havox.times.model.api.model.BasicWorker;

/**
 * Simplest implementation for {@link  AbstractContactOptionTest}.
 *
 * @author Christian Otto
 */
public class BasicContactOptionTest extends AbstractContactOptionTest
{

  @Override
  public ContactOption newInstance() throws Exception
  {
    return new BasicContactOption();
  }

  @Override
  public Employer newEmployer() throws Exception
  {
    return new BasicEmployer();
  }

  @Override
  public Worker newEmployee() throws Exception
  {
    return new BasicWorker();
  }
}
