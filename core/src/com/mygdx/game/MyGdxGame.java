package com.mygdx.game;

import java.util.ArrayList;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.graphics.GL20;

public class MyGdxGame extends ApplicationAdapter {
    ShapeRenderer shape;
    Ball ball;
    Paddle paddle;
    ArrayList<Block> blocks = new ArrayList<>();

    @Override
    public void create() {
        Gdx.graphics.setForegroundFPS(120);
        shape = new ShapeRenderer();
        ball = new Ball(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() / 3, 5, 3, 3);
        paddle = new Paddle(100);
        int blockWidth = 63;
        int blockHeight = 20;
        for (int y = Gdx.graphics.getHeight() / 2; y < Gdx.graphics.getHeight(); y += blockHeight + 10) {
            for (int x = 0; x < Gdx.graphics.getWidth(); x += blockWidth + 10) {
                blocks.add(new Block(x, y, blockWidth, blockHeight));
            }
        }
    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        paddle.update();
        ball.update();
        ball.checkCollision(paddle);
        shape.begin(ShapeRenderer.ShapeType.Filled);
        for (Block block : blocks) {
            block.draw(shape);
            block.checkCollision(ball);
        }
        for (int i = 0; i < blocks.size(); i++) {
            Block b = blocks.get(i);
            if (b.isHit) {
                blocks.remove(b);
                // we need to decrement i when a ball gets removed, otherwise we skip a ball!
                i--;
            }
        }
        ball.draw(shape);
        paddle.draw(shape);
        shape.end();
    }

}
