package pages;

import org.openqa.selenium.By;

import conexao.DriverFactory;

public class CadastroPage extends DriverFactory {

	public By nome = By.xpath("//input[@name='fullName']");
	public By cpf = By.xpath("//input[@name='cpf']");
	public By email = By.xpath("//input[@name='email']");
	public By whatsapp = By.xpath("//input[@name='whatsapp']");
	public By cep = By.xpath("//input[@name='postalcode']");
	public By buscarCepBtn = By.xpath("//input[@type='button' and @value='Buscar CEP']");
	public By numero = By.xpath("//input[@name='address-number']");
	public By complemento = By.xpath("//input[@name='address-details']");
	public By cadastroBtn = By.xpath("//button[@type='submit']");
	public By moto = By.xpath("//ul[@class='delivery-method']//span[text()='Moto']");
	public By bikeEletrica = By.xpath("//ul[@class='delivery-method']//span[text()='Bike Elétrica']");
	public By vanCarro = By.xpath("//ul[@class='delivery-method']//span[text()='Van/Carro']");
	public By fotoDaSuaCNH = By.xpath("//*[text()='Foto da sua CNH']");


}
