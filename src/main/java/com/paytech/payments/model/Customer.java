package com.paytech.payments.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Getter;

@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {

    private String referenceId = "customer_124";
    private String citizenshipCountryCode = "RU";
    private String firstName = "Daria";
    private String lastName = "K";
}
