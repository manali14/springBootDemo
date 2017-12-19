package com.airtel.services;

import com.airtel.dao.Feedback;
import com.airtel.dao.User;
import com.airtel.dao.model.UserFeedbackDao;
import com.airtel.enums.FeedbackStatus;
import com.airtel.impl.CalculationImpl;
import com.airtel.interfaces.UserFeedbackInterface;
import com.airtel.repository.FeedbackRepository;
import com.airtel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserFeedback implements UserFeedbackInterface {

    @Autowired
    UserFeedback userFeedbackService;

    @Autowired
    UserRepository userRepository;

    @Autowired
    FeedbackRepository feedbackRepository;

    @Autowired
    CalculationImpl calculation;

    public Map saveFeedBack(UserFeedbackDao userFeedback) {
        Map map = new HashMap();
        User user = userRepository.findById(userFeedback.getUserId());
        if (user != null) {
            System.out.println(user.getFeedbacks());
            Feedback feedback = new Feedback();
            feedback.setUser(user);
            feedback.setContent(userFeedback.getFeedback());
            Map sentimentMap = calculation.calculateSentiments(feedback);
            feedback.setFeedbackStatus((FeedbackStatus) sentimentMap.get("status"));
            feedback.setScore((Long) sentimentMap.get("score"));
            feedbackRepository.save(feedback);
            map.put("status", true);
            map.put("message", "Feedback saved successfully");
        } else {
            map.put("status", false);
            map.put("message", "No User Found");
        }
        return map;
    }

    @Override
    public List fetchPositiveSentiments() {
        Pageable pageable = new PageRequest(0, 50);
        return feedbackRepository.findAllByFeedbackStatusAndScoreGreaterThan(FeedbackStatus.POSITIVE, 0l, pageable);
    }

    @Override
    public List fetchAllFeedbacks() {
        Pageable pageable = new PageRequest(0, 50);
        return feedbackRepository.findAll(pageable).getContent();
    }

    @Override
    public Map sentimentPercentage() {
        Map map = new HashMap();
        long totalCount = feedbackRepository.count();
        long positiveCount = feedbackRepository.countByFeedbackStatus(FeedbackStatus.POSITIVE);
        long negativeCount = feedbackRepository.countByFeedbackStatus(FeedbackStatus.NEGATIVE);
        long bannedCount = feedbackRepository.countByFeedbackStatus(FeedbackStatus.BANNED);
        map.put("percentBanned", (bannedCount * 100) / totalCount);
        map.put("percentPositive", (positiveCount * 100) / totalCount);
        map.put("percentNegative", (negativeCount * 100) / totalCount);
        return map;
    }
}
