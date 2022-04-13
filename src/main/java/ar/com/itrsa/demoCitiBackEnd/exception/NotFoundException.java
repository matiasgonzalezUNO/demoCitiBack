package ar.com.itrsa.demoCitiBackEnd.exception;

public class NotFoundException extends Exception {
	
	private static final long serialVersionUID = 1L;
	
	public NotFoundException(String errorMessage) {
		super(errorMessage);
	}
	
	public NotFoundException(String errorMessage, Throwable error) {
		super(errorMessage, error);
	}

}
