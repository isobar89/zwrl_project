package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.controller.FunctionIPController;

import java.io.IOException;
import java.lang.reflect.InvocationTargetException;


public class Main extends Application {



    @Override
    public void start(Stage primaryStage) throws Exception{
    Parent parent=(Parent) FXMLLoader.load(getClass().getResource("/sample/view/MainPane.fxml"));
    Scene scene = new Scene(parent);
    primaryStage.setTitle("");
    primaryStage.setScene(scene);
    primaryStage.show();

    }



    public static void main(String[] args) throws IOException {
       Main2 main2 = new Main2();
       Main2.main("test");
        launch(args);
    }

}

