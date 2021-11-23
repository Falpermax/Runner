import javafx.geometry.Rectangle2D;

public class Heart extends StaticThing {



    public Heart(double x, double y, String fileName){
        super(x,y,fileName);

        sprite.setViewport(new Rectangle2D(0,0,15,13));
        sprite.setX(x);
        sprite.setY(y);


    }

    //Transforme le coeur en "coeur vide" quand le joueur perd une vie.
    public void setBlack(){
        sprite.setViewport(new Rectangle2D(15,0,15,13));
    }



}
