package com.mygdx.game;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {
    int x, y, width, height;
    boolean isHit = false;

    public Block(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(x, y, width, height);
    }

    public void checkCollision(Ball ball) {
        if (collidesWith(ball)) {
            isHit = true;
            ball.ySpeed *= -1;
        }
    }

    private boolean collidesWith(Ball ball) {
        if ((ball.x - ball.radius) >= x && (ball.x - ball.radius) <= x + width
                || (ball.x + ball.radius) >= x && (ball.x + ball.radius) <= x + width) {
            if (y <= (ball.y + ball.radius) && y >= (ball.y - ball.radius)
                    || y + height <= (ball.y + ball.radius) && y + height >= (ball.y - ball.radius)) {
                return true;
            } else
                return false;
        } else {
            return false;
        }
    }
}