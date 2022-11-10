import Exceptions.*;
import java.util.Scanner;

public class DataReader {
    Scanner sc = new Scanner(System.in);

    public void executa() {
        int opcao = 0;
        String aux = "";
        do {
            try {
				System.out.println("=========================================\n");
				System.out.println("Opcoes:");
				System.out.println("[1] Cadastrar nova usina.");
				System.out.println("[2] Pesquisar uma usina.");
				System.out.println("[3] Listar todas as usinas.");
				System.out.println("[4] Consulta o preço do MHh.");
				System.out.println("[5] Salvar usinas em arquivo.");
				System.out.println("[0] Sair.");
				System.out.print("Digite a opção desejada: ");
				aux = sc.nextLine();
				
				while (!aux.matches("[0-5]")) {
					System.out.print("Opção inválida, tente novamente: ");
					aux = sc.nextLine();
				}
				
				opcao = Integer.parseInt(aux);
				
				switch (opcao) {
					case 1:
                        //TODO: carregarDadosAbertos
						this.carregarDadosAbertos();
						break;
					case 2:
                        //TODO: classificarDadosPorNome
						this.classificarDadosPorNome();
						break;
					case 3:
                        //TODO: consultarTodosOsDados
						this.consultarTodosOsDados();
						break;
					case 4:
                        //TODO: consultarDadosPorNome
						this.consultarDadosPorNome();
						break;
					case 5:
                        //TODO: salvarDadosArquivo
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

    public void carregarDadosAbertos() throws Exception{
        throw new Exception("Método não implementado");
    }

    public void classificarDadosPorNome() throws Exception{
        throw new Exception("Método não implementado");
    }

    public void consultarTodosOsDados() throws Exception{
        throw new Exception("Método não implementado");
    }

    public void consultarDadosPorNome() throws Exception{
        throw new Exception("Método não implementado");
    }

    public void salvarDadosArquivo() throws Exception{
        throw new Exception("Método não implementado");
    }
}