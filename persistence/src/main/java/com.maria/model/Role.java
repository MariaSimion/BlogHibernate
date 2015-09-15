package com.maria.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * Created by msimion on 9/10/2015.
 */
@Entity
@Table(name = "role")
public class Role implements Serializable {

    @Id
    @GeneratedValue
    @Column(name = "id")
    int idRole;

    @Column(name = "role")
    String role;

    @ManyToMany(mappedBy = "roles")
    private Set<User> users = new HashSet<User>(0);

    public Role() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getIdRole() {
        return idRole;
    }

    public void setIdRole(int idRole) {
        this.idRole = idRole;
    }

    public Set<User> getUsers() {
        return users;
    }

    public void setUsers(Set<User> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Role role1 = (Role) o;

        return !(role != null ? !role.equals(role1.role) : role1.role != null);

    }

    @Override
    public int hashCode() {
        return role != null ? role.hashCode() : 0;
    }
}
