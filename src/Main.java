// add any usefull package line

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class Main extends Application{
    Desert desert = new Desert("desert.png");
    Hero hero = new Hero(100,100,"heros.png");

    public void start(Stage primaryStage){
        primaryStage.setTitle("Demo");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400);

        primaryStage.setScene(scene);
        primaryStage.show();

        root.getChildren().add(desert.getSprite());
        root.getChildren().add(hero.getSprite());

    }
    public static void main(String[] args) {
        launch(args);

    }
}