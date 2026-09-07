package br.com.alura.integracao;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@RequiredArgsConstructor
@Service
public class PaymentService {

  private final PaymentRepository repository;

  public PaymentResponse createPayment(@Valid PaymentRequest request) {return null;}

  public PaymentEntity getPayment(Long paymentId) {return this.repository.getById(paymentId);}
}
