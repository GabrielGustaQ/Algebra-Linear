package settings;

//matriz imports
import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealMatrixFormat;

//javafx imports
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;

//java lang
import java.lang.Integer;




public class ControleMatriz {

    //AQUI INICIAMOS A ORIENTAÇÃO DA INTERFACE;
    @FXML
    private Button CalcularButton;

    @FXML
    private AnchorPane InversaPane;

    @FXML
    private Label errorid;

    @FXML
    private TextField grid_0_0;

    @FXML
    private TextField grid_0_1;

    @FXML
    private TextField grid_0_2;

    @FXML
    private TextField grid_1_0;

    @FXML
    private TextField grid_1_1;

    @FXML
    private TextField grid_1_2;

    @FXML
    private TextField grid_2_0;

    @FXML
    private TextField grid_2_1;

    @FXML
    private TextField grid_2_2;

    @FXML
    private Label LabelInversa;

    @FXML
    void CalcularAction(ActionEvent event) {
        try {

            //AQUI GERAMOS A INTERAÇÃO ENTRE USUARIO E A MATRIZ, INICIANDO CADA "CELULA" DELA;
            int num00 =Integer.parseInt(grid_0_0.getText());
            int num01 =Integer.parseInt(grid_0_1.getText());
            int num02 =Integer.parseInt(grid_0_2.getText());
            int num10 =Integer.parseInt(grid_1_0.getText());
            int num11 =Integer.parseInt(grid_1_1.getText());
            int num12 =Integer.parseInt(grid_1_2.getText());
            int num20 =Integer.parseInt(grid_2_0.getText());
            int num21 =Integer.parseInt(grid_2_1.getText());
            int num22 =Integer.parseInt(grid_2_2.getText());

            //AQUI CRIAMOS O ARRANJO DE DUAS DIMENSÕES UTILIZANDO AS COMPONENTES DECLARADAS ACIMA
            double [][] values = {{num00, num10 ,num20 }, {num01, num11, num21}, {num02,num12 , num22}};
            double [][] identidade = {{1, 0, 0}, {0, 1, 0}, {0, 0, 1}};

            //UTILIZANDO A BIBLIOTECA APACHE, FAZEMOS UM TRATAMENTO PARA O COMPUTADOR INTERPRETAR COMO UMA MATRIZ
            RealMatrix a = new Array2DRowRealMatrix(values);
            DecompositionSolver solver = new LUDecomposition(a).getSolver();
            //AQUI UTILIZAMOS A MATRIZ E A IDENTIDADE PARA GERAR A INVERSA
            RealMatrix i = new Array2DRowRealMatrix(identidade);
            RealMatrix x = solver.solve(i);

            //AQUI FORMATAMOS E MANDAMOS O COMPUTADOR IMPRIMIR
            RealMatrixFormat matrixFormat = new RealMatrixFormat("  ", "  ", "  ", "\n", "", ", ");

            LabelInversa.setText(matrixFormat.format(x));
            
        }
        catch(NumberFormatException e){
            grid_0_0.requestFocus();
            errorid.setText("Escreva todos os numeros e tente novamente");

        }
        
    }

    

}
