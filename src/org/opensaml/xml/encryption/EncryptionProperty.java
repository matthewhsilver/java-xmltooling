/*
 * Copyright [2006] [University Corporation for Advanced Internet Development, Inc.]
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

package org.opensaml.xml.encryption;


import javax.xml.namespace.QName;

import org.opensaml.xml.AttributeExtensibleXMLObject;
import org.opensaml.xml.ElementExtensibleXMLObject;
import org.opensaml.xml.util.XMLConstants;
import org.opensaml.xml.validation.ValidatingXMLObject;

/**
 * XMLObject representing XML Encryption, version 20021210, EncryptionProperty element.
 */
public interface EncryptionProperty extends ValidatingXMLObject, AttributeExtensibleXMLObject, ElementExtensibleXMLObject {
    
    /** Element local name */
    public final static String DEFAULT_ELEMENT_LOCAL_NAME = "EncryptionProperty";
    
    /** Default element name */
    public final static QName DEFAULT_ELEMENT_NAME = new QName(XMLConstants.XMLENC_NS, DEFAULT_ELEMENT_LOCAL_NAME, XMLConstants.XMLENC_PREFIX);
    
    /** Local name of the XSI type */
    public final static String TYPE_LOCAL_NAME = "EncryptionPropertyType"; 
        
    /** QName of the XSI type */
    public final static QName TYPE_NAME = new QName(XMLConstants.XMLENC_NS, TYPE_LOCAL_NAME, XMLConstants.XMLENC_PREFIX);
    
    /** Target attribute name */
    public final static String TARGET_ATTRIB_NAME = "Target";

    /** Id attribute name */
    public final static String ID_ATTRIB_NAME = "Id";
    
    /** Get the target URI attribute which specifies to which element this 
     * property applies
     * 
     * @return the target URI attribute
     */
    public String getTarget();
    
    /** Set the target URI attribute which specifies to which element this 
     * property applies
     * 
     * @param newTarget the new target URI attribute
     */
    public void setTarget(String newTarget);
    
    /**
     * Get the ID attribute which uniquely identifies this element
     * @return
     */
    public String getID();
    
    /**
     * Set the ID attribute which uniquely identifies this element
     * 
     * @param newID the new ID attribute
     */
    public void setID(String newID);

}