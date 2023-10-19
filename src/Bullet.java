import processing.core.PApplet;

public class Bullet {

    int x, y, Bwidth, Bheight;
    int bulletSpeed;

    public Bullet(int a, int b, int bSpeed) {
        x = a;
        y = b;
        Bwidth = 25;
        Bheight = 25;
        bulletSpeed = bSpeed;
    }

    public void draw(PApplet window) {
        window.fill(0, 0, 255);
        window.ellipse(x, y, Bwidth, Bheight);
    }

    public void move() {
        y -= bulletSpeed;
    }

    public boolean inBounds(int heightOfScreen){
        if(y <= heightOfScreen && y >= 0){
            return true;
        }
        return false;
    }

    public int getX (){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getR(){
        return Bwidth;
    }
}