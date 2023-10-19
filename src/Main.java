import processing.core.PApplet;
import java.util.ArrayList;

public class Main extends PApplet {
    ArrayList<Tank> tankArray;
    ArrayList<Tower> towerArray;
    ArrayList<Bullet> bulletArray;

    public void settings(){
        size(800,800);
    }
    public void setup(){
        //Initialize Tanks
        tankArray = new ArrayList<>();
        for (int initilizeTanksCounter = 0; initilizeTanksCounter < 20; initilizeTanksCounter++) {
            Tank inputTank = new Tank(0 - (initilizeTanksCounter * 75),380, 40,40, 100, 1);
            tankArray.add(inputTank);
        }
        //Initialize Towers
        towerArray = new ArrayList<>();
        for (int initializeTowerCounter = 0; initializeTowerCounter < 8; initializeTowerCounter++) {
            Tower inputTower = new Tower(10 + (initializeTowerCounter * 100), 525, 50,50,5, 200);
            towerArray.add(inputTower);
        }
        //Initialize Bullets
        bulletArray = new ArrayList<>();
    }
    public void draw(){
        //White Background
        background(255);

        //Road (Grey Rectangle in Middle):
        fill(105,105,105);
        rect(0,300,800, 200);

        //Tank Movement
        for (int loopTanks = 0; loopTanks < tankArray.size(); loopTanks++) {
            Tank currTank = tankArray.get(loopTanks);
            currTank.draw(this);
            if(! currTank.inBounds(800)){
                tankArray.remove(loopTanks);
            }

            //Check Bullet Collision
            for (int loopBullets = 0; loopBullets < bulletArray.size(); loopBullets++) {
                if(currTank.checkBulletCollision(bulletArray.get(loopBullets))){
                    tankArray.remove(loopTanks);
                    bulletArray.remove(loopBullets);
                }
            }
        }

        //Tower Method
        for(Tower tower : towerArray){
            //Reloading Code
            if(tower.checkReload()){
                if (mousePressed) {
                    if (mouseX >= tower.getX() && mouseX <= tower.getX() + tower.getWidth() && mouseY >= tower.getY() && mouseY <= tower.getY() + tower.getHeight()) {
                        tower.setColor(0,255,0);
                        Bullet addBullet = tower.shoot();
                        bulletArray.add(addBullet);
                        //Reset reload counter
                        tower.setReloadSpeed(0);
                    }
                } else{
                    tower.setColor(255,0,0);
                }
            } else{
                tower.setReloadSpeed(tower.getCurrReload() + 1);
            }

            tower.draw(this);
        }

        //Bullet Method
        for (int loopBullets = 0; loopBullets < bulletArray.size(); loopBullets++) {
            Bullet currBullet = bulletArray.get(loopBullets);
            currBullet.draw(this);
            currBullet.move();
            if(!currBullet.inBounds(800)){
                bulletArray.remove(loopBullets);
            }
        }
    }

    public static void main(String[] args) {
        PApplet.main("Main");
    }
}
