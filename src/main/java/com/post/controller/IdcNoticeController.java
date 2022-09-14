
package com.post.controller;

import com.post.fisco.contract.idc.service.IdcNoticeService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 机房变动通知
 */
@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping(value = "/api/IdcNotice")
@Slf4j
public class IdcNoticeController extends BaseController {

    /**
     * 消息发送
     * @param msg
     * @return
     */
    @RequestMapping("send")
    public String send(String msg) {
        IdcNoticeService.send(msg);
        return "ok";
    }

    /**
     * 消息获取
     * @param seriesNo
     * @return
     */
    @RequestMapping("get")
    public String get(String seriesNo) {
        try {
            return IdcNoticeService.get(seriesNo);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return "error";
        }
    }


}
