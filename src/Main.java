import livros.Livro; // Import da classe dentro do package
import usuario.Leitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Livro> livros = new ArrayList<>();

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

        boolean continuar = true;

        while (continuar) {
            System.out.println("\n=============================");
            System.out.println("  Menu Principal");
            System.out.println("1. Visualizar Livros");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Dados do Leitor");
            System.out.println("4. Modificar Livro");
            System.out.println("5. Remover Livro");
            System.out.println("6. Sair");
            System.out.println("=============================");

            System.out.print("\nEscolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("\n Entrada inválida! Digite um número.");
                scanner.next();
            }
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (livros.isEmpty()) {
                        System.out.println("\nNenhum livro cadastrado ainda.");
                    } else {
                        System.out.println("\nLista de Livros Disponíveis:");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println((i + 1) + ". " + livros.get(i).getTitulo());
                        }

                        System.out.print("\nDigite o número do livro para ver detalhes ou 0 para voltar: ");
                        int escolhaLivro = scanner.nextInt();
                        scanner.nextLine();

                        if (escolhaLivro > 0 && escolhaLivro <= livros.size()) {
                            livros.get(escolhaLivro - 1).exibirInfoLivro();
                        } else if (escolhaLivro != 0) {
                            System.out.println("Opção inválida.");
                        }
                    }
                    break;
                case 2:
                    System.out.print("\nDigite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    livros.add(new Livro(titulo, autor));
                    System.out.println("\nLivro cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("\nDados do Leitor:");
                    leitor.exibirInfoUsuario();
                    break;
                case 4:
                    System.out.println("\nOpção de Modificar Livro ainda não implementada.");
                    break;
                case 5:
                    System.out.println("\nOpção de Remover Livro ainda não implementada.");
                    break;
                case 6:
                    System.out.println("\nSaindo do sistema...");
                    continuar = false;
                    break;
                default:
                    System.out.println("\nOpção inválida! Escolha um número entre 1 e 6.");
            }
        }
        scanner.close();
    }
}
