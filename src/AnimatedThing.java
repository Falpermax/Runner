import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {

    double x;
    double y;
    Image spriteSheet;
    ImageView sprite;




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

        spriteSheet = new Image(fileName);
        this.sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(0,0,75,100));
        this.x = x;
        this.y = y;
        sprite.setX(xEcran);
        sprite.setY(yEcran);


    }

    //Retourne la hitBox des AnimatedThing, identique à toutes les instances issue d'AnimatedThing.
    public Rectangle2D getHitBox(){

            return new Rectangle2D(x,y,50,50);

    }


}
