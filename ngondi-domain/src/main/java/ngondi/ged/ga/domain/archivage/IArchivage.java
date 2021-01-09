package ngondi.ged.ga.domain.archivage;

import java.util.List;

import org.springframework.stereotype.Component;

import ngondi.ged.ga.domain.archivage.structure.DocumentInput;
import ngondi.ged.ga.domain.archivage.structure.DocumentOutput;

/**
 * 
 * @author gmihindou
 *
 */
@Component
public interface IArchivage {

	/**
	 * recupère un document en base de donnée
	 * 
	 * @param idDocument
	 * @return
	 * @throws ArchivageException
	 */
	DocumentOutput getDocument(String idDocument) throws ArchivageException;

	/**
	 * supprime un document en base de données
	 * 
	 * @param idDocument
	 * @return
	 * @throws ArchivageException
	 */
	String deleteDoc(String idDocument) throws ArchivageException;

	/**
	 * 
	 * Enregistre un document en base de donnée
	 * 
	 * @param documentInput
	 * @return
	 * @throws ArchivageException
	 */
	String saveDocument(DocumentInput documentInput) throws ArchivageException;

	/**
	 * Modifie un document en base de donnée
	 * 
	 * @param documentInput
	 * @param idDocument
	 * @return
	 * @throws ArchivageException
	 */
	String updateDocument(DocumentInput documentInput, String idDocument) throws ArchivageException;

	/**
	 * recupère la liste des document en base de donnée
	 * 
	 * @return
	 * @throws ArchivageException
	 */
	List<DocumentOutput> getDocuments() throws ArchivageException;
}
