package tests;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import tasks.Tasks;
import utils.Screenshots;

public class Tests {

	private WebDriver navegador;
	private Tasks testeAutomacaoCompra;
	private String localDir = System.getProperty("user.dir");
	private ExtentReports extent = new ExtentReports();
	private ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter(localDir + "\\resultadoTestes_.html");
	private ExtentTest logger = extent.createTest("Prova Automacao", "Realizar a compra de um produto e cadastrar usuário");

	@Before
	public void inicializaNavegador() {
		extent.attachReporter(htmlReporter);
		System.setProperty("webdriver.chrome.driver",
				"C:\\Users\\vanessaf\\eclipse-workspace\\Drivers\\chromedriver.exe");
		navegador = new ChromeDriver();
		navegador.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		navegador.manage().window().maximize();
		navegador.get("http://automationpractice.com");
		testeAutomacaoCompra = new Tasks(navegador);
	}

	@After
	public void fecharNavegador() {
		navegador.quit();
		extent.flush();
	}

	@Test
	public void realizarUmaCompraComSucesso() throws IOException {
		testeAutomacaoCompra.selecionarProduto();
		if (testeAutomacaoCompra.validarProdutoCarrinho()) {
			logger.pass("Produto selecionado com sucesso!");
			logger.addScreenCaptureFromPath(Screenshots.captureFullScreen());
		} else {
			logger.fail("Produto não foi selecionado!");
		}

		testeAutomacaoCompra.adicionarCarrinho();
		testeAutomacaoCompra.clicarCheckoutOne();
		testeAutomacaoCompra.guardarTexto();
		testeAutomacaoCompra.clicarCheckoutTwo();
		testeAutomacaoCompra.inserirEmail();
		testeAutomacaoCompra.validarEmail();
		testeAutomacaoCompra.inserirPrimeiroNome("Vanessa");
		testeAutomacaoCompra.inserirUltimoNome("Klaier");
		testeAutomacaoCompra.inserirSenha("123456");
		testeAutomacaoCompra.inserirEndereco("Av.Ipiranga, 6681");
		testeAutomacaoCompra.inserirCidade("Porto Alegre");
		testeAutomacaoCompra.inserirEstado("Georgia");
		testeAutomacaoCompra.inserirCep("39039");
		testeAutomacaoCompra.inserirCelular("954827424");
		testeAutomacaoCompra.clicarRegister();
		testeAutomacaoCompra.validarEndereco();
		testeAutomacaoCompra.clicarCheckoutThree();
		testeAutomacaoCompra.aceitarTermos();
		testeAutomacaoCompra.clicarCheckoutFinal();
		testeAutomacaoCompra.validarTotalCompra();
		testeAutomacaoCompra.clicarMetodoPagamentoBank();
		testeAutomacaoCompra.clicarConfirmarPedido();
		testeAutomacaoCompra.confirmarDados();
		logger.pass("Teste Finalizado com sucesso");
		logger.fail("Teste Falhado");
		logger.info("Teste Finalizado");
	}
}