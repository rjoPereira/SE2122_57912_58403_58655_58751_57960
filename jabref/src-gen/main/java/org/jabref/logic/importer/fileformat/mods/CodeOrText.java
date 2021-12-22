//
// This file was generated by the Eclipse Implementation of JAXB, v2.3.3 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2021.12.22 at 07:46:31 PM WET 
//


package org.jabref.logic.importer.fileformat.mods;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * &lt;p&gt;Java class for codeOrText.
 * 
 * &lt;p&gt;The following schema fragment specifies the expected content contained within this class.
 * &lt;pre&gt;
 * &amp;lt;simpleType name="codeOrText"&amp;gt;
 *   &amp;lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&amp;gt;
 *     &amp;lt;enumeration value="code"/&amp;gt;
 *     &amp;lt;enumeration value="text"/&amp;gt;
 *   &amp;lt;/restriction&amp;gt;
 * &amp;lt;/simpleType&amp;gt;
 * &lt;/pre&gt;
 * 
 */
@XmlType(name = "codeOrText", namespace = "http://www.loc.gov/mods/v3")
@XmlEnum
public enum CodeOrText {

    @XmlEnumValue("code")
    CODE("code"),
    @XmlEnumValue("text")
    TEXT("text");
    private final String value;

    CodeOrText(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static CodeOrText fromValue(String v) {
        for (CodeOrText c: CodeOrText.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
