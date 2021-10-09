package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import uber.entity.Payment;
import uber.repository.PaymentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    @Transactional
    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }

    public List<Payment> findAll(){
        Iterable<Payment> paymentIterable = paymentRepository.findAll();
        List<Payment> payments = new ArrayList<>();

        paymentIterable.iterator().forEachRemaining(payments::add);
        return payments;
    }


}
