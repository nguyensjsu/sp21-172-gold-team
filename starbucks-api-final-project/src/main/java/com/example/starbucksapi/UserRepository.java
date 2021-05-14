package com.example.starbucksapi;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;

interface UserRepository extends JpaRepository<User, Long> {
    

}