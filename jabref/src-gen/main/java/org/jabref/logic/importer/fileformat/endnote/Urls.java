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
 *         &amp;lt;element ref="{}web-urls" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}pdf-urls" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}text-urls" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}related-urls" minOccurs="0"/&amp;gt;
 *         &amp;lt;element ref="{}image-urls" minOccurs="0"/&amp;gt;
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
    "webUrls",
    "pdfUrls",
    "textUrls",
    "relatedUrls",
    "imageUrls"
})
@XmlRootElement(name = "urls")
public class Urls {

    @XmlElement(name = "web-urls")
    protected WebUrls webUrls;
    @XmlElement(name = "pdf-urls")
    protected PdfUrls pdfUrls;
    @XmlElement(name = "text-urls")
    protected TextUrls textUrls;
    @XmlElement(name = "related-urls")
    protected RelatedUrls relatedUrls;
    @XmlElement(name = "image-urls")
    protected ImageUrls imageUrls;

    /**
     * Gets the value of the webUrls property.
     * 
     * @return
     *     possible object is
     *     {@link WebUrls }
     *     
     */
    public WebUrls getWebUrls() {
        return webUrls;
    }

    /**
     * Sets the value of the webUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link WebUrls }
     *     
     */
    public void setWebUrls(WebUrls value) {
        this.webUrls = value;
    }

    /**
     * Gets the value of the pdfUrls property.
     * 
     * @return
     *     possible object is
     *     {@link PdfUrls }
     *     
     */
    public PdfUrls getPdfUrls() {
        return pdfUrls;
    }

    /**
     * Sets the value of the pdfUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link PdfUrls }
     *     
     */
    public void setPdfUrls(PdfUrls value) {
        this.pdfUrls = value;
    }

    /**
     * Gets the value of the textUrls property.
     * 
     * @return
     *     possible object is
     *     {@link TextUrls }
     *     
     */
    public TextUrls getTextUrls() {
        return textUrls;
    }

    /**
     * Sets the value of the textUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link TextUrls }
     *     
     */
    public void setTextUrls(TextUrls value) {
        this.textUrls = value;
    }

    /**
     * Gets the value of the relatedUrls property.
     * 
     * @return
     *     possible object is
     *     {@link RelatedUrls }
     *     
     */
    public RelatedUrls getRelatedUrls() {
        return relatedUrls;
    }

    /**
     * Sets the value of the relatedUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link RelatedUrls }
     *     
     */
    public void setRelatedUrls(RelatedUrls value) {
        this.relatedUrls = value;
    }

    /**
     * Gets the value of the imageUrls property.
     * 
     * @return
     *     possible object is
     *     {@link ImageUrls }
     *     
     */
    public ImageUrls getImageUrls() {
        return imageUrls;
    }

    /**
     * Sets the value of the imageUrls property.
     * 
     * @param value
     *     allowed object is
     *     {@link ImageUrls }
     *     
     */
    public void setImageUrls(ImageUrls value) {
        this.imageUrls = value;
    }

}