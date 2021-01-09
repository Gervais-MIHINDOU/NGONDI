/**
 * 
 */
package ngondi.ged.ga.application.fournisseur;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ngondi.ged.ga.domain.archivage.FournisseurException;
import ngondi.ged.ga.domain.archivage.IFournisseur;
import ngondi.ged.ga.domain.archivage.structure.FournisseurInput;
import ngondi.ged.ga.domain.archivage.structure.FournisseurOuput;

/**
 * @author gmihindou
 *
 */
@Service
public class FournisseurManagementImpl implements IFournisseurManagement {

	@Autowired
	private IFournisseur fournisseurImpl;

	@Override
	public FournisseurOuput getFournisseur(String idFournisseur) throws FournisseurException {

		return fournisseurImpl.getFournisseur(idFournisseur);
	}

	@Override
	public String deleteFournisseur(String idFournisseur) throws FournisseurException {

		return fournisseurImpl.deleteFournisseur(idFournisseur);
	}

	@Override
	public String saveFournisseur(FournisseurInput fournisseurInput) throws FournisseurException {

		return fournisseurImpl.saveFournisseur(fournisseurInput);
	}

	@Override
	public String updateFournisseur(FournisseurInput documentInput, String idFournisseur) throws FournisseurException {

		return fournisseurImpl.updateFournisseur(documentInput, idFournisseur);
	}

	@Override
	public List<FournisseurOuput> getFournisseurs() throws FournisseurException {

		return fournisseurImpl.getFournisseurs();
	}

	@Override
	public List<FournisseurOuput> getFournisseursByActivity(String activite) throws FournisseurException {

		return fournisseurImpl.getFournisseursByActivity(activite);
	}

	@Override
	public String saveDocOfFournisseur(List<String> idDocument, String idFournisseur) throws FournisseurException {

		return fournisseurImpl.saveDocOfFournisseur(idDocument, idFournisseur);
	}

}
