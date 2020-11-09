package DAO;

import database.ConexaoHSQLDB;
import model.Funcionario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FuncionarioDAO extends ConexaoHSQLDB {

    final String Insert_SQL = "INSERT INTO FUNCIONARIO (NOME, SENHA) VALUES ( ?,? );";

    final String SQL_SELECT_LOGIN = " SELECT NOME, SENHA FROM FUNCIONARIO WHERE NOME = ?, SENHA =?;";

    final String SQL_SELECT = " SELECT * FROM FUNCIONARIO ORDER BY id ASC ;";

    final String SQL_SELECT_FUNCIONARIO_ID = " SELECT * FROM FUNCIONARIO WHERE ID =? ;";


    final String SQL_ALTERA_FUNCIONARIO = " UPDATE FUNCIONARIO SET NOME = ?, SENHA=? WHERE ID =? ";


    final String SQL_DELETA_FUNCIONARIO = "DELETE FROM FUNCIONARIO WHERE ID = ?";

    public int inserirPessoa(Funcionario funcionario) {
        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(Insert_SQL);) {

            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getSenha());
            quantidade = pst.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return quantidade;
    }

    public Funcionario findbyId(int id) {
        Funcionario f = null;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_SELECT_FUNCIONARIO_ID);) {

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while (rs.next()) {
                f = new Funcionario();
                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("NOME"));
                f.setSenha(rs.getString("SENHA"));

            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return f;
    }

    public List<Funcionario> listAll() {
        ArrayList<Funcionario> listarFuncionario = new ArrayList<>();
        try (Connection connection = connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_SELECT);) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Funcionario f = new Funcionario();
                f.setId(rs.getInt("ID"));
                f.setNome(rs.getString("NOME"));
                f.setSenha(rs.getString("SENHA"));

                listarFuncionario.add(f);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listarFuncionario;
    }

    public int Alterar(Funcionario funcionario) {

        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_FUNCIONARIO);) {

            pst.setString(1, funcionario.getNome());
            pst.setString(2, funcionario.getSenha());
            quantidade = pst.executeUpdate();


        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantidade;
    }

    public int Deletar(int id) {
        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_DELETA_FUNCIONARIO);) {
            pst.setInt(1, id);
            quantidade = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantidade;
    }


}