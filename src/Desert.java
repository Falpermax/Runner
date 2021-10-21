
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class Desert{

    private final Image spriteSheet;
    private ImageView sprite;

    public Desert(String fileName){
        spriteSheet = new Image(fileName);
        sprite = new ImageView(spriteSheet);
    }
    public ImageView getSprite() {
        return sprite;
    }


}
