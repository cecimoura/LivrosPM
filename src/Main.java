import livros.Livro;
import livros.StatusLivro;
import usuario.Leitor;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Scanner para entrada do usuário
    private static final Scanner scanner = new Scanner(System.in);
    // Lista de livros disponíveis no sistema
    private static final List<Livro> livros = new ArrayList<>();
    // Objeto Leitor representando o usuário do sistema
    private static Leitor leitor;

    public static void main(String[] args) {
        cadastrarLeitor(); // Cadastra os dados do usuario
        carregarLivrosIniciais(); // Adiciona alguns livros de exemplo

        boolean continuar = true;
        while (continuar) {
            exibirMenu(); // Exibe o menu principal
            int opcao = lerOpcaoUsuario(); // Lê a opção escolhida

            // Estrutura de decisão para processar a opção do usuario
            switch (opcao) {
                case 1 -> {
                    listarLivros();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine(); // Aguarda o usuario pressionar Enter
                }
                case 2 -> {
                    cadastrarLivro();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 3 -> {
                    visualizarDadosLeitor();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 4 -> {
                    emprestarLivro();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 5 -> {
                    removerLivro();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 6 -> {
                    devolverLivro();  // Opção para devolver livro
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 7 -> {
                    System.out.println("\n👋 Saindo do sistema... Obrigado por usar a biblioteca!");
                    continuar = false;
                }
                default -> System.out.println("\n⚠ Opção inválida! Escolha um número entre 1 e 7.");
            }
        }
        scanner.close(); // Fecha o scanner ao sair do programa
    }

    /**
     * Solicita os dados do usuário e cria um novo objeto Leitor.
     */
    private static void cadastrarLeitor() {
        System.out.println("\n---------------------------");
        System.out.println("     Cadastro de Leitor ");
        System.out.println("---------------------------");
        System.out.print("Digite seu nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite seu CPF: ");
        String CPF = scanner.nextLine();
        leitor = new Leitor(nome, CPF);
        System.out.println("✅ Cadastro realizado com sucesso!");
    }

    /**
     * Adiciona livros pré-definidos à lista.
     */
    private static void carregarLivrosIniciais() {
        livros.add(new Livro("A Cabeça do Santo", "Socorro Acioli", StatusLivro.DISPONIVEL));
        livros.add(new Livro("E não sobrou nenhum", "Agatha Christie", StatusLivro.DISPONIVEL));
        livros.add(new Livro("O Retrato de Dorian Gray", "Oscar Wilde", StatusLivro.DISPONIVEL));
        livros.add(new Livro("A Metamorfose", "Franz Kafka", StatusLivro.EMPRESTADO));
    }

    /**
     * Exibe o menu principal do sistema.
     */
    private static void exibirMenu() {
        System.out.println("\n-------------------------------------------");
        System.out.println("  SISTEMA DE GERENCIAMENTO DE BIBLIOTECA");
        System.out.println("-------------------------------------------");
        System.out.println("1️-  Visualizar Livros");
        System.out.println("2️-  Cadastrar Livro");
        System.out.println("3️-  Dados do Leitor");
        System.out.println("4️-  Empréstimo de Livro");
        System.out.println("5️-  Remover Livro");
        System.out.println("6️-  Devolução de Livro");  // Nova opção
        System.out.println("7️-  Sair");
        System.out.println("-------------------------------------------");
        System.out.print("👉 Escolha uma opção: ");
    }

    /**
     * Lê a opção digitada pelo usuário, garantindo que seja um número válido.
     * @return número da opção escolhida
     */
    private static int lerOpcaoUsuario() {
        while (true) {
            if (scanner.hasNextInt()) {
                int opcao = scanner.nextInt();
                scanner.nextLine(); // Limpa o buffer
                return opcao;
            } else {
                System.out.print("⚠ Entrada inválida! Digite um número: ");
                scanner.next();
            }
        }
    }

    /**
     * Exibe a lista de livros cadastrados no sistema.
     */
    private static void listarLivros() {
        if (livros.isEmpty()) {
            System.out.println("\n Nenhum livro cadastrado ainda.");
            return;
        }

        System.out.println("\n-------------------");
        System.out.println(" Lista de Livros:");
        System.out.println("-------------------");
        System.out.printf("%-5s %-40s %-30s %-15s%n", "ID", "Título", "Autor", "Status");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < livros.size(); i++) {
            System.out.printf("%-5d %-40s %-30s %-15s%n", i + 1, livros.get(i).getTitulo(), livros.get(i).getAutor(), livros.get(i).getStatus());
        }
    }

    /**
     * Permite ao usuário cadastrar um novo livro na biblioteca.
     */
    private static void cadastrarLivro() {
        System.out.print("\n Digite o título do livro: ");
        String titulo = scanner.nextLine();
        System.out.print(" Digite o autor do livro: ");
        String autor = scanner.nextLine();
        livros.add(new Livro(titulo, autor, StatusLivro.DISPONIVEL));
        System.out.println("\n✅ Livro cadastrado com sucesso!");
    }

    /**
     * Exibe as informações do leitor cadastrado no sistema.
     */
    private static void visualizarDadosLeitor() {
        System.out.println("\n📖 Dados do Leitor:");
        leitor.exibirInfoUsuario();
    }

    /**
     * Realiza o empréstimo de um livro, alterando seu status se disponível.
     */
    /**
     * Realiza o empréstimo de um livro, alterando seu status se disponível.
     */
    private static void emprestarLivro() {
        if (livros.isEmpty()) {
            System.out.println("\nNão há livros disponíveis para empréstimo.");
            return;
        }

        System.out.println("\n----------------------------");
        System.out.println("   Livros Disponíveis:");
        System.out.println("----------------------------");
        System.out.printf("%-5s %-40s %-30s %-15s%n", "ID", "Título", "Autor", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            if (livro.getStatus() == StatusLivro.DISPONIVEL) {
                System.out.printf("%-5d %-40s %-30s %-15s%n", i + 1, livro.getTitulo(), livro.getAutor(), "Disponível");
            }
        }

        System.out.println("---------------------------------------------------------------");

        System.out.print("\n👉 Digite o número do livro que deseja pegar emprestado ou 0 para voltar: ");
        int escolhaLivro = lerOpcaoUsuario();

        if (escolhaLivro > 0 && escolhaLivro <= livros.size()) {
            Livro livroSelecionado = livros.get(escolhaLivro - 1);
            if (livroSelecionado.getStatus() == StatusLivro.DISPONIVEL) {
                livroSelecionado.emprestarLivro();
                System.out.println("\n✅ Livro emprestado com sucesso!");
            } else {
                System.out.println("\n⚠ Este livro já está emprestado.");
            }
        } else if (escolhaLivro != 0) {
            System.out.println("\n⚠ Opção inválida! Digite novamente.");
        }
    }


    /**
     * Permite ao usuário remover um livro da biblioteca.
     */
    private static void removerLivro() {
        if (livros.isEmpty()) {
            System.out.println("\n📭 Nenhum livro cadastrado ainda para remover.");
            return;
        }

        System.out.println("\n Livros Disponíveis:");
        for (int i = 0; i < livros.size(); i++) {
            System.out.println((i + 1) + ". " + livros.get(i).getTitulo());
        }

        System.out.print("\n🗑 Digite o número do livro que deseja remover ou 0 para voltar: ");
        int escolha = lerOpcaoUsuario();

        if (escolha > 0 && escolha <= livros.size()) {
            livros.remove(escolha - 1);
            System.out.println("\n✅ Livro removido com sucesso!");
        } else if (escolha != 0) {
            System.out.println("\n⚠ Opção inválida! Digite novamente.");
        }
    }

    /**
     * Permite ao usuário devolver um livro, alterando seu status de emprestado para disponível.
     */
    private static void devolverLivro() {
        if (livros.isEmpty()) {
            System.out.println("\nNão há livros cadastrados no sistema.");
            return;
        }

        System.out.println("\n----------------------------");
        System.out.println("   Livros Emprestados:");
        System.out.println("----------------------------");
        System.out.printf("%-5s %-40s %-30s %-15s%n", "ID", "Título", "Autor", "Status");
        System.out.println("---------------------------------------------------------------");

        boolean livrosEmprestados = false;
        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            if (livro.getStatus() == StatusLivro.EMPRESTADO) {
                System.out.printf("%-5d %-40s %-30s %-15s%n", i + 1, livro.getTitulo(), livro.getAutor(), "Emprestado");
                livrosEmprestados = true;
            }
        }

        if (!livrosEmprestados) {
            System.out.println("\nNão há livros emprestados no momento.");
            return;
        }

        System.out.println("---------------------------------------------------------------");

        System.out.print("\n👉 Digite o número do livro que deseja devolver ou 0 para voltar: ");
        int escolhaLivro = lerOpcaoUsuario();

        if (escolhaLivro > 0 && escolhaLivro <= livros.size()) {
            Livro livroSelecionado = livros.get(escolhaLivro - 1);
            if (livroSelecionado.getStatus() == StatusLivro.EMPRESTADO) {
                livroSelecionado.setStatus(StatusLivro.DISPONIVEL);
                System.out.println("\n✅ Livro devolvido com sucesso!");
            } else {
                System.out.println("\n⚠ Este livro não está emprestado.");
            }
        } else if (escolhaLivro != 0) {
            System.out.println("\n⚠ Opção inválida! Digite novamente.");
        }
    }
}
