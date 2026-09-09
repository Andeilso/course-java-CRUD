package com.project.course.services;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.project.course.entities.Payment;
import com.project.course.repositories.PaymentRepository;

@Service 
public class PaymentService {
    private final PaymentRepository paymentRepository;

    public PaymentService(PaymentRepository paymentRepository){
        this.paymentRepository = paymentRepository;
    }

    public Set<Payment> findAll(){
        List<Payment> payments = paymentRepository.findAll();

        return new HashSet<>(payments);
    }

    public Payment findById(Long id){
        Optional<Payment> payment = paymentRepository.findById(id);

        return payment.get();
    }
}
