package controller.cliente;

import java.net.URL;
import java.util.ResourceBundle;

import DAO.AnimalDAO;
import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import model.Animal;


public class ControllerAnimal {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextFieldRaca;

    @FXML
    private TextField TextFieldNomeA;

    @FXML
    private TextField TextFieldIdade;

    @FXML
    private TextField TextFieldNomeDono;

    @FXML
    private TextField TextFieldID;

    private void limpaCampos() {
        TextFieldNomeA.clear();
        TextFieldIdade.clear();
        TextFieldRaca.clear();
        TextFieldNomeDono.clear();
    }
    private Animal pegaAnimal() {
        return new Animal(TextFieldNomeA.getText(),
                Integer.parseInt(TextFieldIdade.getText()),
                TextFieldRaca.getText(),
                TextFieldNomeDono.getText());
    }
    private Animal pegaAnimalID(){
        return new Animal(Integer.parseInt(TextFieldID.getText()),
                TextFieldNomeA.getText(),
                Integer.parseInt(TextFieldIdade.getText()),
                TextFieldRaca.getText(),
                TextFieldNomeDono.getText());
    }

    @FXML
    void btnCriar(ActionEvent event) {
        Animal aniamal = pegaAnimal();
        limpaCampos();
        int qtde = new AnimalDAO().inserirAnimal(aniamal);

    }

    @FXML
    void brnEditar(ActionEvent event) {
        Animal animal = pegaAnimalID();
        limpaCampos();
        int qtd = new AnimalDAO().Alterar(animal);
    }

    @FXML
    void btnExcluir(ActionEvent event) {

    }

    protected void initialize(){
        Main.addOnChangeScreenListener(new Main.OnChangeScreen() {
            @Override
            public void onScreenChanged(String newScreen, Object userData) {
                System.out.println("Cadastro de Animais"+newScreen+","+userData);
            }
        });
    }
    @FXML
    void btnVoltar(ActionEvent event) {
        Main.changeScreen("Lista");
    }

    @FXML
    void btnSair(ActionEvent event) {
        System.exit(0);
    }



}
