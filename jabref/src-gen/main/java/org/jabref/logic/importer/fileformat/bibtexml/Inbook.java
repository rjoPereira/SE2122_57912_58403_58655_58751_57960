//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.22 at 07:46:30 PM WET 
//


package org.jabref.logic.importer.fileformat.bibtexml;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


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
 *         &amp;lt;choice&amp;gt;
 *           &amp;lt;element name="author" type="{http://bibtexml.sf.net/}authorType"/&amp;gt;
 *         &amp;lt;/choice&amp;gt;
 *         &amp;lt;element name="title" type="{http://bibtexml.sf.net/}titleType"/&amp;gt;
 *         &amp;lt;choice&amp;gt;
 *           &amp;lt;group ref="{http://bibtexml.sf.net/}inbookGroup1"/&amp;gt;
 *           &amp;lt;element name="pages" type="{http://bibtexml.sf.net/}pagesType"/&amp;gt;
 *         &amp;lt;/choice&amp;gt;
 *         &amp;lt;element name="publisher" type="{http://bibtexml.sf.net/}publisherType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="year" type="{http://bibtexml.sf.net/}yearType" minOccurs="0"/&amp;gt;
 *         &amp;lt;choice minOccurs="0"&amp;gt;
 *           &amp;lt;element name="volume" type="{http://bibtexml.sf.net/}volumeType"/&amp;gt;
 *           &amp;lt;element name="number" type="{http://bibtexml.sf.net/}numberType"/&amp;gt;
 *         &amp;lt;/choice&amp;gt;
 *         &amp;lt;element name="series" type="{http://bibtexml.sf.net/}seriesType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="editor" type="{http://bibtexml.sf.net/}editorType"/&amp;gt;
 *         &amp;lt;element name="type" type="{http://bibtexml.sf.net/}typeType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="address" type="{http://bibtexml.sf.net/}addressType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="edition" type="{http://bibtexml.sf.net/}editionType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="month" type="{http://bibtexml.sf.net/}monthType" minOccurs="0"/&amp;gt;
 *         &amp;lt;element name="note" type="{http://bibtexml.sf.net/}noteType" minOccurs="0"/&amp;gt;
 *         &amp;lt;group ref="{http://bibtexml.sf.net/}common"/&amp;gt;
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
    "content"
})
@XmlRootElement(name = "inbook")
public class Inbook {

    @XmlElementRefs({
        @XmlElementRef(name = "author", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "title", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "chapter", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "pages", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "publisher", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "year", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "volume", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "number", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "series", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "editor", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "type", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "address", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "edition", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "month", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "note", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "key", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "annotate", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "crossref", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "abstract", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "affiliation", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "contents", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "copyright", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "doi", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "isbn", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "issn", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "keywords", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "language", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "lccn", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "location", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "mrnumber", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "price", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "size", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "url", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "category", namespace = "http://bibtexml.sf.net/", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<?>> content;

    /**
     * Gets the rest of the content model. 
     * 
     * &lt;p&gt;
     * You are getting this "catch-all" property because of the following reason: 
     * The field name "Pages" is used by two different parts of a schema. See: 
     * line 405 of file:/home/ricardo/IdeaProjects/SE2122_57912_58403_58655_58751_57960/jabref/src/main/resources/xjc/bibtexml/bibtexml.xsd
     * line 446 of file:/home/ricardo/IdeaProjects/SE2122_57912_58403_58655_58751_57960/jabref/src/main/resources/xjc/bibtexml/bibtexml.xsd
     * &lt;p&gt;
     * To get rid of this property, apply a property customization to one 
     * of both of the following declarations to change their names: 
     * Gets the value of the content property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the content property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getContent().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link XMLGregorianCalendar }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link BigInteger }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * {@link JAXBElement }{@code <}{@link String }{@code >}
     * 
     * 
     */
    public List<JAXBElement<?>> getContent() {
        if (content == null) {
            content = new ArrayList<JAXBElement<?>>();
        }
        return this.content;
    }

}