/**
 * 
 */
package ngondi.ged.ga.exposition.structure;

/**
 * @author gmihindou
 *
 */
public class ResponseDTO {

	private String identifier;
	private ErrorGed errors;

	/**
	 * @param errors
	 */
	public ResponseDTO(ErrorGed errors) {
		super();
		this.errors = errors;
	}

	/**
	 * @return the identifier
	 */
	public String getIdentifier() {
		return identifier;
	}

	/**
	 * @param identifier the identifier to set
	 */
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	/**
	 * @return the errors
	 */
	public ErrorGed getErrors() {
		return errors;
	}

	/**
	 * @param errors the errors to set
	 */
	public void setErrors(ErrorGed errors) {
		this.errors = errors;
	}

	public ResponseDTO(String identifier) {
		super();
		this.identifier = identifier;
	}

	public ResponseDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	

}
