/**
 * 
 */
package ngondi.ged.ga.exposition.api;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ngondi.ged.ga.application.archivage.IArchivageManagement;
import ngondi.ged.ga.domain.archivage.ArchivageException;
import ngondi.ged.ga.domain.archivage.structure.DocumentInput;
import ngondi.ged.ga.domain.archivage.structure.DocumentOutput;
import ngondi.ged.ga.exposition.structure.DocumentDTO;
import ngondi.ged.ga.exposition.structure.ErrorGed;
import ngondi.ged.ga.exposition.structure.ResponseDTO;
import ngondi.ged.ga.exposition.structure.ResponseDocumentDTO;
import ngondi.ged.ga.exposition.structure.ResponseDocumentsDTOS;

/**
 * @author gmihindou
 *
 */

@RestController
@RequestMapping("/ngondi")
public class ArchivageController {
	private static final Logger LOG = LoggerFactory.getLogger(ArchivageController.class);

	@Autowired
	private transient IArchivageManagement iArchivageManagement;

	/**
	 * Recupère un document dans la base de donnée
	 * 
	 * @param idDocument
	 * @return
	 */
	@GetMapping("/document/{idDocument}")
	public ResponseEntity<ResponseDocumentDTO> getDocument(@PathVariable("idDocument") String idDocument,
			@RequestParam(required = false) String olsen) {

		try {
			DocumentOutput documentOutput = iArchivageManagement.getDocument(idDocument);

			ResponseDocumentDTO responseDocument = new ResponseDocumentDTO();
			BeanUtils.copyProperties(documentOutput, responseDocument);

			return new ResponseEntity<ResponseDocumentDTO>(responseDocument, HttpStatus.OK);
		} catch (ArchivageException e) {
			LOG.error(e.getMessage(), e);

			Map<String, String> errors = e.getErrors();
//			 errors.entrySet().stream().map(err -> {
//				 ErrorGed error = new ErrorGed();
//				 
//			 });
			ErrorGed error = new ErrorGed();

			return new ResponseEntity<ResponseDocumentDTO>(new ResponseDocumentDTO(error), HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * Enregistre un document dans la base de donnée
	 * 
	 * @param documentGed
	 * @return
	 */

	@PostMapping("/document")
	public ResponseEntity<ResponseDTO> saveDocument(@RequestBody DocumentDTO documentDTO) {

		DocumentInput documentInput = new DocumentInput();

		BeanUtils.copyProperties(documentDTO, documentInput);

		try {
			String idDocument = iArchivageManagement.saveDocument(documentInput);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(idDocument), HttpStatus.OK);
		} catch (ArchivageException e) {
			return getErrors(e);
		}

	}

	/**
	 * supprime un document dans la base de donnée
	 * 
	 * @param String
	 * @return
	 */
	@DeleteMapping("/document/{idDocument}")
	public ResponseEntity<ResponseDTO> deleteDocument(@PathVariable("idDocument") String idDocument) {

		try {
			String idDoc = iArchivageManagement.deleteDoc(idDocument);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(idDoc), HttpStatus.OK);
		} catch (ArchivageException e) {
			return getErrors(e);
		}
	}

	/**
	 * modifie un document dans la base de donnée
	 * 
	 * @param idDocument
	 * @param documentGed
	 * @return
	 */
	@PatchMapping("/document/{idDocument}")
	public ResponseEntity<ResponseDTO> updateDocument(@PathVariable("idDocument") String idDocument,
			@RequestBody DocumentDTO documentDTO) {

		DocumentInput documentInput = new DocumentInput();

		BeanUtils.copyProperties(documentDTO, documentInput);

		try {
			String idDoc = iArchivageManagement.updateDocument(documentInput, idDocument);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(idDoc), HttpStatus.OK);
		} catch (ArchivageException e) {
			return getErrors(e);
		}

	}

	@GetMapping("/document")
	public ResponseEntity<ResponseDocumentsDTOS> getDocuments() {

		ResponseDocumentsDTOS responseDocumentsDTOS = new ResponseDocumentsDTOS();
		try {
			List<DocumentOutput> documentOutputs = iArchivageManagement.getDocuments();
			List<ResponseDocumentDTO> documentsDTO = null;

			documentsDTO = documentOutputs.stream().map(docOutput -> {

				ResponseDocumentDTO responseDocumentDTO = new ResponseDocumentDTO();
				BeanUtils.copyProperties(docOutput, responseDocumentDTO);

				return responseDocumentDTO;

			}).collect(Collectors.toList());

			responseDocumentsDTOS.setResponseDocuments(documentsDTO);
			return new ResponseEntity<ResponseDocumentsDTOS>(responseDocumentsDTOS, HttpStatus.OK);

		} catch (ArchivageException e) {

			LOG.error(e.getMessage(), e);

			Map<String, String> errors = e.getErrors();

			ErrorGed error = new ErrorGed();

			responseDocumentsDTOS.setErrors(error);

			return new ResponseEntity<ResponseDocumentsDTOS>(responseDocumentsDTOS, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * 
	 * @param e
	 * @return
	 */
	private ResponseEntity<ResponseDTO> getErrors(ArchivageException e) {
		LOG.error(e.getMessage(), e);

		Map<String, String> errors = e.getErrors();

		ErrorGed listeErrors = new ErrorGed();
		List<String> messages;
		errors.entrySet().iterator();

		return new ResponseEntity<ResponseDTO>(new ResponseDTO(listeErrors), HttpStatus.BAD_REQUEST);

	}

}
