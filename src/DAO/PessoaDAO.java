package DAO;

import database.ConexaoHSQLDB;
import model.Pessoa;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PessoaDAO extends ConexaoHSQLDB {

    final String Insert_SQL = "INSERT INTO PESSOA (NOME, RG, CPF, DATAN," +
            " CONTATO, ENDERECO, CEP) VALUES ( ?,?,?,?,?,?,?);";


    final String SQL_SELECT = " SELECT * FROM PESSOA ORDER BY id ASC ";

    final String SQL_SELECT_PESSOA_ID = " SELECT * FROM PESSOA WHERE ID =? ";


    final String SQL_ALTERA_PESSOA = " UPDATE PESSOA SET NOME = ?, RG =?, CPF =?, DATAN =?, " +
            "CONTATO=?,ENDERECO =?,CEP =? WHERE ID =? ";


    final String SQL_DELETA_PESSOA = "DELETE FROM PESSOA WHERE ID = ?";




    public int inserirPessoa(Pessoa pessoa){
      int quantidade =0;
      try (Connection connection = this.connectar();
           PreparedStatement pst = connection.prepareStatement(Insert_SQL);){

          pst.setString(1, pessoa.getNome());
          pst.setInt(2, pessoa.getRg());
          pst.setInt(3, pessoa.getCpf());
          pst.setString(4, pessoa.getDataNascimento());
          pst.setString(5, pessoa.getContato());
          pst.setString(6, pessoa.getEndereco());
          pst.setInt(7, pessoa.getCep());
          quantidade = pst.executeUpdate();


      }catch (SQLException e){
          e.printStackTrace();
      } return quantidade;
    }

    public Pessoa findbyId(int id)  {
        Pessoa p = null;
        try(Connection connection = this.connectar();
            PreparedStatement pst = connection.prepareStatement(SQL_SELECT_PESSOA_ID);){

            pst.setInt(1, id);
            ResultSet rs = pst.executeQuery();

            while(rs.next()){
                p = new Pessoa();
                p.setId(rs.getInt("ID"));
                p.setNome(rs.getString("NOME"));
                p.setRg(rs.getInt("RG"));
                p.setCpf(rs.getInt("CPF"));
                p.setDataNascimento(rs.getString("DATAN"));
                p.setContato(rs.getString("CONTATO"));
                p.setEndereco(rs.getString("ENDERECO"));
                p.setCep(rs.getInt("CEP"));
            }
        }catch(SQLException e){
            e.printStackTrace();
        }

        return  p;
    }

    public  List<Pessoa> listAll() {
        ArrayList<Pessoa> listarpessoa = new ArrayList<>();
        try (Connection connection = connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_SELECT);) {
            ResultSet rs = pst.executeQuery();
            while (rs.next()) {
                Pessoa p = new Pessoa();
                p.setId(rs.getInt("ID"));
                p.setNome(rs.getString("NOME"));
                p.setRg(rs.getInt("RG"));
                p.setCpf(rs.getInt("CPF"));
                p.setDataNascimento(rs.getString("DATAN"));
                p.setContato(rs.getString("CONTATO"));
                p.setEndereco(rs.getString("ENDERECO"));
                p.setCep(rs.getInt("CEP"));

                listarpessoa.add(p);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return listarpessoa;
    }

    public int Alterar(Pessoa pessoa){

        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_ALTERA_PESSOA);) {

            pst.setString(1, pessoa.getNome());
            pst.setInt(2, pessoa.getRg());
            pst.setInt(3, pessoa.getCpf());
            pst.setString(4, pessoa.getDataNascimento());
            pst.setString(5, pessoa.getContato());
            pst.setString(6, pessoa.getEndereco());
            pst.setInt(7,pessoa.getCep());
            pst.setInt(8, pessoa.getId());
            quantidade = pst.executeUpdate();

            //final String SQL_ALTERA_PESSOA = " UPDATE PESSOA SET NOME = ?, RG =?, CPF =?, DATAN =?, " +
             //       "CONTATO=?,ENDERECO =?,CEP =? WHERE ID =? ";

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return quantidade;
    }

    public int Deletar(int id){
        int quantidade = 0;
        try (Connection connection = this.connectar();
             PreparedStatement pst = connection.prepareStatement(SQL_DELETA_PESSOA);) {
            pst.setInt(1, id);
            quantidade = pst.executeUpdate();
        } catch (Exception e) {
            System.out.println(e);
        }
        return quantidade;
    }


}
