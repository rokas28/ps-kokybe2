package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import java.io.Writer;

public class WriterProcessor extends Processor {

    public WriterProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        if (xml instanceof Writer) {
            Writer w = (Writer)xml;
            return new StreamResult(w);
        }
        return processNextResult(xml);
    }
}
