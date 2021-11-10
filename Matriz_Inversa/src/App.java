import javafx.application.Application;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class App extends Application {
    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage palco) throws Exception {
        Parent raiz = FXMLLoader.load(getClass().getResource("InversorMatriz.fxml"));
        Scene tela = new Scene(raiz);
        palco.setTitle("Matriz Inversa");
        palco.setScene(tela);
        palco.show();   
    }
}
