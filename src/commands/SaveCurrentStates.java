package commands;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

import commands.Command;

public class SaveCurrentStates {
	private Map<String, Double> myVariables;
	private Map<String, Command> myCommands;
	private BufferedWriter writer = null;
	private Set<String> keys1; 
	private Set<String> keys2;

	public SaveCurrentStates(Map<String, Double> variables, Map<String, Command> commands) {
		myVariables=variables;
		myCommands = commands;
		keys1 =	myVariables.keySet();
		keys2 =	myCommands.keySet();
	}

	public void exportFile() {
		try {
			String myName = "data"+Math.round(Math.random()*100);
			File dataFile = new File(myName);
			writer = new BufferedWriter(new FileWriter(dataFile));
			for(String s : keys1) {
				writer.write(s+" "+"="+" "+myVariables.get(s)+"\n");
			}
			for(String s1 : keys2) {
				System.out.println("here I am in exportFile2");
				writer.write(s1+" "+"="+" "+myCommands.get(s1)+"\n");
			}
		}
		catch(Exception e) {
			System.out.println("Something is wrong with the writer or variables");
		}
		finally {
			try {
				writer.close();
			} catch (Exception e) {
            System.out.println("Exception caught when closing the writer");
			}

		}
	}
	
}