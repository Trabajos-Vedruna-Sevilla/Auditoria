package nexo.auditoria.services;

import java.util.List;

import nexo.auditoria.dto.ApiResponse2;
import org.springframework.stereotype.Service;

import nexo.auditoria.dto.ApiResponse;
import nexo.auditoria.dto.RequestDTO;

@Service
public interface RequestServiceI {
	
	public List<RequestDTO> getAllRequest();
	public List<RequestDTO> getRequestById(String id);
	public void postPrueba(ApiResponse2 a);

}
