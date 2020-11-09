package controller.funcionario;

import DAO.FuncionarioDAO;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Funcionario;

import java.util.ResourceBundle;

public class ControllerFuncionario  {

    @FXML
    private ResourceBundle resources;

    @FXML
    private TextField TextFieldID;

    @FXML
    private TextField TextFieldNome;

    @FXML
    private PasswordField PasswordFieldSenha;


    private void limpaCampos() {

        TextFieldNome.clear();
        PasswordFieldSenha.clear();
        TextFieldID.clear();

    }
    public Funcionario PegaFuncionarioID(){
        return new Funcionario(
                Integer.parseInt(TextFieldID.getText()),
                TextFieldNome.getText(),
                PasswordFieldSenha.getText());
    }

    public Funcionario PegaFuncionario(){
        return new Funcionario(
                TextFieldNome.getText(),
                PasswordFieldSenha.getText());
    }

    @FXML
    void btnCriar(ActionEvent event) {
        Funcionario funcionario = PegaFuncionario();
        limpaCampos();
        int qtd = new FuncionarioDAO().inserirPessoa(funcionario);
        limpaCampos();
    }

    @FXML
    void btnSair(ActionEvent event) {
        System.exit(0);
    }

    @FXML
    void btnVoltar(ActionEvent event) {
        Main.changeScreen("ListF");
    }

    @FXML
    void btnEditar(ActionEvent event) {
        Funcionario f = PegaFuncionarioID();
        limpaCampos();
        int qtde = new FuncionarioDAO().Alterar(f);
    }

    @FXML
    void btnID(ActionEvent event) {
        String idString = TextFieldID.getText();
        Funcionario f = null;
        if (!idString.equals("")) {
            try {
                int id = Integer.parseInt(idString);
                f = new FuncionarioDAO().findbyId(id);
            } catch (Exception e) {

            }
            if (f != null) {
                TextFieldID.setText(f.getId() + "");
                TextFieldNome.setText(f.getNome());
                PasswordFieldSenha.setText(f.getSenha());
            }
        }
    }



}
