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
import javafx.geometry.*;
import java.net.URL;
import javafx.scene.control.ColorPicker;
import javafx.geometry.Insets;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.scene.text.*;
import javafx.stage.Stage;
import java.io.*;
import java.nio.*;
import java.nio.file.*;
import java.util.*;

public class MainAAA extends Application {
    public static void main(String[] args) {

        //data process before gui launch

        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws IOException {

        StackPane root = new StackPane();
        VBox layoutMain = new VBox(20);
        Scene sceneMain = new Scene(layoutMain, 1000, 800);
        primaryStage.setTitle("Virtual Closet");

        //headers for data files
        String TopsCSVHeader = "Temperature,Formality,Material,Layer,Thickness,Looseness,Collar,SleeveLength,Texture,Design,Lining,FrontConnection,Colors,Name\n";
        String BottomsCSVHeader = "Temperature,Formality,Material,Design,Tightness,Length,Texture,Lining,Colors,Name\n";
        String ShoesCSVHeader = "Temperature,Formality,Colors,Name\n";

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
            layout1.setPadding(new Insets(30));
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

        Slider slider = new Slider(0, 4, 0);
        slider.setMin(0);
        slider.setMax(4);
        slider.setValue(1);
        slider.setMinorTickCount(0);
        slider.setMajorTickUnit(1);
        slider.setSnapToTicks(false);
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
                     BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
                     String inputLine;
                     StringBuffer response = new StringBuffer();
                     while ((inputLine = in.readLine()) != null) {
                        response.append(inputLine);
                     }
                     in.close();
                     String r = response.toString();

                     //parse for data and convert to fahrenheit
                     r = r.substring(r.indexOf("temp\":")+6, r.indexOf("temp\":")+12);
                     if(r.contains(",")){
                        r = r.substring(0, r.length()-1);
                     }
                     double tempKelvin = Double.parseDouble(r);
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


              double s = slider.getValue();

              //convert to 1-10 scale
              s = 10*s/4;
              //get formality from a field in the gui
              Formality f = new Formality(s,s,1); //what should the impact be here?
              System.out.println(s);
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

            VBox layoutShoe = new VBox(20);
            layoutShoe.setPadding(new Insets(30));




            //fields for shoe details
            Label nameQuestion = new Label("Give this shoe a name, so you'll recognize it when it is suggested later in an outfit:");
            TextField nameField = new TextField("Beige Sperry");


            Label formalityQuestion = new Label("On a scale of 1-10, how formal would you rate this pair of shoes?");
            TextField formalityField = new TextField("2");

            Label colorsQuestion = new Label("How many colors does this shoe have?");
            TextField colorsField = new TextField("1");

            VBox layoutShoeColor = new VBox(20);
            layoutShoeColor.setPadding(new Insets(30));

            ArrayList<ColorPicker> colors = new ArrayList<ColorPicker>();

            Button submitShoe = new Button();
            submitShoe.setText("Done");
            submitShoe.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  //write data from text fields to shoe data file
                  String shoeEntry = "n/a,";
                  shoeEntry += formalityField.getCharacters().toString()+",";
                  for(ColorPicker c : colors){
                      shoeEntry+= "{"+c.getValue().getHue()+";"+c.getValue().getSaturation()+";"+c.getValue().getBrightness()+"}";
                  }
                  shoeEntry += ","+nameField.getCharacters().toString()+"\n";
                  try{
                      Files.write(Paths.get("Shoes.csv"), shoeEntry.getBytes(), StandardOpenOption.APPEND);
                  }
                  catch(IOException e){
                      System.out.println("IOException while writing shoe details to Shoes.csv");
                  }
                  //return to main scene (main menu)
                  primaryStage.setScene(sceneMain);
                }
            });





            Button cancel = new Button();
            cancel.setText("Cancel");
            cancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(sceneMain);
                }
            });

            Button selectColors = new Button();
            selectColors.setText("Select Colors");
            selectColors.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    for(int i = 0; i<Integer.parseInt(colorsField.getCharacters().toString()); i++){
                        ColorPicker colorPicker = new ColorPicker();
                        colorPicker.setValue(Color.CORAL);
                        colors.add(colorPicker);
                        layoutShoeColor.getChildren().addAll(colorPicker);

                    }

                    layoutShoeColor.getChildren().addAll(cancel, submitShoe);
                    Scene addShoeColorScene = new Scene(layoutShoeColor, 1000, 800);
                    primaryStage.setScene(addShoeColorScene);
                }
            });




            layoutShoe.getChildren().addAll(nameQuestion, nameField, formalityQuestion, formalityField, colorsQuestion, colorsField, selectColors, cancel);
            Scene addShoeScene = new Scene(layoutShoe, 1000, 800);
            primaryStage.setScene(addShoeScene);


          }
        });






        //addBottom Button
        Button addBottom = new Button();
        addBottom.setText("Add Bottom");
        addBottom.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {

            VBox layoutBottom = new VBox(20);
            layoutBottom.setPadding(new Insets(30));




            //fields for shoe details
            Label nameQuestion = new Label("Give this bottom a name, so you'll recognize it when it is suggested later in an outfit:");
            TextField nameField = new TextField("Blue Cargo Shorts");


            Label formalityQuestion = new Label("On a scale of 1-10, how formal would you rate this bottom?");
            TextField formalityField = new TextField("2");

            Label colorsQuestion = new Label("How many colors does this bottom have?");
            TextField colorsField = new TextField("1");

            VBox layoutBottomColor = new VBox(20);
            layoutBottomColor.setPadding(new Insets(30));

            ArrayList<ColorPicker> colors = new ArrayList<ColorPicker>();

            Button submitBottom = new Button();
            submitBottom.setText("Done");
            submitBottom.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  //write data from text fields to shoe data file
                  String bottomEntry = "n/a,";
                  bottomEntry += formalityField.getCharacters().toString()+",";
                  for(ColorPicker c : colors){
                      bottomEntry+= "{"+c.getValue().getHue()+";"+c.getValue().getSaturation()+";"+c.getValue().getBrightness()+"}";
                  }
                  bottomEntry += ","+nameField.getCharacters().toString()+"\n";
                  try{
                      Files.write(Paths.get("Bottoms.csv"), bottomEntry.getBytes(), StandardOpenOption.APPEND);
                  }
                  catch(IOException e){
                      System.out.println("IOException while writing bottom details to Bottoms.csv");
                  }
                  //return to main scene (main menu)
                  primaryStage.setScene(sceneMain);
                }
            });





            Button cancel = new Button();
            cancel.setText("Cancel");
            cancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(sceneMain);
                }
            });

            Button selectColors = new Button();
            selectColors.setText("Select Colors");
            selectColors.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    for(int i = 0; i<Integer.parseInt(colorsField.getCharacters().toString()); i++){
                        ColorPicker colorPicker = new ColorPicker();
                        colorPicker.setValue(Color.CORAL);
                        colors.add(colorPicker);
                        layoutBottomColor.getChildren().addAll(colorPicker);

                    }

                    layoutBottomColor.getChildren().addAll(cancel, submitBottom);
                    Scene addBottomColorScene = new Scene(layoutBottomColor, 1000, 800);
                    primaryStage.setScene(addBottomColorScene);
                }
            });




            layoutBottom.getChildren().addAll(nameQuestion, nameField, formalityQuestion, formalityField, colorsQuestion, colorsField, selectColors, cancel);
            Scene addBottomScene = new Scene(layoutBottom, 1000, 800);
            primaryStage.setScene(addBottomScene);


          }
        });







        //addTop Button
        Button addTop = new Button();
        addTop.setText("Add Top");
        addTop.setOnAction(new EventHandler<ActionEvent>(){
          @Override
          public void handle(ActionEvent event) {

            VBox layoutTop = new VBox(20);
            layoutTop.setPadding(new Insets(30));




            //fields for shoe details
            Label nameQuestion = new Label("Give this top a name, so you'll recognize it when it is suggested later in an outfit:");
            TextField nameField = new TextField("Orange Polo Shirt");


            Label formalityQuestion = new Label("On a scale of 1-10, how formal would you rate this top?");
            TextField formalityField = new TextField("4");

            Label colorsQuestion = new Label("How many colors does this top have?");
            TextField colorsField = new TextField("1");

            VBox layoutTopColor = new VBox(20);
            layoutTopColor.setPadding(new Insets(30));

            ArrayList<ColorPicker> colors = new ArrayList<ColorPicker>();

            Button submitTop = new Button();
            submitTop.setText("Done");
            submitTop.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                  //write data from text fields to shoe data file
                  String topEntry = "n/a,";
                  topEntry += formalityField.getCharacters().toString()+",";
                  for(ColorPicker c : colors){
                      topEntry+= "{"+c.getValue().getHue()+";"+c.getValue().getSaturation()+";"+c.getValue().getBrightness()+"}";
                  }
                  topEntry += ","+nameField.getCharacters().toString()+"\n";
                  try{
                      Files.write(Paths.get("Tops.csv"), topEntry.getBytes(), StandardOpenOption.APPEND);
                  }
                  catch(IOException e){
                      System.out.println("IOException while writing top details to Tops.csv");
                  }
                  //return to main scene (main menu)
                  primaryStage.setScene(sceneMain);
                }
            });





            Button cancel = new Button();
            cancel.setText("Cancel");
            cancel.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    primaryStage.setScene(sceneMain);
                }
            });

            Button selectColors = new Button();
            selectColors.setText("Select Colors");
            selectColors.setOnAction(new EventHandler<ActionEvent>() {
                @Override
                public void handle(ActionEvent event) {
                    for(int i = 0; i<Integer.parseInt(colorsField.getCharacters().toString()); i++){
                        ColorPicker colorPicker = new ColorPicker();
                        colorPicker.setValue(Color.CORAL);
                        colors.add(colorPicker);
                        layoutTopColor.getChildren().addAll(colorPicker);

                    }

                    layoutTopColor.getChildren().addAll(cancel, submitTop);
                    Scene addTopColorScene = new Scene(layoutTopColor, 1000, 800);
                    primaryStage.setScene(addTopColorScene);
                }
            });




            layoutTop.getChildren().addAll(nameQuestion, nameField, formalityQuestion, formalityField, colorsQuestion, colorsField, selectColors, cancel);
            Scene addTopScene = new Scene(layoutTop, 1000, 800);
            primaryStage.setScene(addTopScene);


          }
        });


        //formality slider


        slider.setMinWidth(280);

        //addShoe.setTranslateY(50);
        //addBottom.setTranslateY(50);
        //addBottom.setTranslateX(120);
        //addTop.setTranslateY(50);
        //addTop.setTranslateX(-120);
        layoutMain.getChildren().addAll(slider, getOutfits, addShoe, addBottom, addTop);
        layoutMain.setAlignment(Pos.CENTER);
        layoutMain.setPadding(new Insets(30));
    }
}
