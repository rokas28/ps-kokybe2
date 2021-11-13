package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.InputStream;

public class InputStreamProcessor extends Processor {

    public InputStreamProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        if (xml instanceof InputStream) {
            InputStream in = (InputStream) xml;
            return new StreamSource(in);
        }
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        return processNextResult(xml);
    }
}
