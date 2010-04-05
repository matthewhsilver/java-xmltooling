/*
 * Copyright 2008 University Corporation for Advanced Internet Development, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.opensaml.xml.schema.impl;

import org.joda.time.DateTime;
import org.opensaml.xml.XMLObject;
import org.opensaml.xml.io.BaseXMLObjectUnmarshaller;
import org.opensaml.xml.schema.XSDateTime;

/**
 * Thread-safe unmarshaller for {@link org.opensaml.xml.schema.XSDateTime} objects.
 */
public class XSDateTimeUnmarshaller extends BaseXMLObjectUnmarshaller{
    
    /** Constructor. */
    public XSDateTimeUnmarshaller(){}

    /** {@inheritDoc} */
    protected void processElementContent(XMLObject xmlObject, String elementContent) {
        XSDateTime xsDateTime = (XSDateTime) xmlObject;
        
        xsDateTime.setValue(new DateTime(elementContent));
    }

}
