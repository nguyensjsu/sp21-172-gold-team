package com.example.starbucksapi;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.starbucksapi.PaymentsCommand;

interface PaymentsCommandRepository extends JpaRepository<PaymentsCommand,Long> {

}