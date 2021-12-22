//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.22 at 07:46:31 PM WET 
//


package org.jabref.logic.importer.fileformat.mods;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for citySectionDefinition complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="citySectionDefinition"&amp;gt;
 *   &amp;lt;simpleContent&amp;gt;
 *     &amp;lt;extension base="&amp;lt;http://www.loc.gov/mods/v3&amp;gt;hierarchicalPart"&amp;gt;
 *       &amp;lt;attribute name="citySectionType" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/simpleContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "citySectionDefinition", namespace = "http://www.loc.gov/mods/v3")
public class CitySectionDefinition
    extends HierarchicalPart
{

    @XmlAttribute(name = "citySectionType")
    @XmlSchemaType(name = "anySimpleType")
    protected String citySectionType;

    /**
     * Gets the value of the citySectionType property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCitySectionType() {
        return citySectionType;
    }

    /**
     * Sets the value of the citySectionType property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCitySectionType(String value) {
        this.citySectionType = value;
    }

}
