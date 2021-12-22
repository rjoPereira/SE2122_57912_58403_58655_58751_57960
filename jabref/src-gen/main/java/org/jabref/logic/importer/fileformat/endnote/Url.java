//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.22 at 07:46:31 PM WET 
//


package org.jabref.logic.importer.fileformat.endnote;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlMixed;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.bind.annotation.adapters.CollapsedStringAdapter;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;


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
 *         &amp;lt;element ref="{}style" minOccurs="0"/&amp;gt;
 *       &amp;lt;/sequence&amp;gt;
 *       &amp;lt;attribute name="has-ut"&amp;gt;
 *         &amp;lt;simpleType&amp;gt;
 *           &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *             &amp;lt;enumeration value="yes"/&amp;gt;
 *             &amp;lt;enumeration value="no"/&amp;gt;
 *           &amp;lt;/restriction&amp;gt;
 *         &amp;lt;/simpleType&amp;gt;
 *       &amp;lt;/attribute&amp;gt;
 *       &amp;lt;attribute name="ppv-app" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&amp;gt;
 *       &amp;lt;attribute name="ppv-ref"&amp;gt;
 *         &amp;lt;simpleType&amp;gt;
 *           &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}token"&amp;gt;
 *             &amp;lt;enumeration value="yes"/&amp;gt;
 *             &amp;lt;enumeration value="no"/&amp;gt;
 *           &amp;lt;/restriction&amp;gt;
 *         &amp;lt;/simpleType&amp;gt;
 *       &amp;lt;/attribute&amp;gt;
 *       &amp;lt;attribute name="ppv-ut" type="{http://www.w3.org/2001/XMLSchema}anySimpleType" /&amp;gt;
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
@XmlRootElement(name = "url")
public class Url {

    @XmlElementRef(name = "style", type = Style.class, required = false)
    @XmlMixed
    protected List<Object> content;
    @XmlAttribute(name = "has-ut")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String hasUt;
    @XmlAttribute(name = "ppv-app")
    @XmlSchemaType(name = "anySimpleType")
    protected String ppvApp;
    @XmlAttribute(name = "ppv-ref")
    @XmlJavaTypeAdapter(CollapsedStringAdapter.class)
    protected String ppvRef;
    @XmlAttribute(name = "ppv-ut")
    @XmlSchemaType(name = "anySimpleType")
    protected String ppvUt;

    /**
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
     * {@link Style }
     * {@link String }
     * 
     * 
     */
    public List<Object> getContent() {
        if (content == null) {
            content = new ArrayList<Object>();
        }
        return this.content;
    }

    /**
     * Gets the value of the hasUt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHasUt() {
        return hasUt;
    }

    /**
     * Sets the value of the hasUt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHasUt(String value) {
        this.hasUt = value;
    }

    /**
     * Gets the value of the ppvApp property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPpvApp() {
        return ppvApp;
    }

    /**
     * Sets the value of the ppvApp property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPpvApp(String value) {
        this.ppvApp = value;
    }

    /**
     * Gets the value of the ppvRef property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPpvRef() {
        return ppvRef;
    }

    /**
     * Sets the value of the ppvRef property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPpvRef(String value) {
        this.ppvRef = value;
    }

    /**
     * Gets the value of the ppvUt property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getPpvUt() {
        return ppvUt;
    }

    /**
     * Sets the value of the ppvUt property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setPpvUt(String value) {
        this.ppvUt = value;
    }

}
