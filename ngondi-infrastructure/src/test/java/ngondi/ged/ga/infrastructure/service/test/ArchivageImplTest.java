package ngondi.ged.ga.infrastructure.service.test;

import static org.junit.Assert.assertTrue;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.test.context.junit4.SpringRunner;

import ngondi.ged.ga.domain.archivage.ArchivageException;
import ngondi.ged.ga.domain.archivage.structure.DocumentInput;
import ngondi.ged.ga.domain.archivage.structure.DocumentOutput;
import ngondi.ged.ga.infrastructure.service.ArchivageImpl;
import ngondi.ged.ga.infrastructure.service.IArchivageDao;

@RunWith(SpringRunner.class)
public class ArchivageImplTest {

	@Configuration
	@ComponentScan({ "ngondi.ged.ga.infrastructure", "ngondi.ged.ga.domain" })
	static class conf {

	}

	@Autowired
	private transient ArchivageImpl archivageImpl;
	@Autowired
	private transient IArchivageDao iArchivageDao;

	@Test
	public void testGetDocument() throws ArchivageException, UnsupportedEncodingException {
		DocumentInput documentInput = new DocumentInput("PDF", "Contrat", "xxxxx".getBytes("UTF-8"));
		String idDocumentSave = archivageImpl.saveDocument(documentInput);
		DocumentOutput docOuptut = archivageImpl.getDocument(idDocumentSave);
		assertTrue(docOuptut.getIdDocument() != null);
		assertTrue(docOuptut.getDocBytes() != null);

	}

	@Test
	public void testDeleteDoc() throws ArchivageException, UnsupportedEncodingException {
		DocumentInput documentInput1 = new DocumentInput("PDF", "Contrat", "xxxxx".getBytes("UTF-8"));
		String idDoc = archivageImpl.saveDocument(documentInput1);
		archivageImpl.deleteDoc(idDoc);
		assertTrue(!iArchivageDao.existsById(idDoc));
	}

	@Test
	public void testUpdateDocument() throws ArchivageException, UnsupportedEncodingException {
		DocumentInput documentInput1 = new DocumentInput("PDF", "Contrat", "xxxxx".getBytes("UTF-8"));
		String idDoc = archivageImpl.saveDocument(documentInput1);

		DocumentInput documentInput2 = new DocumentInput("JPEG", "Contrat", "xxxxx".getBytes("UTF-8"));
		archivageImpl.updateDocument(documentInput2, idDoc);

		DocumentOutput docOuptut = archivageImpl.getDocument(idDoc);
		assertTrue("JPEG".equals(docOuptut.getArchiveFormat()));
	}

	@Test
	public void testGetDocuments() throws ArchivageException, UnsupportedEncodingException {
		DocumentInput documentInput1 = new DocumentInput("PDF", "Contrat", "xxxxx".getBytes("UTF-8"));
		DocumentInput documentInput2 = new DocumentInput("JPEG", "Contrat", "xxxxx".getBytes("UTF-8"));

		archivageImpl.saveDocument(documentInput1);
		archivageImpl.saveDocument(documentInput2);

		List<DocumentOutput> documentOutput = archivageImpl.getDocuments();

		assertTrue(documentOutput != null);
		assertTrue(!documentOutput.isEmpty());

	}

}
