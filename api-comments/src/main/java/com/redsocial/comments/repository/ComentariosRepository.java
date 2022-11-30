package com.redsocial.comments.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocial.comments.entity.Comentarios;

@Repository
public interface ComentariosRepository extends JpaRepository<Comentarios, String> {
	Optional<Comentarios> findById(String id);
	List<Comentarios> findByIdPublicacion(String idPost);
}
