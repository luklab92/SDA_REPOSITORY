package pl.sda.programowanie2_prework;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class Point2DTest {
    Point2D first;

    @BeforeEach
    private void setup(){
    first = new Point2D(5,10);
    }

    @Test
    void getDistanceFromCenterRound() {
        assertEquals(11,Math.round(first.getDistanceFromCenter()));
    }
    @Test
    void getDistanceFromCenter2ParseInt() {
        assertEquals(11,(int)first.getDistanceFromCenter());
    }

    @Test
    void getDistanceFromPoint() {
        assertEquals(5,first.getDistanceFromPoint(new Point2D(5,5)));
    }

    @Test
    void getDistanceFromTheSamePoint() {
        assertEquals(0,first.getDistanceFromPoint(new Point2D(5,10)));
    }

    @Test
    void getDistanceFromCenter() {
        assertEquals(11,(int)first.getDistanceFromPoint(new Point2D(0,0)));
    }

    @Test
    void move() {
        first.move(5,5);
        assertEquals(10,first.getX());
        assertEquals(15,first.getY());
    }

    @Test
    void moveNotMove() {
        first.move(0,0);
        assertEquals(5,first.getX());
        assertEquals(10,first.getY());
    }

    @Test
    void moveBack() {
        first.move(-5,-5);
        assertEquals(0,first.getX());
        assertEquals(5,first.getY());
    }

    @Test
    void moveToCenter() {
        first.move(-5,-10);
        assertEquals(0,first.getX());
        assertEquals(0,first.getY());
    }

}