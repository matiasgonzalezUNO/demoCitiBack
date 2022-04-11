package ar.com.itrsa.demoCitiBackEnd.exception;

public class BadRequestException extends Exception{
	
	private static final long serialVersionUID = 1L;
	
	public BadRequestException(String errorMessage) {
		super(errorMessage);
	}
	
	public BadRequestException(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}

}
