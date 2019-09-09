package com.asosiy.idoston.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int idticket;

    private String name;
    private String description;
    private String pubdate;
    private String url;
    private String location;
    private String passed;
    private int userid;

    public Ticket() {
    }

    public Ticket(int idticket, String name, String description, String pubdate, String url, String location, String passed, int userid) {
        this.idticket = idticket;
        this.name = name;
        this.description = description;
        this.pubdate = pubdate;
        this.url = url;
        this.location = location;
        this.passed = passed;
        this.userid = userid;
    }

    public int getIdticket() {
        return idticket;
    }
//
//    public void setIdticket(int idticket) {
//        this.idticket = idticket;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPubdate() {
        return pubdate;
    }

    public void setPubdate(String pubdate) {
        this.pubdate = pubdate;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getPassed() {
        return passed;
    }

    public void setPassed(String passed) {
        this.passed = passed;
    }

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }
}
