package ngondi.ged.ga.application.fournisseur;

import java.util.List;

import org.springframework.stereotype.Component;

import ngondi.ged.ga.domain.archivage.FournisseurException;
import ngondi.ged.ga.domain.archivage.structure.FournisseurInput;
import ngondi.ged.ga.domain.archivage.structure.FournisseurOuput;

/**
 * 
 * 
 * @author gmihindou
 *
 */
@Component
public interface IFournisseurManagement {

	/**
	 * 
	 * @param idDocument
	 * @param idFournisseur
	 * @return
	 * @throws FournisseurException
	 */
	String saveDocOfFournisseur(List<String> idDocument, String idFournisseur) throws FournisseurException;

	/**
	 * 
	 * @param idFournisseur
	 * @return
	 * @throws FournisseurException
	 */
	FournisseurOuput getFournisseur(String idFournisseur) throws FournisseurException;

	/**
	 * 
	 * @param idFournisseur
	 * @return
	 * @throws FournisseurException
	 */
	String deleteFournisseur(String idFournisseur) throws FournisseurException;

	/**
	 * 
	 * @param fournisseurInput
	 * @return
	 * @throws FournisseurException
	 */
	String saveFournisseur(FournisseurInput fournisseurInput) throws FournisseurException;

	/**
	 * 
	 * @param documentInput
	 * @param idFournisseur
	 * @return
	 * @throws FournisseurException
	 */
	String updateFournisseur(FournisseurInput documentInput, String idFournisseur) throws FournisseurException;

	/**
	 * 
	 * @return
	 * @throws FournisseurException
	 */
	List<FournisseurOuput> getFournisseurs() throws FournisseurException;

	/**
	 * 
	 * @param activite
	 * @return
	 * @throws FournisseurException
	 */
	List<FournisseurOuput> getFournisseursByActivity(String activite) throws FournisseurException;

}
