package com.mygdx.game;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Vector2;

public class Ball {
    Circle circle;
    Vector2 speed;
    Color color = Color.WHITE;

    public Ball(int x, int y, int radius, int xSpeed, int ySpeed) {
        circle = new Circle(x,y,radius);
        speed = new Vector2(xSpeed,ySpeed);
    }

    public void update() {
        circle.x += speed.x;
        circle.y += speed.y;
        // x = Gdx.input.getX();
        // y = Gdx.graphics.getHeight() - Gdx.input.getY();
        if (circle.x < circle.radius || circle.x > Gdx.graphics.getWidth() - circle.radius) {
            speed.x = -speed.x;
        }
        if (circle.y < circle.radius || circle.y > Gdx.graphics.getHeight() - circle.radius) {
            speed.y = -speed.y;
        }
    }

    public void draw(ShapeRenderer shape) {
        shape.setColor(color);
        shape.circle(circle.x, circle.y, circle.radius);
    }

    public void checkCollision(Paddle paddle) {
        if (collidesWith(paddle)) {
            speed.y *= -1;
        }
    }

    private boolean collidesWith(Paddle paddle) {
        if ((circle.x - circle.radius) >= paddle.x && (circle.x - circle.radius) <= paddle.x + paddle.width
                || (circle.x + circle.radius) >= paddle.x && (circle.x + circle.radius) <= paddle.x + paddle.width) {
            if (paddle.y <= (circle.y + circle.radius) && paddle.y >= (circle.y - circle.radius)
                    || paddle.y + paddle.height <= (circle.y + circle.radius) && paddle.y + paddle.height >= (circle.y - circle.radius)) {
                return true;
            } else
                return false;
        } else {
            return false;
        }
    }
}