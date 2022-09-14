
package com.post.config;

import com.post.utils.CtxUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Title: 系统配置
 * @Description: TODO(描述)
 * @author: 雷大鹏
 * @date: 2020-05-10 10:12:19
 */
@Service
@Slf4j
public class SystemConfig {
    /**
     * 通过静态方法获取systemConfig对象
     *
     * @return
     */
    public static SystemConfig getInstance() {
        SystemConfig systemConfig = null;
        try {
            systemConfig = (SystemConfig) CtxUtils.getBean("systemConfig");
        } catch (Exception e) {
            e.printStackTrace();
            log.error("获取SystemConfig失败", e);
        }
        return systemConfig;
    }

    /**
     * 服务名称
     */
    @Value("${server.name:null}")
    public String serviceName = "";

    /**
     * 机房变更通知-合约地址
     */
    @Value("${contract.idcNotice.address:null}")
    public String contractIdcNoticeAddress = "";


    @Value("${spring.profiles.active:prod}")
    public String active;

}
