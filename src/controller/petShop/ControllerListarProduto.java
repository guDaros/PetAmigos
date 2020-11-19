package controller;

import DAO.PessoaDAO;
import DAO.PetShopDAO;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Pessoa;
import model.PetShop;

import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerListarProduto implements Initializable {
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea TextAreaList;

    @FXML
    private TextField TextFieldID;





    @FXML
    void btnExcluir(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Excluir cadastro deste Produto?");
        alert.setHeaderText("ctz?");
        alert.setContentText("OK???");
        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.get() == ButtonType.OK){
            PetShop petShop = pegaProdutoID();
            int qtde = new PetShopDAO().Deletar(petShop.getId());
            listarProduto();
            TextFieldID.clear();
        }
    }

    private PetShop pegaProdutoID(){
        return new PetShop(Integer.parseInt(TextFieldID.getText()));

    }



    private void listarProduto(){
        TextAreaList.clear();
        List<PetShop> listarProduto = new PetShopDAO().listAll();
        listarProduto.forEach(produto ->{
            TextAreaList.appendText(produto.toString()+ "\n");
        });

    }
    @FXML
    protected void btnCriar(){
        Main.changeScreen("PetShop");
    }



    @FXML
    protected void btnVoltar(){
        Main.changeScreen("Menu");
    }
    @Override


    public void initialize(URL location, ResourceBundle resources) {


        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("Produto")){
                    listarProduto();

                }

            }
        });
    }

}
