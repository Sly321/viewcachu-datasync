package io.github.sly321.viewcachu.datasync.service.helper;

import io.github.sly321.viewcachu.datasync.model.Series;
import io.github.sly321.viewcachu.datasync.service.ApiWrapper;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.IOException;
import java.io.StringReader;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;


/**
 * Helper Klasse um die Response des {@link ApiWrapper} in eine
 * Datenstruktur ({@link Series}) zu bekommen.
 *
 * @author Sven Liebig
 */
public class TheTvDatabaseResponseTransformer {
    private static final String XML_NODE_NETWORK = "Network";
    private static final String XML_NODE_IMBDID = "IMBD_ID";
    private static final String XML_NODE_BANNER = "banner";
    private static final String XML_NODE_DESCRIPTION = "Overview";
    private static final String XML_NODE_AIRED = "FirstAired";
    private static final String XML_NODE_NAME = "SeriesName";
    private static final String XML_NODE_ID = "seriesid";

    private TheTvDatabaseResponseTransformer() {
    }

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
                try {
                    seriesList.add(transformNodeToSeries(seriesNode));
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
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

    /**
     * Transformiert eine XML {@link Node} einer Serie zu einem {@link Series}
     * Objekt.
     *
     * @param  seriesNode Die Xml {@link Node} der Serie.
     *
     * @return Ein Serienobjekt mit Id, Namen, Beschreibung, Ausstrahlungsdatum,
     *         Netzwerk zugehörigkeit, Imbd Id und Banner Url.
     *
     * @throws ParseException Falls beim Parsen des Erstausstrahlungsdatums ein
     *                        Fehler auftritt wird diese Exception geschmissen.
     */
    private static Series transformNodeToSeries(final Node seriesNode) throws ParseException {
        final NodeList children = seriesNode.getChildNodes();
        final Series series = new Series();

        for (int count = 0; count < children.getLength(); count++) {
            final Node node = children.item(count);

            final String content = node.getTextContent();
            final String nodeName = node.getNodeName();

            if (XML_NODE_ID.equals(nodeName)) {
                series.setId(Integer.valueOf(content));
            } else if (XML_NODE_NAME.equals(nodeName)) {
                series.setName(content);
            } else if (XML_NODE_DESCRIPTION.equals(nodeName)) {
                series.setDescription(content);
            } else if (XML_NODE_AIRED.equals(nodeName)) {
                final DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
                series.setAiringDate(format.parse(content));
            } else if (XML_NODE_NETWORK.equals(nodeName)) {
                series.setNetwork(content);
            } else if (XML_NODE_IMBDID.equals(nodeName)) {
                series.setImbdId(Integer.valueOf(content));
            } else if (XML_NODE_BANNER.equals(nodeName)) {
                series.setImage(content);
            }
        }

        return series;
    }
}
