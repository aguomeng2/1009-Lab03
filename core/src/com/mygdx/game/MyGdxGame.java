package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MyGdxGame extends ApplicationAdapter {
	private List<Sprite> sprites;
	private int count;
	private List<Entity> entities;
	private SpriteBatch batch;
	private Collidable ant,ant2;
	private NonCollidable circle;
	private ShapeRenderer shape;

	@Override
	public void create () {
		this.count = 0;
		shape = new ShapeRenderer();
		this.batch = new SpriteBatch();
		this.sprites = new ArrayList<>();
		Collections.addAll(sprites, new Sprite(new Texture("Ant.png")),
				new Sprite(new Texture("Ant.png")),
				new Sprite(new Texture("circle.png")));
		this.ant = new Collidable(150, 150, sprites.get(0));
		this.ant2 = new Collidable(55, 0, sprites.get(1));
		this.circle = new NonCollidable(0 ,0, sprites.get(2));
		this.entities = new ArrayList<>();
		Collections.addAll(entities, this.ant, this.ant2, this.circle);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0.15f, 0.15f, 0.4f, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		shape.begin(ShapeRenderer.ShapeType.Line);
		batch.begin();
		batch.draw(sprites.get(0), ant.getX(), ant.getY());
		batch.draw(sprites.get(1), ant2.getX(), ant2.getY());
		batch.draw(sprites.get(2), circle.getX(), circle.getY());
		for (Entity e : entities){
			if (e instanceof Collidable) {
				shape.rect(e.getX(), e.getY(), ((Collidable) e).getBody().getHeight(),
						((Collidable) e).getBody().getWidth());
			}
		}
		for (Entity e : entities){
			if (entities.get(count) == e){
				e.movement();
			}
		}
		changeEntities(entities);
		ant.isColliding(ant2);
		ant2.isColliding(ant);
		batch.end();
		shape.end();
	}
	
	@Override
	public void dispose () {
		batch.dispose();
		shape.dispose();
	}

	public void changeEntities(List<Entity> entities){
		if (Gdx.input.isKeyJustPressed(Input.Keys.T)){
			count++;
			if (count == entities.size()){
				count = 0;
			}
		}
	}

}
