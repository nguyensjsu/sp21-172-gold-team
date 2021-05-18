package com.example.springpayments;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.springpayments.PaymentsCommand;

interface PaymentsCommandRepository extends JpaRepository<PaymentsCommand,Long> {

}