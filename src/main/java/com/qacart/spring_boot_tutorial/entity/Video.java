package com.qacart.spring_boot_tutorial.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Video {
    private int id;
    private String url;
    private int duration;


}
