package com.orm.hibenate.domain;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable {

    private static final long serialversionUID = 129348938L;


    @Id
    @GeneratedValue
    private Long id ;

    private String participant ;
    private String speaker ;
    private String session ;

    public Reservation(Long id, String participant, String speaker, String session) {
        this.id = id;
        this.participant = participant;
        this.speaker = speaker;
        this.session = session;
    }

    public Reservation(String participant, String speaker, String session) {
        this.participant = participant;
        this.speaker = speaker;
        this.session = session;
    }

    public Reservation(Long id, String participant, String speaker) {
        this.participant = participant;
        this.speaker = speaker;
    }

    public Reservation() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getParticipant() {
        return participant;
    }

    public void setParticipant(String participant) {
        this.participant = participant;
    }

    public String getSpeaker() {
        return speaker;
    }

    public void setSpeaker(String speaker) {
        this.speaker = speaker;
    }

    public String getSession() {
        return session;
    }

    public void setSession(String session) {
        this.session = session;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", participant='" + participant + '\'' +
                ", speaker='" + speaker + '\'' +
                ", session='" + session + '\'' +
                '}';
    }
}
