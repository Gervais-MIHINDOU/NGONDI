/**
 * 
 */
package ngondi.ged.ga.domain.archivage.structure;

/**
 * @author gmihindou
 *
 */
public class StatistiqueFournisseur {

	public StatistiqueFournisseur() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StatistiqueFournisseur(String idStatistique, String respectDesDelais, String reactiviteDisponibilite,
			String qualiteConformite) {
		super();
		this.idStatistique = idStatistique;
		this.respectDesDelais = respectDesDelais;
		this.reactiviteDisponibilite = reactiviteDisponibilite;
		this.qualiteConformite = qualiteConformite;
	}

	private String idStatistique;

	private String respectDesDelais;

	private String reactiviteDisponibilite;

	/**
	 * @return the idStatistique
	 */
	public String getIdStatistique() {
		return idStatistique;
	}

	/**
	 * @param idStatistique the idStatistique to set
	 */
	public void setIdStatistique(String idStatistique) {
		this.idStatistique = idStatistique;
	}

	/**
	 * @return the respectDesDelais
	 */
	public String getRespectDesDelais() {
		return respectDesDelais;
	}

	/**
	 * @param respectDesDelais the respectDesDelais to set
	 */
	public void setRespectDesDelais(String respectDesDelais) {
		this.respectDesDelais = respectDesDelais;
	}

	/**
	 * @return the reactiviteDisponibilite
	 */
	public String getReactiviteDisponibilite() {
		return reactiviteDisponibilite;
	}

	/**
	 * @param reactiviteDisponibilite the reactiviteDisponibilite to set
	 */
	public void setReactiviteDisponibilite(String reactiviteDisponibilite) {
		this.reactiviteDisponibilite = reactiviteDisponibilite;
	}

	/**
	 * @return the qualiteConformite
	 */
	public String getQualiteConformite() {
		return qualiteConformite;
	}

	/**
	 * @param qualiteConformite the qualiteConformite to set
	 */
	public void setQualiteConformite(String qualiteConformite) {
		this.qualiteConformite = qualiteConformite;
	}

	private String qualiteConformite;
}
