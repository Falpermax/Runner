import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {


    public double getX() {
        return getSprite().getX();
    }

    public double getY() {
        return getSprite().getY();
    }

    private ImageView sprite;

    public ImageView getSprite() {
        return sprite;
    }

    public StaticThing(double x, double y, String fileName){
        Image spriteSheet = new Image(fileName);
        sprite = new ImageView(spriteSheet);
        sprite.setX(x);
        sprite.setY(y);

    }


}
