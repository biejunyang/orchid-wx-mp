# orchid-wx-mp
> 本项目基于Spring Boot、WxJava、Vue、Vant构建，实现微信公众号开发功能。

## WxJava开发使用步骤：
1. 请注意，本项目为简化代码编译时加入了lombok支持，如果不了解lombok的话，请先学习下相关知识，比如可以阅读[此文章](https://mp.weixin.qq.com/s/cUc-bUcprycADfNepnSwZQ)；
2. 另外，新手遇到问题，请务必先阅读[【开发文档首页】](https://github.com/Wechat-Group/WxJava/wiki)的常见问题部分，可以少走很多弯路，节省不少时间。
3. application.yml微信主要配置说明如下：
```
wx:
  mp:
    configs:
      - appId: 1111 （一个公众号的appid）
        secret: 1111（公众号的appsecret）
        token: 111 （接口配置里的Token值）
        aesKey: 111 （接口配置里的EncodingAESKey值）
      - appId: 2222 （另一个公众号的appid，以下同上）
        secret: 1111
        token: 111
        aesKey: 111
```

4. 运行Java程序：`OrchidWxMpApp`；
5. 配置微信公众号中的接口地址：http://公网可访问域名/wx/portal/xxxxx （注意，xxxxx为对应公众号的appid值）；
6. 根据自己需要修改各个handler的实现，加入自己的业务逻辑。
	
### [【WxJava公众号开发文档：】](https://github.com/Wechat-Group/WxJava/wiki/%E5%85%AC%E4%BC%97%E5%8F%B7%E5%BC%80%E5%8F%91%E6%96%87%E6%A1%A3)



## Access_Token管理

### 1、access_token令牌的获取：
WxJava中access_token的获取是在调用微信端接口时实时获取的，并且获取到access_token会存储到公众号对应的WxMpConfigStorage对象中(默认是实现是存储在内存中)，便于二次调用

### 2、access_token令牌的刷新：
在大多数情况下，你是不需要显示地去刷新access token的，因为WxCpService会在access token过期的时候自己刷新。

比如我们获取用户信息时微信反馈access token过期，WxCpService会自己刷新access token，然后再次去获取用户信息。并且会将access token更新到WxCpConfigStora

如果你的确需要自己手工刷新access token，则可以：
```
wxCpService.accessTokenRefresh();
获得的新的access token会更新到WxCpConfigStorage中。
```

### 3、access_token令牌的存储：
令牌获取以及刷新后会存储到WxMpConfigStorage对象中，默认实现为WxMpDefaultConfigImpl对象。公众号配置信息，令牌信息等存储在内存中，适合单机部署应用。分布式集群情况下，可以自己实现WxMpConfigStorage对象，将信息存储到分布式缓存平台或者数据库中。


## 消息回复


## 公众号第三方应用接入

公众号后台管理
公众号第三方应用
第三方应用后台
