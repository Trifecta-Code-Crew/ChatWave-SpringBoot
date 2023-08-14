package com.chatwave.chatwave.models;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "usuarios")
@ToString @EqualsAndHashCode
public class UserModel {
    @Getter @Setter @Column(name = "id") @Id
    private int id;
    @Setter
    @Getter @Column(name = "nombre_usuario")
    private String username;
    @Setter
    @Getter @Column(name = "contraseña")
    private String password;
    @Setter
    @Getter @Column(name = "correo_electronico")
    private String email;
    @Setter
    @Getter @Column(name = "nombre")
    private String name;
    @Setter
    @Getter @Column(name = "foto_perfil")
    private String profilePic;
    @Setter
    @Getter @Column(name = "biografía")
    private String bio;

    public UserModel() {

    }
}
