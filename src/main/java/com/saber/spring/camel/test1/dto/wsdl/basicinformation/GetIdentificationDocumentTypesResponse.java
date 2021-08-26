
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
 *         &lt;element name="GetIdentificationDocumentTypesResult" type="{Fida.Models.BasicInformations}ArrayOfBasicInformation" minOccurs="0"/&gt;
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
    "getIdentificationDocumentTypesResult"
})
@XmlRootElement(name = "GetIdentificationDocumentTypesResponse")
public class GetIdentificationDocumentTypesResponse {

    @XmlElement(name = "GetIdentificationDocumentTypesResult")
    protected ArrayOfBasicInformation getIdentificationDocumentTypesResult;

    /**
     * Gets the value of the getIdentificationDocumentTypesResult property.
     * 
     * @return
     *     possible object is
     *     {@link ArrayOfBasicInformation }
     *     
     */
    public ArrayOfBasicInformation getGetIdentificationDocumentTypesResult() {
        return getIdentificationDocumentTypesResult;
    }

    /**
     * Sets the value of the getIdentificationDocumentTypesResult property.
     * 
     * @param value
     *     allowed object is
     *     {@link ArrayOfBasicInformation }
     *     
     */
    public void setGetIdentificationDocumentTypesResult(ArrayOfBasicInformation value) {
        this.getIdentificationDocumentTypesResult = value;
    }

}
