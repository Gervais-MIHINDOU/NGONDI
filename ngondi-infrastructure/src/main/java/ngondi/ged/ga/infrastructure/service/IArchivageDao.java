package ngondi.ged.ga.infrastructure.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ngondi.ged.ga.infrastructure.model.DocumentEntity;

/**
 * 
 * @author gmihindou
 *
 */
@Repository
public interface IArchivageDao extends JpaRepository<DocumentEntity, String> {

	DocumentEntity findByIdDocument(String idDocument);

}
