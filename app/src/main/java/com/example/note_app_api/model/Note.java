package com.example.note_app_api.model;

import lombok.Data;

import java.util.Date;


@Data//getter, setter, toString
public class Note {

    private int id;
    private Date date;
    private String title;
    private String description;
}
