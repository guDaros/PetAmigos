package DAO;

import database.ConexaoHSQLDB;
import model.Animal;
import model.Pessoa;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AnimalDAO extends ConexaoHSQLDB {

    final String Insert_SQL = "INSERT INTO ANIMAL (NOMEDOG, IDADE, RACA, NOMEDONO) VALUES ( ?,?,?,?);";
    final String SQL_ALTERA_ANIMAL = "UPDATE ANIMAL SET NOMEDOG = ?, IDADE =?, RACA =?, NOMEDONO =?, \" +\n" +
            "            \"NOMEDONO=? WHERE ID =? ";

    public int inserirAnimal(Animal animal) {

        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(Insert_SQL);) {
            pst.setString(1, animal.getNome());
            pst.setInt(2,animal.getId());
            pst.setString(3,animal.getRaca());
            pst.setString(4,animal.getNomeDono());
            quantidade = pst.executeUpdate();


        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return quantidade;
    }

    public int Alterar(Animal animal){

        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_ANIMAL);) {

            pst.setString(1, (animal.getNome()));
            pst.setInt(1, (animal.getIdade()));
            pst.setString(1, (animal.getRaca()));
            pst.setInt(1, (animal.getId()));
            quantidade = pst.executeUpdate();

            //final String SQL_ALTERA_PESSOA = " UPDATE PESSOA SET NOME = ?, RG =?, CPF =?, DATAN =?, " +
            //       "CONTATO=?,ENDERECO =?,CEP =? WHERE ID =? ";

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantidade;
    }


}
