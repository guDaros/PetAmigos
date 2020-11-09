package DAO;

import database.ConexaoHSQLDB;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ServicoDAO extends ConexaoHSQLDB {

    final String Insert_SQL = "INSERT INTO SERVICO (NOMECLIENTE, ANIMAL, DESCRICAO, VALOR) " +
            "VALUES (?, ?, ?, ?);";



    public int inserirVenda(String  cliente,String animal,String descricao,float valor){
        int quantidade =0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(Insert_SQL);){

            pst.setString(1, cliente);
            pst.setString(2, animal);
            pst.setString(2, descricao);
            pst.setFloat(3, valor);


            quantidade = pst.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        } return quantidade;
    }
}
