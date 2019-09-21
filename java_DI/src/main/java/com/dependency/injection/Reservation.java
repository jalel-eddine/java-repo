package com.dependency.injection;


import java.io.Serializable;
import java.util.Date;

public class Reservation implements Serializable {


    private Integer id  ;
    private String name ;
    private Integer day ;
    private Date dateStart ;

    public Reservation(Integer id, String name, Integer day, Date dateStart) {
        this.id = id ;
        this.name = name;
        this.day = day;
        this.dateStart = dateStart;
    }

    public Reservation(String name, Integer day, Date dateStart) {
        this.name = name;
        this.day = day;
        this.dateStart = dateStart;
    }

    public Reservation() {

    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDay() {
        return day;
    }

    public void setDay(Integer day) {
        this.day = day;
    }

    public Date getDateStart() {
        return dateStart;
    }

    public void setDateStart(Date dateStart) {
        this.dateStart = dateStart;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", day=" + day +
                ", dateStart=" + dateStart +
                '}';
    }
}
