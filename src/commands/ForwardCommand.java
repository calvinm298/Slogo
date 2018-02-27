package commands;
import java.util.List;

import Turtle.Turtle;

public class ForwardCommand extends Command{
     private int numberOfParameters = 1;

   @Override
   public double execute(List<CommandNode> children, Turtle t){
	   CommandNode child = children.get(0);
	   double step = child.execute(t);
	   t.move(0, step);
	   return step;
   }

   @Override
	public int getNumberOfParameters() {
		return numberOfParameters;
	}

}
