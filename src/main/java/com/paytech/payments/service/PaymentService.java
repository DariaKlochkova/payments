package com.paytech.payments.service;

import com.paytech.payments.exception.PaymentException;
import com.paytech.payments.model.Customer;
import com.paytech.payments.model.PaymentRequestData;
import com.paytech.payments.model.PaymentResponseData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

@Service
public class PaymentService {

    @Autowired
    private RestTemplate restTemplate;

    @Value("${payment.api.url}")
    private String paymentUrl;

    @Value("${payment.api.request.token}")
    private String paymentRequestToken;

    public String pay(BigDecimal amount, String currency) throws PaymentException {
        HttpHeaders headers = new HttpHeaders();
        headers.set("Authorization", "Bearer " + paymentRequestToken);
        headers.set("Content-Type", "application/json");

        PaymentRequestData requestData = PaymentRequestData.builder()
                .amount(amount)
                .currency(currency)
                .customer(new Customer())
                .build();
        HttpEntity<PaymentRequestData> entity = new HttpEntity<>(requestData, headers);

        try {
            ResponseEntity<PaymentResponseData> response = restTemplate.exchange(paymentUrl, HttpMethod.POST, entity, PaymentResponseData.class);
            System.out.println(response.getBody());
            return response.getBody().getResult().getRedirectUrl();
        } catch (HttpClientErrorException e) {
            throw new PaymentException(e.getMessage());
        }
    }
}
