package com.example.starbucksapi;

//import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

//import javax.persistence.Entity;
import javax.persistence.Column;
//import javax.persistence.GeneratedValue;
//import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

/* https: //spring. io/guides/tutorials/rest/ */

@Entity
@Data
@Table(name = "menu")
@RequiredArgsConstructor
class StarbucksOrder {

    private @Id @GeneratedValue Long id;
    @Column (name = "drinks")
    private String drink ;
    
    /*
    private String CaffeMocha ;
    private String CaffeAmericano ;
    private String Cappuccino ;
    private String CaffeeLatte ;
    */
    @Column (name = "sizes")
    private String size;

    @Column (name = "prize")
    private double prize;

    public StarbucksOrder(String drink, String size, String prize){
        super();
        this.drink = drink;
        this.size = size;
        this.size = prize;
    }
    

    /*
    private double mochaPrize;
    private double americanoPrize;
    private double appuccinoPrize;
    private double lattePrize;
    */
    /*
    private String drink ;
    private String milk ;
    private String size ;
    private double total ; 
    private String status ;
    */

}
/*
    type starbucks_order struct {
    Drink string
    Milk string
    Size string

    Total float32
    Status string
    }
*/