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

package org.opensaml.xml;

import javax.xml.namespace.QName;

import org.opensaml.xml.io.AbstractXMLObjectUnmarshaller;
import org.opensaml.xml.io.UnmarshallingException;
import org.opensaml.xml.util.XMLHelper;
import org.w3c.dom.Attr;
import org.w3c.dom.Element;

/**
 * A thread-safe unmarshaller for {@link org.apache.xml.security.utils.ElementProxy}s.
 */
public class ElementProxyUnmarshaller extends AbstractXMLObjectUnmarshaller {
    
    /*
     * @see org.opensaml.xml.io.AbstractXMLObjectUnmarshaller#buildXMLObject(org.w3c.dom.Element)
     */
    protected XMLObject buildXMLObject(Element domElement) throws UnmarshallingException {
        ElementProxy proxy = (ElementProxy) super.buildXMLObject(domElement);
        proxy.setElementQName(XMLHelper.getNodeQName(domElement));
        return proxy;
    }

    /*
     * @see org.opensaml.xml.io.AbstractXMLObjectUnmarshaller#processChildElement(org.opensaml.xml.XMLObject,
     *      org.opensaml.xml.XMLObject)
     */
    protected void processChildElement(XMLObject parentXMLObject, XMLObject childXMLObject)
            throws UnmarshallingException {
        ElementProxy elementProxy = (ElementProxy) parentXMLObject;
        elementProxy.getOrderedChildren().add(childXMLObject);
    }

    /*
     * @see org.opensaml.xml.io.AbstractXMLObjectUnmarshaller#processAttribute(org.opensaml.xml.XMLObject,
     *      org.w3c.dom.Attr)
     */
    protected void processAttribute(XMLObject xmlObject, Attr attribute) throws UnmarshallingException {
        ElementProxy elementProxy = (ElementProxy) xmlObject;
        QName attribQName = XMLHelper.constructQName(attribute.getNamespaceURI(), attribute.getLocalName(), attribute
                .getPrefix());
        elementProxy.getAttributes().put(attribQName, attribute.getValue());
    }

    /*
     * @see org.opensaml.xml.io.AbstractXMLObjectUnmarshaller#processElementContent(org.opensaml.xml.XMLObject,
     *      java.lang.String)
     */
    protected void processElementContent(XMLObject xmlObject, String elementContent) {
        ElementProxy elementProxy = (ElementProxy) xmlObject;
        elementProxy.setTextContent(elementContent);
    }
}