package com.post.controller;

import com.post.dto.RespDto;
import com.post.utils.JsonUtils;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class BaseController {
    // 返回一个json对象
    public String jsonData(Object data) {
        return toJson("SUCCESS", "0000", "交易成功", data);
    }

    // 返回成功标志
    public String success() {
        return toJson("SUCCESS", "0000", "交易成功", null);
    }

    // 返回失败标志
    public String fail(String desc) {
        return toJson("FAIL", "9999", desc, null);
    }

    // 响应dto转json
    public String toJson(String status, String respCode, String respDesc, Object data) {
        return JsonUtils.toJson(new RespDto(status, respCode, respDesc, data));
    }
}
