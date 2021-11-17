import javafx.geometry.Rectangle2D;

public class Enemy extends AnimatedThing {

    double compteur;
    int indexSprite;
    boolean toAnimate;
    public Enemy(double x, double y, String fileName, double xEcran, double yEcran){
        super(x, y, fileName,xEcran,yEcran);

        compteur = 0;
        indexSprite = 0;
        sprite.setViewport(new Rectangle2D(935 , 750,190,275));


    }


    void update(long time, double xCam){

        compteur++;
        System.out.println(compteur);
        if (x>xCam-300||x<xCam+300){
            sprite.setX(x-xCam);
        }
        if(toAnimate && compteur ==7){
            sprite.setViewport(new Rectangle2D(935 , 750,190,275));
        }
        if(toAnimate && compteur ==14){
            sprite.setViewport(new Rectangle2D(935 , 475,190,275));
        }
        if(toAnimate && compteur ==21){
            sprite.setViewport(new Rectangle2D(935 , 210,190,275));
            compteur=0;
            toAnimate = false;
        }

    }

    public void setToAnimate(boolean b){
        toAnimate = b;
        compteur = 0;
    }

}
