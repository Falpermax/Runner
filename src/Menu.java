import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Scale;
import javafx.scene.transform.Translate;

public class Menu extends Scene {

    Button start;
    Image titreImage;
    ImageView titre;

    public Button getStart() {
        return start;
    }

    public Menu(Group g){
        super(g, 600, 400);



        start = new Button("Commencer");
        titreImage = new Image("runner.png");
        titre = new ImageView(titreImage);
        titre.setX(150);
        titre.setY(150);

        start.getTransforms().add(new Translate(250,250));
        g.getChildren().add(titre);
        g.getChildren().add(start);



    }
}
