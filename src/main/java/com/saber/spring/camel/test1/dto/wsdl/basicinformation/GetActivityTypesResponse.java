
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
 *         &lt;element name="GetActivityTypesResult" type="{Fida.Models.BasicInformations}ArrayOfBasicInformation" minOccurs="0"/&gt;
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
    "getActivityTypesResult"
})
@XmlRootElement(name = "GetActivityTypesResponse")
public class GetActivityTypesResponse {

    @XmlElement(name = "GetActivityTypesResult")
    protected ArrayOfBasicInformation getActivityTypesResult;

    /**
     * Gets the value of the getActivityTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBasicInformation }
     *     
     */
    public ArrayOfBasicInformation getGetActivityTypesResult() {
        return getActivityTypesResult;
    }

    /**
     * Sets the value of the getActivityTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBasicInformation }
     *     
     */
    public void setGetActivityTypesResult(ArrayOfBasicInformation value) {
        this.getActivityTypesResult = value;
    }

}
