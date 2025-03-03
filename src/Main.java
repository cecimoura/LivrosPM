import livros.Livro;
import usuario.Leitor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        // Cadastro do leitor
        System.out.println("\n=============================");
        System.out.println("    Cadastro de Leitor ");
        System.out.println("=============================");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String CPF = scanner.nextLine();
        System.out.println("=============================");

        // Criando o objeto leitor
        Leitor leitor = new Leitor(nome, CPF);

        // Loop do menu principal
        while (continuar) {
            System.out.println("\n=============================");
            System.out.println("     MENU PRINCIPAL");
            System.out.println("=============================");
            System.out.println("1 - Visualizar Livros");
            System.out.println("2 - Cadastrar Livro");
            System.out.println("3 - Dados do Leitor");
            System.out.println("4 - Modificar Livro");
            System.out.println("5 - Remover Livro");
            System.out.println("6 - Sair");
            System.out.print("\nEscolha uma opção: ");

            int opcao;
            while (!scanner.hasNextInt()) {
                System.out.println("\nEntrada inválida! Digite um número.");
                scanner.next(); // Limpa a entrada inválida
            }
            opcao = scanner.nextInt();
            scanner.nextLine(); // Limpa o buffer

            switch (opcao) {
                case 1:
                    System.out.println("\nVocê escolheu: Visualizar Livros");

                    // Chamar o método para visualizar livros (não implementado ainda)
                    break;
                case 2:
                    System.out.println("\nVocê escolheu: Cadastrar Livro");
                    // Chamar o método para cadastrar livro (não implementado ainda)
                    break;
                case 3:
                    System.out.println("\nVocê escolheu: Dados do Leitor");
                    leitor.exibirInfoUsuario(); // Exibe os dados do leitor
                    break;
                case 4:
                    System.out.println("\nVocê escolheu: Modificar Livro");
                    // Chamar o método para modificar livro (não implementado ainda)
                    break;
                case 5:
                    System.out.println("\nVocê escolheu: Remover Livro");
                    // Chamar o método para remover livro (não implementado ainda)
                    break;
                case 6:
                    System.out.println("\nSaindo do sistema...");
                    continuar = false;
                    break;
                default:
                    System.out.println("\nOpção inválida! Escolha um número entre 1 e 6.");
            }

            // Perguntar ao usuário se quer voltar ao menu principal ou sair
            if (continuar) {
                System.out.println("\nDeseja voltar ao menu principal ou sair?");
                System.out.println("1 - Voltar ao menu");
                System.out.println("2 - Sair do sistema");
                int voltarOuSair = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                if (voltarOuSair == 2) {
                    System.out.println("\nSaindo do sistema...");
                    continuar = false;
                }
            }
        }
        scanner.close();
    }
}
