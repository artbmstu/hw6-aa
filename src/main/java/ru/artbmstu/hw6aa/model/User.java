package ru.artbmstu.hw6aa.model;

import lombok.Data;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@Data
@Entity
@Table(name = "vi_user")
public class User {

    @Id
    @Column(name = "user_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column
    private String password;

    @Column(unique = true)
    private String username;

    @Column(unique = true)
    private String email;

    @Column(name = "enabled")
    private Boolean enabled;

    public User() {
        super();
        this.enabled = false;
    }

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    @ToString.Exclude
    private VerificationToken token;

    public User(String username, String email){
        this.username = username;
        this.email = email;
    }

}