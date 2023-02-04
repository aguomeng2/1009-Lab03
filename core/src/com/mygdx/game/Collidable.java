package com.mygdx.game;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Rectangle;

public class Collidable<T> extends Entity<T> implements iCollidable<T> {
    private Rectangle body;
    private float prevx, prevy;
    public Collidable(float x, float y, T object) {
        super(x, y, object);
        try {
            this.body = new Rectangle(((Sprite) object).getBoundingRectangle());
        } catch (IllegalArgumentException e){
            System.out.println("Not Sprite!");
        }
    }

    public Rectangle getBody(){
        return body;
    }

    public void movement(){
        this.prevx = this.getX();
        this.prevy = this.getY();
        this.setPosition(this.getBrain().movement(this.getPosition()));
        this.body.setX(this.getX());
        this.body.setY(this.getY());
    }

    @Override
    public void isColliding(T other){
        Collidable<T> clone = (Collidable)((Collidable) other).clone();
        if (clone.getBody().overlaps(body)) {
                this.setX(prevx);
                this.setY(prevy);
                this.body.setX(prevx);
                this.body.setY(prevy);
            }
        }
}
