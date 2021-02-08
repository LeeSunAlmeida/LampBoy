package org.academiadecodigo.rapunshells.Guns;

import org.academiadecodigo.rapunshells.Grid.Position;
import org.academiadecodigo.simplegraphics.graphics.Movable;
import org.academiadecodigo.simplegraphics.graphics.Rectangle;

public class Bullet implements Movable {

    private int damage;
    private Gun gun;
    private Rectangle bulletVisual;


    public Bullet(int damage,Gun gun) {
        this.gun = gun;
        this.damage = damage;
        bulletVisual = new Rectangle();//bala tem de sair da posição da gun

    }



    // todo bullet will move() in straight line
    public void bulletMove() {
        
    }

    // todo bullet will have collision detection, calls Hittable.hit()


    public int getDamage() {
        return damage;
    }

    @Override
    public void translate(double v, double v1) {

    }
}
