package com.qacart.spring_boot_tutorial.controllers;

import com.qacart.spring_boot_tutorial.entity.Video;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VideoController {

    List<Video> videos = List.of(
            new Video(1, "hhttps:llvideo1", 20),
            new Video(2, "hhttps:llvideo1", 20),
            new Video(3, "hhttps:llvideo1", 20)
    );
    @GetMapping("/videos")
    public List<Video> getVideos (){
        return videos;
    }
}
