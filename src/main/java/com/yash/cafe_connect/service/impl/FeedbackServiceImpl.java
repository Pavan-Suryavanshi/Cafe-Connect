package com.yash.cafe_connect.service.impl;

import com.yash.cafe_connect.entity.Feedback;
import com.yash.cafe_connect.entity.User;
import com.yash.cafe_connect.exception.ResourceNotFoundException;
import com.yash.cafe_connect.repository.FeedbackRepository;
import com.yash.cafe_connect.repository.UserRepository;
import com.yash.cafe_connect.service.FeedbackService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FeedbackServiceImpl implements FeedbackService {

    private final FeedbackRepository feedbackRepository;
    private final UserRepository userRepository;

    public FeedbackServiceImpl(FeedbackRepository feedbackRepository,
                               UserRepository userRepository) {
        this.feedbackRepository = feedbackRepository;
        this.userRepository = userRepository;
    }

    @Override
    public Feedback submitFeedback(Long userId, String message, Integer rating) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Feedback feedback = new Feedback();
        feedback.setUser(user);
        feedback.setMessage(message);
        feedback.setRating(rating);

        return feedbackRepository.save(feedback);
    }

    @Override
    public List<Feedback> getAllFeedback() {
        return feedbackRepository.findAll();
    }
}