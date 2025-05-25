package com.movie.paymentservice.service;

import com.movie.paymentservice.entity.Payment;
import com.movie.paymentservice.repository.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    public Payment addPayment(Payment payment) {
    	payment.setPaymentTime(LocalDateTime.now());
        return paymentRepository.save(payment); // Save new show timing
    }

    public Payment updatePayment(Integer id, Payment paymentDetails) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show timing not found with id " + id));

        payment.setAmount(paymentDetails.getAmount());
        payment.setPaymentMethod(paymentDetails.getPaymentMethod());
        payment.setPaymentStatus(paymentDetails.getPaymentStatus());
        payment.setPaymentTime(paymentDetails.getPaymentTime());
        payment.setTicketId(paymentDetails.getTicketId()); // Resetting available seats

        return paymentRepository.save(payment); // Save updated show timing
    }

    public void deletePayment(Integer id) {
        Payment payment = paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show timing not found with id " + id));
        paymentRepository.delete(payment); // Delete show timing
    }

    public List<Payment> getAllPayments() {
        return paymentRepository.findAll(); // Retrieve all show timings
    }

    public Payment getPaymentById(Integer id) {
        return paymentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Show timing not found with id " + id)); // Find by ID
    }
}