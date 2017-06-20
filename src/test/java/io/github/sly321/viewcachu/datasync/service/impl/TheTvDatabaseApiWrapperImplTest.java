package io.github.sly321.viewcachu.datasync.service.impl;

import io.github.sly321.viewcachu.datasync.service.TheTvDatabaseApiWrapper;

import org.junit.Before;
import org.junit.Test;


public class TheTvDatabaseApiWrapperImplTest {
    private TheTvDatabaseApiWrapper classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new TheTvDatabaseApiWrapperImpl();
    }

    @Test
    public void testFindSeriesByName_Vorbedingung_ErwartetesVerhalten() throws Exception {
        // Vorbereitung

        final String name = "The Walking Dead";

        // Ausführung
        classUnderTest.findSerieByName(name);

        // Prüfung
        // fail("not implemented yet"); // TODO implement me
    }
}
