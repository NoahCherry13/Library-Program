package bigBrain;

public class IllegalDate extends Exception{
	public IllegalDate(String message) {
		super("Illegal Date Exception: " + message);
	}
}
