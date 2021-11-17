package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.IOException;
import java.net.URL;
import java.net.URLConnection;

public class URLProcessor extends Processor {

    public URLProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        if (xml instanceof URL) {
            URL url = (URL) xml;
            return new StreamSource(url.toExternalForm());
        }
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        if (xml instanceof URL) {
            return tryOutputFromURL((URL) xml);
        }
        return processNextResult(xml);
    }

    private Result tryOutputFromURL(URL url) {
        try {
            URLConnection con;
            con = url.openConnection();
            con.setDoOutput(true);
            con.setDoInput(false);
            con.connect();
            return new StreamResult(con.getOutputStream());
        } catch (IOException e) {
            throw new IllegalArgumentException("Failed to extract results from url");
        }
    }
}
