package io.github.sly321.viewcachu.datasync.service.helper;

import io.github.sly321.viewcachu.datasync.model.Series;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

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
        final List<Series> seriesList = new ArrayList<Series>();

        final Document xml = parseResponseToXml(response);
        final Element dataRoot = xml.getDocumentElement();

        if (dataRoot.getNodeName() != "Data") {
            return seriesList;
        }

        final NodeList childNodes = dataRoot.getChildNodes();

        for (int count = 0; count < childNodes.getLength(); count++) {
            final Node seriesNode = childNodes.item(count);

            if ((seriesNode.getNodeName().equals("Series")) && isDeLanguageNode(seriesNode)) {
                seriesList.add(transformNodeToSeries(seriesNode));
            }
        }

        return seriesList;
    }

    private static boolean isDeLanguageNode(final Node seriesNode) {
        final NodeList children = seriesNode.getChildNodes();

        for (int count = 0; count < children.getLength(); count++) {
            final Node node = children.item(count);

            if ("language".equals(node.getNodeName())) {
                return "de".equals(node.getTextContent());
            }
        }

        return false;
    }

    private static Series transformNodeToSeries(final Node seriesNode) {
        final NodeList children = seriesNode.getChildNodes();
        final Series series = new Series();

        for (int count = 0; count < children.getLength(); count++) {
            final Node node = children.item(count);

            if ("seriesid".equals(node.getNodeName())) {
                // series.
                // seriesid, SeriesName, banner, Overview, FirstAired, Network, IMBD_ID, id
            }
        }

        return series;
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
