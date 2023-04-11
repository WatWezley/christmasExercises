package turtle;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static turtle.Direction.*;
import static org.junit.jupiter.api.Assertions.*;

public class TurtleTest {

    Turtle turtle;
        @BeforeEach
        void setUp(){
            turtle = new Turtle();
        }

        @Test
        public void turtleCanMovePenDownTest(){
            assertTrue(turtle.penIsUp());
            turtle.penIsDown();
            assertFalse(turtle.penIsUp());
        }

        @Test
        public void turtleCanMovePenUpTest(){
            turtle.penIsDown();
            assertFalse(turtle.penIsUp());
            turtle.penUp();
            assertTrue(turtle.penIsUp());
        }

       @Test
    public void turtleCanTurnRightWhileFacingEastTest(){

        assertSame(EAST, turtle.getCurrentDirection());
        turtle.turnRight();
        assertSame(SOUTH, turtle.getCurrentDirection());

    }
    @Test
    public void turtleCanTurnRightWhileFacingSouthTest(){
        turtle.turnRight();
        assertSame(SOUTH, turtle.getCurrentDirection());
        turtle.turnRight();
        assertSame(WEST, turtle.getCurrentDirection());
 }
    @Test
        public void turtleCanTurnRightWhileFacingWestTest(){
            turtle.turnRight();
            assertSame(SOUTH,turtle.getCurrentDirection());
            turtle.turnRight();
            assertSame(WEST,turtle.getCurrentDirection());
            turtle.turnRight();
            assertSame(NORTH, turtle.getCurrentDirection());
        }
        @Test
        public void turtleCanTurnRightWhileFacingNorthTest(){
            turtle.turnRight();
            assertSame(SOUTH,turtle.getCurrentDirection());
            turtle.turnRight();
            assertSame(WEST, turtle.getCurrentDirection());
            turtle.turnRight();
            assertSame(NORTH, turtle.getCurrentDirection());
            turtle.turnRight();
            assertSame(EAST, turtle.getCurrentDirection());
        }

        @Test
        public void turtleCanTurnLeftWhileFacingEastTest(){
            assertSame(EAST,turtle.getCurrentDirection());
            turtle.turnLeft();
            assertSame(NORTH, turtle.getCurrentDirection());
        }

        @Test
        public void turtleCanTurnLeftWhileFacingNorthTest(){
            assertSame( EAST,turtle.getCurrentDirection());
            turtle.turnLeft();
            assertSame(NORTH, turtle.getCurrentDirection());
            turtle.turnLeft();
            assertSame(WEST, turtle.getCurrentDirection());

        }

    @Test
    public void turtleCanTurnLeftWhileFacingWestTest(){
        assertSame( EAST,turtle.getCurrentDirection());
        turtle.turnLeft();
        assertSame(NORTH, turtle.getCurrentDirection());
        turtle.turnLeft();
        assertSame(WEST, turtle.getCurrentDirection());
        turtle.turnLeft();
        assertSame(SOUTH, turtle.getCurrentDirection());
        }


        @Test
        public void turtleCanMoveForwardWhileFacingEastTest(){
            assertSame(EAST,turtle.getCurrentDirection());
            assertEquals(new Position(0,0), turtle.getPosition());
            turtle.moveForward(5);
            assertEquals(new Position(0,5), turtle.getPosition());
        }

        @Test
        public void turtleCanMoveForwardWhileFacingSouthTest(){
            assertSame(EAST,turtle.getCurrentDirection());
            turtle.turnRight();
            assertSame(SOUTH, turtle.getCurrentDirection());
            assertEquals(new Position(0,0), turtle.getPosition());
            turtle.moveForward(5);
            assertEquals(new Position(0,5), turtle.getPosition());
        }
        @Test
        public void turtleCanMoveForwardWhileFacingWestTest(){
            assertSame(EAST,turtle.getCurrentDirection());
            turtle.moveForward(10);
            assertEquals(new Position(0,10), turtle.getPosition());
            turtle.turnRight();
            assertSame(SOUTH, turtle.getCurrentDirection());
            turtle.turnRight();
            assertSame(WEST, turtle.getCurrentDirection());
            turtle.moveForward(5);
            assertEquals(new Position(0,5), turtle.getPosition());
    }
    }
