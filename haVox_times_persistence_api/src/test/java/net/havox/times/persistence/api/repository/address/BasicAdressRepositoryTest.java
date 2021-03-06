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
package net.havox.times.persistence.api.repository.address;

import net.havox.times.model.api.address.Address;
import net.havox.times.model.api.model.BasicAddress;
import net.havox.times.persistence.api.repository.generic.BasicAddressRepository;

/**
 * Basic implementation of {@link AbstractAdressRepositoryTest}.
 *
 * @author Christian Otto
 */
public class BasicAdressRepositoryTest extends AbstractAddressRepositoryTest
{

  @Override
  public Address newEntity() throws Exception
  {
    return new BasicAddress();
  }

  @Override
  public AddressRepository getRepository() throws Exception
  {
    return new BasicAddressRepository();
  }
}
