package io.github.sly321.viewcachu.datasync.service.helper;

import io.github.sly321.viewcachu.datasync.model.Series;

import org.w3c.dom.Document;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * @author Sven Liebig
 * @since  20.06.2017
 */
public class TheTvDatabaseResponseTransformer {
    /**
     * @param  response
     *
     * @return
     */
    public static List<Series> transformResponseToSeriesList(final String response) {
        final Document xml = parseResponseToXml(response);
        System.out.println(xml);

        final List<Series> seriesList = new ArrayList<Series>();

        return seriesList;
    }

    public static Document parseResponseToXml(final String response) {
        if (response != null) {
            try {
                final DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
                final DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
                final InputSource is = new InputSource(new StringReader(response));
                final Document doc = dBuilder.parse(is);

                return doc;
            } catch (ParserConfigurationException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (SAXException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        return null;
    }
}
