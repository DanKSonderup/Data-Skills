package gui;


import eu.mihosoft.monacofx.MonacoFX;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import org.junit.Test;
import org.junit.internal.TextListener;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;

public class CodingChallengePane extends Application {
    private MonacoFX monacoFX = new MonacoFX();

    @Override
    public void start(Stage stage) {

        // StackPane root = new StackPane(monacoFX);

        String code = """
                public class A {
                  public int power(int n, int p) {
                        return 20;
                    }
                }
                """;
        // set initial text
        monacoFX.getEditor().getDocument().setText(code);

        // use a predefined language like 'c'
        monacoFX.getEditor().setCurrentLanguage("java");
        monacoFX.getEditor().setCurrentTheme("vs-dark");
        monacoFX.setMaxHeight(800);
        monacoFX.setMaxWidth(1200);
        stage.setTitle("DataSkills");

        GridPane mainPane = new GridPane();

        // Right Pane content
        ScrollPane rightPane = new ScrollPane();
        GridPane rightPaneContent = new GridPane();
        this.initContentRightPane(rightPaneContent);
        rightPane.setContent(rightPaneContent);

        // Left Pane content
        GridPane leftPane = new GridPane();
        this.initContentLeftPane(leftPane);
        mainPane.add(leftPane,0,0);
        mainPane.add(rightPane,1,0);


        rightPane.setMaxWidth(600);
        leftPane.setMinWidth(600);

        rightPane.setVbarPolicy(ScrollPane.ScrollBarPolicy.ALWAYS);
        rightPane.setHbarPolicy(ScrollPane.ScrollBarPolicy.NEVER);
        Scene scene = new Scene(mainPane, 1000, 800);
        stage.setScene(scene);
        stage.setResizable(true);
        stage.show();
    }

    //-----------------------------------------------------------
    // Data felter til Right pane

    private final Button btnSubmit = new Button("Submit solution");

    private void initContentRightPane(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(20));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        Label lblEmne = new Label("Rekursions opgave 2");
        lblEmne.setAlignment(Pos.CENTER);
        lblEmne.setFont(new Font("Sans-Serif", 28));
        lblEmne.setTextFill(Color.BLACK);
        pane.add(lblEmne,0,0);
        Label lblOpgaveBeskrivelse = new Label("Write a recursive method public int power(int n, int p)\nthat calculates np, " +
                "p>=0.\n" +
                "The recursive definition is\n" +
                "n0 = 1\n" +
                "np = np-1*n, p>0\n");
        lblOpgaveBeskrivelse.setFont(new Font("Sans-Serif", 16));
        pane.add(lblOpgaveBeskrivelse,0,2);
    }

    //-----------------------------------------------------------
    // DATA FELTER TIL LEFT PANE
    private final TextArea codeErrors = new TextArea();

    private void initContentLeftPane(GridPane pane) {
        // show or hide grid lines
        pane.setGridLinesVisible(false);
        // set padding of the pane
        pane.setPadding(new Insets(10));
        // set horizontal gap between components
        pane.setHgap(10);
        // set vertical gap between components
        pane.setVgap(10);

        codeErrors.setEditable(false);

        HBox codingbox = new HBox();
        codingbox.getChildren().add(monacoFX);
        pane.add(codingbox,0,0);
        pane.add(btnSubmit,0,2);
        pane.add(codeErrors,0,1);

        btnSubmit.setOnAction(event -> onSubmitAction());
    }


    public void onSubmitAction() {
        MethodTester mt = new MethodTester(monacoFX.getEditor().getDocument().getText(), "A", "power");
        codeErrors.setText(mt.runMethodAndReturnResult());
    }

    public static void resultReport(Result result) {
        System.out.println("Finished. Result: Failures: " +
                result.getFailureCount() + ". Ignored: " +
                result.getIgnoreCount() + ". Tests run: " +
                result.getRunCount() + ". Time: " +
                result.getRunTime() + "ms.");
    }
}

