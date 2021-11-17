package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import java.io.OutputStream;

public class OutputProcessor extends Processor {
    public OutputProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        if (xml instanceof OutputStream) {
            OutputStream os = (OutputStream) xml;
            return new StreamResult(os);
        }
        return processNextResult(xml);
    }
}
