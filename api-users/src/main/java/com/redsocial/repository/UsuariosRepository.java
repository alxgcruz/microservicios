package com.redsocial.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocial.entity.Usuarios;

@Repository
public interface UsuariosRepository extends JpaRepository<Usuarios, String> {
	Optional<Usuarios> findById(String id);
}
