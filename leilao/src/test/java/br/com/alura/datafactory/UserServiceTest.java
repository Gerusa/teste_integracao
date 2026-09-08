package br.com.alura.datafactory;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class UserServiceTest {

  @InjectMocks
  private UserService service;

  @Mock
  private UserRepository repository;

  @Test
  void cadastrarUsuarioTest(){
    var usuario = UserDataFactory.usuarioValido();

    service.cadastrarUsuario(usuario);

    verify(repository).save(usuario);
  }
}
