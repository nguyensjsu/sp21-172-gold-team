package com.example.starbucksapi;

import java.util.Set;
//import javax.persistence.CascadeType;
import javax.persistence.*;

@Entity
@Table(name= "auth user")
public class User {

    @Column(name = "auth_user_id")
    private @Id @GeneratedValue Long id;

    @Column(name = "first_name")
    private String name;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "mobile")
    private String mobile;

    @Column(name = "status")
    private String status;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "auth_user_role", joinColumns = @JoinColumn(name = "auth_user_id"), inverseJoinColumns = @JoinColumn (name = "auth_role_id"))
    private Set<Role> roles;

    public int getId(){
        return id;
    }

    public void setId(int tid){
        this.id = tid;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }
    
    public String getLastName(){
        return lastName;
    }

    public void setLastName(String lastName){
        this.lastName = lastName;
    }

    public String getEmail(){
        return email;
    }

    public void setEmail(String email){
        this.email = email;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getMobile(){
        return mobile;
    }

    public void setMobile(String mobile){
        this.mobile = mobile;
    }

    public String getStatus(){
        return status;
    }
    
    public void setStatus (String status){
        this.status = status;
    }

}
