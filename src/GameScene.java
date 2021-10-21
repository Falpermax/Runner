import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.application.Application;

import javafx.stage.Stage;

public class GameScene {

    private Camera camera = new Camera(0,0);
    private StaticThing backgroundLeft = new StaticThing(0,0,"desert.png");
    private StaticThing backgroundRight = new StaticThing(0,0,"desert.png");


    public GameScene(){

    }

    public void main(String args[]){
        Stage primaryStage = new Stage();
        primaryStage.setTitle("Demo");
        Group root = new Group();
        Scene scene = new Scene(root, 600, 400);
        root.getChildren().add(backgroundLeft.getSprite());
        root.getChildren().add(backgroundRight.getSprite());
        primaryStage.setScene(scene);
        primaryStage.show();

    }
}
