package io.github.evandrolopes85.testedeintegracao.service;

import java.util.ArrayList;

import io.github.evandrolopes85.testedeintegracao.model.Usuario;

public interface IUsuarioService {
	public ArrayList<Usuario> recuperaTodosUsuarios();
	public Usuario cadastraUsuario(Usuario usuario);
	public Usuario atualizarUsuario(Usuario usuario);
}
