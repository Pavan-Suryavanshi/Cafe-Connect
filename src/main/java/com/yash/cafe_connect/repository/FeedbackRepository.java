package com.yash.cafe_connect.repository;

import com.yash.cafe_connect.entity.Feedback;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
}