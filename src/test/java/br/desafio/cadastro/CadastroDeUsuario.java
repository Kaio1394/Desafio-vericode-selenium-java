package br.desafio.cadastro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.Assert;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;
import br.desafio.pages.CadastroPage;

public class CadastroDeUsuario {
	
	private CadastroPage page;
	
	@BeforeEach
	public void beforeEach() {
		page = new CadastroPage();	
	}
	@AfterEach
	public void fechar() {
		page.fecharJanela();
	}
	@Test
	public void testandoCadastroComDadosValidos() throws InterruptedException {
		page.clicarBtnByClass("login");
		
		//Preenche um email valido e clica no bot�o
		page.preencherInputById("email_create", CadastroPage.EMAIL);
		page.clicarBtnById("SubmitCreate");

		Thread.sleep(10000);
		String urlAtual = page.retornarUrlDaPagina();
		System.out.println(urlAtual);
		//Assert
		Assert.assertEquals(CadastroPage.URL_DESAFIO + 
				"?controller=authentication&back=my-account#account-creation", urlAtual);
	
		//Preencher formul�rio
		page.preencherFormularioDeCadastro();
		
		//Clicar no bot�o "Register"
		page.clicarBtnById("submitAccount");		
		
		Thread.sleep(10000);
	}
	@Test
	public void realizarLoginComComUsuarioSenhaCadastrados(){
		//Clicar no bot�o de login
		page.clicarBtnByClass("login");
		
		//Realizar login e clicar no bot�o "Sign in"
		page.preencherLoginComUsuarioValido();
		page.clicarBtnById("SubmitLogin");
		
		//Assert para confirmar que o usu�rio est� logado
		Assert.assertTrue(page.contemElementoNaPagina(
				CadastroPage.PRIMEIRO_NOME
				+" "+
				CadastroPage.ULTIMO_NOME));
	}
}
