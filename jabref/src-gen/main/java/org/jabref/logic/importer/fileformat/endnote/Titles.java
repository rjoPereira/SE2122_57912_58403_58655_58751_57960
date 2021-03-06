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
 *         &amp;lt;element ref="{}title" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}secondary-title" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}tertiary-title" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}alt-title" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}short-title" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}translated-title" minOccurs="0"/&amp;gt;
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
    "title",
    "secondaryTitle",
    "tertiaryTitle",
    "altTitle",
    "shortTitle",
    "translatedTitle"
})
@XmlRootElement(name = "titles")
public class Titles {

    protected Title title;
    @XmlElement(name = "secondary-title")
    protected SecondaryTitle secondaryTitle;
    @XmlElement(name = "tertiary-title")
    protected TertiaryTitle tertiaryTitle;
    @XmlElement(name = "alt-title")
    protected AltTitle altTitle;
    @XmlElement(name = "short-title")
    protected ShortTitle shortTitle;
    @XmlElement(name = "translated-title")
    protected TranslatedTitle translatedTitle;

    /**
     * Gets the value of the title property.
     * 
     * @return
     *     possible object is
     *     {@link Title }
     *     
     */
    public Title getTitle() {
        return title;
    }

    /**
     * Sets the value of the title property.
     * 
     * @param value
     *     allowed object is
     *     {@link Title }
     *     
     */
    public void setTitle(Title value) {
        this.title = value;
    }

    /**
     * Gets the value of the secondaryTitle property.
     * 
     * @return
     *     possible object is
     *     {@link SecondaryTitle }
     *     
     */
    public SecondaryTitle getSecondaryTitle() {
        return secondaryTitle;
    }

    /**
     * Sets the value of the secondaryTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link SecondaryTitle }
     *     
     */
    public void setSecondaryTitle(SecondaryTitle value) {
        this.secondaryTitle = value;
    }

    /**
     * Gets the value of the tertiaryTitle property.
     * 
     * @return
     *     possible object is
     *     {@link TertiaryTitle }
     *     
     */
    public TertiaryTitle getTertiaryTitle() {
        return tertiaryTitle;
    }

    /**
     * Sets the value of the tertiaryTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link TertiaryTitle }
     *     
     */
    public void setTertiaryTitle(TertiaryTitle value) {
        this.tertiaryTitle = value;
    }

    /**
     * Gets the value of the altTitle property.
     * 
     * @return
     *     possible object is
     *     {@link AltTitle }
     *     
     */
    public AltTitle getAltTitle() {
        return altTitle;
    }

    /**
     * Sets the value of the altTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link AltTitle }
     *     
     */
    public void setAltTitle(AltTitle value) {
        this.altTitle = value;
    }

    /**
     * Gets the value of the shortTitle property.
     * 
     * @return
     *     possible object is
     *     {@link ShortTitle }
     *     
     */
    public ShortTitle getShortTitle() {
        return shortTitle;
    }

    /**
     * Sets the value of the shortTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link ShortTitle }
     *     
     */
    public void setShortTitle(ShortTitle value) {
        this.shortTitle = value;
    }

    /**
     * Gets the value of the translatedTitle property.
     * 
     * @return
     *     possible object is
     *     {@link TranslatedTitle }
     *     
     */
    public TranslatedTitle getTranslatedTitle() {
        return translatedTitle;
    }

    /**
     * Sets the value of the translatedTitle property.
     * 
     * @param value
     *     allowed object is
     *     {@link TranslatedTitle }
     *     
     */
    public void setTranslatedTitle(TranslatedTitle value) {
        this.translatedTitle = value;
    }

}
