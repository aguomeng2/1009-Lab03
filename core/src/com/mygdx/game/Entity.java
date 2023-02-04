package com.mygdx.game;



public abstract class Entity<T> implements Cloneable {
    private float x,y;
    private Brain brain;
    private T object;
    public Entity(float x, float y, T object){
        this.x = x;
        this.y = y;
        this.object = object;
        this.brain = new Brain();
    }

    public void setY(float y) {
        this.y = y;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getX() {
        return x;
    }

    public float getY() {
        return y;
    }

    public void setPosition(float[] positions){
        this.setX(positions[0]);
        this.setY(positions[1]);
    }

    public float[] getPosition(){
        float[] Position = {this.getX(), this.getY()};
        return Position;
    }

    public Brain getBrain(){
        return this.brain;
    }

    public abstract void movement();

    @SuppressWarnings("unchecked")
    @Override
    public Entity<T> clone() {
        try {
            return (Entity<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

}
