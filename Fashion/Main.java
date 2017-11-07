import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import java.io.*;

public class Main extends Application {
    public static void main(String[] args) {

        //data process before gui launch

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        //headers for data files
        String TopsCSVHeader = "Type,Color,Collar,Material,Sleeve,Waist,ID";
        String BottomsCSVHeader = "Type,Color,ID";
        String ShoesCSVHeader = "Type,Color,ID";

        File tops = new File("Tops.csv");
        File bottoms = new File("Bottoms.csv");
        File shoes = new File("Shoes.csv");

        //if no data files exist, it is the first application launch
        if(!tops.exists() && !bottoms.exists() && !shoes.exists()){

            //create data files
            File topsNew = new File("Tops.csv");
            PrintWriter outputFile = new PrintWriter(topsNew);
            outputFile.print(TopsCSVHeader);
            outputFile.close();

            File bottomsNew = new File("Bottoms.csv");
            outputFile = new PrintWriter(bottomsNew);
            outputFile.print(BottomsCSVHeader);
            outputFile.close();

            File shoesNew = new File("Shoes.csv");
            outputFile = new PrintWriter(shoesNew);
            outputFile.print(ShoesCSVHeader);
            outputFile.close();

            //Great user


        }

        //process data from files into objects






        primaryStage.setTitle("Virtual Closet");
        Button btn = new Button();
        btn.setText("Get Outfits!");
        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                //present user with outfits
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }
}
