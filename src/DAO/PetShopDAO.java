package DAO;

import database.ConexaoHSQLDB;
import model.PetShop;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PetShopDAO extends ConexaoHSQLDB {

    final String Insert_SQL = "INSERT INTO PETSHOP (NOMEP, QTD, VALOR) " +
            "VALUES (?, ?, ?);";

    final String SQL_SELECT_PRODUTO_ID = " SELECT * FROM PETSHOP WHERE ID =? ";

    final String SQL_ALTERA_PRODUTO = " UPDATE PETSHOP SET NOMEP=?, QTD=?,VALOR=? WHERE ID =? ";

    final String SQL_DELETA_PRODUTO = "DELETE FROM PETSHOP WHERE ID = ?";

    final String SQL_SELECT = " SELECT * FROM PETSHOP ORDER BY ID ASC ";

    public int inserirPetShop(PetShop petshop){
        int quantidade =0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(Insert_SQL);){

           pst.setString(1, petshop.getNomeProduto());
           pst.setString(2, petshop.getQtd()+"");
           pst.setString(3, petshop.getValor()+"");


            quantidade = pst.executeUpdate();


        }catch (SQLException e){
            e.printStackTrace();
        } return quantidade;
    }

    public int Alterar(PetShop petShop){

        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_PRODUTO);) {
//final String SQL_ALTERA_PRODUTO = " UPDATE PETSHOP SET NOMEP=?, QTD=?,VALOR=? WHERE ID =? ";
            pst.setString(1, petShop.getNomeProduto());
            pst.setInt(2,petShop.getQtd());
            pst.setFloat(3,petShop.getValor());
            pst.setInt(4,petShop.getId());

            quantidade = pst.executeUpdate();



        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantidade;


    }
    public PetShop findbyId(int id)  {
        PetShop p = null;
        try(Connection connection = this.connectar();
            PreparedStatement pst = connection.prepareStatement(SQL_SELECT_PRODUTO_ID);){

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();
// final String SQL_SELECT_PRODUTO_ID = " SELECT * FROM PETSHOP WHERE ID =? ";
            while(rs.next()){
                p = new PetShop();
                p.setId(rs.getInt("ID"));
                p.setNomeProduto(rs.getString("NOMEP"));
                p.setQtd(rs.getInt("QTD"));
                p.setValor(rs.getFloat("VALOR"));

            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return p;
    }
    public int Deletar(int id){
        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_DELETA_PRODUTO);) {
            pst.setInt(1, id);
            quantidade = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantidade;
    }
    public List<PetShop> listAll() {
        ArrayList<PetShop> listarProduto = new ArrayList<>();
        try (Connection connection = connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_SELECT);) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                PetShop p = new PetShop();
                p.setId(rs.getInt("ID"));
                p.setNomeProduto(rs.getString("NOMEP"));
                p.setQtd(rs.getInt("QTD"));
                p.setValor(rs.getFloat("VALOR"));

                listarProduto.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listarProduto;
    }

}
