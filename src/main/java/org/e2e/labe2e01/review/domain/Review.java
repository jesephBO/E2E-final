package org.e2e.labe2e01.review.domain;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.e2e.labe2e01.ride.domain.Ride;
import org.e2e.labe2e01.user.domain.User;

@Entity
@RequiredArgsConstructor
@Setter
@Getter
public class Review {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //Hacer en e service la restriccion de o a 5
    @Column(nullable = false)
    private Integer rating;

    @ManyToOne
    @JoinColumn(name = "author_id", nullable = false)
    private User author;

    @ManyToOne
    @JoinColumn(name = "ride_id", nullable = false, unique = true)
    private Ride ride;

    @ManyToOne
    @JoinColumn(name = "target_id")
    private User target;

    @Column(nullable = false, columnDefinition = "VARCHAR(255)")
    private String comment;
}