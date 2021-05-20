package com.example.starbucksapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//import net.javaguides.springboot.model.User;
//import net.javaguides.springboot.repository.UserRepository;

@SpringBootApplication
public class StarbucksBackendApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(StarbucksBackendApplication.class, args);
    }

    @Autowired
    private StarbucksOrderRepository repository;

    @Override
    public void run(String...args) throws Exception {
        this.repository.save(new StarbucksOrder("Caffe Mocha", "Gradne", "5.00"));
        this.repository.save(new StarbucksOrder("Caffe Americano", "Grande", "5.00"));
        this.repository.save(new StarbucksOrder("Cappuccino", "Grande", "5.00"));
        this.repository.save(new StarbucksOrder("Caffe Latte", "Grande", "5.00"));
    }
}