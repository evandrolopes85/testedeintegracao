package io.github.evandrolopes85.testedeintegracao;
	
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;

import io.github.evandrolopes85.testedeintegracao.controller.UsuarioController;
import io.github.evandrolopes85.testedeintegracao.model.Usuario;

public class UsuarioControllerTest extends TestedeintegracaoApplicationTests{
	
	private MockMvc mockMvc; // Vai fazer as requisições
	
	@Autowired
	private UsuarioController usuarioController;
	
	@BeforeEach
	public void setUp() {
		// Passando usuarioController para o MockMvc para nos fazermos a requisição
		this.mockMvc = MockMvcBuilders.standaloneSetup(usuarioController).build();
	}
	
	@Test
	public void adicionarUsuarioCorreto_RetornarStatusCode201() throws Exception {
		Usuario usuario = new Usuario();
		//usuario.setIdUsuario(null);
		usuario.setNome("Evandro Lopes");
		usuario.setEmail("evandrocwd@gmail.com");
		usuario.setSenha("12345");
		
		// Convertendo nosso objeto para um JSON
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(usuario);
		
		// perform dispara uma requisição
		this.mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
								.contentType(MediaType.APPLICATION_JSON)
								.content(json)								
				)
		.andExpect(MockMvcResultMatchers.status().isCreated())
		//.andExpect(MockMvcResultMatchers.header().string("location", Matchers.containsString("http://localhost/usuarios")))
		;
	}
	
	@Test
	public void adicionarUsuarioIncorreto_RetornarStatusCode400() throws Exception {
		
		// perform dispara uma requisição
		this.mockMvc.perform(MockMvcRequestBuilders.post("/usuarios")
								.contentType(MediaType.APPLICATION_JSON)
								.content("")								
				)
		.andExpect(MockMvcResultMatchers.status().isBadRequest())
		//.andExpect(MockMvcResultMatchers.header().string("location", Matchers.containsString("http://localhost/usuarios")))
		;
	}
	
	@Test
	public void recuperarTodosOsUsuarios_RetornarStatusCode200() throws Exception {
		
		// perform dispara uma requisição
		this.mockMvc.perform(MockMvcRequestBuilders.get("/usuarios")
								.contentType(MediaType.APPLICATION_JSON)
														
				)
		.andExpect(MockMvcResultMatchers.status().isOk())
		;
	
	}
	
	@Test
	public void atualizaUsuario_ReturnarStatusCode200() throws Exception {
		
		Usuario usuario = new Usuario();
		usuario.setIdUsuario(1);
		usuario.setNome("Evandro Assis");
		usuario.setEmail("evandroassis@gmail.com");
		usuario.setSenha("12345");
		
		
		ObjectMapper mapper = new ObjectMapper();
		
		String json = mapper.writeValueAsString(usuario);
		
		this.mockMvc.perform(
								MockMvcRequestBuilders
								.put("/usuarios")
								.contentType(MediaType.APPLICATION_JSON)
								.content(json)
							)
					.andExpect(MockMvcResultMatchers.status().isOk());
							
	}
	
}
