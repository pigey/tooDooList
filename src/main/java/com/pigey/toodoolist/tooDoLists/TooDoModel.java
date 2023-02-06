package com.pigey.toodoolist.tooDoLists;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class TooDoModel implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String listInformation;
    private String author;

    public TooDoModel(Long id, String listInformation, String author) {
        this.id = id;
        this.listInformation = listInformation;
        this.author = author;
    }

    public TooDoModel() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getListInformation() {
        return listInformation;
    }

    public void setListInformation(String listInformation) {
        this.listInformation = listInformation;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    @Override
    public String toString() {
        return "TooDoModel{" +
                "listInformation='" + listInformation + '\'' +
                ", author='" + author + '\'' +
                '}';
    }
}
