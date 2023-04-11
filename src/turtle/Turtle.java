package turtle;

import static turtle.Direction.*;

public class Turtle {

    private boolean penIsUp = true;
    private Direction direction = EAST;
    private Position position = new Position(0,0);
    public boolean penIsUp() {
        return penIsUp;
    }

    public void penIsDown() {
        penIsUp = false;
    }

    public void penUp() {
        penIsUp = true;
    }

    public Direction getCurrentDirection() {
        return direction;
    }

    public void turnRight() {
        if(direction == EAST) face(SOUTH);
        else if(direction == SOUTH) face(WEST);
        else if(direction == WEST) face(NORTH);
        else if(direction == NORTH) face(EAST);
    }

    private void face(Direction direction) {
        this.direction = direction;
    }

    public void turnLeft() {
        if(direction == EAST) face(NORTH);
        else if(direction == NORTH) face(WEST);
        else  if(direction == WEST) face(SOUTH);
        else  if(direction == SOUTH) face(EAST);
    }


    public void moveForward(int i) {
        if(direction == EAST){
            position.setColumn(position.getColumn()+i);}
        else if (direction == SOUTH){
            position.setRow(position.getRow()+i);}
        else if (direction == WEST){
            position.setColumn(position.getColumn()-i);}
        else if (direction == NORTH){
            position.setRow(position.getRow()-1);}

        }




    public Position getPosition() {
        return position;
    }
}
