package com.scmoanno.scmoanno.mapper;

import com.scmoanno.scmoanno.entity.Feedback;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FeedbackMapper {

    void insert(Feedback feedback);
}
