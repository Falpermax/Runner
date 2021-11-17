// add any usefull package line

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class Main extends Application{


    public void start(Stage primaryStage){

        Group root = new Group();

        Menu menuStart = new Menu(root);
        primaryStage.setScene(menuStart);
        primaryStage.setTitle("Menu Principal");
        primaryStage.setResizable(false);
        menuStart.getStart().setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent event) {
                Group root = new Group();
                GameScene gs = new GameScene(root);
                primaryStage.setTitle("Runner");
                primaryStage.setScene(gs);
            }
        });

        primaryStage.show();



    }
    public static void main(String[] args) {
        launch(args);

    }
}