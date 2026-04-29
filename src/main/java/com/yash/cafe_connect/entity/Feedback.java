package com.yash.cafe_connect.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String message;

    private Integer rating; // 1 to 5

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;
}