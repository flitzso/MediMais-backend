package com.medimais.Entity;

import jakarta.persistence.*;

@Entity
@Table(name="client")
public class Client {
    @Id
    @Column(name="client_id", length = 45)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int clientid;
    @Column(name="client_name", length = 255)
    private String clientname;
    @Column(name="email", length = 255)
    private String email;
    @Column(name="password", length = 255)
    private String password;
    public Client() {
    }
    public Client(int clientid, String clientname, String email, String password) {
        this.clientid = clientid;
        this.clientname = clientname;
        this.email = email;
        this.password = password;
    }

    public int getClientid() {
        return clientid;
    }

    public void setClientid(int clientid) {
        this.clientid = clientid;
    }

    public String getClientname() {
        return clientname;
    }

    public void setClientname(String clientname) {
        this.clientname = clientname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}