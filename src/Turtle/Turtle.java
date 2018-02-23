package Turtle;

import GUIBoxes.ScreenBox;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Turtle implements TurtleInterface{
	private ScreenBox screen;
	private Image image;
	private ImageView turtle = new ImageView();
	boolean turtleShowing;
	
	public Turtle(ScreenBox turtle_screen, Image turtle_image) {
		screen = turtle_screen;
		image = turtle_image;
		initalizeTurtle();
	}
	
	private void initalizeTurtle() {
		turtle.setImage(image);
        turtle.setX(585/2);
        turtle.setY(650/2);
        //screen.getChildren().add(turtle);
        turtleShowing = true;
	}

	@Override
	public void move(double diffX, double diffY) {
		turtle.setX(getX() + diffX);
		turtle.setY(getY() + diffY);
	}

	@Override
	public void turn(double degrees) {
		turtle.setRotate(turtle.getRotate() + degrees);
	}

	@Override
	public double getX() {
		return turtle.getX();
	}

	@Override
	public double getY() {
		return turtle.getY();
	}

	@Override
	public double getOrientation() {
		return turtle.getRotate();
	}

	@Override
	public void setPenDown(boolean penDown) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getPenDown() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void setTurtleShowing(boolean should_be_showing) {
		//if (turtleShowing && !should_be_showing)
			//screen.getChildren().remove(turtle);
		//if (!turtleShowing && should_be_showing)
			//screen.getChildren().add(turtle);
	}

	@Override
	public boolean getTurtleShowing() {
		return turtleShowing;
	}
}