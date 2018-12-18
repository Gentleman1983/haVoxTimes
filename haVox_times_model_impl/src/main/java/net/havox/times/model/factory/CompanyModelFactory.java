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
package net.havox.times.model.factory;

import net.havox.times.model.api.company.Employer;
import net.havox.times.model.api.company.Employment;
import net.havox.times.model.api.company.Worker;
import net.havox.times.model.impl.company.EmployerImpl;
import net.havox.times.model.impl.company.EmploymentImpl;
import net.havox.times.model.impl.company.WorkerImpl;

/**
 * The company model factory.
 *
 * @author Christian Otto
 */
public class CompanyModelFactory
{

  /**
   * The singleton model factory instance.
   */
  private static final CompanyModelFactory INSTANCE = new CompanyModelFactory();

  /**
   * The private default constructor.
   */
  private CompanyModelFactory()
  {
    super();
  }

  /**
   * Returns the singleton model factory.
   *
   * @return the {@link CompanyModelFactory} instance.
   */
  public static CompanyModelFactory getInstance()
  {
    return CompanyModelFactory.INSTANCE;
  }

  /**
   * Returns a new {@link Employer}.
   *
   * @return a new employer entity.
   */
  public Employer getNewEmployer()
  {
    return new EmployerImpl();
  }

  /**
   * Returns a new {@link Employment}.
   *
   * @return a new employment entity.
   */
  public Employment getNewEmployment()
  {
    return new EmploymentImpl();
  }

  /**
   * Returns a new {@link Worker}.
   *
   * @return a new worker entity.
   */
  public Worker getNewWorker()
  {
    return new WorkerImpl();
  }
}
