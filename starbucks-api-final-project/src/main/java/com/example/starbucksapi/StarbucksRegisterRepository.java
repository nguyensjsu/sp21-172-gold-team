package com.example.starbucksapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

interface StarbucksRegisterRepository extends JpaRepository<StarbucksRegister, Long> {
    StarbucksRegister findByRegister(String regid);
    @Transactional StarbucksRegister deleteByRegid(String regid);

}
