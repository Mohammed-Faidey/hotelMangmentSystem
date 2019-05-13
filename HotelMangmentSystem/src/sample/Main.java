package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.Date;

public class Main extends Application {

    Stage stage=new Stage();

    @Override
    public void start(Stage primaryStage) throws Exception{
        try {

            Pane LoginPane = loginScreen();
            primaryStage.setTitle("Login");
            primaryStage.setScene(new Scene(LoginPane, 600, 600));
            primaryStage.setResizable(false);
            primaryStage.centerOnScreen();
            primaryStage.show();

        }catch(Exception e) {
            System.out.println(e);
        }

        stage=primaryStage;
    }

    private Pane loginScreen(){

        ImageView userimg = new ImageView("images/user.png");
        userimg.setFitWidth(250);
        userimg.setFitHeight(250);
        userimg.setX(170);
        userimg.setY(50);

        Pane pane = new Pane();
        pane.setBackground(setBackGroundImage(
                "images/hotelLogin.jpg",pane,600,600));

        Label alarmLabel = labelSetting("",120,520,20,20);
        alarmLabel.setFont(Font.font("italic",FontWeight.EXTRA_BOLD, FontPosture.ITALIC,20));

        TextField username = new TextField("username");
        username.setId("username");
        username.setOnMouseClicked(event -> {
            if(username.getText().equals("username"))
                username.setText("");
            alarmLabel.setText("");});
        username.setLayoutX(userimg.getX());
        username.setMinSize(userimg.getFitWidth(),30);
        username.setLayoutY(350); // img height>250 + Y>50 +50
        username.setAlignment(Pos.CENTER);


        PasswordField password = new PasswordField();
        password.setId("password");
        password.setMinSize(userimg.getFitWidth(),30);
        password.setLayoutX(username.getLayoutX());
        password.setLayoutY(username.getLayoutY()+50);
        password.setAlignment(Pos.CENTER);
        password.setOnMouseClicked(event -> {alarmLabel.setText("");});

        RadioButton radioButtonAdmin = new RadioButton("Admin");
        RadioButton radioButtonEmployee = new RadioButton("Employee");

        radioButtonAdmin.setLayoutX(170);
        radioButtonAdmin.setLayoutY(310);
        radioButtonAdmin.setFont(Font.font("italic",FontWeight.EXTRA_BOLD, FontPosture.ITALIC,20));
        radioButtonAdmin.setTextFill(Color.SNOW);

        radioButtonEmployee.setLayoutX(300);
        radioButtonEmployee.setLayoutY(310);
        radioButtonEmployee.setFont(Font.font("italic",FontWeight.EXTRA_BOLD, FontPosture.ITALIC,20));
        radioButtonEmployee.setTextFill(Color.SNOW);

        radioButtonAdmin.setOnAction(event -> {
            radioButtonEmployee.setDisable(true);
            userimg.setImage(new Image("images/adminImg.png"));
        });

        radioButtonEmployee.setOnAction(event -> {
            radioButtonAdmin.setDisable(true);
            userimg.setImage(new Image("images/employeeImg.png"));
        });


        Button login = new Button("login");
        login.setLayoutX(userimg.getX()+100);
        login.setLayoutY(password.getLayoutY()+70);
        login.setAlignment(Pos.CENTER);
        login.setScaleX(3);
        login.setScaleY(2);
        login.setOnAction(event -> {
            if(username.getText().equalsIgnoreCase("admin")&&
               password.getText().equalsIgnoreCase("admin")&&
               !radioButtonAdmin.isDisable()){
                stage.setTitle("Home");
                stage.setScene(new Scene(homeScreen(),800,600));
                stage.centerOnScreen();

            }

            else if (username.getText().equals("e")&&
                      password.getText().equals("e")&&
                      !radioButtonEmployee.isDisable()){
                stage.setTitle("Employee");
                stage.setScene(new Scene(customerScreen()/*employeeScreen()*/,800,600));
                stage.centerOnScreen();

            }
            else{
                alarmLabel.setTextFill(Color.RED);
                alarmLabel.setText("wrong username or password");
            }

        });

        pane.getChildren().addAll(userimg, username, password,
                login,alarmLabel,radioButtonAdmin,radioButtonEmployee);
        return pane;
    }

    private Pane homeScreen(){
        Pane p = new Pane();

        p.setBackground(setBackGroundImage("/images/homeImg.jpeg",p,800,600));

        Label imgLabel = labelSetting("",300,20,100,20);
        imgLabel.setFont(Font.font("italic",FontWeight.EXTRA_BOLD, FontPosture.ITALIC,20));
        imgLabel.setTextFill(Color.SNOW);

       ImageView customerImg = ImageSetting("images/customerImg.jpeg",150,50);
       ImageView roomImg = ImageSetting("images/roomScreenImg.jpg",350,50);
       ImageView adminImg = ImageSetting("images/adminImg.png",550,50);
       ImageView employeeImg = ImageSetting("images/employeeImg.png",200,250);
       ImageView logoutImg = ImageSetting("images/logoutImg.png",500,250);
       ImageView exitImg = ImageSetting("images/exitImg.png",350,400);


        mouseEventEntered_Exited(customerImg,imgLabel,"customer screen");
        mouseEventEntered_Exited(roomImg,imgLabel,"room screen");
        mouseEventEntered_Exited(adminImg,imgLabel,"admin screen");
        mouseEventEntered_Exited(employeeImg,imgLabel,"employee screen");
        mouseEventEntered_Exited(logoutImg,imgLabel,"logout screen");
        mouseEventEntered_Exited(exitImg,imgLabel,"exit screen");

        mouseEvent_Clicked(customerImg,customerScreen(),"customerScreen");
        mouseEvent_Clicked(roomImg,roomScreen(),"roomScreen");
        mouseEvent_Clicked(adminImg,customerScreen(),"adminScreen");
        mouseEvent_Clicked(employeeImg,customerScreen(),"employeeScreen");

        logoutImg.setOnMouseClicked(event -> {logout();});
        exitImg.setOnMouseClicked(event -> {Exit();});
       p.getChildren().addAll(customerImg,roomImg,adminImg,employeeImg,logoutImg,exitImg,imgLabel);

        return  p;
    }

    private Pane roomScreen(){
        Pane p = new GridPane();

        return p;
    }

    private Pane adminScreen(){
        Pane pane =new Pane();


        setBackGroundImage("images/adminScreenimg.jpeg",pane,800,600);

//
//        Pane p = new GridPane();
//
//        return p;
        return pane;
    }

    private Pane employeeScreen(){
        Pane p = new GridPane();

        return p;
    }

    private Pane customerScreen(){
                Pane p = new Pane();

        p.setBackground(setBackGroundImage("images/customerImg.jpeg", p, 800, 600));

        TextField nameTF = textFieldSetting("name",20,20,80);
        TextField phoneTF = textFieldSetting("phone",20,60,80);
        TextField addressTF = textFieldSetting("address",20,120,80);
        TextField ssnTF = textFieldSetting("ssn",20,180,20);
        TextField sectionTF = textFieldSetting("section",20,240,20);
        TextField roomTF = textFieldSetting("room number",20,300,20);

        TextArea informationTA= new TextArea();
        informationTA.setLayoutX(400);
        informationTA.setLayoutY(50);
        informationTA.setMaxSize(300,500);
        informationTA.setMinSize(100,100);

        informationTA.setFont(Font.font("italic",FontWeight.LIGHT,FontPosture.ITALIC,15));
        informationTA.setVisible(false);

        Button btnSave = new Button("Save");
        btnSave.setLayoutX(50); btnSave.setLayoutY(360);
        btnSave.setScaleX(3); btnSave.setScaleY(2);
        btnSave.setTextFill(Color.GREEN);

        Button btnSearch = new Button("Search");
        btnSearch.setLayoutX(250); btnSearch.setLayoutY(360);
        btnSearch.setScaleX(3); btnSearch.setScaleY(2);
        btnSearch.setTextFill(Color.GREEN);


        Label statueLabel = labelSetting("",20,420,20,5);
        statueLabel.setVisible(false);
        statueLabel.setFont(Font.font("italic",FontWeight.LIGHT,FontPosture.ITALIC,30));
        statueLabel.setTextFill(Color.DARKGREEN);

        ImageView backToHomeImg = new ImageView("images/homeReturnImg.png");
        backToHomeImg.setFitWidth(100);
        backToHomeImg.setFitHeight(100);
        backToHomeImg.setX(350);
        backToHomeImg.setY(500);
        backToHomeImg.setOnMouseClicked(event -> {
            stage.setTitle("Home");
            stage.setScene(new Scene(homeScreen(),800,600));
            stage.centerOnScreen();
        });

        btnSave.setOnAction(event -> {
            statueLabel.setVisible(true);
            statueLabel.setTextFill(Color.GREEN);
            statueLabel.setText("saved");
            if (nameTF.getText().equals("name")) {
                statueLabel.setVisible(true);
                statueLabel.setText("please insert information ");
            }

        });
        btnSearch.setOnAction(event -> {
            if(statueLabel.getText().equals("saved"))
            statueLabel.setVisible(false);

            if (nameTF.getText().equals("name")&&
                addressTF.getText().equals("address")&&
                phoneTF.getText().equals("phone")&&
                ssnTF.getText().equals("ssn")&&
                sectionTF.getText().equals("section")&&
                roomTF.getText().equals("room")) {
                statueLabel.setVisible(true);
                statueLabel.setText("please insert information ");
                informationTA.setVisible(true);
            }
                else{
                informationTA.setVisible(true);
                informationTA.setText( nameTF.getText()+"\n\n"+
                        phoneTF.getText()+"\n\n"+
                        addressTF.getText()+"\n\n"+
                        phoneTF.getText()+"\n\n"+
                        ssnTF.getText()+"\n\n"+
                        sectionTF.getText()+"\n\n"+
                        roomTF.getText()+"\n\n" );
            }
        });



        p.getChildren().addAll(nameTF,phoneTF,addressTF,ssnTF,sectionTF,roomTF,
                btnSave,btnSearch,statueLabel,informationTA,backToHomeImg);
        return p;
    }

    private void logout(){
        stage.setTitle("Home");
        stage.setScene(new Scene(loginScreen(),600,600));
        stage.centerOnScreen();

    }

    private void Exit(){
    System.exit(0);
    }

    public static void main(String[] args) {
        launch(args);
    }

    private Label labelSetting(String text,ImageView img,int layoutX,int layoutY,
                              int minSizeX,int minSizeY){

        Label label =new Label(text);
        label.setLayoutX(img.getX());
        label.setMinSize(img.getFitWidth(), 30);
        label.setLayoutY(257);
        return label;
    }

    private Label labelSetting(String text,int layoutX,int layoutY,
                              int minSizeX,int minSizeY){

        Label label =new Label(text);
        label.setLayoutX(layoutX);
        label.setLayoutY(layoutY);
        label.setMinSize(minSizeX,minSizeY);

        return label;
    }

    private TextField textFieldSetting(String text ,int layoutX,int layoutY,int opacity){
        String originText=text;//optain comming text

        TextField tf =new TextField(text);
        tf.setPrefHeight(30);
        tf.setPrefWidth(300);
        tf.setLayoutX(layoutX);
        tf.setLayoutY(layoutY);
        tf.setFont(Font.font("System", FontPosture.REGULAR, 14));
        tf.setOpacity(opacity);
        tf.setOnMouseEntered(event -> {
            if(tf.getText().equalsIgnoreCase(text))
                tf.setText("");
        });
        tf.setOnMouseExited(event -> {
            if(tf.getText().equalsIgnoreCase(""))
                tf.setText(originText);
        });
        return tf;
    }

// image setting function not used for login screen but used for all other screens
    private ImageView ImageSetting(String path,int x,int y){

        ImageView img = new ImageView(path);
        img.setFitWidth(150);
        img.setFitHeight(150);
        img.setX(x);
        img.setY(y);
        return img;
    }


    private void mouseEventEntered_Exited(ImageView img ,Label imgLabel,String screenName){
        img.setOnMouseEntered(event -> {imgLabel.setText(screenName);});
        img.setOnMouseExited(event -> {imgLabel.setText("");});
    }

    private void mouseEvent_Clicked(ImageView img,Pane pane,String title){

        img.setOnMouseClicked(event -> {
            stage.setTitle(title);
            stage.setScene(new Scene(pane,800,600));
            stage.centerOnScreen();

        });
    }

    private Background setBackGroundImage(String url,Pane p,int Width ,int Height){

        Image img = new Image(url);

        BackgroundImage backgroundImage= new BackgroundImage(
                img, BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(Width,Height,
                false,false,false,false));
        Background background = new Background(backgroundImage);
        return background;
    }


}
