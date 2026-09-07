package br.com.alura.integracao;

import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

// SpringBootTest levanta o contexto spring e injeta as dependencias
@SpringBootTest
@AutoConfigureMockMvc
class PaymentIntegrationTest {
  /**
   * Nao foge do contexto Spring
   */
  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private PaymentRepository repository;

  @Test
  void getPaymentById() throws Exception {
    // precondicao para o teste
    PaymentEntity build = PaymentEntity.builder().id(1L).build();

    PaymentEntity save = repository.save(build);

    mockMvc.perform(MockMvcRequestBuilders.get("/api/payments/{paymentId}", save.getId()))
        .andExpect(MockMvcResultMatchers.status().isOk())
        .andExpect(MockMvcResultMatchers.jsonPath("$.id", CoreMatchers.is(save.getId())));
  }
}
