package com.airtel.controllers;

import com.airtel.dao.model.UserFeedbackDao;
import com.airtel.services.UserFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    UserFeedback userFeedbackService;

    @RequestMapping(value = "/user/saveFeedback", method = RequestMethod.POST)
    Map addFeedback(@RequestBody UserFeedbackDao userFeedback) {
        System.out.println(userFeedback.getFeedback());
        System.out.println(userFeedback.getUserId());
        return userFeedbackService.saveFeedBack(userFeedback);
    }

    @RequestMapping(value = "/user/positiveSentiments", method = RequestMethod.GET)
        Object positiveSentiments() {
        return userFeedbackService.fetchPositiveSentiments();
    }

}
