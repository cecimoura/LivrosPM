import livros.Livro; //Import da classe dentro do package
import livros.StatusLivro; //import do enum StatusLivro


public class Main {
    public static void main(String[] args) {

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