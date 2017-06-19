package io.github.sly321.viewcachu.datasync.service;

/**
 * 
 * API Wrapper um mit der The Tv Database API zu kommunizieren.
 * 
 * @author Sven Liebig
 *
 */
public interface TheTvDatabaseApiWrapper {
	/** Url der API */
	final String API_URL = "http://thetvdb.com/api/";
	
	/** Base Url der Grafiken */
	final String BANNER_URL = "http://thetvdb.com/banners/_cache/";
	
	/** Key um Serien anhand des Namens zu suchen */
	final String BY_NAME = "GetSeries.php?seriesname=";
	
	/** Setzt die Ausgabesprache der API, default: Deutsch  */
	final String LANG_KEY = "de.xml";
	
	/** Setzt die Ausgabesprache der API als Parameter, default: Deutsch */
	final String LANG_PARAM = "&language=de";
	
	void getSerieById(int id);
	
	void findSerieByName(String name);
}
