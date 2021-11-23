

public class Camera{
    private double x;
    private double y;
    private double vx;
    private double ax;
    private double offsetRessort;


    public double getX() {
        return x;
    }


    public Camera(double x,double y){
        this.x = x;
        this.y=y;
        vx = 0;
        ax=0;
    }

    @Override
    public String toString(){
        return x+","+y;
    }

    //Calcul la position de la caméra enfonction de la position du héro selon un effet ressort.
    // l'effet prinicipalement visible qu'au début.
    void update(long time, double xHero){
        double km = 3;
        double fm = 3;
        ax = km * (xHero - x) - fm * vx;
        vx += ax * 0.016;
        offsetRessort = vx * 0.016;
        x += offsetRessort;


    }

}
