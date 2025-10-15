package com.yuva.yuvaranistore.service;

import com.yuva.yuvaranistore.dto.PaymentIntentRequestDto;
import com.yuva.yuvaranistore.dto.PaymentIntentResponseDto;

public interface IPaymentService {

    PaymentIntentResponseDto createPaymentIntent(PaymentIntentRequestDto requestDto);
}
