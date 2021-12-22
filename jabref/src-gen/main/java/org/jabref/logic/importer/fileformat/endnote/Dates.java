//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.22 at 07:46:31 PM WET 
//


package org.jabref.logic.importer.fileformat.endnote;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for anonymous complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;sequence&amp;gt;
 *         &amp;lt;element ref="{}year" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}pub-dates" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}copyright-dates" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "year",
    "pubDates",
    "copyrightDates"
})
@XmlRootElement(name = "dates")
public class Dates {

    protected Year year;
    @XmlElement(name = "pub-dates")
    protected PubDates pubDates;
    @XmlElement(name = "copyright-dates")
    protected CopyrightDates copyrightDates;

    /**
     * Gets the value of the year property.
     * 
     * @return
     *     possible object is
     *     {@link Year }
     *     
     */
    public Year getYear() {
        return year;
    }

    /**
     * Sets the value of the year property.
     * 
     * @param value
     *     allowed object is
     *     {@link Year }
     *     
     */
    public void setYear(Year value) {
        this.year = value;
    }

    /**
     * Gets the value of the pubDates property.
     * 
     * @return
     *     possible object is
     *     {@link PubDates }
     *     
     */
    public PubDates getPubDates() {
        return pubDates;
    }

    /**
     * Sets the value of the pubDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link PubDates }
     *     
     */
    public void setPubDates(PubDates value) {
        this.pubDates = value;
    }

    /**
     * Gets the value of the copyrightDates property.
     * 
     * @return
     *     possible object is
     *     {@link CopyrightDates }
     *     
     */
    public CopyrightDates getCopyrightDates() {
        return copyrightDates;
    }

    /**
     * Sets the value of the copyrightDates property.
     * 
     * @param value
     *     allowed object is
     *     {@link CopyrightDates }
     *     
     */
    public void setCopyrightDates(CopyrightDates value) {
        this.copyrightDates = value;
    }

}
