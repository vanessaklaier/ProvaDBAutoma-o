package tasks;

import static org.junit.Assert.assertEquals;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import objects.PageObject;
import utils.EmailAleatorio;

public class Tasks {

	private WebDriver navegador;
	private PageObject page;
	private JavascriptExecutor highLight;

	public Tasks(WebDriver navegador) {
		this.navegador = navegador;
		this.page = new PageObject(this.navegador);
		highLight = (JavascriptExecutor) navegador;
	}

	public void selecionarProduto() {
		teste(this.page.getProduct());
		this.page.getProduct().click();
	}

	public void adicionarCarrinho() {
		teste(this.page.getAddCart());
		this.page.getAddCart().click();
	}

	public boolean validarProdutoCarrinho() {
		return this.page.getAddCart().isDisplayed();
	}

	public void clicarCheckoutOne() {
		teste(this.page.getToCheckoutOne());
		this.page.getToCheckoutOne().click();
	}

	public void guardarTexto() {
		teste(this.page.getProductValidation());
		assertEquals("Printed Summer Dress", this.page.getProductValidation().getText());
	}

	public void clicarCheckoutTwo() {
		teste(this.page.getToCheckoutTwo());
		this.page.getToCheckoutTwo().click();
	}

	public void inserirEmail() {
		teste(this.page.getEmailField());
		this.page.getEmailField().sendKeys(EmailAleatorio.getSaltString() + "@gmail.com");
	}

	public void validarEmail() {
		teste(this.page.getClick());
		this.page.getClick().click();
	}

	public void inserirPrimeiroNome(String primeiroNome) {
		teste(this.page.getFirstNameField());
		this.page.getFirstNameField().sendKeys(primeiroNome);
	}

	public void inserirUltimoNome(String UltimoNome) {
		teste(this.page.getLastNameField());
		this.page.getLastNameField().sendKeys(UltimoNome);
	}

	public void inserirSenha(String senha) {
		teste(this.page.getPasswordField());
		this.page.getPasswordField().sendKeys(senha);
	}

	public void inserirEndereco(String endereco) {
		teste(this.page.getAdressField());
		this.page.getAdressField().sendKeys(endereco);
	}

	public void inserirCidade(String cidade) {
		teste(this.page.getCityField());
		this.page.getCityField().sendKeys(cidade);
	}

	public void inserirEstado(String estado) {
		teste(this.page.getStateCombo());
		new Select(this.page.getStateCombo()).selectByVisibleText(estado);
	}

	public void inserirCep(String cep) {
		teste(this.page.getZipCodeField());
		this.page.getZipCodeField().sendKeys(cep);
	}

	public void inserirCelular(String celular) {
		teste(this.page.getMobilePhoneField());
		this.page.getMobilePhoneField().sendKeys(celular);
	}

	public void clicarRegister() {
		teste(this.page.getButtonRegister());
		this.page.getButtonRegister().click();
	}

	public void validarEndereco() {
		teste(this.page.getAdreesValidation());
		assertEquals("Av.Ipiranga, 6681", this.page.getAdreesValidation().getText());
	}

	public void clicarCheckoutThree() {
		teste(this.page.getButtonCheckoutThree());
		this.page.getButtonCheckoutThree().click();
	}

	public void aceitarTermos() {
		teste(this.page.getAgreeTerms());
		this.page.getAgreeTerms().click();
	}

	public void clicarCheckoutFinal() {
		teste(this.page.getButtonCheckoutFinal());
		this.page.getButtonCheckoutFinal().click();
	}

	public void clicarMetodoPagamentoBank() {
		teste(this.page.getButtonPayByBank());
		this.page.getButtonPayByBank().click();
	}

	public void clicarConfirmarPedido() {
		teste(this.page.getButtonConfirmMyOrder());
		this.page.getButtonConfirmMyOrder().click();
	}

	public void confirmarDados() {
		teste(this.page.getValidationOrder());
		assertEquals("Your order on My Store is complete.", this.page.getValidationOrder().getText());
	}

	public void validarTotalCompra() {
		float unitary = Float.valueOf(this.page.getUnitaryValue().getText().replace("$", ""));
		float amount = unitary * Integer.valueOf(this.page.getAmount().getText());
		float freight = amount + Float.valueOf(this.page.getFreight().getText().replace("$", ""));
		teste(this.page.getTotalPrice());
		assertEquals(this.page.getTotalPrice().getText().replace("$", ""), String.valueOf(freight));
	}

	public void teste(WebElement a) {
		highLight.executeScript("arguments[0].setAttribute('style', arguments[1]);", a,
				"background: yellow; color: red; border: 2px solid red;");
	}
}