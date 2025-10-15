package com.yuva.yuvaranistore.service.impl;

import org.springframework.stereotype.Service;
import com.stripe.exception.StripeException;
import com.stripe.model.PaymentIntent;
import com.stripe.param.PaymentIntentCreateParams;
import com.yuva.yuvaranistore.dto.PaymentIntentRequestDto;
import com.yuva.yuvaranistore.dto.PaymentIntentResponseDto;
import com.yuva.yuvaranistore.service.IPaymentService;

@Service
public class PaymentServiceImpl implements IPaymentService {

    @Override
    public PaymentIntentResponseDto createPaymentIntent(PaymentIntentRequestDto requestDto) {
        try {
            PaymentIntentCreateParams params = PaymentIntentCreateParams.builder()
                    .setAmount(requestDto.amount())
                    .setCurrency(requestDto.currency())
                    .addPaymentMethodType("card").build();
            PaymentIntent paymentIntent = PaymentIntent.create(params);
            return new PaymentIntentResponseDto(paymentIntent.getClientSecret());
        } catch (StripeException e) {
            throw new RuntimeException("Failed to create payment intent", e);
        }

    }
}