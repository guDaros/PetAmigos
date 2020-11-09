package DAO;

import database.ConexaoHSQLDB;
import model.Funcionario;
import model.PetShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class VendaDAO extends ConexaoHSQLDB {

    final String Insert_SQL = "INSERT INTO VENDA (NOMECLIENTE, PRODUTO, VALOR) " +
            "VALUES (?, ?, ?);";



    public int inserirVenda(String cliente, String produto, float valor){
        int quantidade =0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(Insert_SQL);){

            pst.setString(1, cliente);
            pst.setString(2, produto);
            pst.setFloat(3, valor);


            quantidade = pst.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        } return quantidade;
    }


}
