//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.22 at 07:46:31 PM WET 
//


package org.jabref.logic.importer.fileformat.mods;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElementRef;
import javax.xml.bind.annotation.XmlElementRefs;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for hierarchicalGeographicDefinition complex type.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * 
 * &lt;pre&gt;
 * &amp;lt;complexType name="hierarchicalGeographicDefinition"&amp;gt;
 *   &amp;lt;complexContent&amp;gt;
 *     &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&amp;gt;
 *       &amp;lt;choice maxOccurs="unbounded"&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}extraTerrestrialArea"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}continent"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}country"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}province"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}region"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}state"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}territory"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}county"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}city"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}citySection"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}island"/&amp;gt;
 *         &amp;lt;element ref="{http://www.loc.gov/mods/v3}area"/&amp;gt;
 *       &amp;lt;/choice&amp;gt;
 *       &amp;lt;attGroup ref="{http://www.loc.gov/mods/v3}authorityAttributeGroup"/&amp;gt;
 *     &amp;lt;/restriction&amp;gt;
 *   &amp;lt;/complexContent&amp;gt;
 * &amp;lt;/complexType&amp;gt;
 * &lt;/pre&gt;
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "hierarchicalGeographicDefinition", namespace = "http://www.loc.gov/mods/v3", propOrder = {
    "extraTerrestrialAreaOrContinentOrCountry"
})
public class HierarchicalGeographicDefinition {

    @XmlElementRefs({
        @XmlElementRef(name = "extraTerrestrialArea", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "continent", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "country", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "province", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "region", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "state", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "territory", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "county", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "city", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "citySection", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "island", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false),
        @XmlElementRef(name = "area", namespace = "http://www.loc.gov/mods/v3", type = JAXBElement.class, required = false)
    })
    protected List<JAXBElement<? extends StringPlusLanguage>> extraTerrestrialAreaOrContinentOrCountry;
    @XmlAttribute(name = "authority")
    protected String authority;
    @XmlAttribute(name = "authorityURI")
    @XmlSchemaType(name = "anyURI")
    protected String authorityURI;
    @XmlAttribute(name = "valueURI")
    @XmlSchemaType(name = "anyURI")
    protected String valueURI;

    /**
     * Gets the value of the extraTerrestrialAreaOrContinentOrCountry property.
     * 
     * &lt;p&gt;
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a &lt;CODE&gt;set&lt;/CODE&gt; method for the extraTerrestrialAreaOrContinentOrCountry property.
     * 
     * &lt;p&gt;
     * For example, to add a new item, do as follows:
     * &lt;pre&gt;
     *    getExtraTerrestrialAreaOrContinentOrCountry().add(newItem);
     * &lt;/pre&gt;
     * 
     * 
     * &lt;p&gt;
     * Objects of the following type(s) are allowed in the list
     * {@link JAXBElement }{@code <}{@link HierarchicalPart }{@code >}
     * {@link JAXBElement }{@code <}{@link HierarchicalPart }{@code >}
     * {@link JAXBElement }{@code <}{@link HierarchicalPart }{@code >}
     * {@link JAXBElement }{@code <}{@link StringPlusLanguage }{@code >}
     * {@link JAXBElement }{@code <}{@link RegionDefinition }{@code >}
     * {@link JAXBElement }{@code <}{@link HierarchicalPart }{@code >}
     * {@link JAXBElement }{@code <}{@link HierarchicalPart }{@code >}
     * {@link JAXBElement }{@code <}{@link HierarchicalPart }{@code >}
     * {@link JAXBElement }{@code <}{@link HierarchicalPart }{@code >}
     * {@link JAXBElement }{@code <}{@link CitySectionDefinition }{@code >}
     * {@link JAXBElement }{@code <}{@link HierarchicalPart }{@code >}
     * {@link JAXBElement }{@code <}{@link AreaDefinition }{@code >}
     * 
     * 
     */
    public List<JAXBElement<? extends StringPlusLanguage>> getExtraTerrestrialAreaOrContinentOrCountry() {
        if (extraTerrestrialAreaOrContinentOrCountry == null) {
            extraTerrestrialAreaOrContinentOrCountry = new ArrayList<JAXBElement<? extends StringPlusLanguage>>();
        }
        return this.extraTerrestrialAreaOrContinentOrCountry;
    }

    /**
     * Gets the value of the authority property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthority() {
        return authority;
    }

    /**
     * Sets the value of the authority property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthority(String value) {
        this.authority = value;
    }

    /**
     * Gets the value of the authorityURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getAuthorityURI() {
        return authorityURI;
    }

    /**
     * Sets the value of the authorityURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setAuthorityURI(String value) {
        this.authorityURI = value;
    }

    /**
     * Gets the value of the valueURI property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getValueURI() {
        return valueURI;
    }

    /**
     * Sets the value of the valueURI property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setValueURI(String value) {
        this.valueURI = value;
    }

}
