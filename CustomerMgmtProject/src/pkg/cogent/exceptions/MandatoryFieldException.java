package pkg.cogent.exceptions;

public class MandatoryFieldException extends RuntimeException {
	private String errorMessage;
	public MandatoryFieldException(String errorMessage) {
		super(errorMessage);
		this.errorMessage = errorMessage;
	}

}
