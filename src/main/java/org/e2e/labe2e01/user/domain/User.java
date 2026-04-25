package org.e2e.labe2e01.user.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.e2e.labe2e01.coordinate.domain.Coordinate;
import org.springframework.data.annotation.Id;
import java.time.ZonedDateTime;

@Getter
@Setter
@Entity
@Table(name = "users")
@Inheritance(strategy = InheritanceType.JOINED)
@RequiredArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double AvgRating=0.0;


    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false)
    private Role role;


    private Integer trips=0;

    @Column(nullable = false)
    private ZonedDateTime CreatedAt;
    private ZonedDateTime UpdatedAt;

    @Column(unique = true,nullable = false)
    private String email;

    @Column(nullable = false)
    private String FirstName;

    @Column(nullable = false)
    private String LastName;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false,unique=true)
    private String PhoneNumber;

    @ManyToOne
    @JoinColumn(name="coordinate_id")
    private Coordinate coordinate;

}