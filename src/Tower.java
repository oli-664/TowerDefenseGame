import processing.core.PApplet;

public class Tower {
    private int x,y,width,height;
    private int bulletSpeed;
    private int currReloadCounter, reloadSpeed;
    private int colorR, colorG, colorB;
    public Tower(int a, int b, int w, int h, int bulletSpd, int inputReloadSpeed){
        x=a;
        y=b;
        width = w;
        height = h;
        bulletSpeed = bulletSpd;
        this.reloadSpeed = inputReloadSpeed;
        currReloadCounter = 0;

        colorR = 43;
        colorG = 68;
        colorB = 89;
    }

    public Bullet shoot(){
        Bullet bullet = new Bullet(x + (width / 2), y + (height / 2), bulletSpeed);
        return bullet;
        //create a bullet with x and y location from this class, and also pass in bulletSpeed
    }

    public boolean checkReload() {
        if(currReloadCounter > reloadSpeed){
            return true;
        }
        return false;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }
    public int getReloadSpeed(){
        return reloadSpeed;
    }
    public int getCurrReload(){
       return currReloadCounter;
    }

    public void setReloadSpeed(int num){
        currReloadCounter = num;
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
