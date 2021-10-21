import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.application.Application;

import javafx.stage.Stage;

public class GameScene extends Scene {

    Camera camera;
    StaticThing backgroundLeft;
    StaticThing backgroundRight;
    AnimatedThing hero;



    public GameScene(Group g) {
        super(g,600,400);
        backgroundRight = new StaticThing(800,400,"desert.png");
        backgroundLeft = new StaticThing(800,400,"desert.png");
        hero = new AnimatedThing(0,250,"heros.png",new Rectangle2D(20,0,65,100));
        camera = new Camera(400,400);
        render();
        g.getChildren().add(backgroundLeft.getSprite());
        g.getChildren().add(backgroundRight.getSprite());
        g.getChildren().add(hero.getSprite());

    }

    void render(){
        double offset = camera.getX()%backgroundLeft.getX();
        backgroundLeft.getSprite().setViewport(new Rectangle2D(offset, 0,backgroundLeft.getX()-offset, backgroundLeft.getY()));
        backgroundRight.getSprite().setX(backgroundRight.getX()-offset);
        //hero.getSprite().setX();
    }

}
