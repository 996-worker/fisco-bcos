
package com.post.controller;

import com.post.contract.idc.service.IdcNoticeService;
import lombok.extern.slf4j.Slf4j;

import org.fisco.bcos.sdk.transaction.model.exception.ContractException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.post.contract.idc.IDCNoticeController;

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
