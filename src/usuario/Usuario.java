//esta é uma superclasse, classe base para representar qualquer usuario do sistema
package usuario;

public abstract class Usuario {

    private String nome; // Atributo privado que armazena o nome do usuario
    private String CPF; // Atributo privado que armazena o CPF do usuario

    //construtor padrão sem parâmetros, para criar um usuario sem inicializar os atributos
    public Usuario() {}

    //construtor parametrizado para inicializar o usuario com nome e cpf
    public Usuario(String nome, String CPF) {
        this.nome = nome; // Inicializa o atributo nome com o valor passado como parâmetro
        this.CPF = CPF; // Inicializa o atributo CPF com o valor passado como parâmetro
    }

    //metodos getters para acessar os dados privados
    public String getNome() {return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getCPF() {return CPF; }
    public void setCPF(String CPF) { this.CPF = CPF; }

    //metodo abstrato que será implementado nas subclasses
    public abstract void exibirInfoUsuario();

}
