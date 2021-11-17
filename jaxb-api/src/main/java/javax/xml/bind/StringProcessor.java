package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class StringProcessor extends Processor {

    public StringProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        if (xml instanceof String) {
            xml = processString(xml);
        }
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        if (xml instanceof String) {
            xml = processString(xml);
        }
        return processNextResult(xml);
    }

    private Object processString(Object xml) {
        try {
            xml = new URI((String) xml);
        } catch (URISyntaxException e) {
            xml = new File((String) xml);
        }
        return xml;
    }
}
