import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {

    double x;
    double y;
    ImageView sprite;

    public double getX() {
        return x;
    }

    public ImageView getSprite() {
        return sprite;
    }


    public StaticThing(double x, double y, String fileName){
        Image spriteSheet = new Image(fileName);
        sprite = new ImageView(spriteSheet);
        this.x = x;
        this.y = y;

    }


}
