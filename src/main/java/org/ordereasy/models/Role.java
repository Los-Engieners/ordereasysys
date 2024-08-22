package org.ordereasy.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


import java.util.List;
import java.util.Set;


@Table(name = "role")
@Entity
public class Role {

    @Id
    @GeneratedValue(strategy =  GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @NotBlank(message = "El nombre es requerido")
    @Column(name = "name")
    private String Name;

    @NotNull(message = "El estado es requerido")
    @Column(name = "state")
    private Integer state;

    @OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
    private Set<User> users;

    public Role() {
    }

    public Role(Integer id, String name, Integer state, Set<User> users) {
        this.id = id;
        Name = name;
        this.state = state;
        this.users = users;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public @NotBlank(message = "El nombre es requerido") String getName() {
        return Name;
    }

    public void setName(@NotBlank(message = "El nombre es requerido") String name) {
        Name = name;
    }

    public @NotNull(message = "El estado es requerido") Integer getState() {
        return state;
    }

    public void setState(@NotNull(message = "El estado es requerido") Integer state) {
        this.state = state;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }
}

