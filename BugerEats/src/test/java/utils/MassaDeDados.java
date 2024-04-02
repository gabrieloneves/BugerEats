package utils;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class MassaDeDados {

	String caminhoArquivoExcel = "/home/gabriel/git/repository/BugerEats/src/test/resources/testData/massateste.xlsx";

	public String inserirCep() {

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

}
