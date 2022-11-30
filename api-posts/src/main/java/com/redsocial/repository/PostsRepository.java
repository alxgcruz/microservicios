package com.redsocial.repository;

import java.util.Optional;
import java.util.ArrayList;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocial.entity.Posts;

@Repository
public interface PostsRepository extends JpaRepository<Posts, String> {
	Optional<Posts> findById(String id);

	ArrayList<Posts> findByIdUsuario(String idUsuario);
}
