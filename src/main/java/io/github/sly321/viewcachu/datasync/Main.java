package io.github.sly321.viewcachu.datasync;

import io.github.sly321.viewcachu.datasync.service.ApiWrapper;
import io.github.sly321.viewcachu.datasync.service.impl.TheTvDatabaseApiWrapper;

public class Main {
    public static void main(final String[] args) {
    	ApiWrapper apiWrapper = new TheTvDatabaseApiWrapper();
    	int id = 153021;
		apiWrapper.getSerieById(id);
		apiWrapper.findSerieByName("The Walking Dead");
    }
}
