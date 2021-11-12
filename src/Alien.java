import javafx.geometry.Rectangle2D;

public class Alien extends AnimatedThing {

    double compteur;
    int indexSprite;
    public Alien(double x, double y, String fileName,double xEcran, double yEcran){
        super(x, y, fileName,xEcran,yEcran);

        compteur = 0;
        indexSprite = 0;

    }


    void update(long time){
        compteur++;

        if (compteur==7) { // Pour annimation uniquement
            compteur = 0;



                indexSprite++;
                indexSprite = indexSprite % 6;



            sprite.setViewport(new Rectangle2D(indexSprite*84, 0, 84, 100));
        }
    }

}
