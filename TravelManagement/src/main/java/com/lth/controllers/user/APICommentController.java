package com.lth.controllers.user;

import com.lth.pojos.Feedback;
import com.lth.service.FeedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class APICommentController {
    @Autowired
    private FeedbackService feedbackService;

    @PostMapping(value = "/api/add-feedback", produces = {MediaType.APPLICATION_JSON_VALUE})
    public ResponseEntity<Feedback> addComment(@RequestBody Map<String, String> params) {
        try {
            String comment = params.get("comment");
            int rating = Integer.parseInt(params.get("rating"));
            int tourId = Integer.parseInt(params.get("tourId"));
            int userId = Integer.parseInt(params.get("userId"));
            Feedback feedback = this.feedbackService.addFeedback(rating, comment, tourId, userId);
            return new ResponseEntity<>(feedback, HttpStatus.CREATED);
        } catch (Exception exception) {
            System.err.println("ERROR!" + exception.getMessage());
            exception.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
}
