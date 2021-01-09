package ngondi.ged.ga.exposition.structure;

import java.util.List;

/**
 * 
 * @author gmihindou
 *
 */
public class ResponseDocumentsDTOS {

	private List<ResponseDocumentDTO> responseDocuments;

	private ErrorGed errors;

	/**
	 * @return the responseDocuments
	 */
	public List<ResponseDocumentDTO> getResponseDocuments() {
		return responseDocuments;
	}

	/**
	 * @param responseDocuments the responseDocuments to set
	 */
	public void setResponseDocuments(List<ResponseDocumentDTO> responseDocuments) {
		this.responseDocuments = responseDocuments;
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

}
