import livros.Livro; //Import da classe dentro do package
import livros.StatusLivro; //import do enum StatusLivro
import usuario.Aluno;

import usuario.Usuario;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        //capturando os dados do alunos
        System.out.println("\n=============================");
        System.out.println("    Cadastro de Aluno");
        System.out.println("==============================");
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu RA: ");
        String RA = scanner.nextLine();

        System.out.println("Digite seu curso: ");
        String curso = scanner.nextLine();
        System.out.println("=============================");

        //criando o Objeto aluno
        Aluno aluno = new Aluno(nome, RA, curso);

        //exibir info do usuario
        System.out.println("\n=============================");
        System.out.println("     Aluno Cadastrado    ");
        aluno.exibirInfoUsuario();
        System.out.println("=============================");


        Livro livro1 = new Livro("A Cabeça do Santo", "Socorro Acioli");
        Livro livro2 = new Livro("E não sobrou nenhum", "Agatha Christie");
        Livro livro3 = new Livro("O Retrato de Dorian Gray", "Oscar Wilde");
        Livro livro4 = new Livro("A Metamorfose",  "Franz Kafka");

        //mostrando os livros disponíveis
        System.out.println("\n=============================");
        System.out.println("  Lista de Livros Disponíveis");
        System.out.println("1. " +livro1.getTitulo());
        System.out.println("2. " +livro2.getTitulo());
        System.out.println("3. " +livro3.getTitulo());
        System.out.println("4. " +livro4.getTitulo());
        System.out.println("==============================");

        System.out.println("\n=================================================");
        System.out.println("Digite o número do livro que gostaria de visualizar");
        System.out.println("=================================================");
        int opcao = scanner.nextInt();

        //switch-case para escolher as opções
        switch(opcao){
            case 1:
                System.out.println("\nOpção 1 escolhida " + livro1.getTitulo());
                break;
            case 2:
                System.out.println("\nOpção 2 escolhida " + livro2.getTitulo());
                break;
            case 3:
                 System.out.println("\nOpção 3 escolhida " + livro3.getTitulo() + "desculpe, este livro está indisponível ");
                 break;
             case 4:
                 System.out.println("\nOpção 4 escolhida " + livro4.getTitulo());
                 break;
            default:
                 System.out.println("\nOpção inválida, por favor digite novamente um número de 1 a 4.");

        }

        /* finalizando o scanner */
        scanner.close();


    }
}