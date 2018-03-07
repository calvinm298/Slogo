package GUIBoxes;

import java.util.ArrayList;

import Turtle.Turtle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.control.Button;
import javafx.scene.control.Tab;
import javafx.scene.layout.Pane;

public abstract class Buttons {
	
	private Pane thisPane;
	private String buttonText;
	private Button thisButton;
	private static ArrayList<Turtle> thisTurtleList;
	
	public Buttons(Pane pane, double[] properties, String text, ArrayList<Turtle> turtleList) {
		setButton(new Button(text));
		thisPane = pane;
		setThisTurtleList(turtleList);
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		setupAction();
		thisPane.getChildren().add(thisButton);
	}
	


	abstract void setupAction();

	private void setupProperties(double xPos, double yPos, double width, double height) {
		getButton().setLayoutX(xPos);
		getButton().setLayoutY(yPos);
		getButton().setMinWidth(width);		
		getButton().setMinHeight(height);
	}



	protected Button getButton() {
		return thisButton;
	}



	protected void setButton(Button runButton) {
		this.thisButton = runButton;
	}



	protected static ArrayList<Turtle> getThisTurtleList() {
		return thisTurtleList;
	}



	protected static void setThisTurtleList(ArrayList<Turtle> thisTurtleList) {
		Buttons.thisTurtleList = thisTurtleList;
	}
}