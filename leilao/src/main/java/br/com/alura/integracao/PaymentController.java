package br.com.alura.integracao;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/payments")
public class PaymentController {

  private final PaymentService paymentService;

  @PostMapping
  @ResponseStatus(HttpStatus.CREATED)
  public PaymentResponse createPayment(@Valid @RequestBody PaymentRequest request){
    return paymentService.createPayment(request);
  }

  @GetMapping("/{paymentId}")
  public PaymentResponse getPayment(@PathVariable Long paymentId){
    PaymentEntity entity = paymentService.getPayment(paymentId);
    return PaymentResponse.builder()
        .id(entity.getId())
        .build();
  }
}
