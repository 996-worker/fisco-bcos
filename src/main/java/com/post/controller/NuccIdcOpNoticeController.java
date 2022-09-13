package com.post.controller;

import com.github.pagehelper.PageHelper;
import com.post.dao.NuccIdcOpNoticeMapper;
import com.post.entity.NuccIdcOpNotice;
import com.post.entity.NuccIdcOpNoticeExample.Criteria;
import com.post.entity.NuccIdcOpNoticeExample;
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
@RequestMapping("/api/nuccIdcOpNotice")
public class NuccIdcOpNoticeController extends BaseController {
    @Autowired
    NuccIdcOpNoticeMapper nuccIdcOpNoticeMapper;

    /**
     *
     * @Description 分页查询
     * @author 代码生成工具
     * @date 2022-01-01 00:00:00
     */
    @RequestMapping("list")
    public String list(NuccIdcOpNotice nuccIdcOpNotice, String currentPage, String pageSize, String token) {
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
        NuccIdcOpNoticeExample example = new NuccIdcOpNoticeExample();
        Criteria criteria = example.createCriteria();
        // 运维单号
        if (StringUtils.isNotBlank(nuccIdcOpNotice.getInfoNo())) {
            criteria.andInfoNoEqualTo(nuccIdcOpNotice.getInfoNo());
        }
        example.setOrderByClause(" create_date desc");
        
        returnMap.put("list", nuccIdcOpNoticeMapper.selectByExample(example));
        Map paginationMap = new HashMap();
        paginationMap.put("total", nuccIdcOpNoticeMapper.countByExample(example));
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
    public String saveOrUpdate(NuccIdcOpNotice nuccIdcOpNotice, String token) {
        if (nuccIdcOpNoticeMapper.selectByPrimaryKey(nuccIdcOpNotice.getRecId()) == null) {
            nuccIdcOpNotice.setRecId(StringUtils.getPrimaryKey());
            nuccIdcOpNoticeMapper.insert(nuccIdcOpNotice);
        } else {
            nuccIdcOpNoticeMapper.updateByPrimaryKeySelective(nuccIdcOpNotice);
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
    public String del(NuccIdcOpNotice nuccIdcOpNotice, String token) {
        return jsonData( nuccIdcOpNoticeMapper.deleteByPrimaryKey(nuccIdcOpNotice.getRecId()));
    }

    /**
     *
     * @Description 根据主键获取记录
     * @author 代码生成工具
     * @date 2022-01-01 00:00:00
     */
    @RequestMapping("getById")
    public String getById(NuccIdcOpNotice nuccIdcOpNotice, String token) {
        return jsonData( nuccIdcOpNoticeMapper.selectByPrimaryKey(nuccIdcOpNotice.getRecId()));
    }
}