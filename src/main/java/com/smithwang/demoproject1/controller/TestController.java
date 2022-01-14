package com.smithwang.demoproject1.controller;

import com.smithwang.demoproject1.config.WXConfig;
import com.smithwang.demoproject1.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("api/v1/test")
@PropertySource({"classpath:pay.properties"})
public class TestController {

    @Autowired
    WXConfig wxConfig;


    @Value("${wx.pay}")
    private String payAppId;

    @Value("${wx.pay.shopNum}")
    private String payShopNum;


    @GetMapping("/get_Config")
    public JsonData testConfig(){
        Map<String,String> map  = new HashMap<>();

        map.put("payAppId",payAppId);
        map.put("payShopNum",payShopNum);

        return JsonData.success(map);
    }

    @GetMapping("/get_Config_Class")
    public JsonData testConfigClass(){

        Map<String,String> map  = new HashMap<>();

        map.put("payAppId", wxConfig.getPayAppId());
        map.put("payShopNum",wxConfig.getPayShopNum());

        //这里有个很有意思的东西，wxConfig是不允许直接返回出去的，似乎和序列化相关的内容有关，
        //感觉比较深，有需求可以研究下
        //暂时知道这个返回信息如果需要使用不能直接返回
        return JsonData.success(map);
    }

}
