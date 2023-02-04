package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input;

public class Brain {
    public float[] movement(float[] positions){
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_LEFT)) {
            positions[0] -= 150 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_RIGHT)) {
            positions[0] += 150 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_UP)) {
            positions[1] += 150 * Gdx.graphics.getDeltaTime();
        }
        if (Gdx.input.isKeyPressed(Input.Keys.DPAD_DOWN)) {
            positions[1] -= 150 * Gdx.graphics.getDeltaTime();
        }
        return positions;
    }
}
