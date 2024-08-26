package com.paytech.payments.controller;

import com.paytech.payments.exception.PaymentException;
import com.paytech.payments.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;

@Controller
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/")
    public String pay(@RequestParam BigDecimal amount,
                      @RequestParam String currency,
                      Model model) {
        try {
            String url = paymentService.pay(amount, currency);
            return "redirect:" + url;
        } catch (PaymentException e) {
            model.addAttribute("errorMessage", e.getMessage());
            return "error";
        }
    }
}
