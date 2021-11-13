package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

public class ResultProcessor extends Processor {

    public ResultProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        if (xml instanceof Result) {
            return (Result) xml;
        }
        return processNextResult(xml);
    }
}
