package com.smithwang.demoproject1.mapper;

import com.smithwang.demoproject1.domain.Video;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Repository
public class VideoMapper {


    private static Map<Integer, Video> videoMap = new HashMap<>();

    static {
        videoMap.put(1,new Video(1,"Java"));
        videoMap.put(2,new Video(2,"Spring"));
        videoMap.put(3,new Video(3,"SpringBoot"));
        videoMap.put(4,new Video(4,"SpringCloud"));
        videoMap.put(5,new Video(5,"Redis"));
        videoMap.put(6,new Video(6,"rabbitMQ"));
        videoMap.put(7,new Video(7,"rocketMq"));
    }


    public List<Video> getList(){
        List<Video> videos  = new ArrayList<>();
//        videoMap.forEach((x,y)->{
//            videos.add(y);
//        });

        videos.addAll(videoMap.values());
        return  videos;
    }
}
