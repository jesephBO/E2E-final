package org.e2e.labe2e01.review.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import org.e2e.labe2e01.review.domain.Review;

public interface ReviewRepository extends JpaRepository<Review, Long> {
    Review findByRideId(Long rideId);
}
