package com.paytech.payments.service;

import com.paytech.payments.exception.PaymentException;
import com.paytech.payments.model.PaymentResponseData;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.bean.override.mockito.MockitoBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceTest {

    @Autowired
    private PaymentService paymentService;

    @MockitoBean
    private RestTemplate restTemplate;

    @Test
    void whenInputIsCorrect_thenRedirectUrlIsReturned() throws PaymentException {
        final String expectedRedirectUrl = "https://test/url";
        PaymentResponseData.Result result = new PaymentResponseData.Result(expectedRedirectUrl);
        PaymentResponseData responseData = new PaymentResponseData();
        responseData.setResult(result);

        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), any(Class.class)))
                .thenReturn(new ResponseEntity<>(responseData, HttpStatus.OK));

        String actualRedirectUrl = paymentService.pay(new BigDecimal("10.01"), "RUB");
        assertEquals(expectedRedirectUrl, actualRedirectUrl);
    }

    @Test
    void whenInputIsNotCorrect_thenExceptionIsThrown() {
        when(restTemplate.exchange(anyString(), eq(HttpMethod.POST), any(HttpEntity.class), any(Class.class)))
                .thenThrow(HttpClientErrorException.class);

        assertThrows(PaymentException.class, () -> {
            paymentService.pay(new BigDecimal("10.01"), "EURO");
        });
    }
}