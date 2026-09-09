package com.project.course.resources;

import java.util.Set;

import com.project.course.entities.Payment;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.course.services.PaymentService;

@RestController
@RequestMapping ("/payments")
public class PaymentResources {
    private PaymentService paymentService;

    public PaymentResources(PaymentService paymentService){
        this.paymentService = paymentService;
    }

    @GetMapping
    public ResponseEntity<Set<Payment>> findAll(){
        Set<Payment> payments = paymentService.findAll();

        return ResponseEntity.ok().body(payments);
    }

    @GetMapping ("/{id}")
    public ResponseEntity<Payment> findById(@PathVariable Long id){
        Payment payment = paymentService.findById(id);

        return ResponseEntity.ok().body(payment);
    }
}
