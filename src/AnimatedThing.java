import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {

    double x;
    double y;
    Image spriteSheet;
    ImageView sprite;
    int attitude; //0 : IDLE; 1 : RUN; 2 : JUMP;
    int indexSprite;
    int compteur;

    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }

    public ImageView getSprite() {
        return sprite;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public AnimatedThing(double x, double y, String fileName, double xEcran, double yEcran) {
        attitude = 1;
        compteur = 0;
        spriteSheet = new Image(fileName);
        this.sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(0,0,75,100));
        this.x = x;
        this.y = y;
        sprite.setX(xEcran);
        sprite.setY(yEcran);


    }

    void update(long time){
        compteur++;
        //System.out.println(time/1000000); //Appel toutes les 16 ms
        if (compteur==7) {
            compteur = 0;
            //System.out.println("Anime");
            if (attitude == 0) {
                indexSprite = 0;
            }
            if (attitude == 1) {
                indexSprite++;
                indexSprite = indexSprite % 6;
                x=x+30;
            }
            sprite.setViewport(new Rectangle2D(indexSprite*84, 0, 84, 100));
        }
         //fait avancer le personnage
        if (x>500){
            attitude = 0;
        }
    }

}
