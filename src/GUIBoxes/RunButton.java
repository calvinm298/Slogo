package GUIBoxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import Turtle.Turtle;
import commands.Command;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;

public class RunButton extends Buttons {

	private static TextInputBox mainTextInput;
	private static PrevCommandList mainPrevCommandBox;
	private static GUIComboBox mainLanguageComboBox;
	private static String language = "English";

	private Map<String, Double> variableMap;
	private Map<String, Command> userCommandMap;

	public RunButton(Group root, GUIComboBox languageComboBox, double[] properties, String text, TextInputBox textInput,
			PrevCommandList prevCommandBox, ArrayList<Turtle> turtleList, Map<String, Double> variables, Map<String, Command> commands) {
		super(root, properties, text, turtleList);
		mainLanguageComboBox = languageComboBox;
		this.mainTextInput = textInput;
		this.mainPrevCommandBox = prevCommandBox;
		variableMap = variables;
		userCommandMap = commands;
	}

	@Override
	void setupAction() {

		getButton().setOnAction((event) -> {
			mainPrevCommandBox.addText(mainTextInput.getText());
			for (Turtle t : getThisTurtleList()) {

				language = ((LanguageCombo) mainLanguageComboBox).getLanguage();
				Command test = new Command(mainTextInput.getText(), t, variableMap, userCommandMap, language);
				test.execute();
			}
			mainTextInput.clear();

		});
	}

}
