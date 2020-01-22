package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Shape;
import javafx.stage.Stage;

import java.util.ArrayList;


public class Main extends Application {
    Artist artist;

    @Override
    public void start(Stage primaryStage) throws Exception{
        artist = new Artist();
        drawGui(primaryStage);
    }

    public void drawGui(Stage primaryStage){
        Pane rootPane = new Pane();
        rootPane.setPrefSize(800, 600);

        GridPane gridPane = new GridPane();
        gridPane.setLayoutX(30);
        gridPane.setLayoutY(30);
        gridPane.setPrefSize(200, 250);
        drawColorPicker(gridPane);

        Pane drawingPane = new Pane();

        VBox vBox = new VBox();
        vBox.setLayoutX(40);
        vBox.setLayoutY(300);
        drawShapeButton(vBox, drawingPane);




        rootPane.getChildren().addAll(gridPane,  vBox, drawingPane);

        Scene scene = new Scene(rootPane);
        primaryStage.setTitle("Stamp Maker");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public void drawShapeButton(VBox vBox, Pane rootPane){
        vBox.setSpacing(10);
        /*
        ////// Rectangle button ////////
        Rectangle rect = new Rectangle();
        rect.setHeight(40);
        rect.setWidth(80);
        rect.setFill(Color.LIGHTGRAY);
        Rectangle topRect = new Rectangle();
        topRect.setHeight(30);
        topRect.setWidth(30);
        topRect.setFill(Color.BLUE);
        topRect.setX(65);
        topRect.setY(305);
        rootPane.getChildren().add(topRect);
        rect.setOnMouseClicked((MouseEvent event) -> {
            Rectangle temp = new Rectangle();
            artist.setCurrentShape(temp);
            System.out.print("ajaa");
        });

        /////////// Circle Button /////////////
        Rectangle circle = new Rectangle();
        circle.setHeight(40);
        circle.setWidth(80);
        circle.setFill(Color.LIGHTGRAY);
        Circle topCircle = new Circle();
        topCircle.setFill(Color.BLUE);
        topCircle.setRadius(15);
        topCircle.setCenterX(80);
        topCircle.setCenterY(370);
        rootPane.getChildren().add(topCircle);
        circle.setOnMouseClicked((MouseEvent event) -> {
            Circle temp = new Circle();
            artist.setCurrentShape(temp);
        });

        /////////// Triangle Button //////////////
        Rectangle triangle = new Rectangle();
        triangle.setHeight(40);
        triangle.setWidth(80);
        triangle.setFill(Color.LIGHTGRAY);
        triangle.setOnMouseClicked((MouseEvent event) -> {
            Polygon temp = new Polygon();
            artist.setCurrentShape(temp);
        });
        */
        Button rect = new Button("Square");
        rect.setPrefSize(80,40);
        rect.setOnAction(event -> {
            Rectangle temp = new Rectangle();
            artist.setCurrentShape(temp);
        });


        Button circle = new Button("Circle");
        circle.setPrefSize(80,40);
        circle.setOnAction(event -> {
            Circle temp = new Circle();
            artist.setCurrentShape(temp);
        });

        Button triangle = new Button("Triangle");
        triangle.setPrefSize(80,40);
        triangle.setOnAction(event -> {
            Polygon temp = new Polygon();
            artist.setCurrentShape(temp);
        });

        vBox.getChildren().addAll(rect, circle, triangle);




    }


    // drawing the grid with the colors on it
    public void drawColorPicker(GridPane gridPane){
        ArrayList<Color> colors = new ArrayList<>();
        colors.add(Color.RED); colors.add(Color.BLUE); colors.add(Color.YELLOW); colors.add(Color.GREEN);
        colors.add(Color.ORANGE); colors.add(Color.BLACK); colors.add(Color.PINK); colors.add(Color.PURPLE);

        for(int i = 0; i < 8; i ++){
            if (i % 2 == 0){
                gridPane.add(drawColor(colors.get(i)), 0, i / 2);
                artist.setCurrentColor(colors.get(i));
            }
            else{
                gridPane.add(drawColor(colors.get(i)), 1, i / 2);
                artist.setCurrentColor(colors.get(i));
            }

        }
    }

    public Rectangle drawColor(Color color){
        Rectangle rect = new Rectangle();
        rect.setFill(color);
        rect.setHeight(50);
        rect.setWidth(50);
        rect.setOnMouseClicked((MouseEvent event) -> {

        });
        return rect;
    }

    public static void main(String[] args) {
        launch(args);
    }
}
