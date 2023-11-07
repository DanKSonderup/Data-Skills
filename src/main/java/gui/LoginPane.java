package gui;


import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class LoginPane extends Application {

    @Override
    public void start(Stage stage) {
        stage.setTitle("DataSkills");
        GridPane pane = new GridPane();
        this.initContent(pane);
        pane.setMaxHeight(800);
        pane.setMaxWidth(1000);

        Scene scene = new Scene(pane);
        stage.setScene(scene);
        stage.setResizable(false);
        stage.show();
    }

    //-----------------------------------------------------------
    // Data felter til Gridpane indsættes her

    private final TextField txfBrugernavn = new TextField();
    private final PasswordField pwfKodeOrd = new PasswordField();
    private final Button btnLogin = new Button("Login");
    private final Button btnRegistrer = new Button("Registrer");
    private final Label lblError = new Label();
    private final Label lblVelkommen = new Label("DataSkill");
    private final Label lblSubHeader = new Label("Upgrade your skills");
    private final Label lblBrugernavn = new Label("Brugernavn");
    private final Label lblKodeord = new Label("Kodeord");


    // Vær obs på at dette på ingen måde er en sikker måde at gemme et password på
    // reelt set bør vi kører kodeord igennem en hashing algoritme som f.eks. SHA
    private String correctUsername = "admin";
    private String correctPassword = "admin";

    private void initContent(GridPane pane) {

        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(0,120,0,120));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);
        // Backgrounds styling & Header Label

        // pane.setStyle("-fx-background-color: linear-gradient(to right, #4e54c8, #8f94fb);");
        pane.setStyle("-fx-background-color: #6D98BA");
        VBox vbox1 = new VBox();
        vbox1.setAlignment(Pos.CENTER);
        vbox1.setSpacing(50);
        pane.add(vbox1,0,2);
        lblVelkommen.setFont(new Font("Sans-Serif", 60));
        lblVelkommen.setTextFill(Color.WHITE);
        lblVelkommen.setAlignment(Pos.CENTER);
        lblSubHeader.setFont(new Font("Sans-Serif", 38));
        lblSubHeader.setTextFill(Color.WHITE);
        lblSubHeader.setAlignment(Pos.CENTER);
        vbox1.getChildren().add(lblVelkommen);
        vbox1.getChildren().add(lblSubHeader);

        // Login Form
        Label lblLogin = new Label("Login");
        lblLogin.setTextFill(Color.WHITE);
        lblLogin.setFont(new Font("Sans-Serif", 20));
        vbox1.getChildren().add(lblLogin);

        VBox vbox2 = new VBox();
        pane.add(vbox2,0,5);
        vbox2.setAlignment(Pos.CENTER);
        vbox2.setSpacing(5);


        lblBrugernavn.setTextFill(Color.WHITE);
        vbox2.getChildren().add(lblBrugernavn);
        txfBrugernavn.setMaxWidth(150);
        vbox2.getChildren().add(txfBrugernavn);


        lblKodeord.setTextFill(Color.WHITE);
        vbox2.getChildren().add(lblKodeord);
        pwfKodeOrd.setMaxWidth(150);
        vbox2.getChildren().add(pwfKodeOrd);
        HBox hBoxLogin = new HBox(15);
        hBoxLogin.setAlignment(Pos.CENTER);
        hBoxLogin.getChildren().add(btnLogin);
        hBoxLogin.getChildren().add(btnRegistrer);

        vbox2.getChildren().add(hBoxLogin);
        lblError.setPadding(new Insets(20));
        vbox2.getChildren().add(lblError);

        // SKAL FJERNES --> MIDLERTIDIGT PREFILL AF LOGIN
        txfBrugernavn.setText("admin");
        pwfKodeOrd.setText("admin");


        // Tilføjer actionEvents
        btnLogin.setOnAction(event -> this.loginOnAction());

        // Tilføjer onKeyPressed Event som udfører loginOnAction hvis der trykkes Enter
        pwfKodeOrd.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent ke) {
                if (ke.getCode().equals(KeyCode.ENTER)) {
                    loginOnAction();
                }
            }
        });

    }

    public void loginOnAction() {
        String brugernavnInput = txfBrugernavn.getText().trim();
        String passwordInput = pwfKodeOrd.getText().trim();

        if (brugernavnInput.equals(correctUsername) && passwordInput.equals(correctPassword)) {
            PRO2Pane pro2Pane = new PRO2Pane();
            pro2Pane.start(new Stage());
            Stage stage = (Stage) btnLogin.getScene().getWindow();
            stage.close();
        } else {
            lblError.setText("Forkert brugernavn eller adgangskode!");
            lblError.setTextFill(Color.RED);
        }
    }
}

