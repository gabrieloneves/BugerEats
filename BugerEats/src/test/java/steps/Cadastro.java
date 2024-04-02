package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import metodos.Metodos;
import pages.CadastroPage;
import pages.HomePage;
import runner.Executa;
import utils.MassaDeDados;

public class Cadastro {
	
	Metodos metodos = new Metodos();
	HomePage homepage = new HomePage();
	CadastroPage cadastropage = new CadastroPage();
	MassaDeDados massa = new MassaDeDados();

	@Given("que estou na página do Buger Eats")
	public void queEstouNaPáginaDoBugerEats()  throws Exception {
		Executa.abrirNavegador("Chrome", "https://buger-eats-qa.vercel.app/");
		metodos.validarUrl("https://buger-eats-qa.vercel.app/");
		metodos.tirarEvidencia("home", "PaginaInicialDoBugerEats");
	}
	@When("clicar em “Cadastre-se para fazer entregas”")
	public void clicarEmCadastreSeParaFazerEntregas() {
		metodos.clicar(homepage.cadastreSeBtn);
	}
	@When("o usuário é direcionado para página de cadastro")
	public void oUsuárioÉDirecionadoParaPáginaDeCadastro() {
		metodos.validarUrl("https://buger-eats-qa.vercel.app/deliver");
		metodos.tirarEvidencia("cadastro", "PaginaDeCadastroDoBugerEats");
	}
	@When("o usuário completa o cadastro com todos os dados obrigatórios, incluindo a CNH")
	public void oUsuárioCompletaOCadastroComTodosOsDadosObrigatóriosIncluindoACNH() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal");
		metodos.escrever(cadastropage.cpf, "18259550008");
		metodos.escrever(cadastropage.email, "fulanodetal@gmail.com");
		metodos.escrever(cadastropage.whatsapp, "67982341457");
		metodos.escrever(cadastropage.cep, "22451530");
		metodos.clicar(cadastropage.buscarCepBtn);
		metodos.escrever(cadastropage.numero, "297");
		metodos.escrever(cadastropage.complemento, "Casa 1");
		metodos.clicar(cadastropage.moto);
		metodos.clicar(cadastropage.fotoDaSuaCNH);
		metodos.uploadArquivo();

	}
	@Then("o usuário é cadastrado com sucesso no sistema")
	public void oUsuárioÉCadastradoComSucessoNoSistema() {
	}




}
