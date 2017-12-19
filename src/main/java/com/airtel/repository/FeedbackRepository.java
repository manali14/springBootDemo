package com.airtel.repository;

import com.airtel.dao.Feedback;
import com.airtel.enums.FeedbackStatus;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface FeedbackRepository extends JpaRepository<Feedback, Long> {
    Feedback findById(Long id);

    List<Feedback> findAllByFeedbackStatusAndScoreGreaterThan(FeedbackStatus feedbackStatus, Long score, Pageable pageable);

    long countByFeedbackStatus(FeedbackStatus positive);
}
