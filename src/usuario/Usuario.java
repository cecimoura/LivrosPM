//esta é uma superclasse, classe base para representar qualquer usuario do sistema
package usuario;

public abstract class Usuario {

    private String nome;
    private String CPF;

    //construtor padrão
    public Usuario() {}

    //construtor parametrizado para inicializar o usuario com nome e cpf
    public Usuario(String nome, String CPF) {
        this.nome = nome;
        this.CPF = CPF;
    }

    //metodos getters para acessar os dados privados
    public String getNome() {return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCPF() {return CPF; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    //metodo abstrato que será implementado nas subclasses
    public abstract void exibirInfoUsuario();

}
