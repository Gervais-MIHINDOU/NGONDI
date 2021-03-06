/**
 * 
 */
package ngondi.ged.ga.domain.archivage.structure;

import java.util.List;

/**
 * @author gmihindou
 *
 */
public class FournisseurOuput {
	private String idFournisseur;
	private String nom;
	private String activite;
	private String nif;
	private String rccm;
	private String adresse;
	private String contact;
	private String telephone;
	private String email;
	List<String> idDocuments;
	private StatistiqueFournisseurOutput statistiqueFournisseur;
	
	/**
	 * 
	 * @param idFournisseur
	 * @param nom
	 * @param activite
	 * @param nif
	 * @param rccm
	 * @param adresse
	 * @param contact
	 * @param telephone
	 * @param email
	 * @param idDocuments
	 * @param statistiqueFournisseur
	 */
	public FournisseurOuput(String idFournisseur, String nom, String activite, String nif, String rccm, String adresse,
			String contact, String telephone, String email, List<String> idDocuments,
			StatistiqueFournisseurOutput statistiqueFournisseur) {
		super();
		this.idFournisseur = idFournisseur;
		this.nom = nom;
		this.activite = activite;
		this.nif = nif;
		this.rccm = rccm;
		this.adresse = adresse;
		this.contact = contact;
		this.telephone = telephone;
		this.email = email;
		this.idDocuments = idDocuments;
		this.statistiqueFournisseur = statistiqueFournisseur;
	}
	
	public FournisseurOuput() {
		super();
		// TODO Auto-generated constructor stub
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
	/**
	 * @return the idDocuments
	 */
	public List<String> getIdDocuments() {
		return idDocuments;
	}
	/**
	 * @param idDocuments the idDocuments to set
	 */
	public void setIdDocuments(List<String> idDocuments) {
		this.idDocuments = idDocuments;
	}
	/**
	 * @return the statistiqueFournisseur
	 */
	public StatistiqueFournisseurOutput getStatistiqueFournisseur() {
		return statistiqueFournisseur;
	}
	/**
	 * @param statistiqueFournisseur the statistiqueFournisseur to set
	 */
	public void setStatistiqueFournisseur(StatistiqueFournisseurOutput statistiqueFournisseur) {
		this.statistiqueFournisseur = statistiqueFournisseur;
	}


	
	
	
}
