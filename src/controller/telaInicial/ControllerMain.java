package controller.telaInicial;



import Main.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;



public class ControllerMain {



    //sair
    @FXML
    protected void btnSair(ActionEvent e){
        System.exit(0);
    }

    //entrar

    @FXML
    protected void btnCClientes(ActionEvent e){
        Main.changeScreen("Lista");
    }

    @FXML
    protected void btnCProduto(ActionEvent e){

    }

    @FXML
    protected  void btnAnimal(ActionEvent e){
        Main.changeScreen("Animal");
    }

    @FXML
    protected  void btnCFuncionario(ActionEvent e){
        Main.changeScreen("ListF");
    }

    @FXML
    protected  void btnCVenda(ActionEvent e){
        Main.changeScreen("Venda");
    }

    @FXML
    protected void btnServico(ActionEvent e){
        Main.changeScreen("Servico");
    }
}

