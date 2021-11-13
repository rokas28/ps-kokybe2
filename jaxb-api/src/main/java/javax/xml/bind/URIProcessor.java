package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import java.net.MalformedURLException;
import java.net.URI;

public class URIProcessor extends Processor {

    public URIProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        if (xml instanceof URI) {
            xml = tryProcessURIToURL(xml);
        }
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        if (xml instanceof URI) {
            xml = tryProcessURIToURL(xml);
        }
        return processNextResult(xml);
    }

    private Object tryProcessURIToURL(Object xml) {
        try {
            URI uri = (URI) xml;
            xml = uri.toURL();
        } catch (MalformedURLException e) {
            throw new IllegalArgumentException("Unable to process xml of instance URI");
        }
        return xml;
    }
}
