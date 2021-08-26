
package com.saber.spring.camel.test1.dto.wsdl.basicinformation;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="GetLanguagesResult" type="{Fida.Models.BasicInformations}ArrayOfBasicInformation" minOccurs="0"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "getLanguagesResult"
})
@XmlRootElement(name = "GetLanguagesResponse")
public class GetLanguagesResponse {

    @XmlElement(name = "GetLanguagesResult")
    protected ArrayOfBasicInformation getLanguagesResult;

    /**
     * Gets the value of the getLanguagesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBasicInformation }
     *     
     */
    public ArrayOfBasicInformation getGetLanguagesResult() {
        return getLanguagesResult;
    }

    /**
     * Sets the value of the getLanguagesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBasicInformation }
     *     
     */
    public void setGetLanguagesResult(ArrayOfBasicInformation value) {
        this.getLanguagesResult = value;
    }

}
