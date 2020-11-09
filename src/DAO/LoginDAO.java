package DAO;

import Main.Main;
import database.ConexaoHSQLDB;
import model.Funcionario;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;



public class LoginDAO extends ConexaoHSQLDB {

    final String SQL_LOGIN = "SELECT NOME, SENHA FROM FUNCIONARIO WHERE NOME =? AND SENHA =?;";


    public boolean inserirLogin(String nome, String senha) {

        PreparedStatement pst;
        boolean result = false;

        try {
            pst = connectar().prepareStatement(SQL_LOGIN);
            pst.setString(1, nome);
            pst.setString(2, senha);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                result = true;
                return result;
            }

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return result;
    }

}
