package com.redsocial.auth.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocial.auth.entity.Autorizaciones;

@Repository
public interface AutorizacionesRepository extends JpaRepository<Autorizaciones, String> {
	Optional<Autorizaciones> findById(String id);
}
