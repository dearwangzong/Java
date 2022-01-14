package com.smithwang.demoproject1;

import com.smithwang.demoproject1.controller.VideoController;
import com.smithwang.demoproject1.domain.Video;
import com.smithwang.demoproject1.service.VideoService;
import com.smithwang.demoproject1.utils.JsonData;
import junit.framework.TestCase;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcResultMatchersDsl;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = {DemoProject1Application.class})
@AutoConfigureMockMvc
public class VideoTest {

    @Autowired
    VideoService service;


    @Autowired
    private MockMvc mockMvc;


    @Test
    public  void testVideoList(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.get("http://localhost:8080/api/v1/video/list"))
                    .andExpect(MockMvcResultMatchers.status().isOk()).andReturn();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }




    @Before
    public  void testBefore(){
        System.out.println("BeforTest");
    }


    @After
    public void testAfter(){
        System.out.println("After");
//        TestCase.assertEquals(1,3);
    }

    @Test
    public  void test(){
      List<Video> videos= service.getList();
//        System.out.println("Size:"+videos.size());

        boolean resule = videos.size()>0;
      TestCase.assertTrue(resule);
    }
}
