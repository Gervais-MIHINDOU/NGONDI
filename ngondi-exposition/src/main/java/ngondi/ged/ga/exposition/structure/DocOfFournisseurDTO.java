/**
 * 
 */
package ngondi.ged.ga.exposition.structure;

import java.util.List;

/**
 * @author gmihindou
 *
 */
public class DocOfFournisseurDTO {
	private List<String> idDocuments;
	private String idFournisseur;

	/**
	 * @return the idDocuments
	 */
	public List<String> getIdDocuments() {
		return idDocuments;
	}

	public DocOfFournisseurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DocOfFournisseurDTO(List<String> idDocuments, String idFournisseur) {
		super();
		this.idDocuments = idDocuments;
		this.idFournisseur = idFournisseur;
	}

	/**
	 * @param idDocuments the idDocuments to set
	 */
	public void setIdDocuments(List<String> idDocuments) {
		this.idDocuments = idDocuments;
	}

	/**
	 * @return the idFournisseur
	 */
	public String getIdFournisseur() {
		return idFournisseur;
	}

	/**
	 * @param idFournisseur the idFournisseur to set
	 */
	public void setIdFournisseur(String idFournisseur) {
		this.idFournisseur = idFournisseur;
	}

}
