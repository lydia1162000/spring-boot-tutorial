package com.qacart.spring_boot_tutorial.controllers;

import com.qacart.spring_boot_tutorial.entity.Video;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class VideoController {

    List<Video> videos = new ArrayList<>(
            List.of(

                    new Video(1, "hhttps:llvideo1", 20),
                    new Video(2, "hhttps:llvideo1", 20),
                    new Video(3, "hhttps:llvideo1", 20)
            )
    );

    @GetMapping("/videos")
    public List<Video> getVideos() {
        return videos;
    }

    @GetMapping("/videos/{id}")
    public Video getVideoById(@PathVariable int id) {
        Optional<Video> result = videos.stream().filter(video -> video.getId() == id).findFirst();
        if (result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return result.get();
    }

    @GetMapping("/videos/search")
    public List<Video> getVideosByURL(@RequestParam String url) {
        return videos.stream().filter(video -> video.getUrl().contains(url)).toList();
    }

    @DeleteMapping("/videos/{id}")
    public String deleteVideoByURL(@PathVariable int id) {
        Optional<Video> result = videos.stream().filter(video -> video.getId() == id).findFirst();
        if (result.isEmpty()) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        videos.remove(result.get());
        return "Deleted";
    }

}
