import Exceptions.*;

import java.io.FileNotFoundException;
import java.util.Scanner;
import Controllers.CidadesController;

public class DataReader {
    Scanner sc = new Scanner(System.in);
	CidadesController controller = new CidadesController();

    public void executa() {
        int opcao = 0;
        String aux = "";
        do {
            try {
				System.out.println("=========================================\n");
				System.out.println("Opcoes:");
				System.out.println("[1] Carregar dados abertos.");
				System.out.println("[2] Classificar dados por nome.");
				System.out.println("[3] Consultar todos os dados.");
				System.out.println("[4] Consultar dados por nome.");
				System.out.println("[5] Salvar ultimos dados pesquisados em arquivo.");
				System.out.println("[0] Sair.");
				System.out.print("Digite a opção desejada: ");
				aux = sc.nextLine();
				System.out.println("\n=========================================\n");
				
				while (!aux.matches("[0-5]")) {
					System.out.print("Opção inválida, tente novamente: ");
					aux = sc.nextLine();
				}
				
				opcao = Integer.parseInt(aux);
				
				switch (opcao) {
					case 1:
						this.carregarDadosAbertos();
						break;
					case 2:
                        //TODO: classificarDadosPorNome
						this.classificarDadosPorNome();
						break;
					case 3:
						this.consultarTodosOsDados();
						break;
					case 4:
						this.consultarDadosPorNome();
						break;
					case 5:
						this.salvarDadosArquivo();
						break;
					case 0:
						break;
					default:
						throw new InvalidOptionException();
				}
            }
            catch (Exception e){
                if (!(e instanceof InvalidOptionException))
                    System.out.println("\nAlgum erro foi encontrado! Entre em contato com o suporte técnico:\n");
                System.out.println(e.getMessage());
            }
        } while (opcao != 0);
        sc.close();
	}

    private void carregarDadosAbertos() throws Exception{
		try{
			System.out.println("Aloque o arquivo para o diretório 'assets' da pasta do projeto!");
			System.out.print("Insira o nome do arquivo (sem extensão): ");
			String fileName = sc.nextLine();

			while (fileName.length() < 5) {
				System.out.println("O nome do arquivo é invalido! Tente novamente");
				fileName = sc.nextLine();
			}

			if (controller.carregarDadosAbertos(fileName))
				System.out.println("\nDados carregados. Operação finalizada com sucesso!");
			else
				throw new Exception("Não foi possível ler o arquivo!");
		}
		catch (Exception e) {
			if (!(e instanceof FileNotFoundException))
				System.out.println("Algum erro foi encontrado! Entre em contato com o suporte técnico");
			System.out.println(e.getMessage());
		}

    }

    private void classificarDadosPorNome() throws Exception{
		if (controller.isEmpty())
			System.out.println("Não existem dados carregados!\n");
		else {
			System.out.print("Como deseja ordenar os dados (1-Crescente/2-Decrescente)? ");
			String order = sc.nextLine();			
			while (!order.matches("[1-2]")) {
				System.out.print("\nOpção inválida, tente novamente: ");
				order = sc.nextLine();
			}

			if (order.equals("1"))
				controller.sortAscending();
			else
				controller.sortDescending();
			
			System.out.println("Ordenação realizada com sucesso!");
		}
    }

    private void consultarTodosOsDados() throws Exception{
		try {
			System.out.println(controller.listarTodosOsDados());
		}
		catch (Exception e) {
			System.out.println("Algum erro foi encontrado! Entre em contato com o suporte técnico");
			System.out.println(e.getMessage());
		}
    }

    private void consultarDadosPorNome() throws Exception{
		try{
			System.out.print("Insira o nome do Município: ");
			String municipio = sc.nextLine();

			while (municipio.length() < 0){
				System.out.print("O nome do município não pode estar vazio, tente novamente: ");
				municipio = sc.nextLine();
			}

			System.out.println("\n" + controller.buscarPorNome(municipio));
		}
		catch (Exception e) {
			System.out.println("Algum erro foi encontrado! Entre em contato com o suporte técnico");
			System.out.println(e.getMessage());
		}
    }

    private void salvarDadosArquivo() throws Exception{
		try {
			System.out.print("Insira o nome do Arquivo (sem extensão): ");
			String nome = sc.nextLine();

			while (nome.length() <= 0){
				System.out.print("O nome da arquivo é obrigatório! Tente novamente: ");
				nome = sc.nextLine();
			}

			if (controller.salvarDadosArquivo(nome))
				System.out.println("\nArquivo salvo no diretório \"out\" do projeto. Operação finalizada com sucesso!");
			else
				throw new Exception("Não foi possível salvar o arquivo!");
		}
		catch (Exception e) {
			System.out.println("Algum erro foi encontrado! Entre em contato com o suporte técnico");
			System.out.println(e.getMessage());
		}
    }
}