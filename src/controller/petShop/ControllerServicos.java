package controller.petShop;


import DAO.ServicoDAO;
import DAO.VendaDAO;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;

import java.util.ResourceBundle;

public class ControllerServicos {

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField textFieldDescricao;

    @FXML
    private TextField textFieldCliente;

    @FXML
    private TextField textFieldValor;

    @FXML
    private TextField textFieldAnimal;

    String cliente, descricao, animal;
    float valor;

    private void pegaTexto(){
        cliente = textFieldCliente.getText();
        descricao = textFieldDescricao.getText();
        animal = textFieldAnimal.getText();
        valor = Float.parseFloat(textFieldValor.getText());
    }

    private void limpaCampos(){
        textFieldCliente.clear();
        textFieldDescricao.clear();
        textFieldAnimal.clear();
        textFieldValor.clear();
    }
    @FXML
    void btnCriar(ActionEvent event) {
        pegaTexto();
        limpaCampos();
        int qtd = new ServicoDAO().inserirVenda(cliente, animal, descricao, valor);
        limpaCampos();
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
