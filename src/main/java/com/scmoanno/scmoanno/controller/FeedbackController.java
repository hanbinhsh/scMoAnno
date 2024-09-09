package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Feedback;
import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.servers.FeedbackServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.security.PublicKey;

@RestController
public class FeedbackController {
    @Resource
    private FeedbackServer feedbackServer;

    @PostMapping("/feedback")
    public Result<String> feedback(@RequestBody Feedback feedback) {
        feedbackServer.insert(feedback);
        return Result.success();
    }
}
