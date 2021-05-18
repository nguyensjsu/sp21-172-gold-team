package com.example.starbucksapi;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.GenerationType;
import javax.persistence.Index;
import javax.persistence.Table;

import lombok.Data;
import lombok.RequiredArgsConstructor;

@Entity
//@Table(indexes=@Index(name = "altIndex", columnList = "regid", unique = true))
@Data
@RequiredArgsConstructor
class StarbucksRegister {

    private @Id @GeneratedValue Long id;
    private String regid;
    private boolean activated;

    private String status;

    public boolean isActivated() { return activated == true;}

}
