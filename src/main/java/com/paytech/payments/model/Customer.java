package com.paytech.payments.model;

import lombok.Getter;

@Getter
public class Customer {

    private String referenceId = "customer_123";
    private String citizenshipCountryCode = "AU";
    private String firstName = "John";
    private String lastName = "Smith";
    private String dateOfBirth = "2001-12-03";
    private String email = "my@email.com";
    private String phone = "357 123123123";
    private String locale = "ru";
    private String accountNumber = "string";
    private String accountName = "string";
    private String bank = "string";
    private String bankBranch = "string";
    private String documentType = "string";
    private String documentNumber = "string";
    private String routingGroup = "VIP";
    private boolean kycStatus = true;
    private boolean paymentInstrumentKycStatus = true;
}
