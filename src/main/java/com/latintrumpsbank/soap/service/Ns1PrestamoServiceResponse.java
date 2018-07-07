
package com.latintrumpsbank.soap.service;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "@xmlns:ns1",
    "ns1:return"
})
public class Ns1PrestamoServiceResponse {

    @JsonProperty("@xmlns:ns1")
    private String xmlnsNs1;
    @JsonProperty("ns1:return")
    private String ns1Return;

    /**
     * No args constructor for use in serialization
     * 
     */
    public Ns1PrestamoServiceResponse() {
    }

    /**
     * 
     * @param ns1Return
     * @param xmlnsNs1
     */
    public Ns1PrestamoServiceResponse(String xmlnsNs1, String ns1Return) {
        super();
        this.xmlnsNs1 = xmlnsNs1;
        this.ns1Return = ns1Return;
    }

    @JsonProperty("@xmlns:ns1")
    public String getXmlnsNs1() {
        return xmlnsNs1;
    }

    @JsonProperty("@xmlns:ns1")
    public void setXmlnsNs1(String xmlnsNs1) {
        this.xmlnsNs1 = xmlnsNs1;
    }

    @JsonProperty("ns1:return")
    public String getNs1Return() {
        return ns1Return;
    }

    @JsonProperty("ns1:return")
    public void setNs1Return(String ns1Return) {
        this.ns1Return = ns1Return;
    }

}
