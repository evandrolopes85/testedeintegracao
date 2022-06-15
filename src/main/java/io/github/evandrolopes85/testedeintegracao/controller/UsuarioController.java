package io.github.evandrolopes85.testedeintegracao.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import io.github.evandrolopes85.testedeintegracao.model.Usuario;
import io.github.evandrolopes85.testedeintegracao.service.IUsuarioService;

@RestController
public class UsuarioController {

	@Autowired
	private IUsuarioService service;
	
	@GetMapping("/usuarios")
	public ResponseEntity<ArrayList<Usuario>> recuperaTodosUsuario(){
		ArrayList<Usuario> usuarios = service.recuperaTodosUsuarios();
		
		if(usuarios != null)
			return ResponseEntity.ok(usuarios);
		
		return ResponseEntity.badRequest().build();
	}
	
	@PostMapping("/usuarios")
	public ResponseEntity<Usuario> cadastraUsuario(@RequestBody Usuario usuario){
		Usuario novoUsuario = service.cadastraUsuario(usuario);
		if(novoUsuario != null)
			return ResponseEntity.status(201).body(novoUsuario);
		
		return ResponseEntity.badRequest().build();
	}
	
	@PutMapping("/usuarios")
	public ResponseEntity<Usuario> atualizarUsuario(@RequestBody Usuario usuario){
		Usuario usuarioAtualizado = service.atualizarUsuario(usuario);
		
		if(usuarioAtualizado != null)
			return ResponseEntity.status(200).body(usuarioAtualizado);
		
		return ResponseEntity.badRequest().build();
		
	}
}
