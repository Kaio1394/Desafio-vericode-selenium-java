package br.desafio.cadastro;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import br.desafio.pages.CompraProdutoPage;
import org.junit.Assert;

public class FinalizarCompraDeUmProduto {
private CompraProdutoPage compraPage;
	@BeforeEach
	public void beforeEach() {
		compraPage = new CompraProdutoPage();
	}
	@AfterEach
	public void afterEach() {
		compraPage.fecharJanela();
	}
	@Test
	public void realizarCompra() throws InterruptedException {
//		compraPage.clicarProduto("product_img_link");
		
		//Clicar botão adicionar ao carrinho
		compraPage.clicarProdutoPeloXpath("//*[@id=\"homefeatured\"]/li[3]/div/div[2]/div[2]/a[1]/span");
		
		//Botão adicionar no carrinho
//		compraPage.clicarBotaoPeloXpath("//*[@id=\"add_to_cart\"]/button");
		
		//Confirmando que o produto foi adicionado no carrinho
		Assert.assertTrue(compraPage.contemElementoNaPagina("Product successfully added to your shopping cart"));

		//Botão de checkout
		compraPage.esperaExplicitaAteElementoSerClicavel("//*[@id=\"layer_cart\"]/div[1]/div[2]/div[4]/a/span");
		
		compraPage.clicarBotaoPeloXpath("//*[@id=\"center_column\"]/p[2]/a[1]");
		compraPage.clicarBotaoPeloNome("processAddress");
		
		//CLicar no checkBox
		compraPage.clicarNoBotaoPeloId("cgv");
		
		//Clicar no botão de checkout e ir para a página de pagamento
		compraPage.clicarBotaoPeloNome("processCarrier");
		
		//Escolha do pagemento
		compraPage.clicarBotaoPelaClasse("bankwire");
		
		// Confirmação do pagemento
		Thread.sleep(8000);
		Assert.assertEquals("BANK-WIRE PAYMENT.", compraPage.retornaElementoTextoPelaClasse("page-subheading"));
		
		
		compraPage.clicarBotaoPeloXpath("//*[@id=\"cart_navigation\"]/button");
		
		
		Thread.sleep(5000);
	}
}
