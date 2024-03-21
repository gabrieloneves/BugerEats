package runner;

import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import conexao.DriverFactory;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.CucumberOptions.SnippetType;
import io.github.bonigarcia.wdm.WebDriverManager;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/test/resources/features",
		glue = "steps",
		tags = "@loginpositivos",
		monochrome = true,
		dryRun = false,
		plugin = {"pretty", "html:target/cucumber-reports.html"},
		snippets = SnippetType.CAMELCASE
		)

public class Executa extends DriverFactory {
	
	

	public static void abrirNavegador(String navegador, String url) throws Exception {
		
		if (navegador.equalsIgnoreCase("Chrome")) {
			WebDriverManager.chromedriver().setup();
			driver = new ChromeDriver();
			
		}else if (navegador.equalsIgnoreCase("Edge")) {
			WebDriverManager.edgedriver().setup();
			driver = new EdgeDriver();
			
		}else if (navegador.equalsIgnoreCase("FireFox")) {
		WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}else {
		System.out.println("Por favor informar um navegador correto para que o teste seja iniciado!");
	}
		driver.get(url);
		driver.manage().window().maximize();	
	}
	
	/**
	@AfterClass
	public static void fecharNavegador() {
		driver.quit();
	}
	 */
}

