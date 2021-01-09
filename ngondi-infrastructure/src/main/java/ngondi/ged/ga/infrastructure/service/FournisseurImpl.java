/**
 * 
 */
package ngondi.ged.ga.infrastructure.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;

import ngondi.ged.ga.domain.archivage.FournisseurException;
import ngondi.ged.ga.domain.archivage.IFournisseur;
import ngondi.ged.ga.domain.archivage.structure.FournisseurInput;
import ngondi.ged.ga.domain.archivage.structure.FournisseurOuput;
import ngondi.ged.ga.infrastructure.model.FournisseurEntity;

/**
 * @author gmihindou
 *
 */
@Component
public class FournisseurImpl implements IFournisseur {
	private static final Logger LOG = LoggerFactory.getLogger(FournisseurImpl.class);
	@Autowired
	private transient IFournisseurDao fournisseurDao;

	@Autowired
	private transient Conf conf;

	@Override
	public FournisseurOuput getFournisseur(String idFournisseur) throws FournisseurException {

		FournisseurOuput fournisseurOuput = new FournisseurOuput();

		FournisseurEntity fournisseurEntity = fournisseurDao.findByIdFournisseur(idFournisseur);
		if (fournisseurEntity != null) {
			BeanUtils.copyProperties(fournisseurEntity, fournisseurOuput);
			fournisseurOuput.setIdDocuments(fournisseurEntity.getIdDocument());
			return fournisseurOuput;
		} else {

			throw showError();
		}

	}

	@Override
	public String deleteFournisseur(String idFournisseur) throws FournisseurException {
		try {
			fournisseurDao.deleteByIdFournisseur(idFournisseur);

			return idFournisseur;
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw showError();
		}

	}

	@Override
	public String saveFournisseur(FournisseurInput fournisseurInput) throws FournisseurException {

		FournisseurEntity fournisseurEntity = new FournisseurEntity();
		fournisseurEntity.setIdFournisseur(generateId());
		// StatistiqueFournisseurEntity statistique = new
		// StatistiqueFournisseurEntity();

		// BeanUtils.copyProperties(fournisseurInput.getStatistique(), statistique);
		BeanUtils.copyProperties(fournisseurInput, fournisseurEntity);
		// fournisseurEntity.setStatistiqueFournisseur(statistique);
		try {

			fournisseurDao.save(fournisseurEntity);
			return fournisseurEntity.getIdFournisseur().toString();

		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw showError();
		}

	}

	@Override
	public String saveDocOfFournisseur(List<String> idDocuments, String idFournisseur) throws FournisseurException {
		Optional<FournisseurEntity> fournisseurEntityOp = fournisseurDao.findById(idFournisseur);

		try {
			if (fournisseurEntityOp != null && fournisseurEntityOp.get() != null) {
				ArrayList<String> idDoc = new ArrayList<String>();
				FournisseurEntity fournisseurEntity = fournisseurEntityOp.get();
				LOG.info("L'id fournisseur est : " + fournisseurEntity.getIdFournisseur());

				idDoc.addAll(idDocuments);

				if (!CollectionUtils.isEmpty(fournisseurEntity.getIdDocument())) {
					idDoc.addAll(fournisseurEntity.getIdDocument());
					LOG.info(" 1 ER L'id du document est : " + fournisseurEntity.getIdDocument().get(0));
				}

				fournisseurEntity.setIdDocument(idDoc);

				fournisseurDao.save(fournisseurEntity);
				LOG.info("L'id du document est : " + fournisseurEntity.getIdDocument().get(0));
				return fournisseurEntity.getIdFournisseur();

			} else {
				throw showError();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			throw showError();
		}

	}

	@Override
	public String updateFournisseur(FournisseurInput fournisseurInput, String idFournisseur)
			throws FournisseurException {
		Optional<FournisseurEntity> fournisseurEntityOp = fournisseurDao.findById(idFournisseur);

		if (fournisseurEntityOp != null && fournisseurEntityOp.get() != null) {
			FournisseurEntity fournisseurEntity = fournisseurEntityOp.get();

			if (fournisseurInput.getActivite() != null) {
				fournisseurEntity.setActivite(fournisseurInput.getActivite());
			}
			if (fournisseurInput.getAdresse() != null) {
				fournisseurEntity.setAdresse(fournisseurInput.getAdresse());
			}
			if (fournisseurInput.getContact() != null) {
				fournisseurEntity.setContact(fournisseurInput.getContact());
			}
			if (fournisseurInput.getEmail() != null) {
				fournisseurEntity.setEmail(fournisseurInput.getEmail());
			}

			if (fournisseurInput.getNif() != null) {
				fournisseurEntity.setNif(fournisseurInput.getNif());
			}

			if (fournisseurInput.getNom() != null) {
				fournisseurEntity.setNom(fournisseurInput.getNom());
			}

			if (fournisseurInput.getRccm() != null) {
				fournisseurEntity.setRccm(fournisseurInput.getRccm());
			}

			if (fournisseurInput.getTelephone() != null) {
				fournisseurEntity.setTelephone(fournisseurInput.getTelephone());
			}
			fournisseurDao.save(fournisseurEntity);

			return fournisseurEntity.getIdFournisseur();
		} else {

			throw showError();
		}

	}

	@Override
	public List<FournisseurOuput> getFournisseurs() throws FournisseurException {

		Iterable<FournisseurEntity> fournisseurs = fournisseurDao.findAll();

		List<FournisseurOuput> fournisseurOuputs = new ArrayList<>();

		if (fournisseurs != null) {
			fournisseurs.forEach(fournisseurEntity -> {
				FournisseurOuput fournisseurOuput = new FournisseurOuput();
				BeanUtils.copyProperties(fournisseurEntity, fournisseurOuput);

				fournisseurOuputs.add(fournisseurOuput);
			});

			return fournisseurOuputs;

		} else {

			throw showError();
		}

	}

	@Override
	public List<FournisseurOuput> getFournisseursByActivity(String activite) throws FournisseurException {
		List<FournisseurEntity> fournisseurs = fournisseurDao.findFournisseursByActivite(activite);

		List<FournisseurOuput> fournisseurOuputs = new ArrayList<>();

		if (fournisseurs != null) {
			fournisseurs.forEach(fournisseurEntity -> {
				FournisseurOuput fournisseurOuput = new FournisseurOuput();
				BeanUtils.copyProperties(fournisseurEntity, fournisseurOuput);

				fournisseurOuputs.add(fournisseurOuput);
			});

			return fournisseurOuputs;

		} else {

			throw showError();
		}

	}

	/**
	 * 
	 * @throws FournisseurException
	 */
	private FournisseurException showError() throws FournisseurException {
		Map<String, String> errors = new HashMap<>();
		errors.put(conf.getCodeMissingFournisseur(), conf.getMessageMissingFournisseur());
		return new FournisseurException(errors);
	}

	private String generateId() {
		String id = null;
		do {
			id = UUID.randomUUID().toString();

		} while (fournisseurDao.existsById(id));

		return id;
	}

	@Override
	public void deleteDocOfFDourniiseur(String idDocument, String idFournisseur) throws FournisseurException {
		Optional<FournisseurEntity> fournisseurEntityOp = fournisseurDao.findById(idFournisseur);
		try {
			if (fournisseurEntityOp != null && fournisseurEntityOp.get() != null) {
				FournisseurEntity fournisseurEntity = fournisseurEntityOp.get();
				LOG.info("L'id fournisseur est : " + fournisseurEntity.getIdFournisseur());
				fournisseurEntity.getIdDocument().remove(idDocument);
				fournisseurDao.save(fournisseurEntity);
				LOG.info("L'id du document est : " + fournisseurEntity.getIdDocument().get(0));

			} else {
				throw showError();
			}
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}

	}

}
