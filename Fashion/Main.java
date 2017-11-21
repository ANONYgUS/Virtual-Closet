import javafx.application.Application;
import javafx.event.*;
import javafx.stage.*;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import javafx.util.StringConverter;
import javafx.geometry.Insets;
import java.net.URL;


import java.io.*;
import java.util.*;

public class Main extends Application {
    public static void main(String[] args) {

        //data process before gui launch

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        StackPane root = new StackPane();
        VBox layoutMain = new VBox(20);
        Scene sceneMain = new Scene(layoutMain, 1000, 800);

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

        //if no location file exists, it is the first application launch
        File location = new File("Location.txt");
        if(!location.exists()){
            //Great user and ask for City for weather
            Label greeting= new Label("Welcome to the Fashion App! For recommendations based on weather conditions, please enter the city in which you live.");
            TextField cityField = new TextField("Boston");
            Button submitCity = new Button();
            submitCity.setText("Submit City");
            submitCity.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  //write data from text field to data file
                  String city = cityField.getCharacters().toString();
                  try{
                  PrintWriter outputFile = new PrintWriter(location);
                  outputFile.print(city);
                  outputFile.close();
                }
                catch(IOException e){
                    System.out.println("IOException while writing location to data file");
                }
                primaryStage.setScene(sceneMain);
                }
            });
            VBox layout1 = new VBox(20);
            layout1.getChildren().addAll(greeting, cityField, submitCity);
            Scene scene1 = new Scene(layout1, 1000, 800);
            primaryStage.setScene(scene1);
            primaryStage.show();
        }
        else{
            primaryStage.setScene(sceneMain);
            primaryStage.show();
        }


        //create closet
        //Closet closet = new Closet();

        //process data from files into closet
        Scanner fileScanner = new Scanner(tops);
        fileScanner.nextLine();
        while(fileScanner.hasNextLine()){
          String[] c = fileScanner.nextLine().split(",");
          //Top t = new Top(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8], c[9], c[10], c[11], c[12], c[13]);
          //closet.addPiece(t);
        }
        fileScanner.close();

        fileScanner = new Scanner(bottoms);
        fileScanner.nextLine();
        while(fileScanner.hasNextLine()){
          String[] c = fileScanner.nextLine().split(",");
          //Bottom b = new Bottom(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7], c[8]);
          //closet.addPiece(b);
        }
        fileScanner.close();

        fileScanner = new Scanner(shoes);
        fileScanner.nextLine();
        while(fileScanner.hasNextLine()){
          String[] c = fileScanner.nextLine().split(",");
          //Shoe s = new Bottom(c[0], c[1], c[2], c[3], c[4], c[5], c[6], c[7]);
          //closet.addPiece(s);
        }
        fileScanner.close();



        primaryStage.setTitle("Virtual Closet");

        //getOutfits Button
        Button getOutfits = new Button();
        getOutfits.setText("Get Outfits!");
        getOutfits.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
              // get City from file

              int tempFahrenheit = 60;
              File location = new File("Location.txt");

              //if file exists, proceed
              if(location.exists()){
                 try{
                     Scanner s = new Scanner(location);
                     String city = s.nextLine().toLowerCase();
                     s.close();
                     String weather = "weather";
                     String forecast = "forecast";
                     String infoType = weather;

                     //get temp from api
                     String url = "http://api.openweathermap.org/data/2.5/" + infoType + "?q=" + city + "&APPID=1421208f8ef53599f787a2a8c5f83580";
                     URL obj = new URL(url);
                     HttpURLConnection con = (HttpURLConnection) obj.openConnection();
                     con.setRequestMethod("GET");
                     con.setRequestProperty("User-Agent", "Chrome");
                     int responseCode = con.getResponseCode();
                     BufferedReader in = new BufferedReader(
                     new InputStreamReader(con.getInputStream()));
                     String inputLine;
                     StringBuffer response = new StringBuffer();
                     while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                     }
                     in.close();
                     String r = response.toString();

                     //parse for data and convert to fahrenheit
                     double tempKelvin = Double.parseDouble(r.substring(r.indexOf("temp\":")+6, r.indexOf("temp\":")+12));
                     System.out.println("tempKelvin"+tempKelvin);
                     double tempF = (9.0/5.0)*(tempKelvin) - 459.67;
                     tempFahrenheit = (int)(tempF);
                     System.out.println(tempFahrenheit);
                }
                catch(IOException e){};
                }
              //otherwise ask for city or temp from user here
              else{


              }



              // get formality from a field in the gui
              //Formality f = new Formality(0,0,0);

              // receive list of outfits
              //ArrayList<Outfit> suggested = closet.getOutfits(tempFahrenheit, f);

              //present outfits to user
            }
        });

        //addShoe Button
        Button addShoe = new Button();
        addShoe.setText("Add Shoe");
        addShoe.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
            Stage addShoeStage = new Stage();
            //fields for shoe details

            addShoeStage.show();
            //Color soleColor = new Color(ColorName.);
            //get Shoe details from fields


          }
        });
        //addBottom Button
        Button addBottom = new Button();
        addBottom.setText("Add Bottom");
        addBottom.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
            Stage addBottomStage = new Stage();
            //fields for shoe details

            addBottomStage.show();
            //Color soleColor = new Color(ColorName.);
            //get Shoe details from fields


          }
        });
        //addTop Button
        Button addTop = new Button();
        addTop.setText("Add Top");
        addTop.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {
            Stage addTopStage = new Stage();
            //fields for shoe details

            addTopStage.show();
            //Color soleColor = new Color(ColorName.);
            //get Shoe details from fields


          }
        });


        //formality slider
        Slider slider = new Slider(0, 4, 0);
        slider.setMin(0);
        slider.setMax(4);
        slider.setValue(1);
        slider.setMinorTickCount(0);
        slider.setMajorTickUnit(1);
        slider.setSnapToTicks(true);
        slider.setShowTickMarks(true);
        slider.setShowTickLabels(true);
        slider.setLabelFormatter(new StringConverter<Double>() {
            @Override
            public String toString(Double n) {
                if (n < 0.5) return "Casual";
                if (n < 1.5) return "Business Casual";
                if (n < 2.5) return "Business Formal";
                if (n < 3.5) return "Semi-Formal";
                return "Formal";
            }

            @Override
            public Double fromString(String s) {
                switch (s) {
                    case "Casual":
                        return 0d;
                    case "Business Casual":
                        return 1d;
                    case "Business Formal":
                        return 2d;
                    case "Semi-Formal":
                        return 3d;
                    case "Formal":
                        return 4d;


                    default:
                        return 1d;
                }
            }
        });

        slider.setMinWidth(280);

        //addShoe.setTranslateY(50);
        //addBottom.setTranslateY(50);
        //addBottom.setTranslateX(120);
        //addTop.setTranslateY(50);
        //addTop.setTranslateX(-120);
        layoutMain.getChildren().addAll(slider, getOutfits, addShoe, addBottom, addTop);
        layoutMain.setPadding(new Insets(30));
    }
}
