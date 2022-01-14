package com.smithwang.demoproject1.controller;

import com.smithwang.demoproject1.utils.JsonData;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/video_Order")
public class VideoOrderController {


    @PostMapping("save")
    public JsonData saveOrder(){
        return JsonData.success(true);
    }
}
