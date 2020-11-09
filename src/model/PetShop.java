package model;

public class PetShop {

    public int id;
    public String NomeProduto;
    public int Qtd;
    public float Valor;

    public PetShop(int id) {
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNomeProduto() {
        return NomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        NomeProduto = nomeProduto;
    }

    public int getQtd() {
        return Qtd;
    }

    public void setQtd(int qtd) {
        Qtd = qtd;
    }

    public float getValor() {
        return Valor;
    }

    public void setValor(float valor) {
        Valor = valor;
    }

    public PetShop(int id, String nomeProduto, int qtd, float valor) {
        this.id = id;
        NomeProduto = nomeProduto;
        Qtd = qtd;
        Valor = valor;
    }

    public PetShop(){
        super();
    }

    public PetShop(String nomeProduto, int qtd, float valor) {
        super();
        NomeProduto = nomeProduto;
        Qtd = qtd;
        Valor = valor;
    }

    @Override
    public String toString() {
        return "PetShop{" +
                "id=" + id +
                ", NomeProduto='" + NomeProduto + '\'' +
                ", Qtd=" + Qtd +
                ", Valor=" + Valor +
                '}';
    }
}
