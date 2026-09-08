package br.com.alura.datafactory;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@RequiredArgsConstructor
@Service
public class UserService {

  private final UserRepository repository;

  public UserEntity cadastrarUsuario(UserEntity user){
    if (!StringUtils.hasText(user.getEmail())){
      return null;
    }
    return this.repository.save(user);
  }
}
