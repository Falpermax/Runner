

public class Camera{
    private double x;
    private double y;
    private double xHero;

    public double getxHero() {
        return xHero;
    }

    public void setxHero(double xHero) {
        this.xHero = xHero;
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
    }

    @Override
    public String toString(){
        return x+","+y;
    }

    void update(long time){



        double km = 1;
        double fm = 1.2;
        double v = (xHero - x) / 0.016;
        double a = km * (xHero - x) + fm * v;
        double vx = a*0.016;
        x = x + vx * 0.016;

    }

}
