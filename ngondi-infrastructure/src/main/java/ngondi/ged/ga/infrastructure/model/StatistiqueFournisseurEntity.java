package ngondi.ged.ga.infrastructure.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * 
 * @author gmihindou
 *
 */
@Entity(name = "STATISTIQUE")
public class StatistiqueFournisseurEntity {

	@Id
	private String idStatistique;

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

	@Column
	private String respectDesDelais;
	@Column
	private String reactiviteDisponibilite;
	@Column
	private String qualiteConformite;

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
