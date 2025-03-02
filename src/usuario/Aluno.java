package usuario;

public class Aluno extends Usuario {
    private String curso;

    public Aluno() {
        super(); //chamando o contrutor da classe pai
    }

    public Aluno(String nome, String RA, String curso) {
        super(nome, RA);
        this.curso = curso;
    }

    public String getCurso(){return curso;}
    public void setCurso(String curso){this.curso = curso;}

    @Override
    public void exibirInfoUsuario() {
        System.out.println("Aluno: " + this.getNome());
        System.out.println("Curso: " + this.getCurso());
        System.out.println("RA: " + this.getRA());
    }




}
