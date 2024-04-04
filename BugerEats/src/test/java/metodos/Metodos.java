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

import org.apache.commons.io.FileUtils;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import conexao.DriverFactory;

public class Metodos extends DriverFactory {

	public void clicar(By elemento) {
		driver.findElement(elemento).click();
	}

	public void escrever(By elemento, String texto) {
		driver.findElement(elemento).sendKeys(texto);
	}

	public void enter(By elemento) {
		driver.findElement(elemento).submit();
	}

	public void tirarEvidencia(String pasta, String nomeEvidencia) {
		TakesScreenshot scrShot = (TakesScreenshot) driver;
		File srcFile = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("./evidencias/" + pasta + "/" + nomeEvidencia + ".png");
		try {
			FileUtils.copyFile(srcFile, destFile);
		} catch (IOException e) {
			System.out.println("Não foi possivel tirar evidencia");
			e.printStackTrace();
		}
	}

	public void validarUrl(String urlEsperada) {
		String url = driver.getCurrentUrl();
		assertTrue(url.contains(urlEsperada));
	}

	public void validarTexto(By elemento, String textoEsperado) {
		try {
			String textoCapturado = driver.findElement(elemento).getText();
			assertEquals(textoEsperado, textoCapturado);
		} catch (Exception e) {
			System.out.println("Não foi possivel validar texto");
			e.printStackTrace();
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

	public void uploadArquivo() {
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

		}
	}

	public void pausa() throws InterruptedException {
		Thread.sleep(5000);
	}

}
