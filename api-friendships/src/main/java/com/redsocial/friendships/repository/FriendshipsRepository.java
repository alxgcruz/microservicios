package com.redsocial.friendships.repository;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.redsocial.friendships.entity.Friendships;

@Repository
public interface FriendshipsRepository extends JpaRepository<Friendships, String> {
	Optional<Friendships> findById(String id);
	List<Friendships> findByIdUsuario(String idUsuario);
}
