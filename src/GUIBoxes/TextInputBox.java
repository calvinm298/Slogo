package GUIBoxes;

import javafx.scene.Node;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Pane;

public class TextInputBox {

	private TextArea textInput;
	private Pane thisPane;

	public TextInputBox(Pane pane, double[] properties) {
		textInput = new TextArea();
		thisPane = pane;
		setupProperties(properties[0], properties[1], properties[2], properties[3]);
		thisPane.getChildren().add(textInput);
	}

	private void setupProperties(double xPos, double yPos, double width, double height) {
		textInput.setLayoutX(xPos);
		textInput.setLayoutY(yPos);
		textInput.setMinWidth(width);
		textInput.setMaxWidth(width);
		textInput.setMinHeight(height);
		textInput.setMaxHeight(height);

	}

	public String getText() {
		return textInput.getText();
	}

	public void clear() {
		textInput.clear();
	}


	public Node getTextArea() {
		return textInput;
	}

	public void setText(String currentItemSelected) {
		textInput.setText(currentItemSelected);		
	}


}
