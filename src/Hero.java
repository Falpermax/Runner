
import javafx.geometry.Rectangle2D;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;


public class Hero{
    private double x;
    private double y;

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }

    private ImageView sprite;

    public Hero(double x, double y, String fileName){
        this.x = x;
        this.y = y;
        Image spriteSheet = new Image(fileName);
        sprite = new ImageView(spriteSheet);
        sprite.setViewport(new Rectangle2D(20,0,65,100));

    }
    public ImageView getSprite() {
        return sprite;
    }





}
