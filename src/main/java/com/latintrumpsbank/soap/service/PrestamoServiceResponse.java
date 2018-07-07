
package com.latintrumpsbank.soap.service;

import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.annotate.JsonPropertyOrder;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
@JsonPropertyOrder({
    "ns1:prestamoServiceResponse"
})
public class PrestamoServiceResponse {

    @JsonProperty("ns1:prestamoServiceResponse")
    private Ns1PrestamoServiceResponse ns1PrestamoServiceResponse;

    /**
     * No args constructor for use in serialization
     * 
     */
    public PrestamoServiceResponse() {
    }

    /**
     * 
     * @param ns1PrestamoServiceResponse
     */
    public PrestamoServiceResponse(Ns1PrestamoServiceResponse ns1PrestamoServiceResponse) {
        super();
        this.ns1PrestamoServiceResponse = ns1PrestamoServiceResponse;
    }

    @JsonProperty("ns1:prestamoServiceResponse")
    public Ns1PrestamoServiceResponse getNs1PrestamoServiceResponse() {
        return ns1PrestamoServiceResponse;
    }

    @JsonProperty("ns1:prestamoServiceResponse")
    public void setNs1PrestamoServiceResponse(Ns1PrestamoServiceResponse ns1PrestamoServiceResponse) {
        this.ns1PrestamoServiceResponse = ns1PrestamoServiceResponse;
    }

}
