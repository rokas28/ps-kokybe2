package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

public class SourceProcessor extends Processor{
    public SourceProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        if (xml instanceof Source) {
            return (Source) xml;
        }
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        return processNextResult(xml);
    }
}
