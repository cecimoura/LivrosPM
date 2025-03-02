package livros;

public abstract class Usuario {

    private String nome;
    private String RA;

    //construtor padrão
    public Usuario() {}

    //construtor parametrizado
    public Usuario(String nome, String RA) {
        this.nome = nome;
        this.RA = RA;
    }

    public String getNome() {return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getRA() {return RA; }
    public void setRA(String RA) { this.RA = RA; }

    //metodo abstrato que será implementado nas subclasses
    public abstract void exibirInfoUsuario();

}
