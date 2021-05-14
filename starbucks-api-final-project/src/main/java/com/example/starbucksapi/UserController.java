package com.example.starbucksapi;

import java.util.List;
import java.util.Random;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.example.starbucksapi.StarbucksOrderController.Message;

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
class UserController {
    private final UserControllerRepository userRepository;

    @Autowired
    private StarbucksCardRepository cardRepository;

    class Message {
        private String status;

        public String getStatus(){
            return status;
        }

        public void setStatus(String msg){
            status = msg;
        }
    }

    private HashMap<String, StarbucksOrder> userHash = new HashMap<>();

    @GetMapping("/users")
    List<User> all() {
        return userRepository.findAll();
    }

    @DeleteMapping("/users")
    Message deleteAll() {
        userRepository.deleteAllInBatch();
        userHash.clear();
        Message msg = new Message();
        msg.setStatus("All Orders Cleared!");
        return msg;
    }

    @GetMapping("/users/{regid}")
    User getOne(@PathVariable String regid, HttpServletResponse reponse) {
        User user = userHash.get(regid);

        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Register Not Found!");
        return user;
    }

    @PostMapping("/users/activate/{regid}")
    User activate(@PathVariable String regid, HttpServletResponse reponse) {
        //StarbucksRegister register = repository.findByRegister(regid);
        User user = userHash.get(regid);
        if (user == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Register Not Found!");
        if (user.getRegid().equals(regid)) {
            user.setActivated(true);
            userRepository.save(user);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Register Not Found!");
        }
        return user;
    }

}
