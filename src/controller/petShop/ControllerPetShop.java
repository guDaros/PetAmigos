package controller.petShop;

import DAO.PessoaDAO;
import DAO.PetShopDAO;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import model.Pessoa;
import model.PetShop;

import java.net.URL;
import java.util.ResourceBundle;

public class ControllerPetShop {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextFieldProduto;

    @FXML
    private TextField TextFieldqtd;

    @FXML
    private TextField TextFieldID;

    @FXML
    private TextField TextFieldValor;


    @FXML
    void btnEditar(ActionEvent event){
        PetShop p = pegaProduto();

        int qtde = new PetShopDAO().Alterar(p);

    }
    @FXML
    void btnID(ActionEvent event) {
        String idString = TextFieldID.getText();
        PetShop p = null;
        if (!idString.equals("")) {
            try {
                int id = Integer.parseInt(idString);
                p = new PetShopDAO().findbyId(id);
            } catch (Exception e) {

            }

            if (p != null) {
                TextFieldID.setText(p.getId() + "");
                TextFieldProduto.setText(p.getNomeProduto());
                TextFieldqtd.setText(p.getQtd()+"");
                TextFieldValor.setText(p.getValor()+"");


            }

        }


    }
    @FXML
    void btnCriar(ActionEvent event){
        PetShop petShop = pegaProduto();
        limpaCampos();
        int qtd = new PetShopDAO().inserirPetShop(petShop);
        limpaCampos();
    }
    private void limpaCampos(){

        TextFieldProduto.clear();
        TextFieldqtd.clear();
        TextFieldValor.clear();
    }
   

    private PetShop pegaProduto(){
        return new PetShop(TextFieldProduto.getText(),
                Integer.parseInt(TextFieldqtd.getText()),
                Float.parseFloat(TextFieldValor.getText()));
    }
    @FXML
    protected void btnVoltar(ActionEvent e){
        Main.changeScreen("Produto");
    }
    @FXML
    protected  void btnSair(ActionEvent e){
        System.exit(0);
    }
}
