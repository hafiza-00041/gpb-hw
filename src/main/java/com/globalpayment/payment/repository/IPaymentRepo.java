package com.globalpayment.payment.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.globalpayment.payment.entity.Payment;


@Repository
public interface IPaymentRepo extends JpaRepository<Payment, Long> {
    
}
