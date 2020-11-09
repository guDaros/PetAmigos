package controller.telaInicial;

import DAO.FuncionarioDAO;
import DAO.LoginDAO;
import Main.Main;
import database.ConexaoHSQLDB;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import model.Funcionario;
import sun.rmi.runtime.Log;

import javax.xml.soap.Text;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ControllerLogin extends ConexaoHSQLDB {

    @FXML
    private TextField textFieldLogin;

    @FXML
    private PasswordField textFieldSenha;


    @FXML
    void btnEntrar(ActionEvent event) {

        String nome = textFieldLogin.getText();
        String senha = textFieldSenha.getText();


        LoginDAO login = new LoginDAO();
        boolean result = login.inserirLogin(nome, senha);

        if (result){
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Tela de Login");
            alert.setHeaderText("Logado Com Sucesso");
            alert.show();

            Main.changeScreen("Menu");


        }else{
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("ERROR");
            alert.setHeaderText("Usuario ou Senha Incorreta");
            alert.show();
        }




    }




    @FXML
    void btnEsqueci(ActionEvent event) {
        System.exit(0);
    }


}
