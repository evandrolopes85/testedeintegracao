package io.github.evandrolopes85.testedeintegracao.dao;

import org.springframework.data.repository.CrudRepository;

import io.github.evandrolopes85.testedeintegracao.model.Usuario;

public interface UsuarioDAO extends CrudRepository<Usuario, Integer>{
	
	public Usuario findByIdUsuario(Integer id);
}
