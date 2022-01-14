package com.smithwang.demoproject1.service;

import com.smithwang.demoproject1.domain.Video;
import org.springframework.stereotype.Service;

import java.util.List;

public interface VideoService {


    List<Video> getList();
}
