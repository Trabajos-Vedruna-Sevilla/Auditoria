package nexo.auditoria.dto;
import java.util.Date;
import java.util.Map;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@AllArgsConstructor
@Data
@NoArgsConstructor
@Document(collection = "Requests")
public class RequestDTO {
    @Id
    private ObjectId  _id;
    
    private int id;
    private String userId;
    private int status;
    private int paymentMethod;
    private boolean paid;
    private Date requestDate;
    private Map<String,String> requestPayload;
    //private HttpHeaders requestHeaders;
    private Map<String, Object> responsePayload;
    //private int id;
    //private String userId;
    //private int status;
    //private int paymentMethod;
    //private boolean paid;
    //private Date requestDate;
    //private Map<String, Object> requestPayload;
    //private Map<String, Object> responsePayload;
    
    

}
