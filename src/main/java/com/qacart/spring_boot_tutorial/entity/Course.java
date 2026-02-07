package com.qacart.spring_boot_tutorial.entity;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Course {

    private int id;
    private String title;
    private double price;
    private int numOfVideos;


}