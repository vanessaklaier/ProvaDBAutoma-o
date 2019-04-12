package objects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class PageObject {
	private final WebDriver navegador;

	public PageObject(WebDriver navegador) {
		this.navegador = navegador;
	}

	public WebElement getProduct() {
		return this.navegador.findElement(By.xpath(
				"//ul[@id='homefeatured']//li[@class='ajax_block_product col-xs-12 col-sm-4 col-md-3 first-in-line last-line first-item-of-mobile-line']//div[@class='product-container']"));
	}

	public WebElement getAddCart() {
		return this.navegador.findElement(By.id("add_to_cart"));
	}

	public WebElement getToCheckoutOne() {
		return this.navegador.findElement(By.xpath("//span[contains(text(),'Proceed to checkout')]"));
	}

	public WebElement getProductValidation() {
		return this.navegador
				.findElement(By.xpath("//td[@class='cart_description']//a[contains(text(),'Printed Summer Dress')]"));
	}

	public WebElement getAdreesValidation() {
		return this.navegador.findElement(By.xpath("(//li[contains(@class,'address2')])[1]"));
	}

	public WebElement getToCheckoutTwo() {
		return this.navegador.findElement(
				By.xpath("//p[@class='cart_navigation clearfix']//span[contains(text(),'Proceed to checkout')]"));
	}

	public WebElement getEmailField() {
		return this.navegador.findElement(By.id("email_create"));
	}

	public WebElement getClick() {
		return this.navegador.findElement(By.id("SubmitCreate"));
	}

	public WebElement getFirstNameField() {
		return this.navegador.findElement(By.id("customer_firstname"));
	}

	public WebElement getLastNameField() {
		return this.navegador.findElement(By.id("customer_lastname"));
	}

	public WebElement getPasswordField() {
		return this.navegador.findElement(By.id("passwd"));
	}

	public WebElement getAdressField() {
		return this.navegador.findElement(By.id("address1"));
	}

	public WebElement getCityField() {
		return this.navegador.findElement(By.id("city"));
	}

	public WebElement getStateCombo() {
		return this.navegador.findElement(By.id("id_state"));
	}

	public WebElement getZipCodeField() {
		return this.navegador.findElement(By.id("postcode"));
	}

	public WebElement getMobilePhoneField() {
		return this.navegador.findElement(By.id("phone"));
	}

	public WebElement getButtonRegister() {
		return this.navegador.findElement(By.id("submitAccount"));
	}

	public WebElement getButtonCheckoutThree() {
		return this.navegador.findElement(By.xpath("//button[@type='submit'][contains(.,'Proceed to checkout')]"));
	}

	public WebElement getAgreeTerms() {
		return this.navegador.findElement(By.id("cgv"));
	}

	public WebElement getButtonCheckoutFinal() {
		return this.navegador.findElement(By.name("processCarrier"));
	}

	public WebElement getButtonPayByBank() {
		return this.navegador.findElement(By.xpath("//a[contains(@class,'bankwire')]"));
	}

	public WebElement getButtonConfirmMyOrder() {
		return this.navegador.findElement(By.xpath("//span[contains(.,'I confirm my order')]"));
	}

	public WebElement getValidationOrder() {
		return this.navegador.findElement(By.xpath("//strong[contains(.,'Your order on My Store is complete.')]"));
	}

	public WebElement getUnitaryValue() {
		return this.navegador.findElement(By.xpath("//span[contains(@class,'price special-price')]"));
	}

	public WebElement getAmount() {
		return this.navegador.findElement(By.xpath("(//span[contains(.,'1')])[10]"));
	}

	public WebElement getFreight() {
		return this.navegador.findElement(By.xpath("//td[contains(@id,'total_shipping')]"));
	}

	public WebElement getTotalPrice() {
		return this.navegador.findElement(By.xpath("//span[@id='total_price']"));
	}
}