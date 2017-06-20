package io.github.sly321.viewcachu.datasync.model;

import lombok.Data;

import java.util.Date;


/**
 * Model für ein Serien Objekt.
 *
 * @author Sven Liebig
 */
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
