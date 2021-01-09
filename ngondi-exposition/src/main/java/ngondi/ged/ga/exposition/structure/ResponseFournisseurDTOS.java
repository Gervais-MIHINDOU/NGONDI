/**
 * 
 */
package ngondi.ged.ga.exposition.structure;

import java.util.List;

/**
 * @author gmihindou
 *
 */
public class ResponseFournisseurDTOS {

	/**
	 * 
	 */
	public ResponseFournisseurDTOS() {
		super();
		// TODO Auto-generated constructor stub
	}

	private ErrorGed errors;
	List<ResponseFournisseurDTO> fournisseurs;

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

	public ResponseFournisseurDTOS(ErrorGed errors) {
		super();
		this.errors = errors;
	}

	/**
	 * @param fournisseurs
	 */
	public ResponseFournisseurDTOS(List<ResponseFournisseurDTO> fournisseurs) {
		super();
		this.fournisseurs = fournisseurs;
	}

	/**
	 * @return the fournisseurs
	 */
	public List<ResponseFournisseurDTO> getFournisseurs() {
		return fournisseurs;
	}

	/**
	 * @param fournisseurs the fournisseurs to set
	 */
	public void setFournisseurs(List<ResponseFournisseurDTO> fournisseurs) {
		this.fournisseurs = fournisseurs;
	}

}
