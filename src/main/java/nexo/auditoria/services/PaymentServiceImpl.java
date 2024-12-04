package nexo.auditoria.services;

import nexo.auditoria.dto.RequestDTO;
import nexo.auditoria.dto.RequestRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import nexo.auditoria.services.RequestServiceImpl;


import java.util.Date;
import java.util.List;

@Service
public class PaymentServiceImpl implements PaymentServiceI {

    @Autowired
    private RequestRepository requestRepository;
    @Autowired
    private RequestServiceImpl requestService;

    @Override
    public int getNumeroConsultarByUsuarioMetodoPago(String userId, Integer paymentMethod) {
        List<RequestDTO> request = requestRepository.findByUserIdAndPaymentMethodAndPaidIsFalse(userId, paymentMethod);
        return request.size();
    }

    @Override
    public void  patch(String userId, Integer paymentMethod) {

        List<RequestDTO> paymentsToUpdate = requestRepository.findByUserIdAndPaymentMethod(userId, paymentMethod);
        for (RequestDTO payment : paymentsToUpdate) {
            payment.setPaid(true);
            requestRepository.save(payment);
        }



    }

    @Override
    public void patch2(String userId, Integer paymentMethod) {
        List<RequestDTO> paymentsToUpdate = requestRepository.findByUserIdAndPaymentMethod(userId, paymentMethod);
        for (RequestDTO payment : paymentsToUpdate) {
            payment.setPaid(true);
            requestRepository.save(payment);
        }
    }

    @Override
    public int getPendingByDateAndPayMet(String userId, Integer paymentMethod, Date dateS, Date dateE) {
        List<RequestDTO> request = requestRepository.findByUserIdAndPaymentMethodAndPaidIsFalseAndRequestDateBetween(userId,
                paymentMethod, dateS, dateE);
        return request.size();
    }


}
