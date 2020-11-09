package controller.cliente;

import DAO.PessoaDAO;
import Main.Main;
import javafx.event.ActionEvent;


import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import model.Pessoa;

import java.util.Optional;


public class ControllerPessoa {

    @FXML
    private TextField TextFieldRg;

    @FXML
    private TextField TextFieldCpf;

    @FXML
    private TextField TextFieldDataNascimento;

    @FXML
    private TextField TextFieldEndereco;

    @FXML
    private TextField TextFieldContato;

    @FXML
    private TextField TextFieldNome;

    @FXML
    private TextField TextFieldCep;
    @FXML
    private TextField TextFieldID;

    @FXML
    protected void btnVoltar(ActionEvent e){
        Main.changeScreen("Lista");
    }

    @FXML
    void FindbyID(ActionEvent event) {
        String idString = TextFieldID.getText();
        Pessoa p = null;
        if (!idString.equals("")) {
            try {
                int id = Integer.parseInt(idString);
                p = new PessoaDAO().findbyId(id);
            } catch (Exception e) {

            }

            if (p != null) {
                TextFieldID.setText(p.getId() + "");
                TextFieldNome.setText(p.getNome());
                TextFieldRg.setText(p.getRg()+"");
                TextFieldCpf.setText(p.getCpf()+"");
                TextFieldDataNascimento.setText(p.getDataNascimento());
                TextFieldEndereco.setText(p.getEndereco());
                TextFieldContato.setText(p.getContato());
                TextFieldCep.setText(p.getCep()+"");
            }

        }


    }

    private void limpaCampos() {

        TextFieldNome.clear();
        TextFieldRg.clear();
        TextFieldCpf.clear();
        TextFieldDataNascimento.clear();
        TextFieldContato.clear();
        TextFieldEndereco.clear();
        TextFieldCep.clear();
        TextFieldID.clear();
    }

    public Pessoa pegaPessoaID(){
        return new Pessoa(
                Integer.parseInt(TextFieldID.getText()),
                TextFieldNome.getText(),
                Integer.parseInt(TextFieldRg.getText()),
                Integer.parseInt(TextFieldCpf.getText()),
                TextFieldDataNascimento.getText(),
                TextFieldContato.getText(),
                TextFieldEndereco.getText(),
                Integer.parseInt(TextFieldCep.getText()));
    }

    private Pessoa pegaPessoa(){
        return new Pessoa(TextFieldNome.getText(),
                (Integer.parseInt(TextFieldRg.getText())),
                (Integer.parseInt(TextFieldCpf.getText())),
                TextFieldDataNascimento.getText(),
                TextFieldContato.getText(),
                TextFieldEndereco.getText(),
                (Integer.parseInt(TextFieldCep.getText())));
    }

    @FXML
    void btnEditar(ActionEvent event) {
        Pessoa p = pegaPessoaID();
        limpaCampos();
        int qtde = new PessoaDAO().Alterar(p);

    }
    @FXML
    void inserirPessoas(ActionEvent event){
            Pessoa pessoa = pegaPessoa();
            limpaCampos();
            int qtd = new PessoaDAO().inserirPessoa(pessoa);
    }

    @FXML
    protected void btnSair(ActionEvent e){
        System.exit(0);
    }


}


