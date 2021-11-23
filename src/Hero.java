import javafx.geometry.Rectangle2D;


public class Hero extends AnimatedThing {

    int attitude; //0 : ATTENTE; 1 : RUN; 2 : SAUT ; 3 : CHUTE;
    int indexSprite;
    int compteur;
    boolean touched;
    final double VITESSE;
    double vy;
    double INVICIBILITY;
    double invicibility;


    public Hero(double x, double y, String fileName, double xEcran, double yEcran){
        super(x,y,fileName,xEcran,yEcran);
        attitude = 1;
        compteur = 0;
        vy = 0;
        VITESSE = 4; // vitesse du héro en pixel/16ms
        INVICIBILITY = 2; // durée d'invicibilité en secondes
        invicibility = 0;
        touched = false;
    }




    void update(long time,double xCam){
        compteur++;
        y = sprite.getY(); //On lie la position à l'écran à la position dans le jeu en Y.

        //Le héro saute et est en montée
        if (attitude == 2){
            double ay = 1000;
            sprite.setY(sprite.getY() - vy*0.016);
            vy -= ay*0.016;
            x=x+VITESSE;
            if (vy <= 0 ){
                attitude = 3 ;
            }
        }

        // Conditions pour la chute, le héro ne monte plus, chute et n'a pas encore atteint le sol
        else if (attitude == 3 && sprite.getY()< 250){
            double ay = 500;
            vy += ay*0.016;
            sprite.setY(sprite.getY() + vy*0.016);
            x=x+VITESSE;
        }

        // le héro à atteint le sol, on le repositionne à la position exacte du sol;
        else if (attitude == 3){
            vy = 0;
            sprite.setY(250);
            attitude = 1;
        }

        sprite.setX(x-xCam);//Sert à compenser l'effet du ressort de la caméra pour eviter le glissement du héro

        // fait avancer le héro
        if (attitude == 1){
            x=x+VITESSE;
        }
        //Fait disparaitre le héro pour l'effet clignotement quand le héro est touché
        if(touched && (compteur == 3 || compteur == 6)){
            animationInvincibilite();
        }
        //Détermine le sprite à afficher selon l'état du héro
        if (compteur==7) {
            compteur = 0;
            //Quand le héro attend (au tout début)
            if (attitude == 0) {
                indexSprite = 0;

            }
            //Quand le héro est en course, on incrémente l'index pour faire défiler les sprites.
            if (attitude == 1) {
                indexSprite++;
                indexSprite = indexSprite % 6;


            }
            //Défile les sprite du héros quand il cour grâce à indexSprite qui est incrémenté toutes les 112 ms
            sprite.setViewport(new Rectangle2D(indexSprite*84, 0, 84, 100));


        }

        //Compte le temps d'invicibilite restant quand le hero est touché
        if (touched){
            calculInvincibilite();
            if (invicibility>INVICIBILITY){
                touched = false;
                invicibility = 0;
            }


        }
    }

    //Est appelé pour faire sauter le héro
    void jump(){
        if(attitude == 1){
            attitude = 2;
            vy = 500;
        }
    }

    //calcule le temps d'invicibilité
    void calculInvincibilite(){
        invicibility = invicibility + 0.016;
    }

    //active le mode invincible
    public void estTouche(){
        touched = true;

    }

    //indique si le héro est invicible
    public boolean estInvincible(){
        return touched;
    }

    //Rend invisible le héro pour l'effet clignotement quand il est invicible
    void animationInvincibilite(){
        sprite.setViewport(new Rectangle2D(0,0,1,1));

    }
}
