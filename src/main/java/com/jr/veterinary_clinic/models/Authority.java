package com.jr.veterinary_clinic.models;

public class Authority {

    private int id;
    private String role;

    public Authority () {}

    public Authority(String role) {
        this.setRole(role);
    }

    public Authority(int id, String role) {
        this.setId(id);
        this.setRole(role);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    // TODO T.U
    public void setRole(String role) {
        if (!"ROLE_SEC".equals(role) && !"ROLE_VET".equals(role) && !"ROLE_ADM".equals(role)) {
            throw new IllegalArgumentException("Le rôle doit être égal à 'ROLE_SEC', 'ROLE_VET' ou 'ROLE_ADM'.");
        } else {
            this.role = role;
        }
    }

    @Override
    public String toString() {
        return "Authority{" +
                "id=" + id +
                ", role='" + role + '\'' +
                '}';
    }

}

