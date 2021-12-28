package br.desafio.pages;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CompraProdutoPage {
	private static final String URL_LOGIN = "http://automationpractice.com/index.php?controller=authentication&back=my-account";
	public static final String EMAIL_CADASTRADO = "testando@ecallen.com";
	public static final String SENHA_CADASTRADA = "kaio1394";
	WebDriver driver;
	
	public CompraProdutoPage() {
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.navigate().to(URL_LOGIN);
		this.realizarLoginAntesDaCompraIrParaPaginaHome();
	}
	public void fecharJanela() {
		// TODO Auto-generated method stub
		this.driver.quit();
	}
	public void realizarLoginAntesDaCompraIrParaPaginaHome() {
		// TODO Auto-generated method stub
		this.driver.findElement(By.id("email")).sendKeys(EMAIL_CADASTRADO);
		this.driver.findElement(By.id("passwd")).sendKeys(SENHA_CADASTRADA);
		this.clicarNoBotaoPeloId("SubmitLogin");
		this.clicarBotaoPeloTexto("Home");
	}
	public void clicarBotaoPeloTexto(String nome) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.linkText(nome)).click();
	}
	public void clicarBotaoPelaClasse(String classe) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.className(classe)).click();
	}
	public void clicarBotaoPeloNome(String nome) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.name(nome)).click();
	}
	public void clicarNoBotaoPeloId(String id) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.id(id)).click();
	}
	public void clicarNoProdutoPelaClasseDoLink(String classe) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.className(classe)).click();
	}
	public void clicarBotaoPeloXpath(String xpath) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.xpath(xpath)).click();
	}
	
	//Mover o mouse e realizar um doubleClick
	public void clicarProduto(String classe) {
		// TODO Auto-generated method stub
		System.out.println(driver.findElement(By.tagName("span")).getText());
		WebElement elemento = this.driver.findElement(By.className(classe));
		Actions actionProvider = new Actions(driver);
		actionProvider.doubleClick(elemento).build().perform();
	}
	

	public boolean contemElementoNaPagina(String elemento) {
		return this.driver.getPageSource().contains(elemento);
	}
	public void esperaExplicitaAteElementoSerClicavel(String xpath) {
		WebDriverWait elemento = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		elemento.until(ExpectedConditions.elementToBeClickable(By.xpath(xpath)));
		this.clicarBotaoPeloXpath(xpath);
	}
	public void esperaExplicitaAteElementoSerClicavelPelaClasse(String classe) {
		WebDriverWait elemento = new WebDriverWait(this.driver, Duration.ofSeconds(10));
		elemento.until(ExpectedConditions.elementToBeClickable(By.className(classe)));
		this.clicarBotaoPelaClasse(classe);
	}
	public void esperaImplicita(int min) {
		this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(min));	
	}
	public String retornaElementoTextoPelaClasse(String classe) {
		return this.driver.findElement(By.className(classe)).getText();
	}
	public void clicarProdutoPeloXpath(String string) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.xpath(string)).click();
	}
	
}
