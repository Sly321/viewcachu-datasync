package io.github.sly321.viewcachu.datasync.service;

import io.github.sly321.viewcachu.datasync.model.Series;

import java.util.List;


/**
 * API Wrapper um mit der The Tv Database API zu kommunizieren.
 *
 * @author Sven Liebig
 */
public interface TheTvDatabaseApiWrapper {
    /** Url der API. */
    String API_URL = "http://thetvdb.com/api/";

    /** Base Url der Grafiken. */
    String BANNER_URL = "http://thetvdb.com/banners/_cache/";

    /** Key um Serien anhand des Namens zu suchen. */
    String BY_NAME = "GetSeries.php?seriesname=";

    /** Setzt die Ausgabesprache der API, default: Deutsch */
    String LANG_KEY = "de.xml";

    /** Setzt die Ausgabesprache der API als Parameter, default: Deutsch */
    String LANG_PARAM = "&language=de";

    void getSerieById(int id);

    List<Series> findSerieByName(String name);
}
