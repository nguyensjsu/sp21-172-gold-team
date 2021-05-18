package com.example.starbucksapi;

import javax.persistence.Id;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.annotation.processing.Generated;
import javax.persistence.Column;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(indexes=@Index(name = "Payments", columnList = "cardnum"))
@Data
@RequiredArgsConstructor
class PaymentsCommand {

    private @Id @GeneratedValue Long id;

    transient private String action ;
    private String firstname ;
    private String lastname ;
    private String address ;
    private String city ;
    private String state ;
    private String zip ;
    private String phone ;
    private String cardnum ;
    private String cardexpmonth ;
    private String cardexpyear ;
    private String cardcvv ;
    private String email ;
    private String notes ;

    private String orderNumber ;
    private String transactionAmount ;
    private String transactionCurrency ;
    private String authId ;
    private String authStatus ;
    private String captureId ;
    private String captureStatus ;

    public String firstname() { return firstname; }
    public String lastname() { return lastname; }
    public String address() { return address; }
    public String city() { return city; }
    public String state() { return state; }
    public String zip() { return zip; }
    public String phone() { return phone; }
    public String cardnum() { return cardnum; }
    public String cardexpmon() { return cardexpmonth; }
    public String cardexpyear() { return cardexpyear; }
    public String cardcvv() {return cardcvv;}
    public String email() { return email; }
    public String notes() { return notes; }

}
