package com.airtel.interfaces;

import com.airtel.dao.Feedback;

import java.util.Map;

public interface CalculationInterface {
    Map calculateSentiments(Feedback feedback);
}
