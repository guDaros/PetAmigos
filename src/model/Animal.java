package model;

public class Animal {

    private int id;
    private String Nome;
    private int Idade;
    private String Raca;
    private String NomeDono;



    public Animal(int id, String nome, int idade,String raca, String nomeDono) {
        this.id = id;
        Nome = nome;
        this.Idade = idade;
        this.Raca = raca;
        this.NomeDono = nomeDono;
    }

    public Animal() {
        super();
    }

    public Animal( String nome, int idade,String raca, String nomeDono) {
        super();
        this.Nome = nome;
        this.Idade = idade;
        this.Raca = raca;
        this.NomeDono = nomeDono;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public int getIdade() {
        return Idade;
    }

    public void setIdade(int idade) {
        this.Idade = idade;
    }

    public String getRaca() {
        return Raca;
    }

    public void setRaca(String raca) {
        Raca = raca;
    }

    public String getNomeDono() {
        return NomeDono;
    }

    public void setNomeDono(String nomeDono) {
        NomeDono = nomeDono;
    }
    @Override
    public String toString() {
        return "Animal{" +
                "id=" + id +
                ", Nome='" + Nome + '\'' +
                ", Idade=" + Idade +
                ", Raça="+ Raca +
                '}';
    }
}
