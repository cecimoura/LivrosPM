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
        System.out.println("\n=====Cadastro de Aluno=====");
        System.out.println("Digite seu nome: ");
        String nome = scanner.nextLine();

        System.out.println("Digite seu RA: ");
        String RA = scanner.nextLine();
        System.out.println("=============================");

        Livro livro1 = new Livro("A Cabeça do Santo", "Socorro Acioli");
        Livro livro2 = new Livro();

        livro2.setTitulo("E não sobrou nenhum");
        livro2.setAutor("Agatha Christie");

        System.out.println("\n Informações do Livro 1: ");
        livro1.exibirInfoLivro();

        System.out.println("\n Informações do Livro 2: ");
        livro2.exibirInfoLivro();
    }
}