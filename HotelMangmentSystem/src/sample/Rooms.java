/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sample;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import javafx.scene.control.TreeTableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import javafx.scene.layout.BackgroundPosition;
import javafx.scene.layout.BackgroundRepeat;
import javafx.scene.layout.BackgroundSize;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.stage.Stage;

/**
 *
 * @author omar
 */
public class Rooms extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        AnchorPane root =new AnchorPane();
        
         Image Roomimg= new Image("images/roomScreenImg.jpg");
         ImageView R =new ImageView(Roomimg);
            BackgroundImage RBG = new BackgroundImage(
               Roomimg, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(1017 , 691, false, false, false, false));
            
            root.setBackground(new Background(RBG));
            
        Pane pane1 =new Pane();
        pane1.setPrefWidth(414);
        pane1.setPrefHeight(700);
        pane1.setLayoutX(14);
        pane1.setLayoutY(14);
        pane1.setScaleX(1);
        pane1.setScaleY(1);
        pane1.setScaleZ(1);
        AnchorPane.setTopAnchor(pane1,15.0);
        AnchorPane.setBottomAnchor(pane1, 15.0);
        AnchorPane.setLeftAnchor(pane1, 15.0);
        AnchorPane.setRightAnchor(pane1, 937.0);
        pane1.setStyle("-fx-backgraund-color: white;-fx-background-radius: 6px");
        pane1.setOpacity(0.7);
        
        Pane pane2 =new Pane();
        pane2.setPrefWidth(378);
        pane2.setPrefHeight(133);
        pane2.setLayoutX(20);
        pane2.setLayoutY(144);
       pane2.setStyle("-fx-border-redius: 15;-fx-border-color:#ccc ;-fx-border-width:2px");
       TextField tf1 =new TextField("search by room number");
       tf1.setPrefHeight(25);
       tf1.setPrefWidth(312);
       tf1.setLayoutX(35);
       tf1.setLayoutY(38);
       tf1.setFont(Font.font("System 14px", FontPosture.REGULAR, 14));
       tf1.setOpacity(0.66);
       Button bt1 =new Button("Search");
       bt1.setStyle("-fx-background-color: #09e2");
       bt1.setPrefWidth(80);
       bt1.setPrefHeight(30);
       bt1.setLayoutX(79);
       bt1.setLayoutY(87);
       
       Button bt2 =new Button("Available");
       bt2.setStyle("-fx-background-color: #09e2");
       bt2.setPrefWidth(80);
       bt2.setPrefHeight(30);
       bt2.setLayoutX(235);
       bt2.setLayoutY(87);
       
       pane2.getChildren().addAll(tf1,bt1,bt2);
       
       
        Pane pane3 =new Pane();
        pane3.setPrefWidth(378);
        pane3.setPrefHeight(133);
        pane3.setLayoutX(20);
        pane3.setLayoutY(293);
        pane3.setStyle("-fx-border-redius: 15;-fx-border-color:#ccc;-fx-border-width:2px");
        
        CheckBox ch1=new CheckBox("Busy");
        ch1.setLayoutX(49);
        ch1.setLayoutY(29);
        CheckBox ch2=new CheckBox("Available");
        ch2.setLayoutX(189);
        ch2.setLayoutY(29);
        
        Button bt3 =new Button("Search");
       bt3.setStyle("-fx-background-color: #09e2");
       bt3.setPrefWidth(80);
       bt3.setPrefHeight(30);
       bt3.setLayoutX(116);
       bt3.setLayoutY(78);
       
       pane3.getChildren().addAll(ch1,ch2,bt3);
       

        
        
        Pane pane4 =new Pane();
        pane4.setPrefWidth(378);
        pane4.setPrefHeight(133);
        pane4.setLayoutX(20);
        pane4.setLayoutY(441);
        pane4.setStyle("-fx-border-redius: 15;-fx-border-color:#ccc;-fx-border-width:2px");
        
        Button bt4 =new Button("Back");
        bt4.setStyle("-fx-background-color: rgba(238,0,11,0.13)");
        bt4.setPrefWidth(80);
        bt4.setPrefHeight(30);
        bt4.setLayoutX(79);
        bt4.setLayoutY(54);
       
        Button bt5 =new Button("Close");
        bt5.setStyle("-fx-background-color: rgba(238,0,11,0.13)");
        bt5.setPrefWidth(80);
        bt5.setPrefHeight(30);
        bt5.setLayoutX(236);
        bt5.setLayoutY(56);

        pane4.getChildren().addAll(bt4,bt5);


        pane1.getChildren().addAll(pane2,pane3,pane4);
        
        TreeTableView ttv =new TreeTableView();
        AnchorPane.setTopAnchor(ttv, 15.0);
        AnchorPane.setBottomAnchor(ttv, 15.0);
        AnchorPane.setRightAnchor(ttv,15.0);
        AnchorPane.setLeftAnchor(ttv,451.0);
        ttv.setPrefWidth(900);
        ttv.setPrefHeight(700);
        ttv.setLayoutX(436);
        ttv.setLayoutY(83);

        
        
        root.getChildren().addAll(pane1,ttv);
        Scene scene =new Scene(root,1366,730);
            primaryStage.setScene(scene);
            primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
