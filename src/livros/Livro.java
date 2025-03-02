package livros;

public class Livro {
    private String titulo;
    private String autor;
    private StatusLivro status;

    public Livro(){
        this.status=StatusLivro.DISPONIVEL;
    }

    public Livro(String titulo, String autor){
        this.titulo=titulo;
        this.autor=autor;
        this.status=StatusLivro.DISPONIVEL;
    }

    public String getTitulo() {return titulo; }
    public void setTitulo(String titulo) {this.titulo = titulo; }

    public String getAutor() {return autor; }
    public void setAutor(String autor) {this.autor = autor; }

    public StatusLivro getStatus() {return status; }
    public void setStatus(StatusLivro status) {this.status = status; }

    public void exibirInfoLivro(){
        System.out.println("Titulo: "+this.getTitulo());
        System.out.println("Autor: "+this.getAutor());
        System.out.println("Status: "+this.getStatus());
    }
}
