package exceptions;

public class FaltaPuntoException extends RuntimeException {
	
	public FaltaPuntoException()
	{
		
	}

	public String getMessage() {
		return "El mail tiene que tener un punto .";
	}
	
}
