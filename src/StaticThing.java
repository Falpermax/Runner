import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class StaticThing {
    private double x;
    private double y;
    private ImageView sprite;

    public ImageView getSprite() {
        return sprite;
    }

    public StaticThing(double x, double y, String fileName){
        Image spriteSheet = new Image(fileName);
        sprite = new ImageView(spriteSheet);
    }

}
