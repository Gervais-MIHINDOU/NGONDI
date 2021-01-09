package ngondi.ged.ga.infrastructure.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import ngondi.ged.ga.infrastructure.model.FournisseurEntity;

/**
 * 
 * @author gmihindou
 *
 */
@Repository
public interface IFournisseurDao extends JpaRepository<FournisseurEntity, String> {

	@Query("SELECT f from FOURNISSEUR f WHERE f.activite = :activite")
	List<FournisseurEntity> findFournisseursByActivite(@Param("activite") String activite);

	FournisseurEntity findByIdFournisseur(String idFournisseur);

	@Transactional
	void deleteByIdFournisseur(String idFournisseur);

//	@Query("delete f from FOURNISSEUR_DOCUMENT f WHERE f.idDocument = :idDocument")
//	void deleteDocOfFournisseur(@Param("idDocument") String idDocument);
}
