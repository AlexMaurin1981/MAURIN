package com.example.demo.model;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

import javax.validation.constraints.Size;


@Entity
@Table (name = "person")
public class Person {

    @Id
    @Column (name = "id")
    @GeneratedValue (strategy =GenerationType.IDENTITY)
    private int id;
    @NotEmpty (message = "не должно быть пустым")
    @Size (min = 2, max = 100, message = "имя не должно быть от 2 до 100 символов")
    @Column (name = "username")
   private String username;
    @Size( min = 1900,message = "год не должен быть больше чем 1900г")
    @Column(name = "year_of_birth")
   private int year_of_birth;

    public Person() {
    }

    @Column (name = "password")
   private  String password;


    public Person(int id, String username, int year_of_birth, String password) {
        this.id = id;
        this.username = username;
        this.year_of_birth = year_of_birth;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public int getYear_of_birth() {
        return year_of_birth;
    }

    public void setYear_of_birth(int year_of_birth) {
        this.year_of_birth = year_of_birth;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", year_of_birth=" + year_of_birth +
                ", password='" + password + '\'' +
                '}';
    }
}
