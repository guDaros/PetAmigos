package controller.petShop;

import DAO.PetShopDAO;
import DAO.VendaDAO;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.PetShop;

import java.util.ResourceBundle;

public class ControllerVenda {
    @FXML
    private ResourceBundle resources;


    @FXML
    private TextField textFieldValor;

    @FXML
    private TextField textFieldCliente;

    @FXML
    private TextField textFieldProduto;

    protected String cliente, produto;
    protected float valor;

    private void pegaTexto(){
        cliente = textFieldCliente.getText();
        produto = textFieldProduto.getText();
        valor = Float.parseFloat(textFieldValor.getText());
    }

    private void limpaCampos(){
        textFieldCliente.clear();
        textFieldProduto.clear();
        textFieldValor.clear();
    }

    @FXML
    void btnVender(ActionEvent event) {
        pegaTexto();
        limpaCampos();
        int qtd = new VendaDAO().inserirVenda(cliente, produto, valor);
        limpaCampos();
    }

    @FXML
    void btnCliente(ActionEvent event) {
        Main.changeScreen("Lista");
    }

    @FXML
    void btnSair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnVoltar(ActionEvent event) {
        Main.changeScreen("Menu");
    }

}
