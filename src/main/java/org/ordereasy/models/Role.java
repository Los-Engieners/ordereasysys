package org.ordereasy.models;

import java.util.List;

public class Role {
    private int IdRol;
    private String Name;

    private List<User> users;

    public Role() {
    }

    public Role(int idRol, String name) {
        IdRol = idRol;
        Name = name;
    }

    public int getIdRol() {
        return IdRol;
    }

    public void setIdRol(int idRol) {
        IdRol = idRol;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}

