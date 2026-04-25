package org.e2e.labe2e01.review.domain;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.review.infrastructure.ReviewRepository;
import org.e2e.labe2e01.ride.domain.Ride;
import org.e2e.labe2e01.ride.infrastructure.RideRepository;
import org.e2e.labe2e01.user.domain.User;
import org.e2e.labe2e01.user.infrastructure.BaseUserRepository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReviewService {
    private final ReviewRepository reviewRepository;
    private final RideRepository rideRepository;
    private final BaseUserRepository userRepository;

    public Review createReview(Long rideId, Long authorId, Long targetId, Review review) throws Throwable {

        // validar rating
        if (review.getRating() == null || review.getRating() < 0 || review.getRating() > 5) {
            throw new RuntimeException("Rating must be between 0 and 5");
        }

        Ride ride = rideRepository.findById(rideId)
                .orElseThrow(() -> new RuntimeException("Ride not found"));

        Review existingReview = reviewRepository.findByRideId(rideId);

        if (existingReview != null) {
            throw new RuntimeException("Ride already has a review");
        }

        User author = userRepository.findById(authorId)
                .orElseThrow(() -> new RuntimeException("Author not found"));

        User target = null;
        if (targetId != null) {
            target = userRepository.findById(targetId)
                    .orElseThrow(() -> new RuntimeException("Target not found"));
        }

        review.setRide(ride);
        review.setAuthor(author);
        review.setTarget(target);

        return reviewRepository.save(review);
    }

    public Review getReview(Long id) {
        return reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));
    }

    public void deleteReview(Long id) {
        if (!reviewRepository.existsById(id)) {
            throw new RuntimeException("Review not found");
        }
        reviewRepository.deleteById(id);
    }

    public Review updateReview(Long id, Review updatedReview) {

        Review review = reviewRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Review not found"));

        if (updatedReview.getRating() != null) {
            if (updatedReview.getRating() < 0 || updatedReview.getRating() > 5) {
                throw new RuntimeException("Rating must be between 0 and 5");
            }
            review.setRating(updatedReview.getRating());
        }
        if (updatedReview.getComment() != null) {
            review.setComment(updatedReview.getComment());
        }
        return reviewRepository.save(review);
    }
}

