package com.post.dao;

import com.post.entity.NuccIdcOpNotice;
import com.post.entity.NuccIdcOpNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NuccIdcOpNoticeMapper {
    long countByExample(NuccIdcOpNoticeExample example);

    int deleteByPrimaryKey(String recId);

    int insert(NuccIdcOpNotice record);

    int insertSelective(NuccIdcOpNotice record);

    List<NuccIdcOpNotice> selectByExample(NuccIdcOpNoticeExample example);

    NuccIdcOpNotice selectByPrimaryKey(String recId);

    int updateByExampleSelective(@Param("record") NuccIdcOpNotice record, @Param("example") NuccIdcOpNoticeExample example);

    int updateByExample(@Param("record") NuccIdcOpNotice record, @Param("example") NuccIdcOpNoticeExample example);

    int updateByPrimaryKeySelective(NuccIdcOpNotice record);

    int updateByPrimaryKey(NuccIdcOpNotice record);
}