package pingamesapi.service.exceptions;

public class LibraryHasGameException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public LibraryHasGameException (String msg) {
		super(msg);
	}
}
