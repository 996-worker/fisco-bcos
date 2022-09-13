package com.post.dao;

import com.post.entity.NuccIdcNotice;
import com.post.entity.NuccIdcNoticeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NuccIdcNoticeMapper {
    long countByExample(NuccIdcNoticeExample example);

    int deleteByPrimaryKey(String seriesNo);

    int insert(NuccIdcNotice record);

    int insertSelective(NuccIdcNotice record);

    List<NuccIdcNotice> selectByExample(NuccIdcNoticeExample example);

    NuccIdcNotice selectByPrimaryKey(String seriesNo);

    int updateByExampleSelective(@Param("record") NuccIdcNotice record, @Param("example") NuccIdcNoticeExample example);

    int updateByExample(@Param("record") NuccIdcNotice record, @Param("example") NuccIdcNoticeExample example);

    int updateByPrimaryKeySelective(NuccIdcNotice record);

    int updateByPrimaryKey(NuccIdcNotice record);
}