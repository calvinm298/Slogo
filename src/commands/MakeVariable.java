package commands;

import java.util.List;

import java.util.Map;
/**
 * Implements functionality for Make Command
 *
 */
import Turtle.Turtle;

/**
 * This class handles the creation of user defined variables.
 * @author milestodzo
 *
 */

public class MakeVariable extends Command{

	private final int numberOfParameters = 1;
	private Map<String, Double> myMap;
	private String myName;

	public MakeVariable(String name, Map<String,Double> variables) {
		myMap = variables;
		myName = name;
	}

	/* (non-Javadoc)
	 * @see commands.Command#execute(java.util.List, Turtle.Turtle)
	 */
	@Override
	double execute(List<CommandNode> children, Turtle t){
		Double myValue = children.get(0).execute(t);
		myMap.put(myName, myValue);
		return myValue;

	}

	/* (non-Javadoc)
	 * @see commands.Command#getNumberOfParameters()
	 */
	@Override
	int getNumberOfParameters() {
		return numberOfParameters;
	}
}
