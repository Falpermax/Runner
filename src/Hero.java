import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing {

    int attitude; //0 : IDLE; 1 : RUN; 2 : SAUT ; 3 : CHUTE;
    int indexSprite;
    int compteur;
    final double HAUTEUR_SAUT;
    final double VITESSE;
    double vy;

    public int getAttitude() {
        return attitude;
    }

    public void setAttitude(int attitude) {
        this.attitude = attitude;
    }
    public Hero(double x, double y, String fileName, double xEcran, double yEcran){
        super(x,y,fileName,xEcran,yEcran);
        attitude = 1;
        compteur = 0;
        vy = 0;
        VITESSE = 4;
        HAUTEUR_SAUT = 100;
    }




    void update(long time,double xCam){
        compteur++;
        if (attitude == 2){ // SAUTE
            double ay = 1000;

            sprite.setY(sprite.getY() - vy*0.016);
            vy -= ay*0.016;
            x=x+VITESSE;
            //System.out.println(vy);
            if (vy <= 0 ){
                attitude = 3 ;
            }
        }

        else if (attitude == 3 && sprite.getY()< 250){ // CHUTE
            double ay = 500;
            vy += ay*0.016;
            sprite.setY(sprite.getY() + vy*0.016);
            x=x+VITESSE;
        }
        else if (attitude == 3){
            vy = 0;
            sprite.setY(250);
            attitude = 1;
        }
        sprite.setX(x-xCam);
        if (attitude == 1){ // AVANCE
            x=x+VITESSE;
        }
        if (compteur==7) { // Pour annimation uniquement
            compteur = 0;
            //System.out.println("Anime");
            if (attitude == 0) {
                indexSprite = 0;

            }
            if (attitude == 1) {
                indexSprite++;
                indexSprite = indexSprite % 6;


            }
            sprite.setViewport(new Rectangle2D(indexSprite*84, 0, 84, 100));
        }
        //fait avancer le personnage
   /*     if (x>1000){
            attitude = 0;

        }*/
    }


    void jump(){
        if(attitude != 2){
            attitude = 2;
            vy = 500;
        }
    }



}
