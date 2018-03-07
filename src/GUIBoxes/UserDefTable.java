package GUIBoxes;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Group;
import javafx.scene.control.Tab;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableColumn.CellEditEvent;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.cell.TextFieldTableCell;
import javafx.scene.layout.Pane;

public class UserDefTable extends TableView implements GUIBoxes {

	private TableView table;

	private static Pane thisPane;
	private final static int NAMECOLWIDTH = 65;
	private final static int VALCOLWIDTH = 133;
	private String tableType;
	
	public UserDefTable(Pane pane, double[] properties, String type) {
		thisPane = pane;
		tableType = type;
		table = new TableView<>();
		setupTableProperties(properties[0], properties[1], properties[2], properties[3]);
		setupTableColumns();
		thisPane.getChildren().add(table);
	}

	private void setupTableColumns() {
		table.setEditable(true);
		TableColumn<TableInsertion, String> nameCol = new TableColumn(tableType);
		nameCol.setCellValueFactory(new PropertyValueFactory("VarName"));
		nameCol.setMinWidth(NAMECOLWIDTH);
		nameCol.setMaxWidth(NAMECOLWIDTH);
		nameCol.setResizable(false);

		TableColumn<TableInsertion, String> valCol = new TableColumn("Value");
		valCol.setMinWidth(VALCOLWIDTH);
		valCol.setResizable(false);
		valCol.setEditable(true);

		valCol.setCellValueFactory(new PropertyValueFactory("Value"));

		valCol.setCellFactory(TextFieldTableCell.<TableInsertion>forTableColumn());
		valCol.setOnEditCommit((CellEditEvent<TableInsertion, String> t) -> {
			((TableInsertion) t.getTableView().getItems().get(t.getTablePosition().getRow())).setValue(t.getNewValue());
			//System.out.println("ugyfcyvghbk");
		});

		ObservableList<TableInsertion> data1 = FXCollections.observableArrayList(new TableInsertion("x", "90"), new TableInsertion("x", "180"));
		table.setItems(data1);

		table.getColumns().addAll(nameCol, valCol);
	}

	private void setupTableProperties(double xPos, double yPos, double width, double height) {
		table.setEditable(false);
		table.setLayoutX(xPos);
		table.setLayoutY(yPos);
		table.setMaxWidth(width);
		table.setMaxHeight(height);
	}

	public void updateBox() {
//		root.getChildren().remove(table);
//		root.getChildren().add(table);
	}

}
