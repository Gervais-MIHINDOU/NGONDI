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

import ngondi.ged.ga.application.fournisseur.IFournisseurManagement;
import ngondi.ged.ga.domain.archivage.FournisseurException;
import ngondi.ged.ga.domain.archivage.structure.FournisseurInput;
import ngondi.ged.ga.domain.archivage.structure.FournisseurOuput;
import ngondi.ged.ga.exposition.structure.DocOfFournisseurDTO;
import ngondi.ged.ga.exposition.structure.ErrorGed;
import ngondi.ged.ga.exposition.structure.FournisseurDTO;
import ngondi.ged.ga.exposition.structure.ResponseDTO;
import ngondi.ged.ga.exposition.structure.ResponseFournisseurDTO;
import ngondi.ged.ga.exposition.structure.ResponseFournisseurDTOS;

/**
 * 
 * @author gmihindou
 *
 */
@RestController
@RequestMapping("/ngondi")
public class FournisseurController {

	private static final Logger LOG = LoggerFactory.getLogger(FournisseurController.class);
	@Autowired
	private IFournisseurManagement fournisseurManagement;

	@PostMapping("/fournisseur")
	public ResponseEntity<ResponseDTO> saveFournisseur(@RequestBody FournisseurDTO fournisseurDTO) {
		FournisseurInput fournisseurInput = new FournisseurInput();
		try {
			BeanUtils.copyProperties(fournisseurDTO, fournisseurInput);
			String idFournisseur = fournisseurManagement.saveFournisseur(fournisseurInput);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(idFournisseur), HttpStatus.OK);
		} catch (FournisseurException e) {
			return getErrorsFournisseur(e);
		}

	}

	@PostMapping("/document/fournisseur")
	public ResponseEntity<ResponseDTO> saveDocOfFournisseur(@RequestBody DocOfFournisseurDTO docOfFournisseurDTO) {
		FournisseurInput fournisseurInput = new FournisseurInput();
		try {
			String idFournisseur = fournisseurManagement.saveDocOfFournisseur(docOfFournisseurDTO.getIdDocuments(),
					docOfFournisseurDTO.getIdFournisseur());
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(idFournisseur), HttpStatus.OK);
		} catch (FournisseurException e) {
			return getErrorsFournisseur(e);
		}

	}

	/**
	 * supprime un document dans la base de donnée
	 * 
	 * @param String
	 * @return
	 */
	@DeleteMapping("/fournisseur/{idFournisseur}")
	public ResponseEntity<ResponseDTO> deleteFournisseur(@PathVariable("idFournisseur") String idFournisseur) {
		try {
			String id = fournisseurManagement.deleteFournisseur(idFournisseur);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(id), HttpStatus.OK);
		} catch (FournisseurException e) {
			return getErrorsFournisseur(e);
		}

	}

	/**
	 * modifie un document dans la base de donnée
	 * 
	 * @param idDocument
	 * @param documentGed
	 * @return
	 */
	@PatchMapping("/fournisseur/{idFournisseur}")
	public ResponseEntity<ResponseDTO> updateFournisseur(@PathVariable("idFournisseur") String idFournisseur,
			@RequestBody ResponseFournisseurDTO responseFournisseurDTO) {
		FournisseurInput fournisseurInput = new FournisseurInput();
		BeanUtils.copyProperties(responseFournisseurDTO, fournisseurInput);
		try {
			idFournisseur = fournisseurManagement.updateFournisseur(fournisseurInput, idFournisseur);
			return new ResponseEntity<ResponseDTO>(new ResponseDTO(idFournisseur), HttpStatus.OK);
		} catch (FournisseurException e) {
			return getErrorsFournisseur(e);
		}
	}

	@GetMapping("/fournisseur")
	public ResponseEntity getFournisseurs() {

		try {
			List<FournisseurOuput> fournisseurOuputs = null;
			List<ResponseFournisseurDTO> fournisseurs = null;
			fournisseurOuputs = fournisseurManagement.getFournisseurs();
			fournisseurs = fournisseurOuputs.stream().map(f -> {
				ResponseFournisseurDTO responseFournisseurDTO = new ResponseFournisseurDTO();
				BeanUtils.copyProperties(f, responseFournisseurDTO);
				return responseFournisseurDTO;
			}).collect(Collectors.toList());
			return new ResponseEntity<ResponseFournisseurDTOS>(new ResponseFournisseurDTOS(fournisseurs),
					HttpStatus.OK);

		} catch (FournisseurException e) {
			LOG.error(e.getMessage(), e);

			Map<String, String> errors = e.getErrors();

			ErrorGed listeErrors = new ErrorGed();
			List<String> messages;
			errors.entrySet().iterator();

			return new ResponseEntity<ResponseFournisseurDTOS>(new ResponseFournisseurDTOS(listeErrors),
					HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping("/fournisseur/{idFournisseur}")
	public ResponseEntity getFournisseurs(@RequestParam(name = "activite", required = false) String activite,
			@PathVariable(name = "idFournisseur", required = false) String idFournisseur) {

		try {
			List<FournisseurOuput> fournisseurOuputs = null;
			List<ResponseFournisseurDTO> fournisseurs = null;

			if (activite != null) {
				fournisseurOuputs = fournisseurManagement.getFournisseursByActivity(activite);
				fournisseurs = fournisseurOuputs.stream().map(f -> {
					ResponseFournisseurDTO responseFournisseurDTO = new ResponseFournisseurDTO();
					BeanUtils.copyProperties(f, responseFournisseurDTO);
					return responseFournisseurDTO;
				}).collect(Collectors.toList());
				return new ResponseEntity<ResponseFournisseurDTOS>(new ResponseFournisseurDTOS(fournisseurs),
						HttpStatus.OK);
			} else if (idFournisseur != null) {

				ResponseFournisseurDTO responseFournisseurDTO = new ResponseFournisseurDTO();
				FournisseurOuput fournisseurOuput = fournisseurManagement.getFournisseur(idFournisseur);
				BeanUtils.copyProperties(fournisseurOuput, responseFournisseurDTO);
				responseFournisseurDTO.setIdDocuments(fournisseurOuput.getIdDocuments());
				return new ResponseEntity<ResponseFournisseurDTO>(responseFournisseurDTO, HttpStatus.OK);

			} else {
				fournisseurOuputs = fournisseurManagement.getFournisseurs();
				fournisseurs = fournisseurOuputs.stream().map(f -> {
					ResponseFournisseurDTO responseFournisseurDTO = new ResponseFournisseurDTO();
					BeanUtils.copyProperties(f, responseFournisseurDTO);
					return responseFournisseurDTO;
				}).collect(Collectors.toList());
				return new ResponseEntity<ResponseFournisseurDTOS>(new ResponseFournisseurDTOS(fournisseurs),
						HttpStatus.OK);
			}

		} catch (FournisseurException e) {
			LOG.error(e.getMessage(), e);

			Map<String, String> errors = e.getErrors();

			ErrorGed listeErrors = new ErrorGed();
			List<String> messages;
			errors.entrySet().iterator();

			return new ResponseEntity<ResponseFournisseurDTOS>(new ResponseFournisseurDTOS(listeErrors),
					HttpStatus.BAD_REQUEST);
		}

	}

	private ResponseEntity<ResponseDTO> getErrorsFournisseur(FournisseurException e) {
		LOG.error(e.getMessage(), e);

		Map<String, String> errors = e.getErrors();

		ErrorGed listeErrors = new ErrorGed();
		List<String> messages;
		errors.entrySet().iterator();

		return new ResponseEntity<ResponseDTO>(new ResponseDTO(listeErrors), HttpStatus.BAD_REQUEST);

	}

}
