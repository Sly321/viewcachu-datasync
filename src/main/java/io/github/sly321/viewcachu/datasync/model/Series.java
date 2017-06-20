package io.github.sly321.viewcachu.datasync.model;

import lombok.Data;

import java.util.Date;


@Data
public class Series {
    private int id;
    private String name;
    private String image;
    private String description;
    private Date airingDate;
    private String network;
    private int imbdId;
}
