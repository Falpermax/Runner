import javafx.geometry.Rectangle2D;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class AnimatedThing {

    double x;
    double y;
    ImageView sprite;
    int attitude;
    Rectangle2D tileSize;

    public ImageView getSprite() {
        return sprite;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    public AnimatedThing(double x, double y, String fileName, Rectangle2D tileSize) {

        Image spriteSheet = new Image(fileName);
        this.tileSize = tileSize;
        this.sprite = new ImageView(spriteSheet);
        sprite.setViewport(tileSize);
        sprite.setX(x);
        sprite.setY(y);


    }
}
