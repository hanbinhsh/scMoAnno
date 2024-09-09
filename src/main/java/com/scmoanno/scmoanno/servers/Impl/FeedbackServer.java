package com.scmoanno.scmoanno.servers.Impl;

import com.scmoanno.scmoanno.entity.Feedback;
import com.scmoanno.scmoanno.mapper.FeedbackMapper;
import com.scmoanno.scmoanno.mapper.TaskMapper;
import jakarta.annotation.Resource;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;

@Service
public class FeedbackServer implements com.scmoanno.scmoanno.servers.FeedbackServer {
    @Resource
    private FeedbackMapper feedbackMapper;

    @Override
    public void insert(Feedback feedback) {
        feedback.setCreateTime(new Timestamp(System.currentTimeMillis()));
        feedbackMapper.insert(feedback);
    }
}
