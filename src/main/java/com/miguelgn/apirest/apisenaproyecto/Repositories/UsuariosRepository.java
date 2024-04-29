package com.miguelgn.apirest.apisenaproyecto.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.miguelgn.apirest.apisenaproyecto.Entities.Usuarios;

public interface UsuariosRepository extends JpaRepository<Usuarios, Long> {

}
