import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;


public class GameScene<event> extends Scene {

    Camera camera;
    StaticThing backgroundLeft;
    StaticThing backgroundRight;
    Hero hero;

    void update(long time){

        render();
    }

    public GameScene(Group g) {
        super(g,600,400);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                hero.update(time,camera.getX());
                camera.update(time,hero.getX());
                update(time);
            }
        };
        this.setOnMouseClicked((event)->{//System.out.println("Jump");
        hero.jump();});
        backgroundLeft = new StaticThing(0,0,"desert.png");
        backgroundRight = new StaticThing(800,0,"desert.png");
        hero = new Hero(0,0,"heros.png",250,250);
        camera = new Camera(0,0);
        //System.out.println(backgroundLeft.getSprite().getImage().getWidth());
        render();
        g.getChildren().add(backgroundLeft.getSprite());
        g.getChildren().add(backgroundRight.getSprite());
        g.getChildren().add(hero.getSprite());
        timer.start();
    }

    void render(){

        double offset = (camera.getX()/*+ camera.getOffsetRessort()*/)%backgroundLeft.getSprite().getImage().getWidth();
        backgroundLeft.getSprite().setViewport(new Rectangle2D(offset, 0,backgroundLeft.getSprite().getImage().getWidth(), backgroundLeft.getSprite().getImage().getHeight()));

        backgroundRight.getSprite().setX(backgroundRight.getX()-offset);

        /*offset = (offset + camera.getVx() * 0.016) % 800;
        backgroundLeft.getSprite().setViewport(new Rectangle2D(offset,0,800 - offset,400));
        backgroundRight.getSprite().setX(800-offset);*/
    }






}
