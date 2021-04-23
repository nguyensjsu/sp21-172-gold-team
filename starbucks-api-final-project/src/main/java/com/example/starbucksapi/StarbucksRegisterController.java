package com.example.starbucksapi;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//import com.example.starbucksapi.StarbucksRegisterController.Message;
//import com.example.starbucksapi.StarbucksOrderController.Message;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;

@RestController
class StarbucksRegisterController {
    private final StarbucksRegisterRepository repository;

    class Message {
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String msg) {
            status = msg;
        }
    }

    StarbucksRegisterController(StarbucksRegisterRepository repository) {
        this.repository = repository;
    }

    @PostMapping("/registers")
    @ResponseStatus(HttpStatus.CREATED)
    StarbucksRegister newRegister() {
        StarbucksRegister newRegister = new StarbucksRegister();

        Random random = new Random();
        int num = random.nextInt(900000) + 100000;

        newRegister.setRegid(String.valueOf(num));
        newRegister.setActivated(false);

        return repository.save(newRegister);
    }

    @GetMapping("/registers")
    List<StarbucksRegister> all() {
        return repository.findAll();
    }

    @DeleteMapping("/registers")
    Message deleteAll() {
        repository.deleteAllInBatch();
        Message msg = new Message();
        msg.setStatus("All Registers Cleared!");
        return msg;
    }

    @GetMapping("/registers/{regid}")
    StarbucksRegister getOne(@PathVariable String regid, HttpServletResponse reponse) {
        StarbucksRegister register = repository.findByRegister(regid);
        if (register == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Register Not Found!");
        return register;
    }

    
    @PostMapping("/registers/activate/{regid}")
    StarbucksRegister activate(@PathVariable String regid, HttpServletResponse reponse) {
        StarbucksRegister register = repository.findByRegister(regid);
        if (register == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Register Not Found!");
        if (register.getRegid().equals(regid)) {
            register.setActivated(true);
            repository.save(register);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Register Not Found!");
        }
        return register;
    }
    

    @DeleteMapping("/registers/{regid}")
    Message deleteOne(@PathVariable String regid, HttpServletResponse reponse) {
        StarbucksRegister register = repository.findByRegister(regid);
        // need to check for any active orders before deleting
        if (register == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Register Not Found!");
        
        repository.deleteByRegid(register.getRegid());
        Message msg = new Message();
        msg.setStatus("Register: {regid} Cleared!");
        return msg;
        
    }

}