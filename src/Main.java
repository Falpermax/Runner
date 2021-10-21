// add any usefull package line

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class Main extends Application{


    public void start(Stage primaryStage){
        primaryStage.setTitle("Demo");
        Group root = new Group();


        GameScene gs = new GameScene(root);
        primaryStage.setScene(gs);
        primaryStage.show();



    }
    public static void main(String[] args) {
        launch(args);

    }
}