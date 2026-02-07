package com.qacart.spring_boot_tutorial.controllers;

import com.qacart.spring_boot_tutorial.entity.Video;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

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
    @GetMapping("/video/{id}")
    public Video getVideoById(@PathVariable int id){
        Optional<Video> result = videos.stream().filter(video->video.getId()==id).findFirst();
        if(result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return result.get();

    }
}
