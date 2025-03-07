package usuario;

public class Leitor extends Usuario {

    public Leitor(String nome, String CPF) {
        super(nome, CPF); // Chama o construtor da classe pai corretamente
    }

    @Override
    public void exibirInfoUsuario() {
        System.out.println("Leitor(a): " + this.getNome());
        System.out.println("CPF: " + this.getCPF());
    }
}
