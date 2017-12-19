package com.airtel.controllers;

import com.airtel.services.UserFeedback;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class AdminController {

    @Autowired
    UserFeedback userFeedbackService;

    @RequestMapping("/admin/feedback/all")
    Object fetchTotalPosts() {
        return userFeedbackService.fetchAllFeedbacks();
    }

    @RequestMapping("/admin/feedback/percentage")
    Map sentimentPercentage() {
        return userFeedbackService.sentimentPercentage();
    }
}
