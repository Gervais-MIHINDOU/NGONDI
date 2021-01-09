/**
 * 
 */
package ngondi.ged.ga.infrastructure.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.CollectionTable;
import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * @author gmihindou
 *
 */
@Entity(name = "FOURNISSEUR")
public class FournisseurEntity implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name = "idFournisseur")
	private String idFournisseur;
	@Column
	private String nom;
	@Column
	private String activite;
	@Column
	private String nif;
	@Column
	private String rccm;
	@Column
	private String adresse;
	@Column
	private String contact;
	@Column
	private String telephone;
	@Column
	private String email;
	@ElementCollection(fetch = FetchType.EAGER, targetClass = String.class)
	@CollectionTable(name = "fournisseur_document", joinColumns = @JoinColumn(name = "id_Fourournisseur"))
	@Column(name = "id_document")
	private List<String> idDocument = new ArrayList<String>();

	@ManyToOne(cascade = { CascadeType.ALL })
	private StatistiqueFournisseurEntity statistiqueFournisseur;

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
	 * @return the idDocument
	 */
	public List<String> getIdDocument() {
		return idDocument;
	}

	/**
	 * @param idDocument the idDocument to set
	 */
	public void setIdDocument(List<String> idDocument) {
		this.idDocument = idDocument;
	}

	/**
	 * @return the statistiqueFournisseur
	 */
	public StatistiqueFournisseurEntity getStatistiqueFournisseur() {
		return statistiqueFournisseur;
	}

	/**
	 * @param statistiqueFournisseur the statistiqueFournisseur to set
	 */
	public void setStatistiqueFournisseur(StatistiqueFournisseurEntity statistiqueFournisseur) {
		this.statistiqueFournisseur = statistiqueFournisseur;
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
