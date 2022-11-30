package com.redsocial.api;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.OK;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.redsocial.modelo.PostsDto;
import com.redsocial.modelo.ConfirmacionResumenDto;
import com.redsocial.service.PostsServiceImpl;

@RestController
@RequestMapping("posts/v1")
public class PostsController {

	private static final Logger log = Logger.getLogger(PostsController.class);
	@Autowired
	private PostsServiceImpl postsService;

	@PostMapping
	@ResponseStatus(CREATED)
	public PostsDto crear(@RequestBody PostsDto post) {
		log.info(">>> posts/v1 creando post");
		return postsService.guardarPost(post).to();
	}

	@GetMapping("/{id}")
	@ResponseStatus(OK)
	public PostsDto obtenerPost(@PathVariable("id") String id) {
		log.info(">>> posts/v1 obtenerPost ");
		return postsService.obtenerPostById(id).to();
	}

	@GetMapping("/user/{id}")
	@ResponseStatus(OK)
	public ArrayList<PostsDto> obtenerPosts(@PathVariable("id") String id) {
		log.info(">>> posts/v1 obtenerPosts ");
		return postsService.obtenerPostsByUser(id);
	}

	@DeleteMapping("/{id}")
	@ResponseStatus(OK)
	public ConfirmacionResumenDto eliminaPost(@PathVariable("id") String id) {
		log.info(">>> posts/v1 eliminaPost ");
		return postsService.eliminaPostById(id);
	}

}
