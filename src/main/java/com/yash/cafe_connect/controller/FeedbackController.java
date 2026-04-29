package com.yash.cafe_connect.controller;

import com.yash.cafe_connect.entity.Feedback;
import com.yash.cafe_connect.service.FeedbackService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/feedback")
public class FeedbackController {

    private final FeedbackService feedbackService;

    public FeedbackController(FeedbackService feedbackService) {
        this.feedbackService = feedbackService;
    }

    @PostMapping
    public Feedback submitFeedback(@RequestParam Long userId,
                                   @RequestParam String message,
                                   @RequestParam Integer rating) {
        return feedbackService.submitFeedback(userId, message, rating);
    }

    @GetMapping
    public List<Feedback> getAllFeedback() {
        return feedbackService.getAllFeedback();
    }
}