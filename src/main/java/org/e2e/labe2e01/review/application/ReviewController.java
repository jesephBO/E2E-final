package org.e2e.labe2e01.review.application;

import lombok.RequiredArgsConstructor;
import org.e2e.labe2e01.review.domain.Review;
import org.e2e.labe2e01.review.domain.ReviewService;
import org.e2e.labe2e01.review.infrastructure.ReviewRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/review")
@RequiredArgsConstructor
public class ReviewController {
    private final ReviewService reviewService;

    //POST
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Review createReview(
            @RequestParam Long rideId,
            @RequestParam Long authorId,
            @RequestParam(required = false) Long targetId,
            @RequestBody Review review) throws Throwable {

        return reviewService.createReview(rideId, authorId, targetId, review);
    }

    //DELETE
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteReview(@PathVariable Long id) {
        reviewService.deleteReview(id);
    }
}
