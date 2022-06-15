package io.github.evandrolopes85.testedeintegracao;

// Aqui pode dizer para nossos testes onde estão os arquivos de configuração que criei

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class) // SpringRunner vai ser classe responsavel por executar nossos testes
@SpringBootTest(classes = TestedeintegracaoApplication.class) // Qual vai ser o contexto da nossa aplicação
@TestPropertySource(locations = "classpath:application.properties") // qual arquivo de configuraçao das propriedades
class TestedeintegracaoApplicationTests {

	@Test
	void contextLoads() {
	}

}
