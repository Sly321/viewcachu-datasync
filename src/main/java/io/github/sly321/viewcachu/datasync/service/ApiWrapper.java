package io.github.sly321.viewcachu.datasync.service;

import java.util.List;

import io.github.sly321.viewcachu.datasync.model.Series;


/**
 * API Wrapper um mit der The Tv Database API zu kommunizieren.
 *
 * @author Sven Liebig
 */
public interface ApiWrapper {

    void getSerieById(int id);

    List<Series> findSerieByName(String name);
}
