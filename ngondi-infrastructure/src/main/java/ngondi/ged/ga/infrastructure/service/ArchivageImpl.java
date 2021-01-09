/**
 * 
 */
package ngondi.ged.ga.infrastructure.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ngondi.ged.ga.domain.archivage.ArchivageException;
import ngondi.ged.ga.domain.archivage.IArchivage;
import ngondi.ged.ga.domain.archivage.structure.DocumentInput;
import ngondi.ged.ga.domain.archivage.structure.DocumentOutput;
import ngondi.ged.ga.infrastructure.model.DocumentEntity;

/**
 * @author gmihindou
 *
 */
@Component
public class ArchivageImpl implements IArchivage {

	@Autowired
	private transient IArchivageDao iArchivageDao;

	@Autowired
	private transient Conf conf;

	/*
	 * (non-Javadoc)
	 * 
	 * @see ngondi.ged.ga.domain.archivage.IArchivage#getDocument(java.lang.String)
	 */
	@Override
	public DocumentOutput getDocument(String idDocument) throws ArchivageException {

		DocumentOutput documentOutput = new DocumentOutput();

		DocumentEntity documentEntity = iArchivageDao.findByIdDocument(idDocument);

		if (documentEntity != null) {

			BeanUtils.copyProperties(documentEntity, documentOutput);
			return documentOutput;

		} else {
			throw showError();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ngondi.ged.ga.domain.archivage.IArchivage#deleteDoc(java.lang.String)
	 */
	@Override
	public String deleteDoc(String idDocument) throws ArchivageException {

		try {
			iArchivageDao.deleteById(idDocument);
			return idDocument;
		} catch (Exception e) {
			throw showError();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngondi.ged.ga.domain.archivage.IArchivage#saveDocument(ngondi.ged.ga.domain.
	 * archivage.structure.DocumentInput)
	 */
	@Override
	public String saveDocument(DocumentInput documentInput) throws ArchivageException {
		DocumentEntity documentEntity = new DocumentEntity();
		BeanUtils.copyProperties(documentInput, documentEntity);
		documentEntity.setDate(LocalDate.now());

		try {

			documentEntity.setIdDocument(generateId());
			iArchivageDao.save(documentEntity);

			return documentEntity.getIdDocument().toString();

		} catch (Exception e) {
			throw showError();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * ngondi.ged.ga.domain.archivage.IArchivage#updateDocument(ngondi.ged.ga.domain
	 * .archivage.structure.DocumentInput, java.lang.String)
	 */
	@Override
	public String updateDocument(DocumentInput documentInput, String idDocument) throws ArchivageException {

		Optional<DocumentEntity> documentEntityOp = iArchivageDao.findById(idDocument);

		if (documentEntityOp != null && documentEntityOp.get() != null) {
			DocumentEntity documentEntity = documentEntityOp.get();

			if (documentInput.getArchiveFormat() != null) {
				documentEntity.setArchiveFormat(documentInput.getArchiveFormat());
			} else if (documentInput.getNameDocument() != null) {
				documentEntity.setNameDocument(documentInput.getNameDocument());
			} else if (documentInput.getDocBytes() != null) {
				documentEntity.setDocBytes(documentInput.getDocBytes());
			}
			iArchivageDao.save(documentEntity);

			return documentEntity.getIdDocument().toString();
		} else {
			throw showError();
		}

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see ngondi.ged.ga.domain.archivage.IArchivage#getDocuments()
	 */
	@Override
	public List<DocumentOutput> getDocuments() throws ArchivageException {

		Iterable<DocumentEntity> documents = iArchivageDao.findAll();

		List<DocumentOutput> docOutputs = new ArrayList<>();

		if (documents != null) {
			documents.forEach(docEntity -> {
				DocumentOutput docOutput = new DocumentOutput();
				BeanUtils.copyProperties(docEntity, docOutput);

				docOutputs.add(docOutput);
			});

			return docOutputs;

		} else {

			throw showError();
		}
	}

	private ArchivageException showError() throws ArchivageException {
		Map<String, String> errors = new HashMap<>();
		errors.put(conf.getCodeMissingDoc(), conf.getMessageMissingDoc());
		return new ArchivageException(errors);
	}

	private String generateId() {
		String id = null;
		do {
			id = UUID.randomUUID().toString();

		} while (iArchivageDao.existsById(id));

		return id;
	}

}
