package com.chatwave.chatwave.models;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import lombok.*;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicUpdate;

import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "usuarios")
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@DynamicUpdate
public class UserModel {

    @Column(name = "id") @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "nombre_usuario")
    private String username;

    @Column(name = "contraseña")
    private String password;

    @Column(name = "correo_electronico")
    private String email;

    @Column(name = "nombre")
    private String name;

    @Column(name = "foto_perfil")
    private String profilePic;

    @Column(name = "biografía")
    private String bio;

    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "fecha_creación")
    private Date creationDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserModel userModel = (UserModel) o;
        return id == userModel.id && Objects.equals(username, userModel.username) && Objects.equals(password, userModel.password) && Objects.equals(email, userModel.email) && Objects.equals(name, userModel.name) && Objects.equals(profilePic, userModel.profilePic) && Objects.equals(bio, userModel.bio);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, username, password, email, name, profilePic, bio);
    }

    @Override
    public String toString() {
        return "UserModel{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", profilePic='" + profilePic + '\'' +
                ", bio='" + bio + '\'' +
                '}';
    }
}
