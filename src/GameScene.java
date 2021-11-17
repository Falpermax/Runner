import javafx.animation.AnimationTimer;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.event.EventType;
import javafx.geometry.Rectangle2D;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

import java.util.ArrayList;
import java.util.Random;


public class GameScene<event> extends Scene {

    Camera camera;
    StaticThing backgroundLeft;
    StaticThing backgroundRight;
    Hero hero;
    ArrayList<Enemy> enemies;
    ArrayList<Heart> life;
    int numberOfLifes;
    int sector;
    int previousSpawn;
    int score;
    Text labelScore;
    Image gameOver;
    ImageView gameOverImageView;

    void update(long time, Group g, boolean b){

        render();
        if (numberOfLifes>=0 && camera.getX()>sector*2000-1000){

            spawnEnemies(enemies,g);
            sector++;
        }
        score = (int)hero.getX();
        labelScore.setText("Score : " + score);



        if (!b){
            for (Enemy e : enemies){
                if(e.getHitBox().intersects(hero.getHitBox())){
                    //System.out.println("TOUCHE !!");
                    hero.estTouche();
                    e.setToAnimate(true);
                    if (numberOfLifes >0){
                        life.get(numberOfLifes-1).setBlack();
                        numberOfLifes--;
                    }
                    else {
                        numberOfLifes--;
                        g.getChildren().clear();
                        g.getChildren().add(gameOverImageView);
                        gameOverImageView.setViewport(new Rectangle2D(125,50,1000,1000));
                        //System.out.println("fin du jeu !");
                    }
                }
            }
        }


    }

    public GameScene(Group g) {
        super(g,600,400);
        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long time) {
                hero.update(time,camera.getX());
                camera.update(time,hero.getX());
                update(time,g,hero.estInvincible());
                for (Enemy e : enemies){
                    e.update(time, camera.getX());
                }
            }
        };
        gameOver = new Image("game over.jpg");
        gameOverImageView = new ImageView(gameOver);
        numberOfLifes = 3;
        sector = 0;
        labelScore = new Text("Score : ");
        labelScore.getTransforms().add(new Translate(400,50));
        labelScore.getTransforms().add(new Scale(2,2));
        this.setOnMouseClicked((event)->{hero.jump();});
        enemies = new ArrayList<Enemy>();
        life = new ArrayList<Heart>();
        backgroundLeft = new StaticThing(0,0,"desert.png");
        backgroundRight = new StaticThing(800,0,"desert.png");
        hero = new Hero(0,0,"heros.png",250,250);
        camera = new Camera(0,0);
        previousSpawn = 900;
        enemies.add(new Enemy(800, 250, "cactus sprite.png", 250 , 250));
        life.add(new Heart(25,30,"coeurs pixel.png"));
        life.add(new Heart(75,30,"coeurs pixel.png"));
        life.add(new Heart(125,30,"coeurs pixel.png"));
        render();
        g.getChildren().add(backgroundLeft.getSprite());
        g.getChildren().add(backgroundRight.getSprite());
        g.getChildren().add(hero.getSprite());
        for (Enemy e : enemies){
            g.getChildren().add(e.getSprite());
            e.getSprite().setFitHeight(100);
            e.getSprite().setPreserveRatio(true);
        }
        for (Heart h : life){
            h.getSprite().setFitHeight(40);
            h.getSprite().setPreserveRatio(true);
            g.getChildren().add(h.getSprite());
        }
        g.getChildren().add(labelScore);
        timer.start();

    }

    void render(){

        double offset = (camera.getX())%backgroundLeft.getSprite().getImage().getWidth();
        backgroundLeft.getSprite().setViewport(new Rectangle2D(offset, 0,backgroundLeft.getSprite().getImage().getWidth(), backgroundLeft.getSprite().getImage().getHeight()));

        backgroundRight.getSprite().setX(backgroundRight.getX()-offset);

    }



    void spawnEnemies(ArrayList<Enemy> e,Group g){
        int randomNumber = getRandomNumberInRange(2,7);

        for (int i = 0; i<randomNumber; i++){

            if(previousSpawn<(sector+1)*2000){
                int randomSpawn = getRandomNumberInRange(previousSpawn,(sector+1)*2000);
                previousSpawn = randomSpawn+100;
                //System.out.println((randomSpawn));
                Enemy enemy = new Enemy(randomSpawn,250,"cactus sprite.png",300,250);
                enemy.getSprite().setFitHeight(100);
                enemy.getSprite().setPreserveRatio(true);
                e.add(enemy);

                g.getChildren().add(enemy.getSprite());

            }
            else{
                break;
            }


        }

    }

    private static int getRandomNumberInRange(int min, int max) {

        if (min >= max) {
            throw new IllegalArgumentException("max must be greater than min");
        }

        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }

}
