/**
 * 
 */
package ngondi.ged.ga.infrastructure.service.test;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import ngondi.ged.ga.domain.archivage.ArchivageException;
import ngondi.ged.ga.domain.archivage.FournisseurException;
import ngondi.ged.ga.domain.archivage.structure.DocumentInput;
import ngondi.ged.ga.domain.archivage.structure.FournisseurInput;
import ngondi.ged.ga.domain.archivage.structure.FournisseurOuput;
import ngondi.ged.ga.domain.archivage.structure.StatistiqueFournisseur;
import ngondi.ged.ga.infrastructure.service.ArchivageImpl;
import ngondi.ged.ga.infrastructure.service.FournisseurImpl;
import ngondi.ged.ga.infrastructure.service.IFournisseurDao;

/**
 * @author gmihindou
 *
 */
@RunWith(SpringRunner.class)
public class FournisseurImplTest {

	@Configuration
	@ComponentScan({ "ngondi.ged.ga.infrastructure", "ngondi.ged.ga.domain" })
	static class conf {

	}

	@Autowired
	private transient FournisseurImpl fournisseurImpl;

	@Autowired
	private transient IFournisseurDao fournisseurDao;

	@Autowired
	private transient ArchivageImpl archivageImpl;

	@Test
	public void testDeleteDocOfFournisseur()
			throws FournisseurException, UnsupportedEncodingException, ArchivageException {
		String idFournisseur = fournisseurImpl.saveFournisseur(new FournisseurInput("OLSEN", "O", "xxxx", "xxxx",
				"Gouvernorat", "MR OBIANG", "0612", "gervaisolsen33@gmail.com"));
		String idDocument = archivageImpl.saveDocument(new DocumentInput("OLSEN", "O", "xxxxx".getBytes("UTF-8")));
		fournisseurImpl.saveDocOfFournisseur(Arrays.asList(idDocument), idFournisseur);
		fournisseurImpl.saveDocOfFournisseur(
				Arrays.asList(archivageImpl.saveDocument(new DocumentInput("OLSEN", "O", "xxxxx".getBytes("UTF-8")))),
				idFournisseur);

		fournisseurImpl.deleteDocOfFDourniiseur(idDocument, idFournisseur);

		FournisseurOuput fournisseurOuput = fournisseurImpl.getFournisseur(idFournisseur);

		assertTrue(fournisseurOuput.getIdFournisseur() != null && !fournisseurOuput.getIdFournisseur().isEmpty());
		assertTrue(fournisseurOuput.getIdDocuments() != null);
		assertTrue(!fournisseurOuput.getIdDocuments().isEmpty());
		assertTrue(fournisseurOuput.getIdDocuments().size() == 1);

	}

	@Test
	public void testGetDocOfFournisseurs()
			throws FournisseurException, UnsupportedEncodingException, ArchivageException {

		String idFournisseur = fournisseurImpl.saveFournisseur(new FournisseurInput("OLSEN", "O", "xxxx", "xxxx",
				"Gouvernorat", "MR OBIANG", "0612", "gervaisolsen33@gmail.com"));
		String idDocument = archivageImpl.saveDocument(new DocumentInput("OLSEN", "O", "xxxxx".getBytes("UTF-8")));
		fournisseurImpl.saveDocOfFournisseur(Arrays.asList(idDocument), idFournisseur);

		FournisseurOuput fournisseurOuput = fournisseurImpl.getFournisseur(idFournisseur);

		assertTrue(fournisseurOuput.getIdFournisseur() != null && !fournisseurOuput.getIdFournisseur().isEmpty());
		assertTrue(fournisseurOuput.getIdDocuments() != null);
		assertTrue(!fournisseurOuput.getIdDocuments().isEmpty());
	}

	/**
	 * Test method for
	 * {@link ngondi.ged.ga.infrastructure.service.FournisseurImpl#getFournisseur(java.lang.String)}.
	 * 
	 * @throws FournisseurException
	 */
	@Test
	public void testGetFournisseur() throws FournisseurException {
		FournisseurInput fournisseurInput = new FournisseurInput("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");
		String idFournisseur = fournisseurImpl.saveFournisseur(fournisseurInput);

		FournisseurOuput fournisseurOuput = fournisseurImpl.getFournisseur(idFournisseur);

		assertTrue(fournisseurOuput.getIdFournisseur() != null && !fournisseurOuput.getIdFournisseur().isEmpty());
		assertTrue(fournisseurOuput.getNom() != null);

	}

	/**
	 * Test method for
	 * {@link ngondi.ged.ga.infrastructure.service.FournisseurImpl#deleteFournisseur(java.lang.String)}.
	 * 
	 * @throws FournisseurException
	 */
	@Test
	public void testDeleteFournisseur() throws FournisseurException {

		FournisseurInput fournisseurInput = new FournisseurInput("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");
		String idFournisseur = fournisseurImpl.saveFournisseur(fournisseurInput);
		fournisseurImpl.deleteFournisseur(idFournisseur);

		assertTrue(!fournisseurDao.existsById(idFournisseur));

	}

	/**
	 * Test method for
	 * {@link ngondi.ged.ga.infrastructure.service.FournisseurImpl#saveFournisseur(ngondi.ged.ga.domain.archivage.structure.FournisseurInput)}.
	 * 
	 * @throws FournisseurException
	 */
	@Test
	public void testSaveFournisseur() throws FournisseurException {
		StatistiqueFournisseur stat1 = new StatistiqueFournisseur("ID1", "ol", "gg", "kdk");

		FournisseurInput fournisseurInput = new FournisseurInput("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");

		fournisseurInput.setStatistique(stat1);
		String idFournisseur = fournisseurImpl.saveFournisseur(fournisseurInput);

		FournisseurOuput fournisseurOuput = fournisseurImpl.getFournisseur(idFournisseur);

		assertTrue(fournisseurOuput.getIdFournisseur() != null && !fournisseurOuput.getIdFournisseur().isEmpty());
		assertTrue(fournisseurOuput.getNom() != null);
	}

	/**
	 * Test method for
	 * {@link ngondi.ged.ga.infrastructure.service.FournisseurImpl#updateFournisseur(ngondi.ged.ga.domain.archivage.structure.FournisseurInput, java.lang.String)}.
	 * 
	 * @throws FournisseurException
	 */
	@Test
	public void testUpdateFournisseur() throws FournisseurException {
		FournisseurInput fournisseurInput = new FournisseurInput("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");
		String idFournisseur = fournisseurImpl.saveFournisseur(fournisseurInput);
		;
		String id = fournisseurImpl.updateFournisseur(new FournisseurInput("Petro Gabon", "TELECOM", "xxxx", "xxxx",
				"Gouvernorat", "MR OBIANG", "0612", "gervaisolsen33@gmail.com"), idFournisseur);

		FournisseurOuput fournisseurOuput = fournisseurImpl.getFournisseur(id);

		assertTrue("TELECOM".equals(fournisseurOuput.getActivite()));
	}

	/**
	 * Test method for
	 * {@link ngondi.ged.ga.infrastructure.service.FournisseurImpl#getFournisseurs()}.
	 * 
	 * @throws FournisseurException
	 */
	@Test
	public void testGetFournisseurs() throws FournisseurException {
		FournisseurInput fournisseurInput = new FournisseurInput("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");
		fournisseurImpl.saveFournisseur(fournisseurInput);
		fournisseurImpl.saveFournisseur(new FournisseurInput("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com"));

		List<FournisseurOuput> fournisseurOuputs = fournisseurImpl.getFournisseurs();

		assertTrue(fournisseurOuputs != null && !fournisseurOuputs.isEmpty());
		assertTrue(fournisseurOuputs.size() >= 2);
	}

	/**
	 * Test method for
	 * {@link ngondi.ged.ga.infrastructure.service.FournisseurImpl#getFournisseursByActivity(java.lang.String)}.
	 * 
	 * @throws FournisseurException
	 */
	@Test
	public void testGetFournisseursByActivity() throws FournisseurException {

		FournisseurInput fournisseurInput = new FournisseurInput("Petro Gabon", "F", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");
		fournisseurImpl.saveFournisseur(fournisseurInput);
		fournisseurImpl.saveFournisseur(new FournisseurInput("Petro Gabon", "F", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com"));

		fournisseurImpl.saveFournisseur(new FournisseurInput("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com"));

		List<FournisseurOuput> fournisseurOuputs = fournisseurImpl.getFournisseursByActivity("F");

		assertTrue(fournisseurOuputs != null && !fournisseurOuputs.isEmpty());
		assertTrue(fournisseurOuputs.size() >= 2);
	}

}
