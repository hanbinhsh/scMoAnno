package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Feedback;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface FeedbackMapper {
    void insert(Feedback feedback);
    void deleteFeedback(long feedbackId);
    @MapKey("feedback_id")
    Map<Object, Object> findAllFeedbackWithUserInformation();
}
