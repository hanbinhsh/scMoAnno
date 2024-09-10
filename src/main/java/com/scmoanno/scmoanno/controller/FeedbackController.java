package com.scmoanno.scmoanno.controller;

import com.scmoanno.scmoanno.entity.Feedback;
import com.scmoanno.scmoanno.entity.Result;
import com.scmoanno.scmoanno.servers.FeedbackServer;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.*;

import java.security.PublicKey;
import java.util.List;
import java.util.Map;

@RestController
public class FeedbackController {
    @Resource
    private FeedbackServer feedbackServer;

    @PostMapping("/feedback")
    public Result<String> feedback(@RequestBody Feedback feedback) {
        feedbackServer.insert(feedback);
        return Result.success();
    }

    @GetMapping("/findFeedback")
    public Result<List<Feedback>> getFeedback() {
        return Result.success(feedbackServer.getFeedback());
    }

    @RequestMapping("/findAllFeedbackWithUserInformation")
    @CrossOrigin(origins = "*")
    public Result<Map<Object,Object>> findAllFeedbackWithUserInformation(){
        return Result.success(feedbackServer.findAllFeedbackWithUserInformation());
    }

    @DeleteMapping("/deleteFeedback/{feedbackId}")
    public Result<String> deleteFeedback(@PathVariable long feedbackId) {
        feedbackServer.deleteFeedback(feedbackId);
        return Result.success();
    }
}
