package com.todo.entity;

import javax.persistence.*;     //emiatt @-k..a @ az tul.-ot ad

//itt irom le az adataim formajat, hogy hogya nf go kinezni
@Entity
@Table(name = "todo")
public class Todo {


    @Id
    @GeneratedValue //alapbol generalja nekem az idt
    private int id;

    @Column(nullable = false) //ezek oszlopok lesznek a tablazatomban
    private String title;

    @Column //ezek oszlopok lesznek a tablazatomban
    private String description;

    public Todo(){

    }
    //azert kellenek a getterek, setterek, mert ugye privatra allitottam mindenem
    //egy id-t kapok
    public int getId() {
        return id;
    }
    //az adott idm idja lesz
    private void setId(int id) {        //de az adatbazisom fog adni idt
        this.id = id;
    }
    //konyv cimemet irja ki
    public String getTitle() {
        return title;
    }
    //az adott könyv címemet
    public void setTitle(String title) {
        this.title = title;
    }
    //könyv leírásom
    public String getDescription() { return description; }
    //adott leírásom
    public void setDescription(String description) {
        this.description = description;
    }
}
