package com.vien.springboot.book.Entity;

import javax.persistence.*;

@Entity
@Table(name = "nguoidung")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_user")
    private int idUser;
    @Column(name = "username")
    private String user_name;
    @Column(name = "password")
    private String password;
    @Column(name = "roles")
    private String roles;

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getUser_name() {
        return user_name;
    }

    public void setUser_name(String username) {
        this.user_name = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }

    @Override
    public String toString() {
        return "UserEntity{" +
                "idUser=" + idUser +
                ", user_name='" + user_name + '\'' +
                ", password='" + password + '\'' +
                ", roles='" + roles + '\'' +
                '}';
    }
}
