package com.jr.veterinary_clinic.models;

import com.jr.veterinary_clinic.services.utils.RegexUtil;

import java.util.ArrayList;
import java.util.List;

public class Staff {

    private int id;
    private String name;
    private String mail;
    private String password;
    private boolean active;
    private List<Authority> authorities = new ArrayList<Authority>();

    public Staff() {
    }

    public Staff(String name, String mail, String password, boolean active, List<Authority> authorities)
            throws IllegalArgumentException {
        this.setName(name);
        this.setMail(mail);
        this.setPassword(password);
        this.setActive(active);
        this.setAuthorities(authorities);
    }

    public Staff(int id, String name, String mail, String password, boolean active, List<Authority> authorities)
            throws IllegalArgumentException {
        this.setId(id);
        this.setName(name);
        this.setMail(mail);
        this.setPassword(password);
        this.setActive(active);
        this.setAuthorities(authorities);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMail() {
        return mail;
    }

    // TODO T.U
    public void setMail(String mail) throws IllegalArgumentException {
        if (!RegexUtil.isValidEmail(mail)) {
            throw new IllegalArgumentException("L'email " + mail + " n'est pas valide.");
        } else {
            this.mail = mail;
        }
    }

    public String getPassword() {
        return password;
    }

    // TODO regex ?
    public void setPassword(String password) {
        this.password = password;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public List<Authority> getAuthorities() {
        return authorities;
    }

    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", mail='" + mail + '\'' +
                ", password='" + password + '\'' +
                ", active=" + active +
                ", authorities=" + authorities +
                '}';
    }
}

