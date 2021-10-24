import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;


public class GameScene extends Scene {

    Camera camera;
    StaticThing backgroundLeft;
    StaticThing backgroundRight;
    AnimatedThing hero;



    public GameScene(Group g) {
        super(g,600,400);

        backgroundLeft = new StaticThing(0,0,"desert.png");
        backgroundRight = new StaticThing(800,0,"desert.png");
        hero = new AnimatedThing(250,250,"heros.png",new Rectangle2D(20,0,65,100));
        camera = new Camera(400,0);
        //System.out.println(backgroundLeft.getSprite().getImage().getWidth());
        render();
        g.getChildren().add(backgroundLeft.getSprite());
        g.getChildren().add(backgroundRight.getSprite());
        g.getChildren().add(hero.getSprite());

    }

    void render(){

        double offset = camera.getX()%backgroundLeft.getSprite().getImage().getWidth();
        //System.out.println(offset);
        backgroundLeft.getSprite().setViewport(new Rectangle2D(offset, 0,backgroundLeft.getSprite().getImage().getWidth(), backgroundLeft.getSprite().getImage().getHeight()));
        //System.out.println(backgroundRight.getX()-offset);
        backgroundRight.getSprite().setX(backgroundRight.getX()-offset);

    }

}
