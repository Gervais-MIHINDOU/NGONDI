/**
 * 
 */
package ngondi.ged.ga.domain.archivage;

import java.util.Map;

/**
 * @author gmihindou
 *
 */
public class FournisseurException extends Exception {
	/**
	 * 
	 */
	private static final long serialVersionUID = -6456483381816224706L;
	private Map<String, String> errors;

	/**
	 * @return the errors
	 */
	public Map<String, String> getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(Map<String, String> errors) {
		this.errors = errors;
	}

	public FournisseurException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public FournisseurException(Map<String, String> errors) {
		super();
		this.errors = errors;
	}

	public FournisseurException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public FournisseurException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public FournisseurException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public FournisseurException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}
}
