/**
 * 
 */
package ngondi.ged.ga.domain.archivage.structure;

/**
 * @author gmihindou
 *
 */
public class StatistiqueFournisseurOutput {
	private String respectDesDelais;
	private String reactiviteDisponibilite;
	private String qualiteConformite;
	
	public StatistiqueFournisseurOutput() {
		super();
		// TODO Auto-generated constructor stub
	}
	public StatistiqueFournisseurOutput(String respectDesDelais, String reactiviteDisponibilite,
			String qualiteConformite) {
		super();
		this.respectDesDelais = respectDesDelais;
		this.reactiviteDisponibilite = reactiviteDisponibilite;
		this.qualiteConformite = qualiteConformite;
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
}
