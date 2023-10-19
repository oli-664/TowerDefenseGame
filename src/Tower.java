import processing.core.PApplet;

public class Tower {
    private int x,y,width,height;
    private int bulletSpeed;
    private int colorR, colorG, colorB;
    public Tower(int a, int b, int w, int h, int bulletSpd){
        x=a;
        y=b;
        width = w;
        height = h;
        bulletSpeed = bulletSpd;

        colorR = 43;
        colorG = 68;
        colorB = 89;
    }

    public Bullet shoot(){
        Bullet bullet = new Bullet(x,y,bulletSpeed);
        return bullet;
        //create a bullet with x and y location from this class, and also pass in bulletSpeed
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public void draw(PApplet window){
        window.fill(colorR,colorG,colorB);
        window.rect(x,y,width,height);

    }

    public int getWidth(){
        return width;
    }

    public int getHeight(){
        return height;
    }

    public void setColor(int inputA, int inputB, int inputC){
        colorR = inputA;
        colorG = inputB;
        colorB = inputC;
    }
}
