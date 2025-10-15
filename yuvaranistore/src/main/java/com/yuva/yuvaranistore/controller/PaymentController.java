package com.yuva.yuvaranistore.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.yuva.yuvaranistore.dto.PaymentIntentRequestDto;
import com.yuva.yuvaranistore.dto.PaymentIntentResponseDto;
import com.yuva.yuvaranistore.service.IPaymentService;

@RestController
@RequestMapping("/api/v1/payment")
public class PaymentController {

    private final IPaymentService iPaymentService;

    public PaymentController(IPaymentService iPaymentService) {
        this.iPaymentService = iPaymentService;
    }

    @PostMapping("/create-payment-intent")
    public ResponseEntity<PaymentIntentResponseDto> createPaymentIntent(
            @RequestBody PaymentIntentRequestDto paymentRequest) {
        PaymentIntentResponseDto response =
                iPaymentService.createPaymentIntent(paymentRequest);
        return ResponseEntity.ok(response);
    }

}