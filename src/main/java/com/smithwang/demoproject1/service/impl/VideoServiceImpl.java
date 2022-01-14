package com.smithwang.demoproject1.service.impl;

import com.smithwang.demoproject1.domain.Video;
import com.smithwang.demoproject1.mapper.VideoMapper;
import com.smithwang.demoproject1.service.VideoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class VideoServiceImpl implements VideoService {


    @Autowired
    VideoMapper mapper;

    @Override
    public List<Video> getList() {
        return mapper.getList();
    }
}
