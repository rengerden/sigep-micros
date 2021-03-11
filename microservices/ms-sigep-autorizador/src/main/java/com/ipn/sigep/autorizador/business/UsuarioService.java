package com.ipn.sigep.autorizador.business;

import com.ipn.sigep.autorizador.clients.UsuariosClient;
import com.ipn.sigep.autorizador.domain.Usuarios;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Collections;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class UsuarioService.
 */
@Service

/** The Constant log. */
@Slf4j
public class UsuarioService implements UserDetailsService {

  /** The usuarios client. */
  @Autowired
  UsuariosClient usuariosClient;

  /**
   * Load user by username.
   *
   * @param username the username
   * @return the user details
   * @throws UsernameNotFoundException the username not found exception
   */
  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
    Usuarios usuario = usuariosClient.getUsuarios(username);


    if (usuario == null) {
      log.error(
          "Ocurrio un error al consultar el usuario es probable que este no exista en el sistema");
      throw new UsernameNotFoundException("El usuario no existe en el sistema");
    } else {
      return new User(usuario.getNombreUsuario(), usuario.getPassword(), true, true, true, true,
          Collections.singleton(new SimpleGrantedAuthority(usuario.getRole())));
    }


  }

}
