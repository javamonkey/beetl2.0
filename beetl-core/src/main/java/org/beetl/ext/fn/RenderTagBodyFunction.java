package org.beetl.ext.fn;

import org.beetl.core.BodyContent;
import org.beetl.core.Context;
import org.beetl.core.Function;
/*
 * 参考 HTMLTagSupportWrapper2
 */
public class RenderTagBodyFunction implements Function {

    @Override
    public Object call(Object[] paras, Context ctx) {
        TagContentRunner runner = (TagContentRunner)paras[0];
        return runner.run();
    }

    public static interface TagContentRunner{
        public BodyContent run();
    }
}
