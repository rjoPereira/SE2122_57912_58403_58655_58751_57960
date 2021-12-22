//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.22 at 07:46:30 PM WET 
//


package org.jabref.logic.importer.fileformat.bibtexml;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for monthTypeString.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="monthTypeString"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="Jan"/&amp;gt;
 *     &amp;lt;enumeration value="Feb"/&amp;gt;
 *     &amp;lt;enumeration value="Mar"/&amp;gt;
 *     &amp;lt;enumeration value="Apr"/&amp;gt;
 *     &amp;lt;enumeration value="May"/&amp;gt;
 *     &amp;lt;enumeration value="Jun"/&amp;gt;
 *     &amp;lt;enumeration value="Jul"/&amp;gt;
 *     &amp;lt;enumeration value="Aug"/&amp;gt;
 *     &amp;lt;enumeration value="Sep"/&amp;gt;
 *     &amp;lt;enumeration value="Oct"/&amp;gt;
 *     &amp;lt;enumeration value="Nov"/&amp;gt;
 *     &amp;lt;enumeration value="Dec"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "monthTypeString")
@XmlEnum
public enum MonthTypeString {

    @XmlEnumValue("Jan")
    JAN("Jan"),
    @XmlEnumValue("Feb")
    FEB("Feb"),
    @XmlEnumValue("Mar")
    MAR("Mar"),
    @XmlEnumValue("Apr")
    APR("Apr"),
    @XmlEnumValue("May")
    MAY("May"),
    @XmlEnumValue("Jun")
    JUN("Jun"),
    @XmlEnumValue("Jul")
    JUL("Jul"),
    @XmlEnumValue("Aug")
    AUG("Aug"),
    @XmlEnumValue("Sep")
    SEP("Sep"),
    @XmlEnumValue("Oct")
    OCT("Oct"),
    @XmlEnumValue("Nov")
    NOV("Nov"),
    @XmlEnumValue("Dec")
    DEC("Dec");
    private final String value;

    MonthTypeString(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static MonthTypeString fromValue(String v) {
        for (MonthTypeString c: MonthTypeString.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
