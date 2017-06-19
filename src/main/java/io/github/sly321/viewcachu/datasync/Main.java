package io.github.sly321.viewcachu.datasync;

import io.github.sly321.viewcachu.datasync.service.TheTvDatabaseApiWrapper;
import io.github.sly321.viewcachu.datasync.service.impl.TheTvDatabaseApiWrapperImpl;

public class Main {
    public static void main(final String[] args) {
    	TheTvDatabaseApiWrapper apiWrapper = new TheTvDatabaseApiWrapperImpl();
    	int id = 153021;
		apiWrapper.getSerieById(id);
		apiWrapper.findSerieByName("The Walking Dead");
    }
}
