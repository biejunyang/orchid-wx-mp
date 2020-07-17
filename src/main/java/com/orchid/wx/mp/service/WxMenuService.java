package com.orchid.wx.mp.service;

import me.chanjar.weixin.common.bean.menu.WxMenu;

import java.net.MalformedURLException;
import java.util.List;

public interface WxMenuService {

    WxMenu getWxMenus(String appid) throws MalformedURLException;
}
