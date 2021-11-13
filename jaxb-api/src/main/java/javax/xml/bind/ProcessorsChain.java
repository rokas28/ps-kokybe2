package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

public class ProcessorsChain {
    private Processor sourceChain;
    private Processor resultChain;

    public ProcessorsChain() {
        sourceChain = new StringProcessor()
                .linkWith(new FileProcessor())
                .linkWith(new URIProcessor())
                .linkWith(new URLProcessor())
                .linkWith(new InputStreamProcessor())
                .linkWith(new ReaderProcessor())
                .linkWith(new SourceProcessor());
        resultChain = new StringProcessor()
                .linkWith(new FileProcessor())
                .linkWith(new URIProcessor())
                .linkWith(new URLProcessor())
                .linkWith(new OutputProcessor())
                .linkWith(new WriterProcessor())
                .linkWith(new ResultProcessor());
    }

    public Source processToSource(Object xml) {
        return sourceChain.processToSource(xml);
    }

    public Result processToResult(Object xml) {
        return sourceChain.processToResult(xml);
    }
}
