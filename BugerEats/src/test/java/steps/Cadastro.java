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
	public void queEstouNaPáginaDoBugerEats() throws Exception {
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

	@When("o usuário completa o cadastro com todos os dados obrigatórios")
	public void o_usuário_completa_o_cadastro_com_todos_os_dados_obrigatórios() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal");
		metodos.escrever(cadastropage.cpf, "18259550008");
		metodos.escrever(cadastropage.email, "fulanodetal@gmail.com");
		metodos.escrever(cadastropage.whatsapp, "67982341457");
		metodos.escrever(cadastropage.cep, "22451530");
		metodos.clicar(cadastropage.buscarCepBtn);
		metodos.escrever(cadastropage.numero, "297");
		metodos.escrever(cadastropage.complemento, "Casa 1");
		metodos.tirarEvidencia("cadastro", "CadastroComTodosOsDadosObrigatorios");
	}

	@When("o usuário escolhe o método de entrega moto")
	public void o_usuário_escolhe_o_método_de_entrega_moto() {
		metodos.clicar(cadastropage.moto);
		metodos.tirarEvidencia("cadastro", "Moto");
	}

	@When("o usuário faz upload da CNH")
	public void o_usuário_faz_upload_da_cnh() {
		metodos.clicar(cadastropage.fotoDaSuaCNH);
		metodos.uploadArquivo();
		metodos.tirarEvidencia("cadastro", "UploadDaCNH");
	}

	@Then("o usuário é cadastrado com sucesso no sistema")
	public void oUsuárioÉCadastradoComSucessoNoSistema() {
		metodos.clicar(cadastropage.cadastroBtn);
		metodos.validarTexto(cadastropage.cadastroComSucesso, "Aí Sim...");
		metodos.tirarEvidencia("cadastro", "CadastroComSucesso");
	}

	@When("o usuário escolhe o método de entrega bike elétrica")
	public void o_usuário_escolhe_o_método_de_entrega_bike_elétrica() {
		metodos.clicar(cadastropage.bikeEletrica);
		metodos.tirarEvidencia("cadastro", "BikeEletrica");
	}

	@When("o usuário escolhe o método de entrega van\\/carro")
	public void o_usuário_escolhe_o_método_de_entrega_van_carro() {
		metodos.clicar(cadastropage.vanCarro);
		metodos.tirarEvidencia("cadastro", "VanCarro");
	}

	@When("o usuário não faz upload da CNH")
	public void o_usuário_não_faz_upload_da_cnh() {
		metodos.tirarEvidencia("cadastro", "SemUpload");
		metodos.clicar(cadastropage.cadastroBtn);
	}

	@Then("o usuário é informado sobre a necessidade de fazer upload de CNH")
	public void o_usuário_é_informado_sobre_a_necessidade_de_fazer_upload_de_cnh() {
		metodos.validarTexto(cadastropage.adicioneCNH, "Adicione uma foto da sua CNH");
		metodos.tirarEvidencia("cadastro", "AdicioneUmaFotoDaDuaCNH");
	}

	@When("o usuário tenta se cadastrar sem preencher todos os campos obrigatórios")
	public void o_usuário_tenta_se_cadastrar_sem_preencher_todos_os_campos_obrigatórios() {
		metodos.tirarEvidencia("cadastro", "SemCamposObrigatorios");
		metodos.clicar(cadastropage.cadastroBtn);
	}

	@Then("o sistema apresenta mensagens indicando quais campos são obrigatórios")
	public void o_sistema_apresenta_mensagens_indicando_quais_campos_são_obrigatórios() {
		metodos.validarTexto(cadastropage.informarNome, "É necessário informar o nome");
		metodos.validarTexto(cadastropage.informarCPF, "É necessário informar o CPF");
		metodos.validarTexto(cadastropage.informarEmail, "É necessário informar o email");
		metodos.validarTexto(cadastropage.informarCEP, "É necessário informar o CEP");
		metodos.validarTexto(cadastropage.informarNumEndereco, "É necessário informar o número do endereço");
		metodos.tirarEvidencia("cadastro", "AlertasDeCamposEmBranco");
	}

	@When("o usuário tenta se cadastrar com um número de CPF inválido")
	public void o_usuário_tenta_se_cadastrar_com_um_número_de_cpf_inválido() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal");
		metodos.escrever(cadastropage.cpf, "00000000000");
		metodos.escrever(cadastropage.email, "fulanodetal@gmail.com");
		metodos.escrever(cadastropage.whatsapp, "67982341457");
		metodos.escrever(cadastropage.cep, "22451530");
		metodos.clicar(cadastropage.buscarCepBtn);
		metodos.escrever(cadastropage.numero, "297");
		metodos.escrever(cadastropage.complemento, "Casa 1");
		metodos.tirarEvidencia("cadastro", "CPFInvalido");
		metodos.clicar(cadastropage.cadastroBtn);
	}

	@Then("o sistema apresenta uma mensagem de erro indicando “CPF inválido”")
	public void o_sistema_apresenta_uma_mensagem_de_erro_indicando_cpf_inválido() {
		metodos.validarTexto(cadastropage.CPFInvalido, "Oops! CPF inválido");
		metodos.tirarEvidencia("cadastro", "AlertaCPFInvalido");
	}

	@When("o usuário tenta se cadastrar com um email inválido")
	public void o_usuário_tenta_se_cadastrar_com_um_email_inválido() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal");
		metodos.escrever(cadastropage.cpf, "18259550008");
		metodos.escrever(cadastropage.email, "fulanodetalgmail.com");
		metodos.escrever(cadastropage.whatsapp, "67982341457");
		metodos.escrever(cadastropage.cep, "22451530");
		metodos.clicar(cadastropage.buscarCepBtn);
		metodos.escrever(cadastropage.numero, "297");
		metodos.escrever(cadastropage.complemento, "Casa 1");
		metodos.tirarEvidencia("cadastro", "EmailInvalido");
		metodos.clicar(cadastropage.cadastroBtn);
	}

	@Then("o sistema apresenta uma mensagem de erro “e-mail inválido”")
	public void o_sistema_apresenta_uma_mensagem_de_erro_e_mail_inválido() {
		metodos.validarTexto(cadastropage.emailInvalido, "Oops! Email com formato inválido.");
		metodos.tirarEvidencia("cadastro", "AlertaEmailInvalido");
	}

	@When("o usuário tenta se cadastrar com um número de CEP inválido")
	public void o_usuário_tenta_se_cadastrar_com_um_número_de_cep_inválido() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal");
		metodos.escrever(cadastropage.cpf, "18259550008");
		metodos.escrever(cadastropage.email, "fulanodetal@gmail.com");
		metodos.escrever(cadastropage.whatsapp, "67982341457");
		metodos.escrever(cadastropage.cep, "224515301");
		metodos.clicar(cadastropage.buscarCepBtn);
		metodos.escrever(cadastropage.numero, "297");
		metodos.escrever(cadastropage.complemento, "Casa 1");
		metodos.tirarEvidencia("cadastro", "CEPInvalido");
		metodos.clicar(cadastropage.cadastroBtn);
	}

	@Then("o sistema apresenta uma mensagem de erro “CEP não encontrado”")
	public void o_sistema_apresenta_uma_mensagem_de_erro_cep_não_encontrado() {
		metodos.validarTexto(cadastropage.CEPInvalido, "Informe um CEP válido");
		metodos.tirarEvidencia("cadastro", "AlertaCEPInvalido");
	}

}
