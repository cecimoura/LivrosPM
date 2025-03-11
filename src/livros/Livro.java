package livros;

// A classe Livro implementa duas interfaces: Emprestimo e InfoLivro
public class Livro implements Emprestimo, InfoLivro {
    private String titulo;
    private String autor;
    private StatusLivro status; // Atributo status do livro, disponivel ou emprestado

    // Construtor para criar um livro com título, nome do autor e status
    public Livro(String titulo, String autor, StatusLivro status) {
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
    }

    // Métodos getters e setters
    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo; // Define o título do livro
    }

    public String getAutor() {
        return autor; // Retorna o nome do autor
    }

    public void setAutor(String autor) {
        this.autor = autor; // Define o autor do livro
    }

    public StatusLivro getStatus() {
        return status;
    }

    public void setStatus(StatusLivro status) {
        this.status = status; // Define o status do livro
    }

    // Implementação do metodo exibirInfoLivro da interface InfoLivro
    @Override
    public void exibirInfoLivro() {
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Autor: " + this.getAutor());
        System.out.println("Status: " + this.getStatus());
    }

    // Implementação do metodo emprestarLivro da interface Emprestimo
    @Override
    public void emprestarLivro() {  // Verifica se o livro está disponível para empréstimo
        if (this.status == StatusLivro.DISPONIVEL) {
            this.status = StatusLivro.EMPRESTADO;
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Este livro já foi emprestado."); // Caso o livro não esteja disponível, exibe uma mensagem de erro
        }
    }

    // Implementação do metodo devolverLivro da interface Emprestimo
    @Override // A anotação @Override garante que seja implementado corretamente o metodo da interface.
    public void devolverLivro() {
        // Verifica se o livro está emprestado
        if (this.status == StatusLivro.EMPRESTADO) {
            this.status = StatusLivro.DISPONIVEL;
            System.out.println("Livro devolvido com sucesso!");
        } else {
            System.out.println("Este livro não está emprestado.");
        }
    }
}
