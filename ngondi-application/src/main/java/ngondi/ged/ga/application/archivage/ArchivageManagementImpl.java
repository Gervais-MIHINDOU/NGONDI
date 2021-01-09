/**
 * 
 */
package ngondi.ged.ga.application.archivage;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ngondi.ged.ga.domain.archivage.ArchivageException;
import ngondi.ged.ga.domain.archivage.IArchivage;
import ngondi.ged.ga.domain.archivage.structure.DocumentInput;
import ngondi.ged.ga.domain.archivage.structure.DocumentOutput;

/**
 * @author gmihindou
 *
 */
@Component
public class ArchivageManagementImpl implements IArchivageManagement {
	private static final Logger LOG = LoggerFactory.getLogger(ArchivageManagementImpl.class);

	@Autowired()
	private transient IArchivage iArchivage;

	@Override
	public DocumentOutput getDocument(String idDocument) throws ArchivageException {
		
		LOG.info("La valeur de l'instance recherché est : "+iArchivage);
		return iArchivage.getDocument(idDocument);
	}

	@Override
	public String deleteDoc(String idDocument) throws ArchivageException {

		return iArchivage.deleteDoc(idDocument);
	}

	@Override
	public String saveDocument(DocumentInput documentInput) throws ArchivageException {
		LOG.info("La valeur de l'instance recherché est : "+iArchivage);
		return iArchivage.saveDocument(documentInput);
	}

	@Override
	public String updateDocument(DocumentInput documentInput, String idDocument) throws ArchivageException {

		return iArchivage.updateDocument(documentInput, idDocument);
	}

	@Override
	public List<DocumentOutput> getDocuments() throws ArchivageException {

		return iArchivage.getDocuments();
	}

}
