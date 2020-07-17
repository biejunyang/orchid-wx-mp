package com.orchid.wx.mp.init;

import com.orchid.wx.mp.config.WxMpProperties;
import com.orchid.wx.mp.service.WxMenuService;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.bean.menu.WxMenu;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class WxMpStartRunner implements CommandLineRunner {

    @Autowired
    private WxMpService wxMpService;

    @Autowired
    private WxMpProperties properties;

    @Autowired
    private WxMenuService wxMenuService;

    @Override
    public void run(String... args) throws Exception {
        log.info("初始化微信公众号--------------");
        log.info("菜单初始化：");
        for (WxMpProperties.MpConfig config : this.properties.getConfigs()) {
            WxMenu menu=wxMenuService.getWxMenus(config.getAppId());
            wxMpService.switchoverTo(config.getAppId()).getMenuService().menuCreate(menu);
        }
    }
}
