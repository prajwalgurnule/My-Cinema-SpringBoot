package dev.prajwal.movies;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1/reviews")
public class ReviewController {
    @Autowired
    private ReviewService reviewService;

    @PostMapping
    public ResponseEntity<Review> createReview(@RequestBody Map<String, String> payload) {
        // Call the review service to create a review
        Review review = reviewService.createReview(payload.get("reviewBody"), payload.get("imdbId"));

        // Return the review with an OK status
        return new ResponseEntity<>(review, HttpStatus.OK);
    }
}
