package usuario;

public abstract class Usuario {

    private String nome;
    private String CPF;

    //construtor padrão
    public Usuario() {}

    //construtor parametrizado
    public Usuario(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    public String getNome() {return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCPF() {return CPF; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    //metodo abstrato que será implementado nas subclasses
    public abstract void exibirInfoUsuario();

}
