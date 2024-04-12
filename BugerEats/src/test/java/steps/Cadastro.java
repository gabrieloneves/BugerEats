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
		metodos.validarUrl("https://buger-eats-qa.vercel.app/", "validando URL da página inicial  do Buger Eats");
		metodos.tirarEvidencia("home", "PaginaInicialDoBugerEats", "tirando evidencia da PaginaInicialDoBugerEats");
	}

	@When("clicar em “Cadastre-se para fazer entregas”")
	public void clicarEmCadastreSeParaFazerEntregas() {
		metodos.clicar(homepage.cadastreSeBtn, "clicando em botão cadastre-se");
	}

	@When("o usuário é direcionado para página de cadastro")
	public void oUsuárioÉDirecionadoParaPáginaDeCadastro() {
		metodos.validarUrl("https://buger-eats-qa.vercel.app/deliver",
				"validando URL da página de cadastro do Buger Eats");
		metodos.tirarEvidencia("cadastro", "PaginaDeCadastroDoBugerEats",
				"tirando evidencia da PaginaDeCadastroDoBugerEats");
	}

	@When("o usuário completa o cadastro com todos os dados obrigatórios")
	public void o_usuário_completa_o_cadastro_com_todos_os_dados_obrigatórios() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal", "preenchendo o campo nome");
		metodos.escrever(cadastropage.cpf, "18259550008", "preenchendo o campo CPF");
		metodos.escrever(cadastropage.email, "fulanodetal@gmail.com", "preenchendo o campo e-mail");
		metodos.escrever(cadastropage.whatsapp, "67982341457", "preenchendo o campo WhatsApp");
		metodos.escrever(cadastropage.cep, "22451530", "preenchendo o campo CEP");
		metodos.clicar(cadastropage.buscarCepBtn, "clicando em botão buscar CEP");
		metodos.escrever(cadastropage.numero, "297", "preenchendo o campo número");
		metodos.escrever(cadastropage.complemento, "Casa 1", "preenchendo o campo complemento");
		metodos.tirarEvidencia("cadastro", "CadastroComTodosOsDadosObrigatorios",
				"tirando evidencia do CadastroComTodosOsDadosObrigatorios");
	}

	@When("o usuário escolhe o método de entrega moto")
	public void o_usuário_escolhe_o_método_de_entrega_moto() {
		metodos.clicar(cadastropage.moto, "escolhendo método moto");
		metodos.tirarEvidencia("cadastro", "Moto", "tirando evidencia escolhendo método moto");
	}

	@When("o usuário faz upload da CNH")
	public void o_usuário_faz_upload_da_cnh() {
		metodos.clicar(cadastropage.fotoDaSuaCNH, "clicando para carregar foto");
		metodos.uploadArquivo("upload da CNH");
		metodos.tirarEvidencia("cadastro", "UploadDaCNH", "tirando evidencia do UploadDaCNH");
	}

	@Then("o usuário é cadastrado com sucesso no sistema")
	public void oUsuárioÉCadastradoComSucessoNoSistema() {
		metodos.clicar(cadastropage.cadastroBtn, "clicando no botão para fazer cadastro");
		metodos.validarTexto(cadastropage.cadastroComSucesso, "Aí Sim...", "validando cadastro com sucesso");
		metodos.tirarEvidencia("cadastro", "CadastroComSucesso", "tirando evidencia do CadastroComSucesso");
		Executa.fecharNavegador();
	}

	@When("o usuário escolhe o método de entrega bike elétrica")
	public void o_usuário_escolhe_o_método_de_entrega_bike_elétrica() {
		metodos.clicar(cadastropage.bikeEletrica, "escolhendo método bike eletrica");
		metodos.tirarEvidencia("cadastro", "BikeEletrica", "tirando evidencia escolhendo método BikeEletrica");
	}

	@When("o usuário escolhe o método de entrega van\\/carro")
	public void o_usuário_escolhe_o_método_de_entrega_van_carro() {
		metodos.clicar(cadastropage.vanCarro, "escolhendo método van/carro");
		metodos.tirarEvidencia("cadastro", "VanCarro", "tirando evidencia escolhendo método VanCarro");
	}

	@When("o usuário não faz upload da CNH")
	public void o_usuário_não_faz_upload_da_cnh() {
		metodos.scrollTela(0, 400);
		metodos.tirarEvidencia("cadastro", "SemUpload", "tirando evidencia não fazendo Upload");
		metodos.clicar(cadastropage.cadastroBtn, "clicando no botão para fazer cadastro");
	}

	@Then("o usuário é informado sobre a necessidade de fazer upload de CNH")
	public void o_usuário_é_informado_sobre_a_necessidade_de_fazer_upload_de_cnh() {
		metodos.validarTexto(cadastropage.adicioneCNH, "Adicione uma foto da sua CNH",
				"validando cadastro com sucesso");
		metodos.tirarEvidencia("cadastro", "AdicioneUmaFotoDaDuaCNH", "tirando evidencia da obrigatoriedade do Upload");
		Executa.fecharNavegador();
	}

	@When("o usuário tenta se cadastrar sem preencher todos os campos obrigatórios")
	public void o_usuário_tenta_se_cadastrar_sem_preencher_todos_os_campos_obrigatórios() {
		metodos.tirarEvidencia("cadastro", "SemCamposObrigatorios", "tirando evidencia de campos não preenchido");
		metodos.clicar(cadastropage.cadastroBtn, "clicando no botão para fazer cadastro");
	}

	@Then("o sistema apresenta mensagens indicando quais campos são obrigatórios")
	public void o_sistema_apresenta_mensagens_indicando_quais_campos_são_obrigatórios() {
		metodos.validarTexto(cadastropage.informarNome, "É necessário informar o nome",
				"validando alerta de nome em branco");
		metodos.validarTexto(cadastropage.informarCPF, "É necessário informar o CPF",
				"validando alerta de CPF em branco");
		metodos.validarTexto(cadastropage.informarEmail, "É necessário informar o email",
				"validando alerta de e-mail em branco");
		metodos.validarTexto(cadastropage.informarCEP, "É necessário informar o CEP",
				"validando alerta de CEP em branco");
		metodos.validarTexto(cadastropage.informarNumEndereco, "É necessário informar o número do endereço",
				"validando alerta de número de endereço em branco");
		metodos.tirarEvidencia("cadastro", "AlertasDeCamposEmBranco",
				"tirando evidencia do alertas de campos não preenchido");
		Executa.fecharNavegador();
	}

	@When("o usuário tenta se cadastrar com um número de CPF inválido")
	public void o_usuário_tenta_se_cadastrar_com_um_número_de_cpf_inválido() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal", "preenchendo o campo nome");
		metodos.escrever(cadastropage.cpf, "00000000000", "preenchendo o campo CPF");
		metodos.escrever(cadastropage.email, "fulanodetal@gmail.com", "preenchendo o campo e-mail");
		metodos.escrever(cadastropage.whatsapp, "67982341457", "preenchendo o campo WhatsApp");
		metodos.escrever(cadastropage.cep, "22451530", "preenchendo o campo CEP");
		metodos.clicar(cadastropage.buscarCepBtn, "clicando em botão buscar CEP");
		metodos.escrever(cadastropage.numero, "297", "preenchendo o campo número");
		metodos.escrever(cadastropage.complemento, "Casa 1", "preenchendo o campo complemento");
		metodos.scrollTela(0, -50);
		metodos.tirarEvidencia("cadastro", "CPFInvalido", "tirando evidencia de CPF invalido");
		metodos.clicar(cadastropage.cadastroBtn, "clicando no botão para fazer cadastro");
	}

	@Then("o sistema apresenta uma mensagem de erro indicando “CPF inválido”")
	public void o_sistema_apresenta_uma_mensagem_de_erro_indicando_cpf_inválido() {
		metodos.validarTexto(cadastropage.CPFInvalido, "Oops! CPF inválido", "validando alerta de CPF em inválido");
		metodos.scrollTela(0, -600);
		metodos.tirarEvidencia("cadastro", "AlertaCPFInvalido", "tirando evidencia do arlerta de CPF inválido");
		Executa.fecharNavegador();
	}

	@When("o usuário tenta se cadastrar com um email inválido")
	public void o_usuário_tenta_se_cadastrar_com_um_email_inválido() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal", "preenchendo o campo nome");
		metodos.escrever(cadastropage.cpf, "18259550008", "preenchendo o campo CPF");
		metodos.escrever(cadastropage.email, "fulanodetalgmail.com", "preenchendo o campo e-mail");
		metodos.escrever(cadastropage.whatsapp, "67982341457", "preenchendo o campo WhatsApp");
		metodos.escrever(cadastropage.cep, "22451530", "preenchendo o campo CEP");
		metodos.clicar(cadastropage.buscarCepBtn, "clicando em botão buscar CEP");
		metodos.escrever(cadastropage.numero, "297", "preenchendo o campo número");
		metodos.escrever(cadastropage.complemento, "Casa 1", "preenchendo o campo complemento");
		metodos.tirarEvidencia("cadastro", "EmailInvalido", "tirando evidencia de email inválido");
		metodos.clicar(cadastropage.cadastroBtn, "clicando no botão para fazer cadastro");
	}

	@Then("o sistema apresenta uma mensagem de erro “e-mail inválido”")
	public void o_sistema_apresenta_uma_mensagem_de_erro_e_mail_inválido() {
		metodos.validarTexto(cadastropage.emailInvalido, "Oops! Email com formato inválido.",
				"validando alerta de CPF em branco");
		metodos.scrollTela(0, -600);
		metodos.tirarEvidencia("cadastro", "AlertaEmailInvalido", "tirando evidencia do alerta de email inválido");
		Executa.fecharNavegador();
	}

	@When("o usuário tenta se cadastrar com um número de CEP inválido")
	public void o_usuário_tenta_se_cadastrar_com_um_número_de_cep_inválido() {
		metodos.escrever(cadastropage.nome, "Fulano de Tal", "preenchendo o campo nome");
		metodos.escrever(cadastropage.cpf, "18259550008", "preenchendo o campo CPF");
		metodos.escrever(cadastropage.email, "fulanodetal@gmail.com", "preenchendo o campo e-mail");
		metodos.escrever(cadastropage.whatsapp, "67982341457", "preenchendo o campo WhatsApp");
		metodos.escrever(cadastropage.cep, "224515301", "preenchendo o campo CEP");
		metodos.clicar(cadastropage.buscarCepBtn, "clicando em botão buscar CEP");
		metodos.escrever(cadastropage.numero, "297", "preenchendo o campo número");
		metodos.escrever(cadastropage.complemento, "Casa 1", "preenchendo o campo complemento");
		metodos.tirarEvidencia("cadastro", "CEPInvalido", "tirando evidencia do alerta de email inválido");
		metodos.clicar(cadastropage.cadastroBtn, "clicando no botão para fazer cadastro");
	}

	@Then("o sistema apresenta uma mensagem de erro “CEP não encontrado”")
	public void o_sistema_apresenta_uma_mensagem_de_erro_cep_não_encontrado() throws InterruptedException {
		metodos.validarTexto(cadastropage.CEPInvalido, "Informe um CEP válido", "validando alerta de CEP em branco");
		metodos.scrollTela(0, -600);
		metodos.tirarEvidenciadoAlertaCEPInvalido("tirando evidencia do alerta de email inválido");
		Executa.fecharNavegador();
	}

	@When("o usuário tenta se cadastrar selecionando mais de um método de entrega")
	public void oUsuárioTentaSeCadastrarSelecionandoMaisDeUmMétodoDeEntrega() {
		metodos.clicar(cadastropage.moto, "escolhendo método bike eletrica");
		metodos.clicar(cadastropage.bikeEletrica, "escolhendo método bike eletrica");
		metodos.tirarEvidencia("cadastro", "SelecionandoMaisDeUmMetodoDeEntrega",
				"tirando evidencia SelecionandoMaisDeUmMetodoDeEntrega");
		metodos.clicar(cadastropage.cadastroBtn, "clicando no botão para fazer cadastro");
	}

	@Then("o sistema apresenta uma mensagem de erro “Selecionar apenas um método de entrega”")
	public void oSistemaApresentaUmaMensagemDeErroSelecionarApenasUmMétodoDeEntrega() {
		metodos.validarTexto(cadastropage.apenasUmMetodo, "Oops! Selecione apenas um método de entrega",
				"validando seleção dee mais de um método de entrega");
		metodos.tirarEvidencia("cadastro", "AlertaApenasUmMetodoDeEntrega",
				"tirando evidencia alerta SelecionandoMaisDeUmMetodoDeEntrega");
		Executa.fecharNavegador();
	}
}
