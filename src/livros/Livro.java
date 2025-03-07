package livros; // Certifique-se de que este é o nome correto do pacote

public class Livro {
    private String titulo;
    private String autor;
    private StatusLivro status; // Adicionado atributo status

    // Construtor para criar um livro com título, nome do autor e status
    public Livro(String titulo, String autor, StatusLivro status){
        this.titulo = titulo;
        this.autor = autor;
        this.status = status;
    }

    // Métodos getters e setters
    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public StatusLivro getStatus() { return status; } // Agora retorna o status
    public void setStatus(StatusLivro status) { this.status = status; }

    // Exibir informações do livro
    public void exibirInfoLivro(){
        System.out.println("Título: " + this.getTitulo());
        System.out.println("Autor: " + this.getAutor());
        System.out.println("Status: " + this.getStatus()); // Exibir o status também
    }
}
