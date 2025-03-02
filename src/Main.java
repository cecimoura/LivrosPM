import livros.Livro; //Import da classe dentro do package
import livros.StatusLivro; //import do enum StatusLivro
import usuario.Aluno;


public class Main {
    public static void main(String[] args) {

        //criando o aluno
        Aluno aluno = new Aluno("Cecília de Moura", "12345", "ADS");

        //exibindo as infos
        System.out.println("=====Informações do Aluno=====");
        aluno.exibirInfoUsuario();

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