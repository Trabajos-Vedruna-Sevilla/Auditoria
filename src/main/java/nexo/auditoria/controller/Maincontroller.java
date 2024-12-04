package nexo.auditoria.controller;

import java.util.List;

import nexo.auditoria.dto.ApiResponse2;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import lombok.extern.slf4j.Slf4j;
import nexo.auditoria.dto.ApiResponse;
import nexo.auditoria.dto.RequestDTO;
import nexo.auditoria.services.RequestServiceImpl;



@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/api")
public class Maincontroller {
	
	@Autowired
	private RequestServiceImpl requestService;
	
	@GetMapping(path = "/all")
    public List<RequestDTO> getAll() {
		return requestService.getAllRequest();
    }

	@GetMapping(path = "/allById/{id}")
	public List<RequestDTO> getAllById(@PathVariable  String id) {
		return requestService.getRequestById(id);
	}

	@GetMapping(path = "/allByIdpago/{id}/{estado}")
	public List<RequestDTO> getAllById(@PathVariable  String id,@PathVariable boolean estado) {
		return requestService.getRequestByIdPagadasNoPagadas(id,estado);
	}


	@PostMapping(path = "/insertar")
	public void createRequest(@RequestBody ApiResponse2 respuesta) {
		Logger log = LoggerFactory.getLogger(Maincontroller.class);
		log.info("Este es un mensaje de información");

		requestService.postPrueba(respuesta);
	}

	@GetMapping(path = "/allByIdpago1/{id}/{metodo}")
	public List<RequestDTO> getAllById(@PathVariable  String id,@PathVariable int metodo) {
		return requestService.getRequestByIdMetodo(id,metodo);
	}


}
