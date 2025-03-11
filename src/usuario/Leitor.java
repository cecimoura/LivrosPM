package usuario;

public class Leitor extends Usuario {

    // Construtor da classe 'Leitor', que recebe nome e CPF e passa para o construtor da classe pai 'Usuario'
    public Leitor(String nome, String CPF) {
        super(nome, CPF); // Chama o construtor da classe pai corretamente
    }

    // Sobrescrita do metodo exibirInfoUsuario da classe pai Usuario
    @Override
    public void exibirInfoUsuario() { // Exibe as informações do leitor/usuario
        System.out.println("Leitor(a): " + this.getNome());
        System.out.println("CPF: " + this.getCPF());
    }
}
