package nexo.auditoria.services;

import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.Date;

@Service
public interface PaymentServiceI {

    public int getNumeroConsultarByUsuarioMetodoPago(String userId, Integer paymentMethod) ;


    public void  patch (String userId, Integer paymentMethod) ;

    public void  patch2 (String userId, Integer paymentMethod) ;

    public int getPendingByDateAndPayMet(String userId, Integer paymentMethod, Date dateS, Date dateE) ;


}
