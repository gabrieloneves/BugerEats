package metodos;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import conexao.DriverFactory;

public class Metodos extends DriverFactory {

	public void clicar(By elemento, String descricaoPasso) {
		try {
			driver.findElement(elemento).click();
		} catch (Exception e) {
			System.out.println("***** Erro no passo *****" + descricaoPasso);
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

	public void escrever(By elemento, String texto, String descricaoPasso) {
		try {
			driver.findElement(elemento).sendKeys(texto);
		} catch (Exception e) {
			System.out.println("***** Erro no passo *****" + descricaoPasso);
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

	public void tirarEvidencia(String pasta, String nomeEvidencia, String descricaoPasso) {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./evidencias/" + pasta + "/" + nomeEvidencia + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			System.out.println("***** Erro no passo *****" + descricaoPasso);
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

	public void validarUrl(String urlEsperada, String descricaoPasso) {
		try {
			String url = driver.getCurrentUrl();
			assertTrue(url.contains(urlEsperada));
		} catch (Exception e) {
			System.out.println("***** Erro no passo *****" + descricaoPasso);
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

	public void validarTexto(By elemento, String textoEsperado, String descricaoPasso) {
		try {
			String textoCapturado = driver.findElement(elemento).getText();
			assertEquals(textoEsperado, textoCapturado);
		} catch (Exception e) {
			System.out.println("***** Erro no passo *****" + descricaoPasso);
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

	public String inserirCep() {

		String caminhoArquivoExcel = "/home/gabriel/git/repository/BugerEats/src/test/resources/testData/massateste.xlsx";

		try {
			FileInputStream arquivo = new FileInputStream(new File(caminhoArquivoExcel));
			Workbook planilha = new XSSFWorkbook(arquivo);
			org.apache.poi.ss.usermodel.Sheet abaPlanilha = planilha.getSheetAt(0);

			for (Row linha : abaPlanilha) {

				Cell celula = linha.getCell(0);
				switch (celula.getCellType()) {
				case STRING:
					return celula.getStringCellValue();
				case NUMERIC:
					return String.valueOf((int) celula.getNumericCellValue());
				}
			}
		} catch (Exception e) {
			System.out.println("Erro ao ler planilha");
		}
		return null;
	}

	public void uploadArquivo(String descricaoPasso) {
		Robot robot = null;
		try {
			robot = new Robot();
			robot.delay(1000);
			StringSelection ss = new StringSelection("C:\\Users\\Gabriel\\Pictures\\CNH.jpg");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
			robot.keyPress(KeyEvent.VK_CONTROL);
			robot.keyPress(KeyEvent.VK_V);
			robot.keyRelease(KeyEvent.VK_CONTROL);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_V);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_ENTER);
			robot.keyRelease(KeyEvent.VK_ENTER);
			robot.delay(1000);

		} catch (Exception e) {
			System.out.println("***** Erro no passo *****" + descricaoPasso);
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}

	public void scrollTela(int n1, int n2) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(" + n1 + "," + n2 + ")");
	}

	public void tirarEvidenciadoAlertaCEPInvalido(String descricaoPasso) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		WebElement element = wait
				.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//*[text()='Informe um CEP válido']")));
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./evidencias/cadastro/AlertaCEPInvalido.png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			System.out.println("***** Erro no passo *****" + descricaoPasso);
			System.out.println(e.getCause());
			System.out.println(e.getMessage());
		}
	}
}
