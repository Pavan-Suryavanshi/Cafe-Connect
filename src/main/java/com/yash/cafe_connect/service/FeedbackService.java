package com.yash.cafe_connect.service;

import com.yash.cafe_connect.entity.Feedback;

import java.util.List;

public interface FeedbackService {

    Feedback submitFeedback(Long userId, String message, Integer rating);

    List<Feedback> getAllFeedback();
}