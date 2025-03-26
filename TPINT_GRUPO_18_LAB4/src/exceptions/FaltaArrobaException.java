package exceptions;

public class FaltaArrobaException extends RuntimeException {
	
	public FaltaArrobaException() 
	{
		
	}

	public String getMessage() {
		return "El mail tiene que tener un arroba @";
	}
	
}
