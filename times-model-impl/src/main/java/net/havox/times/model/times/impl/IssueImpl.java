/*
 * Copyright (C) 2015 [haVox] Design
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
package net.havox.times.model.times.impl;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import net.havox.times.model.times.api.Issue;
import net.havox.times.model.times.api.Task;
import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * The standard implementation of an issue.
 * 
 * @author Christian Otto
 */
public class IssueImpl implements Issue {

    /**
     * The SerialVersionUID.
     */
    private static final long serialVersionUID = -8302339463943510497L;

    /**
     * The id.
     */
    private Long id;
    
    /**
     * The version.
     */
    private long version;
    /**
     * The issue description.
     */
    private String description;
    /**
     * The start time.
     */
    private LocalDateTime start;
    /**
     * The end time.
     */
    private LocalDateTime end;
    /**
     * The contained tasks.
     */
    private Collection<Task> tasks = new ArrayList<>();
    

    /**
     * {@inheritDoc}
     */
    @Override
    public Long getId() {
        return this.id;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getVersion() {
        return this.version;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getDescription() {
        return this.description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Collection<Task> getTasks() {
        return this.tasks;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime getStart() {
        return this.start;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime getEnd() {
        return this.end;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        int hashCode;

        if (this.getId() == null) {
            hashCode = super.hashCode();
        } else {
            HashCodeBuilder builder = new HashCodeBuilder();

            builder.append(this.getId());

            hashCode = builder.toHashCode();
        }

        return hashCode;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof Issue) {
            Issue issue = (Issue) obj;

            if (this.getId() == null) {
                return (this == issue);
            } else {
                EqualsBuilder builder = new EqualsBuilder();

                builder.append(this.getId(), issue.getId());

                return builder.isEquals();
            }
        }

        return false;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        ToStringBuilder builder = new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE);
        
        builder.append(this.getId());
        builder.append(this.getDescription());
        builder.append(this.getStart());
        builder.append(this.getEnd());
        builder.append(this.getDuration());
        builder.append(this.getTasks());

        return builder.toString();
    }
}
