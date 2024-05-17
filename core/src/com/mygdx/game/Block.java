package com.mygdx.game;

import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Rectangle;

public class Block {
    Rectangle rect;
    boolean isHit = false;
    boolean hitSide = false;

    public Block(int x, int y, int width, int height) {
        rect = new Rectangle(x,y,width,height);
    }

    public void draw(ShapeRenderer shape) {
        shape.rect(rect.x, rect.y, rect.width, rect.height);
    }

    public void checkCollision(Ball ball) {
        if (Collision.intersects(rect, ball.circle)) {
            if (hitSide) {
                isHit = true;
                ball.speed.x *= -1;
            } else {
                isHit = true;
                ball.speed.y *= -1;
            }
        }
    }
}
