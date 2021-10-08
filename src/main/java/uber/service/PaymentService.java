package uber.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import uber.entity.Payment;
import uber.repository.PaymentRepository;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;

    public Payment savePayment(Payment payment){
        return paymentRepository.save(payment);
    }
}
