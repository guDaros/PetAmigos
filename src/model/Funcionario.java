package model;

public class Funcionario {

    private int id;
    private String nome;
    private String senha;

    public Funcionario(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nomes) {
        nome = nomes;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senhas) {
        senha = senhas;
    }

    public Funcionario(int id, String nomes, String senhas) {
        this.id = id;
        nome = nomes;
        senha = senhas;
    }


    public Funcionario() {
        super();
    }

    public Funcionario(String nomes, String senhas) {
        super();

        nome = nomes;
        senha = senhas;
    }
    @Override
    public String toString() {
        return "Funcionario{" +
                "id=" + id +
                ", Usuario'" + nome + '\'' +
                '}';
    }
}
