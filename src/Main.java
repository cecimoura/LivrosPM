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


        Livro livro1 = new Livro("A Cabeça do Santo", "Socorro Acioli");
        Livro livro2 = new Livro("E não sobrou nenhum", "Agatha Christie");

        //mostrando os livros disponíveis
        System.out.println("\n=============================");
        System.out.println("  Lista de Livros Disponíveis");
        System.out.println("1. " +livro1.getTitulo());
        System.out.println("2. " +livro2.getTitulo());
        System.out.println("===============================");
    }
}