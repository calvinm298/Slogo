package GUIBoxes;

import javafx.beans.property.BooleanProperty;
import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleDoubleProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class TurtleListInsertion {
	private BooleanProperty active = new SimpleBooleanProperty();
	private StringProperty id = new SimpleStringProperty();
	private StringProperty xpos = new SimpleStringProperty();
	private StringProperty ypos = new SimpleStringProperty();
	private StringProperty heading = new SimpleStringProperty();
	private BooleanProperty pen_status = new SimpleBooleanProperty();
	private StringProperty pen_color = new SimpleStringProperty();
	private StringProperty pen_thickness = new SimpleStringProperty();
	
	public TurtleListInsertion(boolean active, int id, double xpos, double ypos, double heading, boolean pen, 
			String pen_color, double pen_thickness) {
		this.setActive(active);
		this.setId(id);
		this.setXpos(xpos);
		this.setYpos(ypos);
		this.setHeading(heading);
		this.setPenActive(pen);
		this.setPenColor(pen_color);
		this.setPenThickness(pen_thickness);
	}
	
	public BooleanProperty isActive() {
		return active;
	}
	
	public void setActive(boolean active) {
		this.active.set(active);
	}

	public StringProperty getId() {
		return id;
	}

	public void setId(int id) {
		this.id.set(Integer.toString(id));
	}

	public StringProperty getXpos() {
		return xpos;
	}

	public void setXpos(double xpos) {
		this.xpos.set(Double.toString(xpos));
	}

	public StringProperty getYpos() {
		return ypos;
	}

	public void setYpos(double ypos) {
		this.ypos.set(Double.toString(ypos));
	}

	public StringProperty getHeading() {
		return heading;
	}

	public void setHeading(double heading) {
		this.heading.set(Double.toString(heading));
	}

	public BooleanProperty isPenActive() {
		return pen_status;
	}

	public void setPenActive(boolean pen_status) {
		this.pen_status.set(pen_status);
	}

	public StringProperty getPenColor() {
		return pen_color;
	}

	public void setPenColor(String pen_color) {
		this.pen_color.set(pen_color);
	}

	public StringProperty getPenThickness() {
		return pen_thickness;
	}

	public void setPenThickness(double pen_thickness) {
		this.pen_thickness.set(Double.toString(pen_thickness));
	}
}