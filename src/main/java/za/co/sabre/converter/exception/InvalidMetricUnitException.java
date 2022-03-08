package za.co.sabre.converter.exception;

public class InvalidMetricUnitException extends IllegalArgumentException
{
	private String errorCode;
	private String message;

	public InvalidMetricUnitException(  )
	{
	}

	public InvalidMetricUnitException( String errorCode, String message )
	{
		super( message );
		this.errorCode = errorCode;
		this.message = message;
	}

	public String getErrorCode()
	{
		return errorCode;
	}

	public void setErrorCode( String errorCode )
	{
		this.errorCode = errorCode;
	}

	@Override
	public String getMessage()
	{
		return message;
	}

	public void setMessage( String message )
	{
		this.message = message;
	}
}
