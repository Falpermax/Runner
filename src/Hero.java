import javafx.geometry.Rectangle2D;

public class Hero extends AnimatedThing {

    int attitude; //0 : IDLE; 1 : RUN; 2 : SAUT ; 3 : CHUTE;
    int indexSprite;
    int compteur;
    boolean touched;
    final double VITESSE;
    double vy;
    double INVICIBILITY;
    double invicibility;

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
        INVICIBILITY = 2; // durée d'invicibilité en secondes
        invicibility = 0;
        touched = false;
    }




    void update(long time,double xCam){
        compteur++;
        y = sprite.getY();
        if (attitude == 2){ // SAUTE
            double ay = 1000;
            sprite.setY(sprite.getY() - vy*0.016);
            vy -= ay*0.016;
            x=x+VITESSE;
            if (vy <= 0 ){
                attitude = 3 ;
            }
        }

        else if (attitude == 3 && sprite.getY()< 250){ // Conditions pour la chute, le héro ne monte plus et descend et n'a pas encore atteint le sol
            double ay = 500;
            vy += ay*0.016;
            sprite.setY(sprite.getY() + vy*0.016);
            x=x+VITESSE;
        }
        else if (attitude == 3){ // le héro à atteint le sol;
            vy = 0;
            sprite.setY(250);
            attitude = 1;
        }
        sprite.setX(x-xCam);
        if (attitude == 1){ // fait avancer le héro
            x=x+VITESSE;
        }
        if(touched && (compteur == 3 || compteur == 6)){ //Fait disparaitre le héro pour l'effet clignotement quand le héro est touché
            animationInvincibilite();
        }
        if (compteur==7) { //Joue l'animation de course du héro
            compteur = 0;
            if (attitude == 0) { //Quand le héro attend (au tout début)
                indexSprite = 0;

            }
            if (attitude == 1) { //Défile les sprite du héros quand il cour
                indexSprite++;
                indexSprite = indexSprite % 6;


            }

            sprite.setViewport(new Rectangle2D(indexSprite*84, 0, 84, 100));


        }


        if (touched){ //Compte le temps d'invicibilite restant quand le hero est touché
            calculInvincibilite();
            if (invicibility>INVICIBILITY){
                touched = false;
                invicibility = 0;
            }


        }
    }


    void jump(){ //Est appelé pour faire sauter le héro
        if(attitude == 1){
            attitude = 2;
            vy = 500;
        }
    }

    void calculInvincibilite(){
        invicibility = invicibility + 0.016;
    }

    public void estTouche(){
        touched = true;
    }

    public boolean estInvincible(){
        return touched;
    }

    void animationInvincibilite(){
        sprite.setViewport(new Rectangle2D(0,0,1,1));

    }
}
