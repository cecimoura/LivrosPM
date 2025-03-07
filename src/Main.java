import livros.Livro; // Import da classe dentro do package
import livros.StatusLivro; // Import do enum StatusLivro
import usuario.Leitor;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Livro> livros = new ArrayList<>();

        // Capturando os dados do leitor
        System.out.println("\n---------------------------");
        System.out.println("    Cadastro de Leitor ");
        System.out.println("----------------------------");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.print("Digite seu CPF: ");
        String CPF = scanner.nextLine();
        System.out.println("----------------------------");

        // Criando o objeto leitor
        Leitor leitor = new Leitor(nome, CPF);

        // Livros disponíveis
        livros.add(new Livro("A Cabeça do Santo", "Socorro Acioli", StatusLivro.DISPONIVEL));
        livros.add(new Livro("E não sobrou nenhum", "Agatha Christie", StatusLivro.DISPONIVEL));
        livros.add(new Livro("O Retrato de Dorian Gray", "Oscar Wilde", StatusLivro.DISPONIVEL));
        livros.add(new Livro("A Metamorfose", "Franz Kafka", StatusLivro.EMPRESTADO));

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n-----------------------");
            System.out.println("  Menu Principal");
            System.out.println("-----------------------");
            System.out.println("1. Visualizar Livros");
            System.out.println("2. Cadastrar Livro");
            System.out.println("3. Dados do Leitor");
            System.out.println("4. Empréstimo de Livro");
            System.out.println("5. Remover Livro");
            System.out.println("6. Sair");
            System.out.println("------------------------");

            System.out.print("\nEscolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.println("\nOpção inválida! Digite um número.");
                scanner.next();
            }
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    if (livros.isEmpty()) {
                        System.out.println("\nNenhum livro cadastrado ainda.");
                    } else {
                        System.out.println("\n----------------------------------");
                        System.out.println("  Lista de Livros Disponíveis:");
                        System.out.println("----------------------------------");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println((i + 1) + ". " + livros.get(i).getTitulo() + " - " + livros.get(i).getStatus());
                        }
                    }scanner.nextLine();
                    break;
                case 2:
                    System.out.print("\nDigite o título do livro: ");
                    String titulo = scanner.nextLine();
                    System.out.print("Digite o autor do livro: ");
                    String autor = scanner.nextLine();
                    livros.add(new Livro(titulo, autor, StatusLivro.DISPONIVEL));
                    System.out.println("\nLivro cadastrado com sucesso!");
                    break;
                case 3:
                    System.out.println("\nDados do Leitor:");
                    leitor.exibirInfoUsuario();
                    break;
                case 4:
                    if (livros.isEmpty()) {
                        System.out.println("\nNão há livros disponíveis para empréstimo.");
                    } else {
                        System.out.println("\nLista de Livros para Empréstimo:");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println((i + 1) + ". " + livros.get(i).getTitulo() + " - " + livros.get(i).getStatus());
                        }

                        System.out.print("\nDigite o número do livro que deseja pegar emprestado ou 0 para voltar: ");
                        int escolhaLivro = scanner.nextInt();
                        scanner.nextLine();

                        if (escolhaLivro > 0 && escolhaLivro <= livros.size()) {
                            Livro livroSelecionado = livros.get(escolhaLivro - 1);
                            if (livroSelecionado.getStatus() == StatusLivro.DISPONIVEL) {
                                livroSelecionado.emprestarLivro();
                                System.out.println("\nLivro emprestado com sucesso!");
                            } else {
                                System.out.println("\nEste livro já está emprestado.");
                            }
                        } else if (escolhaLivro != 0) {
                            System.out.println("\nOpção inválida! Digite novamente.");
                        }
                    }
                    break;
                case 5:
                    if (livros.isEmpty()) {
                        System.out.println("\nNenhum livro cadastrado ainda para realizar esta ação.");
                    } else {
                        System.out.println("\nLista de Livros:");
                        for (int i = 0; i < livros.size(); i++) {
                            System.out.println((i + 1) + ". " + livros.get(i).getTitulo());
                        }

                        System.out.print("\nDigite o número do livro que deseja remover ou 0 para voltar: ");
                        int escolha = scanner.nextInt();
                        scanner.nextLine();

                        if (escolha > 0 && escolha <= livros.size()) {
                            livros.remove(escolha - 1);
                            System.out.println("\nLivro removido com sucesso!");
                        } else if (escolha != 0) {
                            System.out.println("\nOpção inválida! Digite novamente.");
                        }
                    }
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
