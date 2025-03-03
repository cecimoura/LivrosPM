import livros.Livro; // Import da classe dentro do package
import usuario.Leitor;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Capturando os dados do leitor
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

        System.out.println("\nPressione Enter para continuar...");
        scanner.nextLine(); // Aguarda o usuário pressionar Enter

        // Criando os livros disponíveis
        Livro livro1 = new Livro("A Cabeça do Santo", "Socorro Acioli");
        Livro livro2 = new Livro("E não sobrou nenhum", "Agatha Christie");
        Livro livro3 = new Livro("O Retrato de Dorian Gray", "Oscar Wilde");
        Livro livro4 = new Livro("A Metamorfose", "Franz Kafka");

        boolean continuar = true;

        while (continuar) {
            int opcao;
            boolean escolhaValida = false;

            // Loop para garantir que o usuário escolha um livro válido
            do {
                // Mostrando os livros disponíveis
                System.out.println("\n=============================");
                System.out.println("  Lista de Livros Disponíveis");
                System.out.println("1. " + livro1.getTitulo());
                System.out.println("2. " + livro2.getTitulo());
                System.out.println("3. " + livro3.getTitulo() + " (Indisponível)");
                System.out.println("4. " + livro4.getTitulo());
                System.out.println("5. Dados do leitor");
                System.out.println("6. Sair");
                System.out.println("=============================");

                System.out.print("\nDigite o número que gostaria de visualizar: ");

                // Verifica se o usuário digitou um número válido
                while (!scanner.hasNextInt()) {
                    System.out.println("\nEntrada inválida! Digite um número.");
                    scanner.next(); // Limpa a entrada inválida
                }

                opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer do scanner

                // Switch-case para escolher as opções
                switch (opcao) {
                    case 1:
                        System.out.println("\nOpção 1 escolhida: " + livro1.getTitulo());
                        escolhaValida = true;
                        break;
                    case 2:
                        System.out.println("\nOpção 2 escolhida: " + livro2.getTitulo());
                        escolhaValida = true;
                        break;
                    case 3:
                        System.out.println("\nOpção 3 escolhida: " + livro3.getTitulo() + " - Desculpe, este livro está indisponível.");
                        escolhaValida = false; // Não pode ser confirmado
                        break;
                    case 4:
                        System.out.println("\nOpção 4 escolhida: " + livro4.getTitulo());
                        escolhaValida = true;
                        break;
                    case 5:
                        System.out.println("\nOpção 5 escolhida: Dados do leitor");
                        leitor.exibirInfoUsuario();
                        // Adicionando uma opção para voltar ao menu
                        System.out.println("\nPressione Enter para voltar ao menu...");
                        scanner.nextLine(); // Aguarda o usuário pressionar Enter
                        break;
                    case 6:
                        System.out.println("\nSaindo do menu...");
                        continuar = false;
                        escolhaValida = true;
                        break;
                    default:
                        System.out.println("\nOpção inválida, por favor digite novamente um número de 1 a 6.");
                }
            } while (!escolhaValida);

            // Caso tenha escolhido um livro válido, exibe opção para voltar ou continuar
            if (continuar && escolhaValida) {
                System.out.println("\nDeseja visualizar outro livro?");
                System.out.println("1 - Sim");
                System.out.println("2 - Não, finalizar escolha");

                int escolha = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer

                if (escolha == 2) {
                    System.out.println("\nLivro confirmado! Continuando...");
                    continuar = false;
                }
            }
        }

        // Finalizando o scanner
        scanner.close();
    }
}
