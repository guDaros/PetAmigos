package controller.cliente;


import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import DAO.PessoaDAO;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import model.Pessoa;

public class ControllerClientes implements Initializable {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    @FXML private TextField TextFieldID;

    @FXML
    private TextArea TextAreaList;





    public void listarPessoas()  {
        TextAreaList.clear();
        List<Pessoa> listaPessoa = new PessoaDAO().listAll();
        listaPessoa.forEach(pessoa ->{
            TextAreaList.appendText(pessoa.toString()+ "\n");
        });

    }
    @FXML
    void btnExcluir(ActionEvent event){
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle("Excluir cadastro deste Cliente?");
        alert.setHeaderText("ctz?");
        alert.setContentText("OK???");
        Optional<ButtonType> resultado = alert.showAndWait();
        if (resultado.get() == ButtonType.OK){
            Pessoa pessoa = pegaPessoaID();
            int qtde = new PessoaDAO().Deletar(pessoa.getId());
            listarPessoas();
            TextFieldID.clear();
        }
    }
    private Pessoa pegaPessoaID(){
        return new Pessoa(Integer.parseInt(TextFieldID.getText()));

    }
    @FXML
    protected void btnCriar(){
        Main.changeScreen("Pessoa");
    }
    @FXML
    protected void btnEditar(){
        Main.changeScreen("Pessoa");
    }
    @FXML
    protected void btnExcluir(){
        Main.changeScreen("Pessoa");
    }
    @FXML
    protected void btnVoltar(){
        Main.changeScreen("Menu");
    }

    @FXML
    protected void btnVenda(ActionEvent e){
        Main.changeScreen("Venda");
    }

    @FXML
    void btnAddPet(ActionEvent event){
        Main.changeScreen("Animal");
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                if(newScreen.equals("Lista")){
                    listarPessoas();
                }
            }
        });
    }

}


