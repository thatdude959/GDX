package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;

public class Block {
    int x, y, width, height;
    boolean isHit = false;
    boolean hitSide = false;

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
            if (hitSide) {
                isHit = true;
                ball.xSpeed *= -1;
            } else {
                isHit = true;
                ball.ySpeed *= -1;
            }
        }
    }

    private boolean collidesWith(Ball ball) {
        if ((ball.x - ball.radius) >= x - 1 && (ball.x - ball.radius) <= x + width + 1
                || (ball.x + ball.radius) >= x - 1 && (ball.x + ball.radius) <= x + width + 1) {
            if ((ball.y - ball.radius) >= y - 1 && (ball.y - ball.radius) <= y + height + 1
                    || (ball.y + ball.radius) >= y - 1 && (ball.y + ball.radius) <= y + height + 1) {
                if ((ball.x - ball.radius) >= x + width || (ball.x + ball.radius) <= x) {
                    hitSide = true;
                    return true;
                } else {
                    return true;
                }
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
}
