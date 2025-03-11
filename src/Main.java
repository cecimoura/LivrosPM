import livros.Livro; // Importa a classe 'Livro' do pacote 'livros'
import livros.StatusLivro; // Importa a enumeração 'StatusLivro' do pacote 'livros'
import usuario.Leitor; // Importa a classe 'Leitor' do pacote 'usuario'

import java.util.ArrayList; // Importa a classe 'ArrayList' da biblioteca Java para armazenar uma lista de objetos
import java.util.List; // Importa a interface 'List' para definir uma lista de objetos
import java.util.Scanner;  // Importa a classe 'Scanner' para ler a entrada do usuário no console

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
                case 1 -> { //case q lista os livros
                    listarLivros();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine(); // Aguarda o usuario pressionar Enter
                }
                case 2 -> { //case p cadastrar os livros
                    cadastrarLivro();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 3 -> { //case p mostrar as infos do user
                    visualizarDadosLeitor();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 4 -> { //case p realizar emprestimo de livro
                    emprestarLivro();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 5 -> { //case p remover o livro
                    removerLivro();
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 6 -> {
                    devolverLivro();  // case com a Opção de devolver livro
                    System.out.println("\nPressione Enter para continuar...");
                    scanner.nextLine();
                }
                case 7 -> { //case p sair do sistema
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
        while (true) { // Loop infinito até o usuário fornecer uma entrada válida
            if (scanner.hasNextInt()) { // Verifica se a próxima entrada é um número inteiro
                int opcao = scanner.nextInt(); // Lê o número inteiro digitado pelo usuário
                scanner.nextLine(); // Limpa o buffer
                return opcao; //Retorna a opção escolhida
            } else {
                System.out.print("⚠ Entrada inválida! Digite um número: "); //mensagem de erro
                scanner.next(); // Descarta a entrada inválida e continua o loop
            }
        }
    }

    /**
     * Exibe a lista de livros cadastrados no sistema.
     */
    private static void listarLivros() {
        if (livros.isEmpty()) {  // Verifica se a lista de livros está vazia
            System.out.println("\n Nenhum livro cadastrado ainda.");
            return;
        }

        System.out.println("\n-------------------");
        System.out.println(" Lista de Livros:");
        System.out.println("-------------------");
        System.out.printf("%-5s %-40s %-30s %-15s%n", "ID", "Título", "Autor", "Status");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < livros.size(); i++) { // Percorre a lista de livros e exibe cada um formatado corretamente
            System.out.printf("%-5d %-40s %-30s %-15s%n", i + 1, livros.get(i).getTitulo(), livros.get(i).getAutor(), livros.get(i).getStatus());
        }
    }

    /**
     * Permite ao usuário cadastrar um novo livro na biblioteca.
     */
    private static void cadastrarLivro() {
        System.out.print("\n Digite o título do livro: ");  // Solicita ao usuário que digite o título do livro
        String titulo = scanner.nextLine();
        System.out.print(" Digite o autor do livro: ");
        String autor = scanner.nextLine();
        livros.add(new Livro(titulo, autor, StatusLivro.DISPONIVEL)); // Adiciona um novo livro à lista com status DISPONIVEL
        System.out.println("\n✅ Livro cadastrado com sucesso!");
    }

    /**
     * Exibe as informações do leitor cadastrado no sistema.
     */
    private static void visualizarDadosLeitor() {
        System.out.println("\n📖 Dados do Leitor:");
        leitor.exibirInfoUsuario(); // Chama o metodo da classe Leitor p exibir as informações do usuário
    }

    /**
     * Realiza o empréstimo de um livro, alterando seu status se disponível.
     */
    /**
     * Realiza o empréstimo de um livro, alterando seu status se disponível.
     */
    private static void emprestarLivro() {
        if (livros.isEmpty()) { // Verifica se há livros cadastrados
            System.out.println("\nNão há livros disponíveis para empréstimo.");
            return;  // Sai do metodo caso não haja livros
        }

        System.out.println("\n----------------------------");
        System.out.println("   Livros Disponíveis:");
        System.out.println("----------------------------");
        System.out.printf("%-5s %-40s %-30s %-15s%n", "ID", "Título", "Autor", "Status");
        System.out.println("---------------------------------------------------------------");

        for (int i = 0; i < livros.size(); i++) {
            Livro livro = livros.get(i);
            if (livro.getStatus() == StatusLivro.DISPONIVEL) { // Exibe apenas livros disponíveis
                System.out.printf("%-5d %-40s %-30s %-15s%n", i + 1, livro.getTitulo(), livro.getAutor(), "Disponível");
            }
        }

        System.out.println("---------------------------------------------------------------");

        // Solicita ao usuario que escolha um livro para emprestar
        System.out.print("\n👉 Digite o número do livro que deseja pegar emprestado ou 0 para voltar: ");
        int escolhaLivro = lerOpcaoUsuario();

        // Verifica se o número escolhido está dentro do intervalo válido
        if (escolhaLivro > 0 && escolhaLivro <= livros.size()) {
            Livro livroSelecionado = livros.get(escolhaLivro - 1); // Obtém o livro correspondente à escolha do usuario
            if (livroSelecionado.getStatus() == StatusLivro.DISPONIVEL) {
                livroSelecionado.emprestarLivro(); // Chama o metodo que altera o status do livro para EMPRESTADO
                System.out.println("\n✅ Livro emprestado com sucesso!");
            } else {
                System.out.println("\n⚠ Este livro já está emprestado."); // Informa que o livro não pode ser emprestado novamente
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
