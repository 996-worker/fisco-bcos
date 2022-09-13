
package com.post.controller;

import com.post.contract.idc.service.IdcNoticeService;
import com.post.epcc.dto.EpccTradeDto;
import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(allowCredentials = "true")
@RequestMapping(value = "/api/test")
@Slf4j
public class NoticeController extends BaseController {

    @RequestMapping("send")
    public String send(String msg) {



        IdcNoticeService.send(msg);
        return "ok";
    }

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
