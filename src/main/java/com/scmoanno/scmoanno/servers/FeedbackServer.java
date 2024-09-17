package com.scmoanno.scmoanno.servers;

import com.scmoanno.scmoanno.entity.Feedback;

import java.util.List;
import java.util.Map;

public interface FeedbackServer {
    void insert(Feedback feedback);
    void deleteFeedback(long feedbackId);
    Map<Object, Object> findAllFeedbackWithUserInformation();
}
