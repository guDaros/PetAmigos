package controller.funcionario;

import DAO.FuncionarioDAO;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import model.Funcionario;


import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

public class ControllerListarFuncionario implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea TextAreaList;

    @FXML
    private TextField TextFieldID;


    @FXML
    void btnExcluir(){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Excluir cadastro deste Produto?");
        alert.setHeaderText("ctz?");
        alert.setContentText("OK???");
        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.get() == ButtonType.OK){
            Funcionario funcionario = pegaProdutoID();
            int qtde = new FuncionarioDAO().Deletar(funcionario.getId());
            listarProduto();
            TextFieldID.clear();
        }
    }

    private Funcionario pegaProdutoID(){
        return new Funcionario(Integer.parseInt(TextFieldID.getText()));

    }

    private void listarProduto(){
        TextAreaList.clear();
        List<Funcionario> listarProduto = new FuncionarioDAO().listAll();
        listarProduto.forEach(funcionario ->{
            TextAreaList.appendText(funcionario.toString()+ "\n");
        });


    }

    @FXML
    void btnVoltar(ActionEvent event){
        Main.changeScreen("Menu");
    }

    @FXML
    void btnCriar(ActionEvent event){
        Main.changeScreen("Funcionario");
    }



    @Override
    public void initialize(URL location, ResourceBundle resources) {
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("ListF")){
                    listarProduto();
                }

            }
        });
    }
}
