package com.airtel.impl;

import com.airtel.dao.Feedback;
import com.airtel.enums.BannedDictionary;
import com.airtel.enums.FeedbackStatus;
import com.airtel.enums.NegativeDictionary;
import com.airtel.enums.PositiveDictionary;
import com.airtel.interfaces.CalculationInterface;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

@Service
public class CalculationImpl implements CalculationInterface {
    @Override
    public Map calculateSentiments(Feedback feedback) {
        Map map = new HashMap();
        FeedbackStatus feedbackStatus = null;
        Long score = 0l;
        String content = feedback.getContent();
        String[] contentArray = content.split(" ");
        for (String c : contentArray) {
            long match = Arrays.stream(BannedDictionary.values()).filter(word -> word.getName().equalsIgnoreCase(c)).count();
            if (match > 0) {
                feedbackStatus = FeedbackStatus.BANNED;
                break;
            } else {
                NegativeDictionary negativeDictionary = Arrays.stream(NegativeDictionary.values()).filter(word -> word.getName().equalsIgnoreCase(c)).findFirst().orElse(null);
                if (negativeDictionary != null) {
                    score += negativeDictionary.getScore();
                } else {
                    PositiveDictionary positiveDictionary = Arrays.stream(PositiveDictionary.values()).filter(word -> word.getName().equalsIgnoreCase(c)).findFirst().orElse(null);
                    if (positiveDictionary != null) {
                        score += positiveDictionary.getScore();
                    }
                }
            }
        }
        map = populateResponseMap(map, score, feedbackStatus);
        return map;
    }

    private Map populateResponseMap(Map map, Long score, FeedbackStatus feedbackStatus) {
        if (feedbackStatus != FeedbackStatus.BANNED) {
            feedbackStatus = (score > 0l) ? FeedbackStatus.POSITIVE : FeedbackStatus.NEGATIVE;
        }
        map.put("status", feedbackStatus);
        map.put("score", score);
        return map;
    }
}
