package com.smithwang.demoproject1.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ConfigurationProperties(prefix = "test")
@PropertySource({"classpath:pay.properties"})
@Data
public class WXConfig {

    @Value("${wx.pay}")
    private String payAppId;

    @Value("${wx.pay.shopNum}")
    private String payShopNum;

    @Value("${wx.pay.security}")
    private String paySecurity;

}
