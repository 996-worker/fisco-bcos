package com.post.controller;

import com.github.pagehelper.PageHelper;
import com.post.dao.NuccIdcNoticeMapper;
import com.post.entity.NuccIdcNotice;
import com.post.entity.NuccIdcNoticeExample.Criteria;
import com.post.entity.NuccIdcNoticeExample;
import com.post.utils.JsonUtils;
import com.post.utils.StringUtils;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping("/api/nuccIdcNotice")
public class NuccIdcNoticeController extends BaseController {
    @Autowired
    NuccIdcNoticeMapper nuccIdcNoticeMapper;

    /**
     *
     * @Description 分页查询
     * @author 代码生成工具
     * @date 2022-01-01 00:00:00
     */
    @RequestMapping("list")
    public String list(NuccIdcNotice nuccIdcNotice, String currentPage, String pageSize, String token) {
        Map returnMap = new HashMap();
        // 当前页码
        int pn = 1;
        if (StringUtils.isNotBlank(currentPage)) {
            pn = Integer.parseInt(currentPage);
        }
        // 每页记录数
        int ps = 10;
        if (StringUtils.isNotBlank(pageSize)) {
            ps = Integer.parseInt(pageSize);
        }
        PageHelper.startPage(pn, ps);
        NuccIdcNoticeExample example = new NuccIdcNoticeExample();
        Criteria criteria = example.createCriteria();
        // 消息主键
        if (StringUtils.isNotBlank(nuccIdcNotice.getSeriesNo())) {
            criteria.andSeriesNoEqualTo(nuccIdcNotice.getSeriesNo());
        }
        // 消息状态
        if (StringUtils.isNotBlank(nuccIdcNotice.getNoticeStatus())) {
            criteria.andNoticeStatusEqualTo(nuccIdcNotice.getNoticeStatus());
        }
        example.setOrderByClause(" create_date desc");
        
        returnMap.put("list", nuccIdcNoticeMapper.selectByExample(example));
        Map paginationMap = new HashMap();
        paginationMap.put("total", nuccIdcNoticeMapper.countByExample(example));
        paginationMap.put("pageSize", ps);
        paginationMap.put("current", pn);
        returnMap.put("pagination", paginationMap);
        return jsonData(returnMap);
    }

    /**
     *
     * @Description 根据主键新增或修改
     * @author 代码生成工具
     * @date 2022-01-01 00:00:00
     */
    @RequestMapping("saveOrUpdate")
    public String saveOrUpdate(NuccIdcNotice nuccIdcNotice, String token) {
        if (nuccIdcNoticeMapper.selectByPrimaryKey(nuccIdcNotice.getSeriesNo()) == null) {
            nuccIdcNotice.setSeriesNo(StringUtils.getPrimaryKey());
            nuccIdcNoticeMapper.insert(nuccIdcNotice);
        } else {
            nuccIdcNoticeMapper.updateByPrimaryKeySelective(nuccIdcNotice);
        }
        return success();
    }

    /**
     *
     * @Description 根据主键删除记录
     * @author 代码生成工具
     * @date 2022-01-01 00:00:00
     */
    @RequestMapping("del")
    public String del(NuccIdcNotice nuccIdcNotice, String token) {
        return jsonData( nuccIdcNoticeMapper.deleteByPrimaryKey(nuccIdcNotice.getSeriesNo()));
    }

    /**
     *
     * @Description 根据主键获取记录
     * @author 代码生成工具
     * @date 2022-01-01 00:00:00
     */
    @RequestMapping("getById")
    public String getById(NuccIdcNotice nuccIdcNotice, String token) {
        return jsonData( nuccIdcNoticeMapper.selectByPrimaryKey(nuccIdcNotice.getSeriesNo()));
    }
}