package model;

import DAO.PessoaDAO;

import java.util.List;

public class Pessoa {

    private int id;
    private String Nome;
    private int Rg;
    private int Cpf;
    private String dataNascimento;
    private String Contato;
    private String Endereco;
    private int Cep;

    public Pessoa(int id,String Nome, int Rg, int Cpf, String dataNascimento, String Contato, String Endereco, int Cep){
        super();
        this.id = id;
        this.Nome = Nome;
        this.Rg = Rg;
        this.Cpf = Cpf;
        this.dataNascimento = dataNascimento;
        this.Contato = Contato;
        this.Endereco = Endereco;
        this.Cep = Cep;
    }
    public Pessoa() {
        super();
    }

    public Pessoa(String Nome, int Rg, int Cpf, String dataNascimento, String Contato, String Endereco, int Cep ){
        super();
        this.Nome = Nome;
        this.Rg = Rg;
        this.Cpf = Cpf;
        this.dataNascimento = dataNascimento;
        this.Contato = Contato;
        this.Endereco = Endereco;
        this.Cep = Cep;
    }

    public Pessoa(int id) {
        this.id = id;
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

    public int getCpf() {
        return Cpf;
    }

    public void setCpf(int cpf) {
        Cpf = cpf;
    }

    public int getRg() {
        return Rg;
    }

    public void setRg(int rg) {
        Rg = rg;
    }

    public String getDataNascimento() {
        return dataNascimento;
    }

    public void setDataNascimento(String dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public String getContato() {
        return Contato;
    }

    public void setContato(String contato) {
        Contato = contato;
    }

    public String getEndereco() {
        return Endereco;
    }

    public void setEndereco(String endereco) {
        Endereco = endereco;
    }

    public int getCep() {
        return Cep;
    }

    public void setCep(int cep) {
        Cep = cep;
    }

    @Override
    public String toString() {
        return "Pessoa{" +
                "id=" + id +
                ", Nome="+Nome+
                ", Rg=" + Rg +
                ", Cpf=" + Cpf +
                ", dataNascimento='" + dataNascimento + '\'' +
                ", Contato='" + Contato + '\'' +
                ", Endereco='" + Endereco + '\'' +
                ", Cep=" + Cep +
                '}';
    }


}
