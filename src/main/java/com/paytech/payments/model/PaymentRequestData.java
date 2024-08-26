package com.paytech.payments.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public class PaymentRequestData {

    @Builder.Default
    private String paymentType = "DEPOSIT";

    @Builder.Default
    private String paymentMethod = "BASIC_CARD";

    private BigDecimal amount;

    private String currency;

    private Customer customer;
}
