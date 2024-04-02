package pages;

import org.openqa.selenium.By;

import conexao.DriverFactory;

public class HomePage extends DriverFactory {

	public By cadastreSeBtn = By.xpath("//a[contains(@href, '/deliver')]");

}
