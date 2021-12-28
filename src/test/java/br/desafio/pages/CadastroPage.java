package br.desafio.pages;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CadastroPage {
	public static final String URL_DESAFIO = "http://automationpractice.com/index.php";
	public static final String PRIMEIRO_NOME = "Fulano";
	public static final String ULTIMO_NOME = "Bartolomeu";
	public static final String EMAIL = "jasonwu222@bedul.net";
	public static final String SENHA = "kaio1310";
	public static final String RUA = "Abington Lane";
	public static final String CIDADE = "Dearborn";
	public static final String POSTAL = "48124";
	public static final String TELEFONE = "42988652291";
	public static final String ENDERECO_ALTERNATIVO = "Appoline";
	
	WebDriver driver;
	CadastroPage page;
	
	public CadastroPage() {
		// TODO Auto-generated constructor stub
		System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
		this.driver = new ChromeDriver();
		this.driver.navigate().to(URL_DESAFIO);
	}
	
	public void fecharJanela() {
		this.driver.quit();	
	}
	public void clicarBtnById(String id) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.id(id)).click();
	}
	public void clicarBtnByClass(String classe) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.className(classe)).click();
	}
	public void preencherInputById(String id, String texto) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.id(id)).sendKeys(texto);;
	}

	public void clicarRadioBtnById(String id) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.id(id)).click();	
		
	}
//	public void tempoDeEsperaEmSegundos() {
////		driver.manage().timeouts().implicitlyWait(time, TimeUnit.SECONDS);
//		this.driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
//		
//	}
	private void limparCampo(String id) {
		// TODO Auto-generated method stub
		this.driver.findElement(By.id(id)).clear();
	}
	public boolean contemElementoNaPagina(String elemento) {
		return this.driver.getPageSource().contains(elemento);
	}
	public void preencherFormularioDeCadastro() {
		// TODO Auto-generated method stub
		
		//YOUR PERSONAL INFORMATION
		this.clicarRadioBtnById("id_gender1");
		this.preencherInputById("customer_firstname", CadastroPage.PRIMEIRO_NOME);
		this.preencherInputById("customer_lastname", CadastroPage.ULTIMO_NOME);
		this.limparCampo("email");
		this.preencherInputById("email", CadastroPage.EMAIL);
		this.preencherInputById("passwd", CadastroPage.SENHA);
		
		//YOUR ADDRESS
		this.selecionarDataDeNascimento("13", "10", "1994");
		this.preencherInputById("address1", RUA);
		this.preencherInputById("city", CIDADE);
		this.selecionarEstadoPorNome("Michigan");
		this.preencherInputById("postcode", POSTAL);
		this.preencherInputById("phone_mobile", TELEFONE);
		this.preencherInputById("alias", ENDERECO_ALTERNATIVO);
		
	}
	private void selecionarDataDeNascimento(String dia, String mes, String ano) {
		// TODO Auto-generated method stub
		WebElement elementDia = this.driver.findElement(By.id("days"));
		WebElement elementMes = this.driver.findElement(By.id("months"));
		WebElement elementAno = this.driver.findElement(By.id("years"));
		Select elementoDia = new Select(elementDia);
		Select elementoMes = new Select(elementMes);
		Select elementoAno = new Select(elementAno);
		elementoDia.selectByValue(dia);
		elementoMes.selectByValue(mes);
		elementoAno.selectByValue(ano);
	}
	private void selecionarEstadoPorNome(String nomeEstado) {
		// TODO Auto-generated method stub
		WebElement elementoEstado = this.driver.findElement(By.id("id_state"));
		Select elementEstado = new Select(elementoEstado);
		elementEstado.selectByVisibleText(nomeEstado);
	}
	public String retornarUrlDaPagina() {
		// TODO Auto-generated method stub
		return this.driver.getCurrentUrl();	
	}
	public void preencherLoginComUsuarioValido() {
		// TODO Auto-generated method stub
		this.driver.findElement(By.id("email")).sendKeys(EMAIL);
		this.driver.findElement(By.id("passwd")).sendKeys(SENHA);
	}
	
}
