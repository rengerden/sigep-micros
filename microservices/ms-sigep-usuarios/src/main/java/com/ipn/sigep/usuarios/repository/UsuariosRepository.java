package com.ipn.sigep.usuarios.repository;

import com.ipn.sigep.usuarios.domain.Usuarios;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;

@Repository
@RepositoryRestResource(path = "usuarios", collectionResourceRel = "usuarios")
public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

  @RestResource(path = "buscaUsuario")
  public Usuarios findByNombreUsuario(@Param(value = "name") String name);
}
