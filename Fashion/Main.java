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
        String TopsCSVHeader = "Temperature,Formality,Material,Layer,Thickness,Looseness,Collar,SleeveLength,Texture,Design,Lining,FrontConnection,Colors,ID";
        String BottomsCSVHeader = "Temperature,Formality,Material,Design,Tightness,Length,Texture,Lining,Colors,ID";
        String ShoesCSVHeader = "Temperature,Formality,ShoeType,Colors,SoleColor,Formality,Height,ID";

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

        //create closet
        Closet closet = new Closet();

        //process data from files into closet
        Scanner fileScanner = new Scanner(tops);
        fileScanner.nextLine();
        while(fileScanner.hasNextLine()){
          String[] c = fileScanner.nextLine().split(",");
          Top t = new Top(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8], c[9], c[10], c[11], c[12], c[13]);
          closet.addPiece(t);
        }
        fileScanner.close();

        fileScanner = new Scanner(bottoms);
        fileScanner.nextLine();
        while(fileScanner.hasNextLine()){
          String[] c = fileScanner.nextLine().split(",");
          Bottom b = new Bottom(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8]);
          closet.addPiece(b);
        }
        fileScanner.close();

        fileScanner = new Scanner(shoes);
        fileScanner.nextLine();
        while(fileScanner.hasNextLine()){
          String[] c = fileScanner.nextLine().split(",");
          Shoe s = new Bottom(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7]);
          closet.addPiece(s);
        }
        fileScanner.close();



        primaryStage.setTitle("Virtual Closet");
        Button getOutfits = new Button();
        getOutfits.setText("Get Outfits!");
        getOutfits.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
              // get temp from some API
              int temp = 60;

              // get formality from a field in the gui
              Formality f = new Formality(0,0,0);

              // receive list of outfits
              ArrayList<Outfit> suggested = closet.getOutfits(temp, f);

              //present outfits to user
            }
        });

        StackPane root = new StackPane();
        root.getChildren().add(btn);
        primaryStage.setScene(new Scene(root, 1000, 800));
        primaryStage.show();
    }
}
