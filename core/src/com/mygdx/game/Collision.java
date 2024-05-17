package com.mygdx.game;

import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;

public class Collision {
    public static boolean intersects(Rectangle rect, Circle circle) {
        Vector2 center = rect.getCenter(new Vector2());

        double circleDistanceX = Math.abs(circle.x - center.x);
        double circleDistanceY = Math.abs(circle.y - center.y);

        if (circleDistanceX > (rect.width / 2 + circle.radius)) {
            return false;
        }
        if (circleDistanceY > (rect.height / 2 + circle.radius)) {
            return false;
        }

        if (circleDistanceX <= (rect.width / 2)) {
            return true;
        }
        if (circleDistanceY <= (rect.height / 2)) {
            return true;
        }

        double cornerDistanceSq = Math.pow(circleDistanceX - rect.width / 2 , 2) +
                Math.pow(circleDistanceY - rect.height / 2 , 2);

        return (cornerDistanceSq <= Math.pow(circle.radius , 2));
    }
}
