package com.ipn.sigep.autorizador.clients;

import com.ipn.sigep.autorizador.domain.Usuarios;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "ms-sigep-usuarios")
public interface UsuariosClient {

  @GetMapping("/usuarios/search/buscaUsuario")
  public Usuarios getUsuarios (@RequestParam String name);
}
