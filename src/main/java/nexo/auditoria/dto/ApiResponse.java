package nexo.auditoria.dto;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpHeaders;
import org.springframework.web.reactive.function.client.ClientResponse;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonIgnoreProperties(ignoreUnknown = true)
public class ApiResponse {
    private int id;
    private String userId;
    private int status;
    private int paymentMethod;
    private boolean paid;
    private Date requestDate;
    private Map<String,String> requestPayload;
    private HttpHeaders requestHeaders;
    private Response responsePayload;

}