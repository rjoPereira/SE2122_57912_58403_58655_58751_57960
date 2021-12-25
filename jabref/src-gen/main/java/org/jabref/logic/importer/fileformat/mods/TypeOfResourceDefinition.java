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
 * &lt;p&gt;Java class for typeOfResourceDefinition complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="typeOfResourceDefinition"&amp;gt;
 *   &amp;lt;simpleContent&amp;gt;
 *     &amp;lt;extension base="&amp;lt;http://www.loc.gov/mods/v3&amp;gt;stringPlusLanguagePlusAuthority"&amp;gt;
 *       &amp;lt;attribute name="collection" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="yes" /&amp;gt;
 *       &amp;lt;attribute name="manuscript" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="yes" /&amp;gt;
 *       &amp;lt;attribute name="displayLabel" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *       &amp;lt;attribute name="altRepGroup" type="{http://www.w3.org/2001/XMLSchema}string" /&amp;gt;
 *       &amp;lt;attribute name="usage" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" fixed="primary" /&amp;gt;
 *     &amp;lt;/extension&amp;gt;
 *   &amp;lt;/simpleContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "typeOfResourceDefinition", namespace = "http://www.loc.gov/mods/v3")
public class TypeOfResourceDefinition
    extends StringPlusLanguagePlusAuthority
{

    @XmlAttribute(name = "collection")
    @XmlSchemaType(name = "anySimpleType")
    protected String collection;
    @XmlAttribute(name = "manuscript")
    @XmlSchemaType(name = "anySimpleType")
    protected String manuscript;
    @XmlAttribute(name = "displayLabel")
    protected String displayLabel;
    @XmlAttribute(name = "altRepGroup")
    protected String altRepGroup;
    @XmlAttribute(name = "usage")
    @XmlSchemaType(name = "anySimpleType")
    protected String usage;

    /**
     * Gets the value of the collection property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getCollection() {
        if (collection == null) {
            return "yes";
        } else {
            return collection;
        }
    }

    /**
     * Sets the value of the collection property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setCollection(String value) {
        this.collection = value;
    }

    /**
     * Gets the value of the manuscript property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getManuscript() {
        if (manuscript == null) {
            return "yes";
        } else {
            return manuscript;
        }
    }

    /**
     * Sets the value of the manuscript property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setManuscript(String value) {
        this.manuscript = value;
    }

    /**
     * Gets the value of the displayLabel property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getDisplayLabel() {
        return displayLabel;
    }

    /**
     * Sets the value of the displayLabel property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setDisplayLabel(String value) {
        this.displayLabel = value;
    }

    /**
     * Gets the value of the altRepGroup property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAltRepGroup() {
        return altRepGroup;
    }

    /**
     * Sets the value of the altRepGroup property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAltRepGroup(String value) {
        this.altRepGroup = value;
    }

    /**
     * Gets the value of the usage property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsage() {
        if (usage == null) {
            return "primary";
        } else {
            return usage;
        }
    }

    /**
     * Sets the value of the usage property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsage(String value) {
        this.usage = value;
    }

}