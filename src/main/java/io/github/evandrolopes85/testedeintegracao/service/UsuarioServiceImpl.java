package io.github.evandrolopes85.testedeintegracao.service;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import io.github.evandrolopes85.testedeintegracao.dao.UsuarioDAO;
import io.github.evandrolopes85.testedeintegracao.model.Usuario;

@Service
public class UsuarioServiceImpl implements IUsuarioService{

	@Autowired
	private UsuarioDAO dao;
	
	@Override
	public ArrayList<Usuario> recuperaTodosUsuarios() {
		// TODO Auto-generated method stub
		ArrayList<Usuario> usuarios = (ArrayList<Usuario>)dao.findAll();
		
		if(usuarios != null)
			return usuarios;
		
		return null;
	}

	@Override
	public Usuario cadastraUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if(usuario != null)
			return dao.save(usuario);
		
		return null;
	}

	@Override
	public Usuario atualizarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		if(usuario.getIdUsuario() == null)
			return null;
		
		Usuario update = dao.findByIdUsuario(usuario.getIdUsuario());
		
		update.setNome(usuario.getNome());
		update.setEmail(usuario.getEmail());
		update.setSenha(usuario.getSenha());
		
		return dao.save(update);
	}

}
