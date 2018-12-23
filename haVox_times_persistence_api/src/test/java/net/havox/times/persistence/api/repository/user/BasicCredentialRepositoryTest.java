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
package net.havox.times.persistence.api.repository.user;

import net.havox.times.model.api.model.BasicCredential;
import net.havox.times.model.api.user.Credential;
import net.havox.times.persistence.api.repository.generic.BasicCredentialRepository;

/**
 * Basic implementation of {@link AbstractCredentialRepositoryTest}.
 *
 * @author Christian Otto
 */
public class BasicCredentialRepositoryTest extends AbstractCredentialRepositoryTest
{

  @Override
  public Credential newEntity() throws Exception
  {
    return new BasicCredential();
  }

  @Override
  public CredentialRepository getRepository() throws Exception
  {
    return new BasicCredentialRepository();
  }

}
