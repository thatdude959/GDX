package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Ball {
    int x;
    int y;
    int radius;
    int xSpeed;
    int ySpeed;
    Color color = Color.WHITE;

    public Ball(int x, int y, int radius, int xSpeed, int ySpeed) {
        this.x = x;
        this.y = y;
        this.radius = radius;
        this.xSpeed = xSpeed;
        this.ySpeed = ySpeed;
    }

    public void update() {
        x += xSpeed;
        y += ySpeed;
        // x = Gdx.input.getX();
        // y = Gdx.graphics.getHeight() - Gdx.input.getY();
        if (x < radius || x > Gdx.graphics.getWidth() - radius) {
            xSpeed = -xSpeed;
        }
        if (y < radius || y > Gdx.graphics.getHeight() - radius) {
            ySpeed = -ySpeed;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(x, y, radius);
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            ySpeed *= -1;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        if ((x - radius) >= paddle.x && (x - radius) <= paddle.x + paddle.width
                || (x + radius) >= paddle.x && (x + radius) <= paddle.x + paddle.width) {
            if (paddle.y <= (y + radius) && paddle.y >= (y - radius)
                    || paddle.y + paddle.height <= (y + radius) && paddle.y + paddle.height >= (y - radius)) {
                return true;
            } else
                return false;
        } else {
            return false;
        }
    }
}