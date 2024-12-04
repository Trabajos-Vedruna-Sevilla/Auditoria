package nexo.auditoria.dto;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface RequestRepository extends MongoRepository<RequestDTO, String>{

    List<RequestDTO> findByUserIdAndPaymentMethodAndPaidIsFalse(String userId, Integer paymentMethod);
    List<RequestDTO> findByUserId(String id);

    List<RequestDTO> findByUserIdAndPaid(String id, boolean paid);
    List<RequestDTO> findByUserIdAndPaymentMethod(String userId, Integer paymentMethod);
    List<RequestDTO> findByUserIdAndPaymentMethod(String id, int metodo);

    List<RequestDTO> findByUserIdAndPaymentMethodAndPaidIsFalseAndRequestDateBetween(String userId, Integer paymentMethod,
                                                                       Date dateS, Date dateE);

    //int updateByUserIdAndPaymentMethod(String userId, Integer paymentMethod, boolean paid);
    //void updatePaidByUserIdAndPaymentMethod(String userId, String paymentMethod, boolean paid);
    /*
    @Query("{'userId' : ?0, 'paymentMethod' : ?1}")
    int updateByUserIdAndPaymentMethod(String userId, Integer paymentMethod);*/


}
