package gui;

import eu.mihosoft.monacofx.MonacoFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class PRO2Pane extends Application {

    @Override
    public void start(Stage stage) {

        stage.setTitle("PRO2 Challenges");

        ScrollPane scrollPane = new ScrollPane();
        GridPane pane = new GridPane();
        this.initContent(pane);
        scrollPane.setContent(pane);

        Scene scene = new Scene(scrollPane, 800, 600);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //-----------------------------------------------------------
    // Data felter til Gridpane indsættes her

    private final Button[] btnEmner = new Button[3];
    private String[] emnerStrings = {"Rekursion 1", "Rekursion 2", "Del-løs-kombiner"};
    private void initContent(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblEmne = new Label("Vælg et emne");
        lblEmne.setAlignment(Pos.CENTER);
        lblEmne.setFont(new Font("Sans-Serif", 28));
        lblEmne.setTextFill(Color.BLACK);
        pane.add(lblEmne,0,0);
        HBox hBox1 = new HBox(25);

        for (int i = 0; i < btnEmner.length; i++) {
            btnEmner[i] = new Button(emnerStrings[i]);
            hBox1.getChildren().add(btnEmner[i]);
        }
        pane.add(hBox1,0,1);

        btnEmner[0].setOnAction(event -> this.onEmneSelect(0));
    }


    private void onEmneSelect(int index) {
        CodingChallengePane ccp = new CodingChallengePane();
        ccp.start(new Stage());
        Stage stage = (Stage) btnEmner[index].getScene().getWindow();
        stage.close();
    }


}

