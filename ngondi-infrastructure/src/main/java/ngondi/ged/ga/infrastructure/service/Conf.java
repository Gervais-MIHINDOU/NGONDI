/**
 * 
 */
package ngondi.ged.ga.infrastructure.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

/**
 * @author gmihindou
 *
 */
@Configuration
@PropertySource("classpath:application.properties")
public class Conf {

	@Value("${CODE.ERROR.DOCUMENT}")
	private String codeMissingDoc;

	@Value("${MESSAGE.ERROR.DOCUMENT}")
	private String messageMissingDoc;
	
	/**
	 * @return the codeMissingFournisseur
	 */
	public String getCodeMissingFournisseur() {
		return codeMissingFournisseur;
	}

	/**
	 * @param codeMissingFournisseur the codeMissingFournisseur to set
	 */
	public void setCodeMissingFournisseur(String codeMissingFournisseur) {
		this.codeMissingFournisseur = codeMissingFournisseur;
	}

	/**
	 * @return the messageMissingFournisseur
	 */
	public String getMessageMissingFournisseur() {
		return messageMissingFournisseur;
	}

	/**
	 * @param messageMissingFournisseur the messageMissingFournisseur to set
	 */
	public void setMessageMissingFournisseur(String messageMissingFournisseur) {
		this.messageMissingFournisseur = messageMissingFournisseur;
	}

	@Value("${CODE.ERROR.FOURNISSEUR}")
	private String codeMissingFournisseur;
	@Value("${MESSAGE.ERROR.FOURNISSEUR}")
	private String messageMissingFournisseur;

	/**
	 * @return the codeMissingDoc
	 */
	public String getCodeMissingDoc() {
		return codeMissingDoc;
	}

	/**
	 * @param codeMissingDoc the codeMissingDoc to set
	 */
	public void setCodeMissingDoc(String codeMissingDoc) {
		this.codeMissingDoc = codeMissingDoc;
	}

	/**
	 * @return the messageMissingDoc
	 */
	public String getMessageMissingDoc() {
		return messageMissingDoc;
	}

	/**
	 * @param messageMissingDoc the messageMissingDoc to set
	 */
	public void setMessageMissingDoc(String messageMissingDoc) {
		this.messageMissingDoc = messageMissingDoc;
	}

}
