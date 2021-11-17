package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamSource;
import java.io.Reader;

public class ReaderProcessor extends Processor {

    public ReaderProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        if (xml instanceof Reader) {
            Reader r = (Reader) xml;
            return new StreamSource(r);
        }
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        return processNextResult(xml);
    }
}
