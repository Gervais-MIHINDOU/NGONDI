package ngondi.ged.ga.exposition.test;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

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
import ngondi.ged.ga.exposition.structure.DocOfFournisseurDTO;
import ngondi.ged.ga.exposition.structure.DocumentDTO;
import ngondi.ged.ga.exposition.structure.FournisseurDTO;
import ngondi.ged.ga.exposition.structure.ResponseDTO;
import ngondi.ged.ga.exposition.structure.ResponseDocumentDTO;
import ngondi.ged.ga.exposition.structure.ResponseFournisseurDTO;
import ngondi.ged.ga.exposition.structure.ResponseFournisseurDTOS;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = NgondiExpositionApplication.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class FournisseurControllerTest {

	@LocalServerPort
	private int port;

	TestRestTemplate restTemplate = new TestRestTemplate();

	HttpHeaders headers = new HttpHeaders();

	@Test
	public void testGetFournisseur() {
		String url = "http://localhost:" + port + "/ngondi/save/fournisseur";
		FournisseurDTO fournisseurDTO = new FournisseurDTO("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");

		HttpEntity<FournisseurDTO> entity = new HttpEntity<FournisseurDTO>(fournisseurDTO, headers);
		ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		url = "http://localhost:" + port + "/ngondi/fournisseur/" + response.getBody().getIdentifier();
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);
		ResponseEntity<ResponseFournisseurDTO> responseGetF = restTemplate.exchange(url, HttpMethod.GET, entityliste,
				ResponseFournisseurDTO.class);

		assertTrue(responseGetF != null);
		assertTrue(responseGetF.getStatusCode() != null);
		assertTrue(responseGetF.getStatusCode().is2xxSuccessful());
		assertTrue(responseGetF.getBody().getIdFournisseur() != null);
	}

	@Test
	public void testDeleteFournisseur() {
		String url = "http://localhost:" + port + "/ngondi/save/fournisseur";
		FournisseurDTO fournisseurDTO = new FournisseurDTO("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");

		HttpEntity<FournisseurDTO> entity = new HttpEntity<FournisseurDTO>(fournisseurDTO, headers);
		ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		url = "http://localhost:" + port + "/ngondi/delete/fournisseur/" + response.getBody().getIdentifier();
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);
		ResponseEntity<ResponseDTO> responseDeleteF = restTemplate.exchange(url, HttpMethod.DELETE, entityliste,
				ResponseDTO.class);

		assertTrue(responseDeleteF != null);
		assertTrue(responseDeleteF.getStatusCode() != null);
		assertTrue(responseDeleteF.getStatusCode().is2xxSuccessful());
		assertTrue(responseDeleteF.getBody().getIdentifier() != null);
	}

	@Test
	public void testUpdateFournisseur() {
		String url = "http://localhost:" + port + "/ngondi/save/fournisseur";
		FournisseurDTO fournisseurDTO = new FournisseurDTO("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");

		HttpEntity<FournisseurDTO> entity = new HttpEntity<FournisseurDTO>(fournisseurDTO, headers);
		ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		/**
		 * modifier le fournisseur
		 */
		url = "http://localhost:" + port + "/ngondi/update/fournisseur/" + response.getBody().getIdentifier();

		FournisseurDTO fournisseurDTO1 = new FournisseurDTO("Petro Gabon", "PETROL", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");
		entity = new HttpEntity<FournisseurDTO>(fournisseurDTO1, headers);

		response = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		url = "http://localhost:" + port + "/ngondi/fournisseur/" + response.getBody().getIdentifier();
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);
		ResponseEntity<ResponseFournisseurDTO> responseGetF = restTemplate.exchange(url, HttpMethod.GET, entityliste,
				ResponseFournisseurDTO.class);

		assertTrue(responseGetF != null);
		assertTrue(responseGetF.getStatusCode() != null);
		assertTrue(responseGetF.getStatusCode().is2xxSuccessful());
		assertTrue(responseGetF.getBody().getIdFournisseur() != null);
		assertTrue("PETROL".equals(responseGetF.getBody().getActivite()));
	}

	@Test
	public void testGetFournisseurs() {
		String url = "http://localhost:" + port + "/ngondi/save/fournisseur";
		FournisseurDTO fournisseurDTO = new FournisseurDTO("Petro Gabon", "BTP", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");

		HttpEntity<FournisseurDTO> entity = new HttpEntity<FournisseurDTO>(fournisseurDTO, headers);
		restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);
		restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);
		restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		/**
		 * recuperation des fournisseurs en base de donnée
		 */
		url = "http://localhost:" + port + "/ngondi/fournisseur/list";
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);

		ResponseEntity<ResponseFournisseurDTOS> response = restTemplate.exchange(url, HttpMethod.GET, entityliste,
				ResponseFournisseurDTOS.class);

		assertTrue(response != null);
		assertTrue(response.getStatusCode() != null);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(response.getBody().getFournisseurs().size() >= 3);
	}

	@Test
	public void testGetFournisseurByActivite() {
		String url = "http://localhost:" + port + "/ngondi/save/fournisseur";
		FournisseurDTO fournisseurDTO = new FournisseurDTO("Petro Gabon", "SANTE", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");

		HttpEntity<FournisseurDTO> entity = new HttpEntity<FournisseurDTO>(fournisseurDTO, headers);
		restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);
		restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		/**
		 * recuperation des fournisseurs en base de donnée
		 */
		url = "http://localhost:" + port + "/ngondi/fournisseur/list/SANTE";
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);

		ResponseEntity<ResponseFournisseurDTOS> response = restTemplate.exchange(url, HttpMethod.GET, entityliste,
				ResponseFournisseurDTOS.class);

		assertTrue(response != null);
		assertTrue(response.getStatusCode() != null);
		assertTrue(response.getStatusCode().is2xxSuccessful());
		assertTrue(response.getBody().getFournisseurs().size() >= 2);
	}

	@Test
	public void testsaveDocOfFournisseur() {
		/**
		 * Enregistrement du fournisseur
		 */
		String url = "http://localhost:" + port + "/ngondi/save/fournisseur";
		FournisseurDTO fournisseurDTO = new FournisseurDTO("Petro Gabon", "SANTE", "xxxx", "xxxx", "Gouvernorat",
				"MR OBIANG", "0612", "gervaisolsen33@gmail.com");

		HttpEntity<FournisseurDTO> entity = new HttpEntity<FournisseurDTO>(fournisseurDTO, headers);
		ResponseEntity<ResponseDTO> responseF = restTemplate.exchange(url, HttpMethod.POST, entity, ResponseDTO.class);

		/**
		 * enregistrement du document en base de donnée
		 */
		url = "http://localhost:" + port + "/ngondi/save/document";
		DocumentDTO documentDTO = new DocumentDTO("PDF", "Paye", documentBytes());
		HttpEntity<DocumentDTO> entitysave = new HttpEntity<DocumentDTO>(documentDTO, headers);
		ResponseEntity<ResponseDTO> response = restTemplate.exchange(url, HttpMethod.POST, entitysave,
				ResponseDTO.class);

		url = "http://localhost:" + port + "/ngondi/document/" + response.getBody().getIdentifier();
		HttpEntity<String> entityliste = new HttpEntity<String>(headers);
		ResponseEntity<ResponseDocumentDTO> responseGetDoc = restTemplate.exchange(url, HttpMethod.GET, entityliste,
				ResponseDocumentDTO.class);

		assertTrue(responseGetDoc != null);
		assertTrue(responseGetDoc.getStatusCode() != null);
		assertTrue(responseGetDoc.getStatusCode().is2xxSuccessful());
		assertTrue(responseGetDoc.getBody().getIdDocument() != null);
		assertTrue("PDF".equals(responseGetDoc.getBody().getArchiveFormat()));

		/**
		 * correspondance entre le document et le fournisseur
		 */
		url = "http://localhost:" + port + "/ngondi/save/doc/fournisseur";

		DocOfFournisseurDTO docOfFournisseurDTO = new DocOfFournisseurDTO(
				Arrays.asList(responseGetDoc.getBody().getIdDocument()), responseF.getBody().getIdentifier());
		HttpEntity<DocOfFournisseurDTO> entityfDoc = new HttpEntity<DocOfFournisseurDTO>(docOfFournisseurDTO, headers);

		ResponseEntity<ResponseDTO> response3 = restTemplate.exchange(url, HttpMethod.POST, entityfDoc,
				ResponseDTO.class);

		assertTrue(response3 != null);
		assertTrue(response3.getBody() != null);
		assertTrue(response3.getBody().getIdentifier() != null);
		assertTrue(response3.getStatusCode() != null);
		assertTrue(response3.getStatusCode().is2xxSuccessful());

	}

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
}
