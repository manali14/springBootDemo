package com.airtel.interfaces;

import java.util.List;
import java.util.Map;

public interface UserFeedbackInterface {
    List fetchPositiveSentiments();

    List fetchAllFeedbacks();

    Map sentimentPercentage();
}
