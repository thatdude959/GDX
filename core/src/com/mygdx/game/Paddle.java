package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Paddle {
    int x;
    int y = 10;
    int height = 7;
    int width;

    public Paddle(int width) {
        this.width = width;
    }

    public void update() {
        x = Gdx.input.getX() - (width / 2);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }
}
