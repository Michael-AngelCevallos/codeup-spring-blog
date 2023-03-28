package com.codeup.codeupspringblog.models;

import jakarta.persistence.*;

@Entity
@Table(name = "dogs")
public class Dog {


//    Create a model class (Dog) with proper annotations to make a dogs table with the following properties:
//  1) id
//  2) age
//  3) name
//  4) resideState


    @Id
    @Column(name = "id", columnDefinition = "int(11) UNSIGNED", nullable = false )
    private Long id;

    @Column(name = "age", columnDefinition = " tinyint(3) unsigned ", nullable = false)
    @GeneratedValue(strategy  = GenerationType.IDENTITY)
    private Integer age;


    @Column(name = "name", columnDefinition = "varchar(200) ", nullable = false)
    private String name;

    @Column(name = "reside_state", length = 2, columnDefinition = "CHAR(2) DEFAULT 'XX'")
    private String resideState;


    public Dog() {
    }

    public Dog(long id, int age, String name, String resideState) {
        this.id = id;
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public Dog( int age, String name, String resideState) {
        this.age = age;
        this.name = name;
        this.resideState = resideState;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getResideState() {
        return resideState;
    }

    public void setResideState(String resideState) {
        this.resideState = resideState;
    }
}
