package javax.xml.bind;

import javax.xml.transform.Result;
import javax.xml.transform.Source;

public abstract class Processor {
    private Processor next;

    public Processor linkWith(Processor next) {
        this.next = next;
        return next;
    }

    public abstract Source processToSource(Object xml);
    public abstract Result processToResult(Object xml);

    protected Source processNextSource(Object xml) {
        throwIfNull(xml);
        return next.processToSource(xml);
    }

    protected Result processNextResult(Object xml) {
        throwIfNull(xml);
        return next.processToResult(xml);
    }

    private void throwIfNull(Object xml) {
        if (next == null) {
            throw new IllegalArgumentException("I don't understand how to handle "+xml.getClass());
        }
    }
}
