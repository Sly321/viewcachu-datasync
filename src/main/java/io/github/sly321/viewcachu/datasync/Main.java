package io.github.sly321.viewcachu.datasync;

import java.util.List;

import io.github.sly321.viewcachu.datasync.model.Series;
import io.github.sly321.viewcachu.datasync.service.ApiWrapper;
import io.github.sly321.viewcachu.datasync.service.impl.TheTvDatabaseApiWrapper;

public class Main {
    public static void main(final String[] args) {
    	ApiWrapper apiWrapper = new TheTvDatabaseApiWrapper();
    	int id = 153021;
		apiWrapper.getSerieById(id);
		List<Series> series = apiWrapper.findSerieByName("The Walking Dead");
    }
}
