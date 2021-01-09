/**
 * 
 */
package ngondi.ged.ga.exposition.structure;

/**
 * @author gmihindou
 *
 */
public class FournisseurDTO {
	private String nom;
	private String activite;
	private String nif;
	private String rccm;
	private String adresse;
	private String contact;
	private String telephone;
	private String email;

	/**
	 * 
	 * @param nom
	 * @param activite
	 * @param nif
	 * @param rccm
	 * @param adresse
	 * @param contact
	 * @param telephone
	 * @param email
	 */
	public FournisseurDTO(String nom, String activite, String nif, String rccm, String adresse, String contact,
			String telephone, String email) {
		super();
		this.nom = nom;
		this.activite = activite;
		this.nif = nif;
		this.rccm = rccm;
		this.adresse = adresse;
		this.contact = contact;
		this.telephone = telephone;
		this.email = email;
	}

	/**
	 * 
	 */
	public FournisseurDTO() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the activite
	 */
	public String getActivite() {
		return activite;
	}

	/**
	 * @param activite the activite to set
	 */
	public void setActivite(String activite) {
		this.activite = activite;
	}

	/**
	 * @return the nif
	 */
	public String getNif() {
		return nif;
	}

	/**
	 * @param nif the nif to set
	 */
	public void setNif(String nif) {
		this.nif = nif;
	}

	/**
	 * @return the rccm
	 */
	public String getRccm() {
		return rccm;
	}

	/**
	 * @param rccm the rccm to set
	 */
	public void setRccm(String rccm) {
		this.rccm = rccm;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	/**
	 * @return the contact
	 */
	public String getContact() {
		return contact;
	}

	/**
	 * @param contact the contact to set
	 */
	public void setContact(String contact) {
		this.contact = contact;
	}

	/**
	 * @return the telephone
	 */
	public String getTelephone() {
		return telephone;
	}

	/**
	 * @param telephone the telephone to set
	 */
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

}
