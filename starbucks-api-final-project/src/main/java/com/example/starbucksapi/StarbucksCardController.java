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
class StarbucksCardController {
    private final StarbucksCardRepository repository;

    class Message {
        private String status;

        public String getStatus() {
            return status;
        }

        public void setStatus(String msg) {
            status = msg;
        }
    }

    StarbucksCardController(StarbucksCardRepository repository) {
        this.repository = repository;
    }

    // Create a new Starbucks card
    @PostMapping("/cards")
    @ResponseStatus(HttpStatus.CREATED)
    StarbucksCard newCard() {
        StarbucksCard newCard = new StarbucksCard();

        Random random = new Random();
        int num = random.nextInt(900000000) + 100000000;
        int code = random.nextInt(900) + 100;

        newCard.setCardNumber(String.valueOf(num));
        newCard.setCardCode(String.valueOf(code));
        newCard.setBalance(20.00);
        newCard.setActivated(false);
        newCard.setStatus("New Card");
        newCard.setRewards(0);

        return repository.save(newCard);
    }

    @GetMapping("/cards")
    List<StarbucksCard> all() {
        return repository.findAll();
    }

    @DeleteMapping("/cards")
    Message deleteAll() {
        repository.deleteAllInBatch();
        Message msg = new Message();
        msg.setStatus("All Cards Cleared!");
        return msg;
    }

    @GetMapping("/cards/{num}")
    StarbucksCard getOne(@PathVariable String num, HttpServletResponse reponse) {
        StarbucksCard card = repository.findByCardNumber(num);
        if (card == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card Not Found!");
        return card;
    }

    @PostMapping("/card/activate/{num}/{code}")
    StarbucksCard activate(@PathVariable String num, @PathVariable String code, HttpServletResponse reponse) {
        StarbucksCard card = repository.findByCardNumber(num);
        if (card == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card Not Found!");
        if (card.getCardCode().equals(code)) {
            card.setActivated(true);
            repository.save(card);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card Not Found!");
        }
        return card;
    }


    @PostMapping("/card/{cardNum}/{value}")
    void addBalance(@PathVariable String cardNum, @PathVariable String value, HttpServletResponse reponse) {
        StarbucksCard card = repository.findByCardNumber(cardNum);
        if (card == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card Not Found!");

        if(value.startsWith("-") )
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Negative value added");

        old_balance = card.getBalance();
        new_balance = old_balance + value;
            
        card.setBalance(new_balance);
    }

    @PostMapping("/card/rewards/{cardNum}")
    void showRewards(@PathVariable String cardNum, HttpServletResponse reponse) {
        StarbucksCard card = repository.findByCardNumber(cardNum);
        if (card == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. Card Not Found!");

        if(card.getRewards() == 0 || card.getRewards() == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Error. No Rewards Points Found");

        card.getRewards();
    }
}
