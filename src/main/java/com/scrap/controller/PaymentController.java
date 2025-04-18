package com.scrap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.scrap.entities.Payment;
import com.scrap.entities.UserProfile;
import com.scrap.services.PaymentService;
import com.scrap.services.UserProfileService;

import java.util.List;

@RestController
@RequestMapping("/api/payments")
public class PaymentController {
    @Autowired
    private PaymentService paymentService;

    @Autowired
    private UserProfileService userProfileService;


    // @PostMapping
    // public ResponseEntity<Payment> createPayment(@RequestBody Payment payment) {
    //     Payment createdPayment = paymentService.savePayment(payment);
    //     return new ResponseEntity<>(createdPayment, HttpStatus.CREATED);
    // }

    @GetMapping("/{id}")
    public ResponseEntity<List<Payment>> getAllPayments(@PathVariable Long id) {
        UserProfile userProfile = userProfileService.getUserProfile(id);
        if (userProfile != null){
            List<Payment> payments = paymentService.getAllPayments();
            return new ResponseEntity<>(payments, HttpStatus.OK);
        }
        return new ResponseEntity<>(null, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Payment> updatePayment(@PathVariable Long id, @RequestBody Payment payment) {
        Payment updatedPayment = paymentService.updatePayment(id, payment);
        return new ResponseEntity<>(updatedPayment, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePayment(@PathVariable Long id) {
        paymentService.deletePayment(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
