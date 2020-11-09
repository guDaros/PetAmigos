package Main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.util.ArrayList;

public class Main extends Application {

    private static Stage stage;
    private static Scene menuScene;
    private static Scene pessoaScene;
    private static Scene petShopScene;
    private static Scene animalScene;
    private static Scene loginScene;
    private static Scene listaClientesScene;
    private static Scene ServicoScene;
    private static Scene listaFuncionariotoScene;
    private static Scene FuncionarioScene;
    private static Scene VendaScene;



    @Override
    public void start(Stage primaryStage) throws Exception {

        stage = primaryStage;

        primaryStage.setTitle("Trabalho PP");

        //puxa o fxml da main
        Parent fxmlmain = FXMLLoader.load(getClass().getResource("/view/telaInicial/Main.fxml"));
       //puxa o objeto da main(para aparecer a janela)
        menuScene = new Scene(fxmlmain);

        Parent fxmlPessoa = FXMLLoader.load(getClass().getResource("/view/clientes/CadastroPessoa.fxml"));
        pessoaScene = new Scene(fxmlPessoa);

        Parent fxmlPetShop = FXMLLoader.load(getClass().getResource("/view/petShop/PetShop.fxml"));
        petShopScene = new Scene(fxmlPetShop);

        Parent fxmlAnimal = FXMLLoader.load(getClass().getResource("/view/clientes/Animal.fxml"));
        animalScene = new Scene(fxmlAnimal);

        Parent fxmlLogin = FXMLLoader.load(getClass().getResource("/view/telaInicial/Login.fxml"));
        loginScene = new Scene(fxmlLogin);

        Parent fxmlListClientes = FXMLLoader.load(getClass().getResource("/view/clientes/ListaClientes.fxml"));
        listaClientesScene = new Scene(fxmlListClientes);

        Parent fxmlServico= FXMLLoader.load(getClass().getResource("/view/petShop/Servico.fxml"));
        ServicoScene = new Scene(fxmlServico);

        Parent fxmlListFuncionario= FXMLLoader.load(getClass().getResource("/view/funcionario/ListarFuncionario.fxml"));
        listaFuncionariotoScene = new Scene(fxmlListFuncionario);

        Parent fxmlFuncionario= FXMLLoader.load(getClass().getResource("/view/funcionario/Funcionario.fxml"));
        FuncionarioScene = new Scene(fxmlFuncionario);

        Parent fxmlVenda = FXMLLoader.load(getClass().getResource("/view/petShop/Venda.fxml"));
        VendaScene = new Scene(fxmlVenda);


        primaryStage.setScene(loginScene);
        primaryStage.show();
    }


    public static void changeScreen(String scr, Object userData){

        switch (scr){
            case "Menu":
                stage.setScene(menuScene);
                notifyAllListeners("Menu", userData );
                break;
            case "Pessoa":
                stage.setScene(pessoaScene);
                notifyAllListeners("Pessoa", userData );
                break;
            case "PetShop":
                stage.setScene(petShopScene);
                notifyAllListeners("PetShop", userData );
                break;
            case "Animal":
                stage.setScene(animalScene);
                notifyAllListeners("Animal", userData );
                break;
            case "Login":
                stage.setScene(loginScene);
                notifyAllListeners("Login", userData );
                break;
            case "Lista":
                stage.setScene(listaClientesScene);
                notifyAllListeners("Lista", userData );
                break;
                case "Servico":
                stage.setScene(ServicoScene);
                notifyAllListeners("Servico", userData );
                break;
            case "ListF":
                stage.setScene(listaFuncionariotoScene);
                notifyAllListeners("ListF", userData );
                break;
            case "Funcionario":
                stage.setScene(FuncionarioScene);
                notifyAllListeners("Funcionario", userData );
                break;
            case "Venda":
                stage.setScene(VendaScene);
                notifyAllListeners("Venda", userData );
                break;

        }
    }
    public static void changeScreen(String scr){
        switch (scr){
            case "Menu":
                stage.setScene(menuScene);
                notifyAllListeners("Menu", null );
                break;
            case "Pessoa":
                stage.setScene(pessoaScene);
                notifyAllListeners("Pessoa", null );
                break;
            case "PetShop":
                stage.setScene(petShopScene);
                notifyAllListeners("PetShop", null);
                break;
            case "Animal":
                stage.setScene(animalScene);
                notifyAllListeners("Animal", null );
                break;
            case "Login":
                stage.setScene(loginScene);
                notifyAllListeners("Login", null );
                break;
            case "Lista":
                stage.setScene(listaClientesScene);
                notifyAllListeners("Lista", null );
                break;
            case "Servico":
                stage.setScene(ServicoScene);
                notifyAllListeners("Servico", null );
                break;
            case "ListF":
                stage.setScene(listaFuncionariotoScene);
                notifyAllListeners("ListF", null );
                break;
            case "Funcionario":
                stage.setScene(FuncionarioScene);
                notifyAllListeners("Funcionario", null );
                break;
            case "Venda":
                stage.setScene(VendaScene);
                notifyAllListeners("Venda", null );
                break;
        }

    }

    public static void main(String[] args) {
        launch(args);
    }

    private static ArrayList<OnChangeScreen> listeners = new ArrayList<>();

    public  static interface OnChangeScreen{
      void  onScreenChanged(String newScreen, Object userData);
    }

    public static void addOnChangeScreenListener(OnChangeScreen newListener){
        listeners.add(newListener);
    }
    private static  void notifyAllListeners(String newScreen, Object userData){
        for(OnChangeScreen l : listeners){
            l.onScreenChanged(newScreen, userData);
        }
    }
}
