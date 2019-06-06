package ru.artbmstu.hw6aa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "vi_token")
@Data
@NoArgsConstructor
public class VerificationToken {

    private static final int EXPIRATION = 60 * 24;

    public VerificationToken(String token, User user) {
        this.token = token;
        this.user = user;
    }

    @Id
    @Column(name = "token_id")
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private String id;

    @Column
    private String token;

    @OneToOne(targetEntity = User.class, fetch = FetchType.EAGER)
    @JoinColumn(nullable = false, name = "user_id")
    @JsonIgnore
    @ToString.Exclude
    private User user;

    @Column(name = "expiry_date")
    private Date expiryDate;
}