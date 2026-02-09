package com.qacart.spring_boot_tutorial.entity;

import lombok.*;

import java.util.UUID;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Video {
    private UUID id;
    private String url;
    private int duration;


}
