package com.smithwang.demoproject1.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class Video {

    private Integer id;

    private String title;

    private String summary;

    private Integer price;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String coverImg;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",locale = "zh",timezone = "GTM+8")
    private Date createTime;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<Chapter> chapters;


    public  Video (){

    }

    public  Video(int id,String title){
        this.id = id;
        this.title = title;
        this.createTime= new Date();
    }


    @Override
    public String toString(){
        return  "chapters:"+chapters;
    }
}
