

public class Camera{
    private double x;
    private double y;
    private double vx;
    private double ax;
    private double offsetRessort;


    public double getOffsetRessort() {
        return offsetRessort;
    }





    public void setX(double x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
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

    void update(long time, double xHero){


        //if (time>1) time = 0;


        double km = 3;
        double fm = 3;
        ax = km * (xHero - x) - fm * vx;
        vx += ax * 0.016;
        offsetRessort = vx * 0.016;
        x += offsetRessort;
        //System.out.println(offsetRessort);


    }

}
