import processing.core.PApplet;

public class Tank {
    private int x, y, tankWidth, tankHeight, health;
    private double speed;

    public Tank(int inputX, int inputY, int inputWidth, int inputHeight, int inputHealth, double inputSpeed){
        this.x = inputX;
        this.y = inputY;
        this.tankWidth = inputWidth;
        this.tankHeight = inputHeight;
        this.health = inputHealth;
        this.speed = inputSpeed;
    }

    public void draw(PApplet window){
        window.fill(255,0,0);
        window.rect(x, y,(tankWidth/2),(tankHeight/2));
        this.move();
    }

    public void move(){
        x += speed;
    }

    public boolean inBounds(int widthOfScreen){
        if(x < widthOfScreen){
            return true;
        }
        return false;
    }
    public boolean checkBulletCollision(Bullet incomingBullet){
        if(((incomingBullet.getX() + incomingBullet.getR()) > this.x) && (incomingBullet.getX() - incomingBullet.getR()) < (this.x + this.tankWidth)){
            if((incomingBullet.getY() + incomingBullet.getR()) > this.y + this.tankHeight && (incomingBullet.getY() - incomingBullet.getR()) < this.y){
                return true;
            }
        }
        return false;
    }

    public void set(){
        this.x = -30;
    }
}

