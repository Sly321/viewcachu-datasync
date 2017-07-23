package io.github.sly321.viewcachu.datasync.service.impl;

import io.github.sly321.viewcachu.datasync.model.Series;
import io.github.sly321.viewcachu.datasync.service.ApiWrapper;

import org.hamcrest.junit.MatcherAssert;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;

import java.util.List;


public class TheTvDatabaseApiWrapperTest {
    private ApiWrapper classUnderTest;

    @Before
    public void setUp() {
        classUnderTest = new TheTvDatabaseApiWrapper();
    }

    @Test
    public void testFindSeriesByName_TheWalkingDeadWirdAlsNameUebergeben_SollteMindestensZweiSerienFinden()
        throws Exception {
        // Vorbereitung
        final String name = "The Walking Dead";

        // Ausführung
        final List<Series> seriesList = classUnderTest.findSerieByName(name);

        // Prüfung
        MatcherAssert.assertThat(seriesList.size(), Matchers.is(Matchers.greaterThan(1)));
    }

    @Test
    public void testFindSeriesByName_FearTheWalkingDead_SollteEineSerieFinden() throws Exception {
        // Vorbereitung
        final String name = "Fear The Walking Dead";

        // Ausführung
        final List<Series> seriesList = classUnderTest.findSerieByName(name);

        // Prüfung
        MatcherAssert.assertThat(seriesList.size(), Matchers.is(1));
    }
}
