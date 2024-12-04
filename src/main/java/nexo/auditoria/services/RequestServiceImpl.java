package nexo.auditoria.services;


import java.util.Date; 
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import lombok.extern.slf4j.Slf4j;
import nexo.auditoria.dto.ApiResponse2;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.bson.Document;

import nexo.auditoria.dto.ApiResponse;
import nexo.auditoria.dto.RequestDTO;
import nexo.auditoria.dto.RequestRepository;
import org.springframework.web.reactive.function.client.WebClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RequestServiceImpl implements RequestServiceI {

	@Autowired
	private RequestRepository requestRepository;

	@Override
	public List<RequestDTO> getAllRequest() {
		Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
		log.info("Este es un mensaje de información");
		return requestRepository.findAll();
		
	}

	@Override
	public List<RequestDTO> getRequestById(String id) {
		Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
		log.info("Este es un mensaje de información");

		// Assuming requestRepository.findById(id) returns an Optional<RequestDTO>
		List<RequestDTO> requestOptional = requestRepository.findByUserId(id);

		// Convert the Optional<RequestDTO> to a List<RequestDTO>
		/*List<RequestDTO> resultList = requestOptional
				.map(Collections::singletonList)
				.orElse(Collections.emptyList());*/

		return requestOptional;
	}

	public List<RequestDTO> getRequestByIdPagadasNoPagadas(String id, boolean estado) {

		Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
		log.info("Este es un mensaje de información");

		List<RequestDTO> requestOptional = requestRepository.findByUserIdAndPaid(id,estado);


		return requestOptional;
	}

	public List<RequestDTO> getRequestByIdMetodo(String id, int metodo) {

		Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
		log.info("Este es un mensaje de información");

		List<RequestDTO> requestOptional = requestRepository.findByUserIdAndPaymentMethod(id,metodo);

		return requestOptional;
	}

	@Override
	public void postPrueba(ApiResponse2 a) {
		Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
		log.info("Entra en el servicio de post");
		RequestDTO b = new RequestDTO();
		b.setUserId(a.getUserId());
		b.setId(a.getId());
		b.setRequestDate(a.getRequestDate());
		log.info("AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA" +a.getRequestDate());
		b.setStatus(a.getStatus());
		b.setPaymentMethod(a.getPaymentMethod());
		b.setResponsePayload(a.getResponsePayload());
		requestRepository.save(b);
		
	}





	/*public ResponseEntity<String> createRequest(Object ps) {
		try {
			// Verifica que ps sea del tipo ResponseEntity antes de extraer la información
			if (ps instanceof ResponseEntity) {
				ResponseEntity<?> respuesta = (ResponseEntity<?>) ps;
				
				// Extrae la información necesaria de la ResponseEntity y crea un nuevo objeto RequestDTO
				RequestDTO requestDTO = new RequestDTO();
				requestDTO.set
				requestDTO.setId(1); // Asigna el valor adecuado
				requestDTO.setUserId("joaquin"); // Asigna el valor adecuado
				requestDTO.setStatus(200); // Asigna el valor adecuado
				requestDTO.setPaymentMethod(1); // Asigna el valor adecuado
				requestDTO.setPaid(true); // Asigna el valor adecuado
				requestDTO.setRequestDate(new Date()); // Asigna el valor adecuado
				requestDTO.setRequestPayload(null); // Asigna el valor adecuado
				// Asigna null o el valor adecuado según tu caso
				requestDTO.setResponsePayload((Map<String, Object>) respuesta.getBody());

				// Guarda el objeto RequestDTO en el repositorio
				requestRepository.save(requestDTO);
				Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
				log.info("entro en el if");
				// Devuelve una ResponseEntity con un mensaje indicando que la operación fue exitosa
				return new ResponseEntity<>("Solicitud creada correctamente", HttpStatus.OK);
			} else {

				RequestDTO requestDTO = new RequestDTO();
				requestDTO.setId(1); // Asigna el valor adecuado
				requestDTO.setUserId("joaquin"); // Asigna el valor adecuado
				requestDTO.setStatus(200); // Asigna el valor adecuado
				requestDTO.setPaymentMethod(1); // Asigna el valor adecuado
				requestDTO.setPaid(true); // Asigna el valor adecuado
				requestDTO.setRequestDate(new Date()); // Asigna el valor adecuado
				requestDTO.setRequestPayload(null); // Asigna el valor adecuado
				requestDTO.setResponsePayload((Map<String, Object>) ps);
				Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
				log.info("entro en el else antes del save");

				requestRepository.save(requestDTO);

				log.info("entro en el else despues del save");
				return new ResponseEntity<>("Solicitud creada correctamente en el else", HttpStatus.OK);


				/*
				Map<String, Object> prueba = new HashMap<>();
				prueba.put("key", "hola");  // Puedes ajustar la clave ("key") según tus necesidades
				RequestDTO requestDTO = new RequestDTO();
				requestDTO.setResponsePayload(prueba);
				requestRepository.save(requestDTO);
				return new ResponseEntity<>("Solicitud creada correctamente desde el else", HttpStatus.OK);
				*//*
			}
		} catch (Exception e) {
			Map<String, Object> prueba = new HashMap<>();
			prueba.put("key", "ae");  // Puedes ajustar la clave ("key") según tus necesidades
			prueba.put("tipo", e.toString());
			prueba.put("tipoDeObjeto", ps.getClass().getName());
			prueba.put("tipodeob", ps.toString());
			RequestDTO requestDTO = new RequestDTO();
			requestDTO.setResponsePayload(prueba);
			Logger log = LoggerFactory.getLogger(RequestServiceImpl.class);
			log.info("entro en el cantch antes del save");

			requestRepository.save(requestDTO);

			log.info("entro en el cantch despues del save");
			return new ResponseEntity<>("Error al crear la solicitud: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/



	/*
	public ResponseEntity<String> createRequest(ResponseEntity respuesta) {
		try {
			// Extrae la información necesaria de la ResponseEntity y crea un nuevo objeto RequestDTO
			RequestDTO requestDTO = new RequestDTO();
			requestDTO.setId(1); // Asigna el valor adecuado
			requestDTO.setUserId("joaquin"); // Asigna el valor adecuado
			requestDTO.setStatus(200); // Asigna el valor adecuado
			requestDTO.setPaymentMethod(1); // Asigna el valor adecuado
			requestDTO.setPaid(true); // Asigna el valor adecuado
			requestDTO.setRequestDate(new Date()); // Asigna el valor adecuado
			requestDTO.setRequestPayload(null); // Asigna el valor adecuado
			// Asigna null o el valor adecuado según tu caso
			requestDTO.setResponsePayload((Map<String, Object>) respuesta.getBody());

			// Guarda el objeto RequestDTO en el repositorio
			requestRepository.save(requestDTO);

			// Devuelve una ResponseEntity con un mensaje indicando que la operación fue exitosa
			return new ResponseEntity<>("Solicitud creada correctamente", HttpStatus.OK);
		} catch (Exception e) {
			// En caso de error, devuelve una ResponseEntity con el mensaje de error
			return new ResponseEntity<>("Error al crear la solicitud: " + e.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	*/

}
