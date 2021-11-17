package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.stream.StreamResult;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

public class FileProcessor extends Processor {

    public FileProcessor() {
        // This implementation does not need any additional parameters
    }

    @Override
    public Source processToSource(Object xml) {
        if (xml instanceof File) {
            File file = (File) xml;
            return new StreamSource(file);
        }
        return processNextSource(xml);
    }

    @Override
    public Result processToResult(Object xml) {
        if (xml instanceof File) {
            File file = (File) xml;
            return new StreamResult(file);
        }
        return processNextResult(xml);
    }
}
