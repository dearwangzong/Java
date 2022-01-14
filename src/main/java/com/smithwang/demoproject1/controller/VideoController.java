package com.smithwang.demoproject1.controller;


import com.smithwang.demoproject1.domain.Video;
import com.smithwang.demoproject1.service.VideoService;
import com.smithwang.demoproject1.utils.JsonData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 视频控制器
 */
@RestController
@RequestMapping("/api/v1/video")
public class VideoController {



    @Autowired
    VideoService videoService;

//    @RequestMapping("list")
//    public  Object list(){
//        Map<String,String> map = new HashMap<>();
//
//        map.put("1","面试专题");
//        map.put("2","Spring Cloud微服务");
//        map.put("3","Spring Boot2.0");
//
//        return  map;
//    }

    @GetMapping("/list")
    public JsonData getList(){

//        int i = 1/0;
        List<Video> videos =  videoService.getList();

        return JsonData.success(videos);
    }

    @PostMapping("/save")
    public  JsonData saveVideo(@RequestBody Video video){

        System.out.println(video.toString());
        return  JsonData.success(true);
    }

}
