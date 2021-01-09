package ngondi.ged.ga.exposition.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import ngondi.ged.ga.exposition.NgondiExpositionApplication;
import ngondi.ged.ga.exposition.structure.DocumentDTO;
import ngondi.ged.ga.exposition.structure.ResponseDTO;
import ngondi.ged.ga.exposition.structure.ResponseDocumentDTO;
import ngondi.ged.ga.exposition.structure.ResponseDocumentsDTOS;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NgondiExpositionApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class ArchivageControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	private byte[] documentBytes() {
		File file = new File("src/main/resources/document.pdf");

		// Using java.io.FileInputStream
		byte[] arrayB = readFileToByteArray(file);
		// displaying content of byte array
		for (int i = 0; i < arrayB.length; i++) {
			System.out.print((char) arrayB[i]);
		}

		return arrayB;
	}

	private static byte[] readFileToByteArray(File file) {
		FileInputStream fis = null;
		// Creating a byte array using the length of the file
		// file.length returns long which is cast to int
		byte[] bArray = new byte[(int) file.length()];
		try {
			fis = new FileInputStream(file);
			fis.read(bArray);
			fis.close();

		} catch (IOException ioExp) {
			ioExp.printStackTrace();
		}
		return bArray;
	}

	@Test
	public void testGetDocSuccess() {
		String url = "http://localhost:" + port + "/ngondi/save/document";
		DocumentDTO documentDTO = new DocumentDTO("PDF", "Paye", documentBytes());
		HttpEntity<DocumentDTO> entity = new HttpEntity<DocumentDTO>(documentDTO, headers);
		ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		url = "http://localhost:" + port + "/ngondi/document/" + response.getBody().getIdentifier();
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);
		ResponseEntity<ResponseDocumentDTO> responseGetDoc = restTemplate.exchange(url, HttpMethod.GET, entityliste,
				ResponseDocumentDTO.class);

		assertTrue(responseGetDoc != null);
		assertTrue(responseGetDoc.getStatusCode() != null);
		assertTrue(responseGetDoc.getStatusCode().is2xxSuccessful());
		assertTrue(responseGetDoc.getBody().getIdDocument() != null);
		assertTrue("PDF".equals(responseGetDoc.getBody().getArchiveFormat()));

	}

	@Test
	public void testDeleteSuccess() {
		String url = "http://localhost:" + port + "/ngondi/save/document";
		DocumentDTO documentDTO = new DocumentDTO("PDF", "Paye", documentBytes());

		HttpEntity<DocumentDTO> entity = new HttpEntity<DocumentDTO>(documentDTO, headers);

		ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		url = "http://localhost:" + port + "/ngondi/delete/document/" + response.getBody().getIdentifier();
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);

		ResponseEntity<ResponseDTO> responseDelete = restTemplate.exchange(url, HttpMethod.DELETE, entityliste,
				ResponseDTO.class);

		assertTrue(responseDelete != null);
		assertTrue(responseDelete.getStatusCode().is2xxSuccessful());
		assertTrue(responseDelete.getBody() != null);
		assertTrue(responseDelete.getBody().getIdentifier() != null);
	}

	@Test
	public void testUpdateSuccess() {
		/**
		 * enregistrement en base de donnée
		 */
		String url = "http://localhost:" + port + "/ngondi/save/document";
		DocumentDTO documentDTO = new DocumentDTO("PDF", "Paye", documentBytes());

		HttpEntity<DocumentDTO> entity = new HttpEntity<DocumentDTO>(documentDTO, headers);

		ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		/**
		 * modification du document en base de donnée
		 */
		url = "http://localhost:" + port + "/ngondi/update/document/" + response.getBody().getIdentifier();
		DocumentDTO documentDTO5 = new DocumentDTO("JPEG", "Paye", documentBytes());
		HttpEntity<DocumentDTO> entity5 = new HttpEntity<DocumentDTO>(documentDTO5, headers);

		ResponseEntity<ResponseDTO> responseUpadete = restTemplate.exchange(url, HttpMethod.POST, entity5,
				ResponseDTO.class);

		assertTrue(responseUpadete != null);
		assertTrue(responseUpadete.getStatusCode().is2xxSuccessful());
		assertTrue(responseUpadete.getBody() != null);
		assertTrue(responseUpadete.getBody().getIdentifier() != null);

		url = "http://localhost:" + port + "/ngondi/document/" + responseUpadete.getBody().getIdentifier();
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);
		ResponseEntity<ResponseDocumentDTO> responseGetDoc = restTemplate.exchange(url, HttpMethod.GET, entityliste,
				ResponseDocumentDTO.class);

		assertTrue(responseGetDoc != null);
		assertTrue(responseGetDoc.getStatusCode() != null);
		assertTrue(responseGetDoc.getStatusCode().is2xxSuccessful());
		assertTrue(responseGetDoc.getBody().getIdDocument() != null);
		assertTrue("JPEG".equals(responseGetDoc.getBody().getArchiveFormat()));
	}

	@Test
	public void saveDocSuccess() {
		String url = "http://localhost:" + port + "/ngondi/save/document";
		DocumentDTO documentDTO = new DocumentDTO("PDF", "Paye", documentBytes());

		HttpEntity<DocumentDTO> entity = new HttpEntity<DocumentDTO>(documentDTO, headers);

		ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		assertTrue(response != null);
		assertTrue(response.getStatusCode() != null);
		assertTrue(response.getBody() != null);
		assertTrue(response.getBody().getIdentifier() != null);
		assertTrue(response.getStatusCode().is2xxSuccessful());
	}

	@Test
	public void getListDocument() {

		String url = "http://localhost:" + port + "/ngondi/save/document";
		DocumentDTO documentDTO = new DocumentDTO("PDF", "Paye", documentBytes());

		HttpEntity<DocumentDTO> entity = new HttpEntity<DocumentDTO>(documentDTO, headers);
		/**
		 * enregistrement des documents en base de données
		 */
		ResponseEntity<ResponseDTO> response1 = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);
		ResponseEntity<ResponseDTO> response2 = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		assertTrue(response1 != null);
		assertTrue(response2 != null);
		/**
		 * recuperation des documents en base de donnée
		 */
		url = "http://localhost:" + port + "/ngondi/document/list";
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);

		ResponseEntity<ResponseDocumentsDTOS> response = restTemplate.exchange(url, HttpMethod.GET, entityliste,
				ResponseDocumentsDTOS.class);

		assertTrue(response != null);
		assertTrue(response.getStatusCode() != null);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(response.getBody() != null);
		assertTrue(response.getBody().getResponseDocuments() != null);
		assertTrue(!response.getBody().getResponseDocuments().isEmpty());
	}

}
