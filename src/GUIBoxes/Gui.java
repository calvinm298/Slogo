package GUIBoxes;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

import Turtle.Turtle;
import commands.Command;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Gui {

	private final static double SCREEN_HEIGHT = 600;
	private final static double SCREEN_WIDTH = 1215;// 915;
	private final static String MOVEFORWARDCOMMAND = "fd 20";
	private final static String MOVEBACKCOMMAND = "bk 20";
	private final static String TURNRIGHTCOMMAND = "rt 30";
	private final static String TURNLEFTCOMMAND = "lt 30";
	private final static String BACKGROUNDCOMBOLABEL = "Change Background Color";
	private static final String PENCOMBOLABEL = "Change Pen Color";
	private static final String FUNCTABLELABEL = "Function";
	private static final String VARTABLELABEL = "Variable";
	private static final String LANGUAGECOMBOLABEL = "Change Language";
	private static final String RUNBUTTONLABEL = "Run";
	private static final String CLEARBUTTONLABEL = "Clear";
	private static final String CHANGEIMAGELABEL = "Change Turtle Image";
	private static final String NEWTURTLELABEL = "New Turtle";
	private static final String REDOMOVELABEL = "Undo";
	private static final String MOVEFORWARDLABEL = "Move Forward";
	private static final String MOVEBACKLABEL = "Move Back";
	private static final String TURNRIGHTLABEL = "Turn\nRight";
	private static final String TURNLEFTLABEL = "Turn\nLeft";
	private final Map<String, double[]> GUIProperties = createMap();

	private TextInputBox textInput;
	private ScreenBox turtleScreen;
	private GUIComboBox languageComboBox;
	private PrevCommandList prevCommandBox;
	private ArrayList<Turtle> turtleList;
	private UserDefTable varTable;
	private UserDefTable funcTable;
	private TurtleViewTable turtleTable;

	public static final String DEFAULT_RESOURCES = "GUIBoxes/resources/ViewLocations";

	private ResourceBundle myResources;

	// Additional setup for the main menu
	private Group root;
	private Stage myStage;
	private Map<String, Double> variableMap;
	private Map<String, Command> commandMap;
	private Pane myPane;

	public Gui(Group root, Stage stage) {
		variableMap = new HashMap<>();
		commandMap = new HashMap<>();
		turtleList = new ArrayList<>();
		this.root = root;
		myStage = stage;
		myPane = new Pane();
		myPane.setMinHeight(SCREEN_HEIGHT);
		myPane.setMinWidth(SCREEN_WIDTH);
		initializeGUI();
	}

	private double[] readResourceFile(String s) {
		return new double[] { Double.parseDouble(myResources.getString(s).split(",")[0]),
				Double.parseDouble(myResources.getString(s).split(",")[1]),
				Double.parseDouble(myResources.getString(s).split(",")[2]),
				Double.parseDouble(myResources.getString(s).split(",")[3]) };
	}

	private Map<String, double[]> createMap() {
		myResources = ResourceBundle.getBundle(DEFAULT_RESOURCES);
		Map<String, double[]> GUIProperties = new HashMap<>();
		// first index = xPos, second = yPos, third = width, fourth = length

		GUIProperties.put("turtleScreen", readResourceFile("turtleScreen"));
		GUIProperties.put("textInput", readResourceFile("textInput"));

		GUIProperties.put("varTable", readResourceFile("varTable"));
		GUIProperties.put("funcTable", readResourceFile("funcTable"));

		GUIProperties.put("prevCommandBox", readResourceFile("prevCommandBox"));

		GUIProperties.put("backgroundCombo", readResourceFile("backgroundCombo"));
		GUIProperties.put("languageCombo", readResourceFile("languageCombo"));
		GUIProperties.put("penCombo", readResourceFile("penCombo"));

		GUIProperties.put("imageButton", readResourceFile("imageButton"));
		GUIProperties.put("runButton", readResourceFile("runButton"));
		GUIProperties.put("clearButton", readResourceFile("clearButton"));
		GUIProperties.put("newTurtleButton", readResourceFile("newTurtleButton"));

		GUIProperties.put("redoMoveButton", readResourceFile("redoMoveButton"));

		GUIProperties.put("turtleList", readResourceFile("turtleList"));

		GUIProperties.put("moveForwardButton", readResourceFile("moveForwardButton"));
		GUIProperties.put("moveBackButton", readResourceFile("moveBackButton"));
		GUIProperties.put("turnRightButton", readResourceFile("turnRightButton"));
		GUIProperties.put("turnLeftButton", readResourceFile("turnLeftButton"));

		return GUIProperties;
	}

	public void initializeGUI() {

		setupGUIBoxes();
		setupComboboxes();
		setupButtons();
	}

	private void setupComboboxes() {

		new BackgroundCombo(myPane, turtleScreen, GUIProperties.get("backgroundCombo"), BACKGROUNDCOMBOLABEL);
		new PenCombo(myPane, turtleList, GUIProperties.get("penCombo"), PENCOMBOLABEL);

	}

	private void setupGUIBoxes() {

		textInput = new TextInputBox(myPane, GUIProperties.get("textInput"));
		turtleScreen = new ScreenBox(myPane, GUIProperties.get("turtleScreen"), turtleList);
		Image image = new Image(getClass().getClassLoader().getResourceAsStream("images/turtle.png"), 0, 55, true,
				false);
		Turtle turtle = new Turtle(turtleScreen, image);

		turtleList.add(turtle);

		System.out.println(turtleList);

		varTable = new VariableTable(myPane, GUIProperties.get("varTable"), VARTABLELABEL, variableMap);
		funcTable = new CommandTable(myPane, GUIProperties.get("funcTable"), FUNCTABLELABEL);
		languageComboBox = new LanguageCombo(myPane, GUIProperties.get("languageCombo"), LANGUAGECOMBOLABEL);

		turtleTable = new TurtleViewTable(myPane, GUIProperties.get("turtleList"), turtleList);

		prevCommandBox = new PrevCommandList(myPane, GUIProperties.get("prevCommandBox"), textInput, turtleList,
				variableMap, commandMap, languageComboBox, turtleTable);

	}

	private void setupButtons() {
		new RunButton(myPane, languageComboBox, GUIProperties.get("runButton"), RUNBUTTONLABEL, textInput,
				prevCommandBox, turtleList, variableMap, commandMap, varTable, funcTable, turtleTable);

		new ClearButton(myPane, GUIProperties.get("clearButton"), CLEARBUTTONLABEL, textInput, prevCommandBox,
				turtleList);

		new ChangeImageButton(myPane, GUIProperties.get("imageButton"), CHANGEIMAGELABEL, turtleScreen, myStage,
				turtleList);

		new NewTurtleButton(myPane, GUIProperties.get("newTurtleButton"), NEWTURTLELABEL, turtleScreen, myStage,
				turtleList, turtleTable);

		new RedoMoveButton(myPane, GUIProperties.get("redoMoveButton"), REDOMOVELABEL, turtleScreen, myStage,
				turtleList);

		new MoveButton(myPane, GUIProperties.get("moveForwardButton"), MOVEFORWARDLABEL, turtleList, languageComboBox,
				turtleTable, MOVEFORWARDCOMMAND);

		new MoveButton(myPane, GUIProperties.get("moveBackButton"), MOVEBACKLABEL, turtleList, languageComboBox,
				turtleTable, MOVEBACKCOMMAND);

		new MoveButton(myPane, GUIProperties.get("turnRightButton"), TURNRIGHTLABEL, turtleList, languageComboBox,
				turtleTable, TURNRIGHTCOMMAND);

		new MoveButton(myPane, GUIProperties.get("turnLeftButton"), TURNLEFTLABEL, turtleList, languageComboBox,
				turtleTable, TURNLEFTCOMMAND);

	}

	public Pane getPane() {
		return myPane;
	}
}
