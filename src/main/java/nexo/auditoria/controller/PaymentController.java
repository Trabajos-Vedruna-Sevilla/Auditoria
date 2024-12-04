package nexo.auditoria.controller;

import lombok.extern.slf4j.Slf4j;
import nexo.auditoria.dto.RequestDTO;
import nexo.auditoria.services.PaymentServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@Slf4j
@CrossOrigin
@RequestMapping("/pay")
public class PaymentController {

    @Autowired
    private PaymentServiceImpl paymentService;


    @GetMapping(path = "/numConsByMet/{userId}/{paymentMethod}")
    public int getNumeroConsultarByUsuarioMetodoPago(@PathVariable String userId, @PathVariable Integer paymentMethod) {
        return paymentService.getNumeroConsultarByUsuarioMetodoPago(userId,paymentMethod);
    }

    @PutMapping (path = "/pay/{userId}/{paymentMethod}")
    public void  updateByUserIdAndPaymentMethod(@PathVariable String userId, @PathVariable Integer paymentMethod) {
         paymentService.patch(userId,paymentMethod);

    }

    @PutMapping (path = "/pay2/{userId}/{paymentMethod}")
    public void  updateByUserIdAndPaymentMethod2(@PathVariable String userId, @PathVariable Integer paymentMethod) {
        paymentService.patch(userId,paymentMethod);

    }

    @GetMapping(path = "/numPendingByDate/{userId}/{paymentMethod}")
    public int getPendingByDateAndPayMet(@PathVariable String userId, @PathVariable Integer paymentMethod,
                                         @RequestHeader ("dateS") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                         Date dateS,
                                         @RequestHeader("dateE") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
                                         Date dateE) {
        return paymentService.getPendingByDateAndPayMet(userId, paymentMethod, dateS, dateE);
    }

}
