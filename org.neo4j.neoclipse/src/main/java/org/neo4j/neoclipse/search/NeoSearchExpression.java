/**
 * Licensed to Neo Technology under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Neo Technology licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package org.neo4j.neoclipse.search;

import java.util.regex.Pattern;

/**
 * This class is a Neo search expression that is based on Java regular
 * expressions.
 * @author Peter H&auml;nsgen
 */
public class NeoSearchExpression
{
    /**
     * The compiled regular expression.
     */
    private final Pattern pattern;
    private static final Pattern ID_PATTERN = Pattern.compile( "\\d+" );

    /**
     * The constructor.
     */
    public NeoSearchExpression( final Pattern pattern )
    {
        this.pattern = pattern;
    }

    /**
     * Returns true, if the given value represents a match.
     */
    public boolean matches( final Object value )
    {
        String v = String.valueOf( value );

        return pattern.matcher( v ).matches();
    }

    /**
     * Returns the search expression string, e.g. the regular expression.
     */
    public String getExpression()
    {
        return pattern.pattern();
    }

    /**
     * Test if the pattern could be a full node id.
     * @return true if pattern could be a full id number
     */
    public boolean isPossibleId()
    {
        return ID_PATTERN.matcher( pattern.pattern() ).matches();
    }
}
